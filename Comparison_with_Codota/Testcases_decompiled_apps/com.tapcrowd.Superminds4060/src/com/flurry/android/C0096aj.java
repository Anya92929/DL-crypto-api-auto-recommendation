package com.flurry.android;

import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* renamed from: com.flurry.android.aj */
final class C0096aj extends SSLSocketFactory {

    /* renamed from: a */
    private SSLContext f118a = SSLContext.getInstance("TLS");

    public C0096aj(FlurryAgent flurryAgent, KeyStore keyStore) {
        super(keyStore);
        C0112n nVar = new C0112n();
        this.f118a.init((KeyManager[]) null, new TrustManager[]{nVar}, (SecureRandom) null);
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.f118a.getSocketFactory().createSocket(socket, str, i, z);
    }

    public final Socket createSocket() {
        return this.f118a.getSocketFactory().createSocket();
    }
}
