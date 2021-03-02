package com.forexcrunch.forexcrunch.http;

import android.content.Context;
import android.util.Log;
import com.parse.entity.mime.MIME;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class RestClient {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$forexcrunch$forexcrunch$http$RequestMethod;
    private boolean authentication;
    protected Context context;
    private ArrayList<NameValuePair> headers = new ArrayList<>();
    private String jsonBody;
    private String message;
    private ArrayList<NameValuePair> params = new ArrayList<>();
    private String password;
    private String response;
    private int responseCode;
    private String url;
    private String username;

    static /* synthetic */ int[] $SWITCH_TABLE$com$forexcrunch$forexcrunch$http$RequestMethod() {
        int[] iArr = $SWITCH_TABLE$com$forexcrunch$forexcrunch$http$RequestMethod;
        if (iArr == null) {
            iArr = new int[RequestMethod.values().length];
            try {
                iArr[RequestMethod.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RequestMethod.GET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[RequestMethod.POST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[RequestMethod.PUT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$forexcrunch$forexcrunch$http$RequestMethod = iArr;
        }
        return iArr;
    }

    public RestClient(String url2) {
        this.url = url2;
    }

    public void addBasicAuthentication(String user, String pass) {
        this.authentication = true;
        this.username = user;
        this.password = pass;
    }

    public void addHeader(String name, String value) {
        this.headers.add(new BasicNameValuePair(name, value));
    }

    public void addParam(String name, String value) {
        this.params.add(new BasicNameValuePair(name, value));
    }

    public void execute(RequestMethod method) throws Exception {
        switch ($SWITCH_TABLE$com$forexcrunch$forexcrunch$http$RequestMethod()[method.ordinal()]) {
            case 1:
                executeRequest(addHeaderParams(new HttpDelete(this.url)), this.url);
                return;
            case 2:
                executeRequest(addHeaderParams(new HttpGet(String.valueOf(this.url) + addGetParams())), this.url);
                return;
            case 3:
                executeRequest(addBodyParams(addHeaderParams(new HttpPost(this.url))), this.url);
                return;
            case 4:
                executeRequest(addBodyParams(addHeaderParams(new HttpPut(this.url))), this.url);
                return;
            default:
                return;
        }
    }

    private HttpUriRequest addHeaderParams(HttpUriRequest request) throws Exception {
        Iterator<NameValuePair> it = this.headers.iterator();
        while (it.hasNext()) {
            NameValuePair h = it.next();
            request.addHeader(h.getName(), h.getValue());
        }
        if (this.authentication) {
            request.addHeader(new BasicScheme().authenticate(new UsernamePasswordCredentials(this.username, this.password), request));
        }
        return request;
    }

    private HttpUriRequest addBodyParams(HttpUriRequest request) throws Exception {
        if (this.jsonBody != null) {
            request.addHeader(MIME.CONTENT_TYPE, "application/json");
            if (request instanceof HttpPost) {
                ((HttpPost) request).setEntity(new StringEntity(this.jsonBody, "UTF-8"));
            } else if (request instanceof HttpPut) {
                ((HttpPut) request).setEntity(new StringEntity(this.jsonBody, "UTF-8"));
            }
        } else if (!this.params.isEmpty()) {
            if (request instanceof HttpPost) {
                ((HttpPost) request).setEntity(new UrlEncodedFormEntity(this.params, "UTF-8"));
            } else if (request instanceof HttpPut) {
                ((HttpPut) request).setEntity(new UrlEncodedFormEntity(this.params, "UTF-8"));
            }
        }
        return request;
    }

    private String addGetParams() throws Exception {
        StringBuffer combinedParams = new StringBuffer();
        if (!this.params.isEmpty()) {
            combinedParams.append("?");
            Iterator<NameValuePair> it = this.params.iterator();
            while (it.hasNext()) {
                NameValuePair p = it.next();
                combinedParams.append(String.valueOf(combinedParams.length() > 1 ? "&" : "") + p.getName() + "=" + URLEncoder.encode(p.getValue(), "UTF-8"));
            }
        }
        return combinedParams.toString();
    }

    public String getErrorMessage() {
        return this.message;
    }

    public String getResponse() {
        return this.response;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setContext(Context ctx) {
        this.context = ctx;
    }

    public void setJSONString(String data) {
        this.jsonBody = data;
    }

    private void executeRequest(HttpUriRequest request, String url2) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpParams params2 = client.getParams();
        HttpConnectionParams.setConnectionTimeout(params2, 30000);
        HttpConnectionParams.setSoTimeout(params2, 30000);
        try {
            Log.e("URL", request.getURI().toString());
            HttpResponse httpResponse = client.execute(request);
            this.responseCode = httpResponse.getStatusLine().getStatusCode();
            this.message = httpResponse.getStatusLine().getReasonPhrase();
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                this.response = convertStreamToString(instream);
                instream.close();
            }
        } catch (ClientProtocolException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        } catch (IOException e2) {
            client.getConnectionManager().shutdown();
            e2.printStackTrace();
        }
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    try {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    sb.append(String.valueOf(line) + "\n");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    is.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    is.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        is.close();
        return sb.toString();
    }

    public String getJsonBody() {
        return this.jsonBody;
    }

    public void setJsonBody(String jsonBody2) {
        this.jsonBody = jsonBody2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        this.message = message2;
    }
}
