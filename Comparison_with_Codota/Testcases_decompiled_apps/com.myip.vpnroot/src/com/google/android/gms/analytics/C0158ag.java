package com.google.android.gms.analytics;

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
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

/* renamed from: com.google.android.gms.analytics.ag */
class C0158ag implements C0179m {

    /* renamed from: Bj */
    private final HttpClient f151Bj;

    /* renamed from: Bk */
    private URL f152Bk;
    private final Context mContext;

    /* renamed from: vW */
    private final String f153vW;

    /* renamed from: yu */
    private GoogleAnalytics f154yu;

    C0158ag(HttpClient httpClient, Context context) {
        this(httpClient, GoogleAnalytics.getInstance(context), context);
    }

    C0158ag(HttpClient httpClient, GoogleAnalytics googleAnalytics, Context context) {
        this.mContext = context.getApplicationContext();
        this.f153vW = mo3627a("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, C0162aj.m143a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f151Bj = httpClient;
        this.f154yu = googleAnalytics;
    }

    /* renamed from: a */
    private void m114a(C0151aa aaVar, URL url, boolean z) {
        URL url2;
        if (!TextUtils.isEmpty(aaVar.mo3599eM()) && mo3631eT()) {
            if (url == null) {
                try {
                    url2 = this.f152Bk != null ? this.f152Bk : new URL("https://ssl.google-analytics.com/collect");
                } catch (MalformedURLException e) {
                    return;
                }
            } else {
                url2 = url;
            }
            HttpHost httpHost = new HttpHost(url2.getHost(), url2.getPort(), url2.getProtocol());
            try {
                HttpEntityEnclosingRequest h = m116h(aaVar.mo3599eM(), url2.getPath());
                if (h != null) {
                    h.addHeader("Host", httpHost.toHostString());
                    if (C0207z.m310eL()) {
                        m115a(h);
                    }
                    if (z) {
                        C0182p.m211A(this.mContext);
                    }
                    HttpResponse execute = this.f151Bj.execute(httpHost, h);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        C0207z.m309W("Bad response: " + execute.getStatusLine().getStatusCode());
                    }
                }
            } catch (ClientProtocolException e2) {
                C0207z.m309W("ClientProtocolException sending monitoring hit.");
            } catch (IOException e3) {
                C0207z.m309W("Exception sending monitoring hit: " + e3.getClass().getSimpleName());
                C0207z.m309W(e3.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m115a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        int available;
        StringBuffer stringBuffer = new StringBuffer();
        for (Header obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null && (available = content.available()) > 0) {
                    byte[] bArr = new byte[available];
                    content.read(bArr);
                    stringBuffer.append("POST:\n");
                    stringBuffer.append(new String(bArr)).append("\n");
                }
            } catch (IOException e) {
                C0207z.m308V("Error Writing hit to log...");
            }
        }
        C0207z.m308V(stringBuffer.toString());
    }

    /* renamed from: h */
    private HttpEntityEnclosingRequest m116h(String str, String str2) {
        BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        if (TextUtils.isEmpty(str)) {
            C0207z.m309W("Empty hit, discarding.");
            return null;
        }
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                C0207z.m309W("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.f153vW);
        return basicHttpEntityEnclosingRequest;
    }

    /* renamed from: a */
    public int mo3626a(List<C0204w> list, C0151aa aaVar, boolean z) {
        int i;
        URL url;
        int i2 = 0;
        int min = Math.min(list.size(), 40);
        aaVar.mo3598e("_hr", list.size());
        int i3 = 0;
        URL url2 = null;
        boolean z2 = true;
        int i4 = 0;
        while (i4 < min) {
            C0204w wVar = list.get(i4);
            URL a = mo3628a(wVar);
            if (a == null) {
                if (C0207z.m310eL()) {
                    C0207z.m309W("No destination: discarding hit: " + wVar.mo3747eG());
                } else {
                    C0207z.m309W("No destination: discarding hit.");
                }
                i3++;
                URL url3 = url2;
                i = i2 + 1;
                url = url3;
            } else {
                HttpHost httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                String path = a.getPath();
                String a2 = TextUtils.isEmpty(wVar.mo3747eG()) ? "" : C0205x.m303a(wVar, System.currentTimeMillis());
                HttpEntityEnclosingRequest h = m116h(a2, path);
                if (h == null) {
                    i3++;
                    i = i2 + 1;
                    url = a;
                } else {
                    h.addHeader("Host", httpHost.toHostString());
                    if (C0207z.m310eL()) {
                        m115a(h);
                    }
                    if (a2.length() > 8192) {
                        C0207z.m309W("Hit too long (> 8192 bytes)--not sent");
                        i3++;
                    } else if (this.f154yu.isDryRunEnabled()) {
                        C0207z.m307U("Dry run enabled. Hit not actually sent.");
                    } else {
                        if (z2) {
                            try {
                                C0182p.m211A(this.mContext);
                                z2 = false;
                            } catch (ClientProtocolException e) {
                                C0207z.m309W("ClientProtocolException sending hit; discarding hit...");
                                aaVar.mo3598e("_hd", i3);
                            } catch (IOException e2) {
                                C0207z.m309W("Exception sending hit: " + e2.getClass().getSimpleName());
                                C0207z.m309W(e2.getMessage());
                                aaVar.mo3598e("_de", 1);
                                aaVar.mo3598e("_hd", i3);
                                aaVar.mo3598e("_hs", i2);
                                m114a(aaVar, a, z2);
                                return i2;
                            }
                        }
                        HttpResponse execute = this.f151Bj.execute(httpHost, h);
                        int statusCode = execute.getStatusLine().getStatusCode();
                        HttpEntity entity = execute.getEntity();
                        if (entity != null) {
                            entity.consumeContent();
                        }
                        if (statusCode != 200) {
                            C0207z.m309W("Bad response: " + execute.getStatusLine().getStatusCode());
                        }
                    }
                    aaVar.mo3598e("_td", a2.getBytes().length);
                    i = i2 + 1;
                    url = a;
                }
            }
            i4++;
            i2 = i;
            url2 = url;
        }
        aaVar.mo3598e("_hd", i3);
        aaVar.mo3598e("_hs", i2);
        if (z) {
            m114a(aaVar, url2, z2);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo3627a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public URL mo3628a(C0204w wVar) {
        if (this.f152Bk != null) {
            return this.f152Bk;
        }
        try {
            return new URL("http:".equals(wVar.mo3750eJ()) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            C0207z.m306T("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    /* renamed from: af */
    public void mo3629af(String str) {
        try {
            this.f152Bk = new URL(str);
        } catch (MalformedURLException e) {
            this.f152Bk = null;
        }
    }

    /* renamed from: dY */
    public boolean mo3630dY() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C0207z.m308V("...no network connectivity");
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eT */
    public boolean mo3631eT() {
        return Math.random() * 100.0d <= 1.0d;
    }
}
