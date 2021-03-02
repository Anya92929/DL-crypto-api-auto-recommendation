package com.google.ads.internal;

import android.content.Context;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import com.parse.entity.mime.MIME;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.ads.internal.j */
public class C0255j implements Runnable {

    /* renamed from: a */
    private String f597a;

    /* renamed from: b */
    private Context f598b;

    public C0255j(String str, Context context) {
        this.f597a = str;
        this.f598b = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo3623a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        AdUtil.m447a(httpURLConnection, this.f598b);
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "application/json");
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public BufferedOutputStream mo3622a(HttpURLConnection httpURLConnection) throws IOException {
        return new BufferedOutputStream(httpURLConnection.getOutputStream());
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r3 = this;
            com.google.ads.m r0 = com.google.ads.C0265m.m411a()
            com.google.ads.util.i$b<com.google.ads.m$a> r0 = r0.f616b
            java.lang.Object r0 = r0.mo3725a()
            com.google.ads.m$a r0 = (com.google.ads.C0265m.C0266a) r0
            com.google.ads.util.i$c<java.lang.String> r0 = r0.f625h
            java.lang.Object r0 = r0.mo3726a()
            java.lang.String r0 = (java.lang.String) r0
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x0069 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0069 }
            java.net.HttpURLConnection r1 = r3.mo3623a((java.net.URL) r1)     // Catch:{ IOException -> 0x0069 }
            com.google.ads.internal.j$a r0 = new com.google.ads.internal.j$a     // Catch:{ IOException -> 0x0069 }
            java.lang.String r2 = r3.f597a     // Catch:{ IOException -> 0x0069 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0069 }
            org.json.JSONObject r0 = r0.mo3625a()     // Catch:{ IOException -> 0x0069 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0069 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0069 }
            int r2 = r0.length     // Catch:{ IOException -> 0x0069 }
            r1.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x0069 }
            java.io.BufferedOutputStream r2 = r3.mo3622a((java.net.HttpURLConnection) r1)     // Catch:{ all -> 0x0064 }
            r2.write(r0)     // Catch:{ all -> 0x0064 }
            r2.close()     // Catch:{ all -> 0x0064 }
            int r0 = r1.getResponseCode()     // Catch:{ all -> 0x0064 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 == r2) goto L_0x0060
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r0.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "Got error response from BadAd backend: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = r1.getResponseMessage()     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0064 }
            com.google.ads.util.C0284b.m484b(r0)     // Catch:{ all -> 0x0064 }
        L_0x0060:
            r1.disconnect()     // Catch:{ IOException -> 0x0069 }
        L_0x0063:
            return
        L_0x0064:
            r0 = move-exception
            r1.disconnect()     // Catch:{ IOException -> 0x0069 }
            throw r0     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            r0 = move-exception
            java.lang.String r1 = "Error reporting bad ad."
            com.google.ads.util.C0284b.m485b(r1, r0)
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.internal.C0255j.run():void");
    }

    /* renamed from: com.google.ads.internal.j$a */
    public static class C0256a {

        /* renamed from: a */
        private final String f599a;

        public C0256a(String str) {
            this.f599a = str;
        }

        /* renamed from: a */
        public JSONObject mo3625a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("debugHeader", this.f599a);
            } catch (JSONException e) {
                C0284b.m485b("Could not build ReportAdJson from inputs.", e);
            }
            return jSONObject;
        }
    }
}
