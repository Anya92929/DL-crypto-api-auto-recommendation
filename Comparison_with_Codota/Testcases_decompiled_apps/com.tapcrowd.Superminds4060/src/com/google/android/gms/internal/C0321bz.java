package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.C0318by;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.bz */
public final class C0321bz extends C0318by.C0319a {

    /* renamed from: gL */
    private static final Object f936gL = new Object();

    /* renamed from: gM */
    private static C0321bz f937gM;

    /* renamed from: gN */
    private final C0224al f938gN;
    private final Context mContext;

    private C0321bz(Context context, C0224al alVar) {
        this.mContext = context;
        this.f938gN = alVar;
    }

    /* renamed from: a */
    private static C0316bw m653a(final Context context, C0224al alVar, final C0313bu buVar) {
        C0344cn.m733m("Starting ad request from service.");
        alVar.init();
        C0329cd cdVar = new C0329cd(context);
        if (cdVar.f973hs == -1) {
            C0344cn.m733m("Device is offline.");
            return new C0316bw(2);
        }
        final C0325cb cbVar = new C0325cb();
        final String a = C0324ca.m658a(buVar, cdVar, alVar.mo4039a(250));
        if (a == null) {
            return new C0316bw(0);
        }
        C0343cm.f1013hO.post(new Runnable() {
            public void run() {
                C0347cq a = C0347cq.m741a(context, new C0622x(), false, false, (C0599h) null, buVar.f912eg);
                a.setWillNotDraw(true);
                cbVar.mo4187b(a);
                C0348cr aw = a.mo4212aw();
                aw.mo4225a("/invalidRequest", cbVar.f947gU);
                aw.mo4225a("/loadAdURL", cbVar.f948gV);
                aw.mo4225a("/log", C0213ah.f567eE);
                C0344cn.m733m("Getting the ad request URL.");
                a.loadDataWithBaseURL("http://googleads.g.doubleclick.net", "<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(" + a + ");</script></head><body></body></html>", "text/html", "UTF-8", (String) null);
            }
        });
        String aj = cbVar.mo4186aj();
        return TextUtils.isEmpty(aj) ? new C0316bw(cbVar.getErrorCode()) : m654a(context, buVar.f912eg.f1014hP, aj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        com.google.android.gms.internal.C0344cn.m737q("Received error HTTP response code: " + r4);
        r1 = new com.google.android.gms.internal.C0316bw(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.C0316bw m654a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = 300(0x12c, float:4.2E-43)
            r0 = 0
            com.google.android.gms.internal.cc r3 = new com.google.android.gms.internal.cc     // Catch:{ IOException -> 0x00b4 }
            r3.<init>()     // Catch:{ IOException -> 0x00b4 }
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00b4 }
            r1.<init>(r10)     // Catch:{ IOException -> 0x00b4 }
            r2 = r1
            r1 = r0
        L_0x000f:
            java.net.URLConnection r0 = r2.openConnection()     // Catch:{ IOException -> 0x00b4 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x00b4 }
            r4 = 0
            com.google.android.gms.internal.C0337ci.m694a(r8, r9, r4, r0)     // Catch:{ all -> 0x00d7 }
            int r4 = r0.getResponseCode()     // Catch:{ all -> 0x00d7 }
            java.util.Map r5 = r0.getHeaderFields()     // Catch:{ all -> 0x00d7 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 < r6) goto L_0x0047
            if (r4 >= r7) goto L_0x0047
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00d7 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x00d7 }
            java.io.InputStream r6 = r0.getInputStream()     // Catch:{ all -> 0x00d7 }
            r2.<init>(r6)     // Catch:{ all -> 0x00d7 }
            java.lang.String r2 = com.google.android.gms.internal.C0337ci.m688a((java.lang.Readable) r2)     // Catch:{ all -> 0x00d7 }
            m656a(r1, r5, r2, r4)     // Catch:{ all -> 0x00d7 }
            r3.mo4189a(r1, r5, r2)     // Catch:{ all -> 0x00d7 }
            com.google.android.gms.internal.bw r1 = r3.mo4190ak()     // Catch:{ all -> 0x00d7 }
            r0.disconnect()     // Catch:{ IOException -> 0x00b4 }
            r0 = r1
        L_0x0046:
            return r0
        L_0x0047:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d7 }
            r6 = 0
            m656a(r2, r5, r6, r4)     // Catch:{ all -> 0x00d7 }
            if (r4 < r7) goto L_0x008b
            r2 = 400(0x190, float:5.6E-43)
            if (r4 >= r2) goto L_0x008b
            java.lang.String r2 = "Location"
            java.lang.String r4 = r0.getHeaderField(r2)     // Catch:{ all -> 0x00d7 }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x0071
            java.lang.String r1 = "No location header to follow redirect."
            com.google.android.gms.internal.C0344cn.m737q(r1)     // Catch:{ all -> 0x00d7 }
            com.google.android.gms.internal.bw r1 = new com.google.android.gms.internal.bw     // Catch:{ all -> 0x00d7 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x00d7 }
            r0.disconnect()     // Catch:{ IOException -> 0x00b4 }
            r0 = r1
            goto L_0x0046
        L_0x0071:
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x00d7 }
            r2.<init>(r4)     // Catch:{ all -> 0x00d7 }
            int r1 = r1 + 1
            r4 = 5
            if (r1 <= r4) goto L_0x00ac
            java.lang.String r1 = "Too many redirects."
            com.google.android.gms.internal.C0344cn.m737q(r1)     // Catch:{ all -> 0x00d7 }
            com.google.android.gms.internal.bw r1 = new com.google.android.gms.internal.bw     // Catch:{ all -> 0x00d7 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x00d7 }
            r0.disconnect()     // Catch:{ IOException -> 0x00b4 }
            r0 = r1
            goto L_0x0046
        L_0x008b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r1.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00d7 }
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d7 }
            com.google.android.gms.internal.C0344cn.m737q(r1)     // Catch:{ all -> 0x00d7 }
            com.google.android.gms.internal.bw r1 = new com.google.android.gms.internal.bw     // Catch:{ all -> 0x00d7 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x00d7 }
            r0.disconnect()     // Catch:{ IOException -> 0x00b4 }
            r0 = r1
            goto L_0x0046
        L_0x00ac:
            r3.mo4191d(r5)     // Catch:{ all -> 0x00d7 }
            r0.disconnect()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x000f
        L_0x00b4:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.C0344cn.m737q(r0)
            com.google.android.gms.internal.bw r0 = new com.google.android.gms.internal.bw
            r1 = 2
            r0.<init>(r1)
            goto L_0x0046
        L_0x00d7:
            r1 = move-exception
            r0.disconnect()     // Catch:{ IOException -> 0x00b4 }
            throw r1     // Catch:{ IOException -> 0x00b4 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0321bz.m654a(android.content.Context, java.lang.String, java.lang.String):com.google.android.gms.internal.bw");
    }

    /* renamed from: a */
    public static C0321bz m655a(Context context, C0224al alVar) {
        C0321bz bzVar;
        synchronized (f936gL) {
            if (f937gM == null) {
                f937gM = new C0321bz(context.getApplicationContext(), alVar);
            }
            bzVar = f937gM;
        }
        return bzVar;
    }

    /* renamed from: a */
    private static void m656a(String str, Map<String, List<String>> map, String str2, int i) {
        if (C0344cn.m732k(2)) {
            C0344cn.m736p("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String next : map.keySet()) {
                    C0344cn.m736p("    " + next + ":");
                    for (String str3 : map.get(next)) {
                        C0344cn.m736p("      " + str3);
                    }
                }
            }
            C0344cn.m736p("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
                    C0344cn.m736p(str2.substring(i2, Math.min(str2.length(), i2 + LocationStatusCodes.GEOFENCE_NOT_AVAILABLE)));
                }
            } else {
                C0344cn.m736p("    null");
            }
            C0344cn.m736p("  Response Code:\n    " + i + "\n}");
        }
    }

    /* renamed from: a */
    public C0316bw mo4181a(C0313bu buVar) {
        return m653a(this.mContext, this.f938gN, buVar);
    }
}
