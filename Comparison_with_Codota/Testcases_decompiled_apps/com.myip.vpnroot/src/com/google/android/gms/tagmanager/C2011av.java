package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* renamed from: com.google.android.gms.tagmanager.av */
class C2011av implements C2033bm {
    private HttpClient apj;

    C2011av() {
    }

    /* renamed from: a */
    private InputStream m6780a(HttpClient httpClient, HttpResponse httpResponse) throws IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            C2028bh.m6818V("Success response");
            return httpResponse.getEntity().getContent();
        }
        String str = "Bad response: " + statusCode;
        if (statusCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    /* renamed from: a */
    private void m6781a(HttpClient httpClient) {
        if (httpClient != null && httpClient.getConnectionManager() != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    /* renamed from: cA */
    public InputStream mo11565cA(String str) throws IOException {
        this.apj = mo11567ot();
        return m6780a(this.apj, this.apj.execute(new HttpGet(str)));
    }

    public void close() {
        m6781a(this.apj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ot */
    public HttpClient mo11567ot() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        return new DefaultHttpClient(basicHttpParams);
    }
}
