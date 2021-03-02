package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.tagmanager.aw */
class C2012aw implements C2033bm {
    private HttpURLConnection apk;

    C2012aw() {
    }

    /* renamed from: a */
    private InputStream m6784a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    /* renamed from: b */
    private void m6785b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: cA */
    public InputStream mo11565cA(String str) throws IOException {
        this.apk = mo11568cB(str);
        return m6784a(this.apk);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cB */
    public HttpURLConnection mo11568cB(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }

    public void close() {
        m6785b(this.apk);
    }
}
