package com.google.ads;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.ads.ae */
public class C0170ae implements Runnable {

    /* renamed from: a */
    private final Context f125a;

    /* renamed from: b */
    private final String f126b;

    public C0170ae(String str, Context context) {
        this.f126b = str;
        this.f125a = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo3327a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0066 }
            r0.<init>()     // Catch:{ Throwable -> 0x0066 }
            java.lang.String r1 = "Pinging URL: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0066 }
            java.lang.String r1 = r4.f126b     // Catch:{ Throwable -> 0x0066 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0066 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0066 }
            com.google.ads.util.C0284b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0066 }
            java.net.URL r0 = new java.net.URL     // Catch:{ Throwable -> 0x0066 }
            java.lang.String r1 = r4.f126b     // Catch:{ Throwable -> 0x0066 }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0066 }
            java.net.HttpURLConnection r1 = r4.mo3327a(r0)     // Catch:{ Throwable -> 0x0066 }
            android.content.Context r0 = r4.f125a     // Catch:{ all -> 0x0061 }
            com.google.ads.util.AdUtil.m447a((java.net.HttpURLConnection) r1, (android.content.Context) r0)     // Catch:{ all -> 0x0061 }
            r0 = 1
            r1.setInstanceFollowRedirects(r0)     // Catch:{ all -> 0x0061 }
            r1.connect()     // Catch:{ all -> 0x0061 }
            int r0 = r1.getResponseCode()     // Catch:{ all -> 0x0061 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 < r2) goto L_0x003b
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 < r2) goto L_0x005d
        L_0x003b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r2.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = "Did not receive 2XX (got "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = ") from pinging URL: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = r4.f126b     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0061 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0061 }
            com.google.ads.util.C0284b.m490e(r0)     // Catch:{ all -> 0x0061 }
        L_0x005d:
            r1.disconnect()     // Catch:{ Throwable -> 0x0066 }
        L_0x0060:
            return
        L_0x0061:
            r0 = move-exception
            r1.disconnect()     // Catch:{ Throwable -> 0x0066 }
            throw r0     // Catch:{ Throwable -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to ping the URL: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r4.f126b
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.ads.util.C0284b.m489d(r1, r0)
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.C0170ae.run():void");
    }
}
