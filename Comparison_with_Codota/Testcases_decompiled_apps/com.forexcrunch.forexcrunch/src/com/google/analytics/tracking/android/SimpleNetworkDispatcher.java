package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements Dispatcher {
    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private final HttpClientFactory httpClientFactory;
    private final String userAgent;

    SimpleNetworkDispatcher(AnalyticsStore store, HttpClientFactory httpClientFactory2, Context ctx2) {
        this(httpClientFactory2, ctx2);
    }

    SimpleNetworkDispatcher(HttpClientFactory httpClientFactory2, Context ctx2) {
        this.ctx = ctx2.getApplicationContext();
        this.userAgent = createUserAgentString("GoogleAnalytics", "2.0", Build.VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        this.httpClientFactory = httpClientFactory2;
    }

    public boolean okToDispatch() {
        NetworkInfo network = ((ConnectivityManager) this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
        if (network != null && network.isConnected()) {
            return true;
        }
        Log.vDebug("...no network connectivity");
        return false;
    }

    public int dispatchHits(List<Hit> hits) {
        int hitsDispatched = 0;
        int maxHits = Math.min(hits.size(), 40);
        int i = 0;
        while (true) {
            if (i >= maxHits) {
                break;
            }
            HttpClient client = this.httpClientFactory.newInstance();
            Hit hit = hits.get(i);
            URL url = getUrl(hit);
            if (url != null) {
                HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                String path = url.getPath();
                String params = TextUtils.isEmpty(hit.getHitParams()) ? "" : HitBuilder.postProcessHit(hit, System.currentTimeMillis());
                HttpEntityEnclosingRequest request = buildRequest(params, path);
                if (request == null) {
                    continue;
                } else {
                    request.addHeader("Host", targetHost.toHostString());
                    logDebugInformation(Log.isDebugEnabled(), request);
                    if (params.length() > 8192) {
                        Log.m529w("Hit too long (> 8192 bytes)--not sent");
                    } else {
                        try {
                            HttpResponse response = client.execute(targetHost, request);
                            if (response.getStatusLine().getStatusCode() != 200) {
                                Log.m529w("Bad response: " + response.getStatusLine().getStatusCode());
                                break;
                            }
                        } catch (ClientProtocolException e) {
                            Log.m529w("ClientProtocolException sending hit; discarding hit...");
                        } catch (IOException e2) {
                            Log.m529w("Exception sending hit: " + e2.getClass().getSimpleName());
                            Log.m529w(e2.getMessage());
                        }
                    }
                }
            } else if (Log.isDebugEnabled()) {
                Log.m529w("No destination: discarding hit: " + hit.getHitParams());
            } else {
                Log.m529w("No destination: discarding hit.");
            }
            hitsDispatched++;
            i++;
        }
        return hitsDispatched;
    }

    private HttpEntityEnclosingRequest buildRequest(String params, String path) {
        HttpEntityEnclosingRequest request;
        if (TextUtils.isEmpty(params)) {
            Log.m529w("Empty hit, discarding.");
            return null;
        }
        String full = path + "?" + params;
        if (full.length() < 2036) {
            request = new BasicHttpEntityEnclosingRequest("GET", full);
        } else {
            request = new BasicHttpEntityEnclosingRequest("POST", path);
            try {
                request.setEntity(new StringEntity(params));
            } catch (UnsupportedEncodingException e) {
                Log.m529w("Encoding error, discarding hit");
                return null;
            }
        }
        request.addHeader("User-Agent", this.userAgent);
        return request;
    }

    private void logDebugInformation(boolean debug, HttpEntityEnclosingRequest request) {
        int avail;
        if (debug) {
            StringBuffer httpHeaders = new StringBuffer();
            for (Header header : request.getAllHeaders()) {
                httpHeaders.append(header.toString()).append("\n");
            }
            httpHeaders.append(request.getRequestLine().toString()).append("\n");
            if (request.getEntity() != null) {
                try {
                    InputStream is = request.getEntity().getContent();
                    if (is != null && (avail = is.available()) > 0) {
                        byte[] b = new byte[avail];
                        is.read(b);
                        httpHeaders.append("POST:\n");
                        httpHeaders.append(new String(b)).append("\n");
                    }
                } catch (IOException e) {
                    Log.m529w("Error Writing hit to log...");
                }
            }
            Log.m527i(httpHeaders.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public String createUserAgentString(String product, String version, String release, String language, String model, String id) {
        return String.format(USER_AGENT_TEMPLATE, new Object[]{product, version, release, language, model, id});
    }

    private URL getUrl(Hit hit) {
        if (TextUtils.isEmpty(hit.getHitUrl())) {
            return null;
        }
        try {
            return new URL(hit.getHitUrl());
        } catch (MalformedURLException e) {
            try {
                return new URL("http://www.google-analytics.com/collect");
            } catch (MalformedURLException e2) {
                return null;
            }
        }
    }
}
