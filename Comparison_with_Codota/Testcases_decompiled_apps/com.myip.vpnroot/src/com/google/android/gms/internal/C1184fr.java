package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.internal.C1173fm;
import com.google.android.gms.internal.C1234gw;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@C1130ez
/* renamed from: com.google.android.gms.internal.fr */
public final class C1184fr extends C1173fm.C1174a {

    /* renamed from: uf */
    private static final Object f3596uf = new Object();

    /* renamed from: ug */
    private static C1184fr f3597ug;
    private final Context mContext;

    /* renamed from: uh */
    private final C1194fx f3598uh;

    /* renamed from: ui */
    private final C0999ci f3599ui;

    /* renamed from: uj */
    private final C0951bm f3600uj;

    C1184fr(Context context, C0951bm bmVar, C0999ci ciVar, C1194fx fxVar) {
        this.mContext = context;
        this.f3598uh = fxVar;
        this.f3599ui = ciVar;
        this.f3600uj = bmVar;
    }

    /* renamed from: I */
    private static C1234gw.C1236a m4491I(final String str) {
        return new C1234gw.C1236a() {
            /* renamed from: a */
            public void mo7957a(C1232gv gvVar) {
                String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", str});
                C1229gs.m4678V("About to execute: " + format);
                gvVar.loadUrl(format);
            }
        };
    }

    /* renamed from: a */
    private static C1171fk m4492a(Context context, C0951bm bmVar, C0999ci ciVar, C1194fx fxVar, C1168fi fiVar) {
        String string;
        C1229gs.m4675S("Starting ad request from service.");
        ciVar.init();
        C1193fw fwVar = new C1193fw(context);
        if (fwVar.f3653vd == -1) {
            C1229gs.m4675S("Device is offline.");
            return new C1171fk(2);
        }
        final C1188ft ftVar = new C1188ft(fiVar.applicationInfo.packageName);
        if (fiVar.f3539tx.extras != null && (string = fiVar.f3539tx.extras.getString("_ad")) != null) {
            return C1187fs.m4498a(context, fiVar, string);
        }
        Location a = ciVar.mo8214a(250);
        final String bp = bmVar.mo8134bp();
        String a2 = C1187fs.m4499a(fiVar, fwVar, a, bmVar.mo8135bq(), bmVar.mo8136br());
        if (a2 == null) {
            return new C1171fk(0);
        }
        final C1234gw.C1236a I = m4491I(a2);
        final Context context2 = context;
        final C1168fi fiVar2 = fiVar;
        C1228gr.f3776wC.post(new Runnable() {
            public void run() {
                C1232gv a = C1232gv.m4688a(context2, new C0927ay(), false, false, (C1391k) null, fiVar2.f3529lD);
                a.setWillNotDraw(true);
                ftVar.mo8527b(a);
                C1234gw dv = a.mo8631dv();
                dv.mo8652a("/invalidRequest", ftVar.f3612us);
                dv.mo8652a("/loadAdURL", ftVar.f3613ut);
                dv.mo8652a("/log", C0965bx.f2948pG);
                dv.mo8649a(I);
                C1229gs.m4675S("Loading the JS library.");
                a.loadUrl(bp);
            }
        });
        try {
            C1192fv fvVar = ftVar.mo8528cL().get(10, TimeUnit.SECONDS);
            if (fvVar == null) {
                return new C1171fk(0);
            }
            if (fvVar.getErrorCode() != -2) {
                return new C1171fk(fvVar.getErrorCode());
            }
            String str = null;
            if (fvVar.mo8534cO()) {
                str = fxVar.mo8539K(fiVar.f3540ty.packageName);
            }
            return m4493a(context, fiVar.f3529lD.f3777wD, fvVar.getUrl(), str, fvVar);
        } catch (Exception e) {
            return new C1171fk(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.google.android.gms.internal.C1229gs.m4679W("Received error HTTP response code: " + r6);
        r1 = new com.google.android.gms.internal.C1171fk(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.C1171fk m4493a(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.google.android.gms.internal.C1192fv r14) {
        /*
            r9 = 300(0x12c, float:4.2E-43)
            r0 = 0
            com.google.android.gms.internal.fu r3 = new com.google.android.gms.internal.fu     // Catch:{ IOException -> 0x0104 }
            r3.<init>()     // Catch:{ IOException -> 0x0104 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0104 }
            r1.<init>()     // Catch:{ IOException -> 0x0104 }
            java.lang.String r2 = "AdRequestServiceImpl: Sending request: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ IOException -> 0x0104 }
            java.lang.StringBuilder r1 = r1.append(r12)     // Catch:{ IOException -> 0x0104 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0104 }
            com.google.android.gms.internal.C1229gs.m4675S(r1)     // Catch:{ IOException -> 0x0104 }
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x0104 }
            r1.<init>(r12)     // Catch:{ IOException -> 0x0104 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0104 }
            r2 = r1
            r1 = r0
        L_0x0029:
            java.net.URLConnection r0 = r2.openConnection()     // Catch:{ IOException -> 0x0104 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0104 }
            r6 = 0
            com.google.android.gms.internal.C1213gj.m4619a((android.content.Context) r10, (java.lang.String) r11, (boolean) r6, (java.net.HttpURLConnection) r0)     // Catch:{ all -> 0x0127 }
            boolean r6 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0127 }
            if (r6 != 0) goto L_0x003e
            java.lang.String r6 = "x-afma-drt-cookie"
            r0.addRequestProperty(r6, r13)     // Catch:{ all -> 0x0127 }
        L_0x003e:
            if (r14 == 0) goto L_0x0069
            java.lang.String r6 = r14.mo8533cN()     // Catch:{ all -> 0x0127 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0127 }
            if (r6 != 0) goto L_0x0069
            r6 = 1
            r0.setDoOutput(r6)     // Catch:{ all -> 0x0127 }
            java.lang.String r6 = r14.mo8533cN()     // Catch:{ all -> 0x0127 }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x0127 }
            int r7 = r6.length     // Catch:{ all -> 0x0127 }
            r0.setFixedLengthStreamingMode(r7)     // Catch:{ all -> 0x0127 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0127 }
            java.io.OutputStream r8 = r0.getOutputStream()     // Catch:{ all -> 0x0127 }
            r7.<init>(r8)     // Catch:{ all -> 0x0127 }
            r7.write(r6)     // Catch:{ all -> 0x0127 }
            r7.close()     // Catch:{ all -> 0x0127 }
        L_0x0069:
            int r6 = r0.getResponseCode()     // Catch:{ all -> 0x0127 }
            java.util.Map r7 = r0.getHeaderFields()     // Catch:{ all -> 0x0127 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r6 < r8) goto L_0x0097
            if (r6 >= r9) goto L_0x0097
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0127 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0127 }
            java.io.InputStream r8 = r0.getInputStream()     // Catch:{ all -> 0x0127 }
            r2.<init>(r8)     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = com.google.android.gms.internal.C1213gj.m4613a((java.lang.Readable) r2)     // Catch:{ all -> 0x0127 }
            m4495a((java.lang.String) r1, (java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r7, (java.lang.String) r2, (int) r6)     // Catch:{ all -> 0x0127 }
            r3.mo8529a(r1, r7, r2)     // Catch:{ all -> 0x0127 }
            com.google.android.gms.internal.fk r1 = r3.mo8531i((long) r4)     // Catch:{ all -> 0x0127 }
            r0.disconnect()     // Catch:{ IOException -> 0x0104 }
            r0 = r1
        L_0x0096:
            return r0
        L_0x0097:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0127 }
            r8 = 0
            m4495a((java.lang.String) r2, (java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r7, (java.lang.String) r8, (int) r6)     // Catch:{ all -> 0x0127 }
            if (r6 < r9) goto L_0x00db
            r2 = 400(0x190, float:5.6E-43)
            if (r6 >= r2) goto L_0x00db
            java.lang.String r2 = "Location"
            java.lang.String r6 = r0.getHeaderField(r2)     // Catch:{ all -> 0x0127 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0127 }
            if (r2 == 0) goto L_0x00c1
            java.lang.String r1 = "No location header to follow redirect."
            com.google.android.gms.internal.C1229gs.m4679W(r1)     // Catch:{ all -> 0x0127 }
            com.google.android.gms.internal.fk r1 = new com.google.android.gms.internal.fk     // Catch:{ all -> 0x0127 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x0127 }
            r0.disconnect()     // Catch:{ IOException -> 0x0104 }
            r0 = r1
            goto L_0x0096
        L_0x00c1:
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0127 }
            r2.<init>(r6)     // Catch:{ all -> 0x0127 }
            int r1 = r1 + 1
            r6 = 5
            if (r1 <= r6) goto L_0x00fc
            java.lang.String r1 = "Too many redirects."
            com.google.android.gms.internal.C1229gs.m4679W(r1)     // Catch:{ all -> 0x0127 }
            com.google.android.gms.internal.fk r1 = new com.google.android.gms.internal.fk     // Catch:{ all -> 0x0127 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x0127 }
            r0.disconnect()     // Catch:{ IOException -> 0x0104 }
            r0 = r1
            goto L_0x0096
        L_0x00db:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r1.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0127 }
            com.google.android.gms.internal.C1229gs.m4679W(r1)     // Catch:{ all -> 0x0127 }
            com.google.android.gms.internal.fk r1 = new com.google.android.gms.internal.fk     // Catch:{ all -> 0x0127 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x0127 }
            r0.disconnect()     // Catch:{ IOException -> 0x0104 }
            r0 = r1
            goto L_0x0096
        L_0x00fc:
            r3.mo8530e(r7)     // Catch:{ all -> 0x0127 }
            r0.disconnect()     // Catch:{ IOException -> 0x0104 }
            goto L_0x0029
        L_0x0104:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.C1229gs.m4679W(r0)
            com.google.android.gms.internal.fk r0 = new com.google.android.gms.internal.fk
            r1 = 2
            r0.<init>(r1)
            goto L_0x0096
        L_0x0127:
            r1 = move-exception
            r0.disconnect()     // Catch:{ IOException -> 0x0104 }
            throw r1     // Catch:{ IOException -> 0x0104 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1184fr.m4493a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.fv):com.google.android.gms.internal.fk");
    }

    /* renamed from: a */
    public static C1184fr m4494a(Context context, C0951bm bmVar, C0999ci ciVar, C1194fx fxVar) {
        C1184fr frVar;
        synchronized (f3596uf) {
            if (f3597ug == null) {
                f3597ug = new C1184fr(context.getApplicationContext(), bmVar, ciVar, fxVar);
            }
            frVar = f3597ug;
        }
        return frVar;
    }

    /* renamed from: a */
    private static void m4495a(String str, Map<String, List<String>> map, String str2, int i) {
        if (C1229gs.m4684u(2)) {
            C1229gs.m4678V("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String next : map.keySet()) {
                    C1229gs.m4678V("    " + next + ":");
                    for (String str3 : map.get(next)) {
                        C1229gs.m4678V("      " + str3);
                    }
                }
            }
            C1229gs.m4678V("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    C1229gs.m4678V(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                C1229gs.m4678V("    null");
            }
            C1229gs.m4678V("  Response Code:\n    " + i + "\n}");
        }
    }

    /* renamed from: b */
    public C1171fk mo8507b(C1168fi fiVar) {
        return m4492a(this.mContext, this.f3600uj, this.f3599ui, this.f3598uh, fiVar);
    }
}
