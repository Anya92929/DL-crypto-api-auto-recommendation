package com.google.android.gms.internal;

import android.content.Context;

@C1130ez
/* renamed from: com.google.android.gms.internal.ck */
public final class C1001ck {

    /* renamed from: lq */
    private final C1013ct f3019lq;
    private final Context mContext;

    /* renamed from: mw */
    private final Object f3020mw = new Object();

    /* renamed from: pQ */
    private final C1168fi f3021pQ;

    /* renamed from: pR */
    private final C1004cm f3022pR;

    /* renamed from: pS */
    private boolean f3023pS = false;

    /* renamed from: pT */
    private C1007cp f3024pT;

    public C1001ck(Context context, C1168fi fiVar, C1013ct ctVar, C1004cm cmVar) {
        this.mContext = context;
        this.f3021pQ = fiVar;
        this.f3019lq = ctVar;
        this.f3022pR = cmVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0080, code lost:
        r4 = r16.f3024pT.mo8232b(r17, r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
        if (r4.f3060qx != 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
        com.google.android.gms.internal.C1229gs.m4675S("Adapter succeeded.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009b, code lost:
        if (r4.f3062qz == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009d, code lost:
        com.google.android.gms.internal.C1228gr.f3776wC.post(new com.google.android.gms.internal.C1001ck.C10021(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return r4;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.C1009cq mo8216a(long r17, long r19) {
        /*
            r16 = this;
            java.lang.String r4 = "Starting mediation."
            com.google.android.gms.internal.C1229gs.m4675S(r4)
            r0 = r16
            com.google.android.gms.internal.cm r4 = r0.f3022pR
            java.util.List<com.google.android.gms.internal.cl> r4 = r4.f3034qd
            java.util.Iterator r13 = r4.iterator()
        L_0x000f:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x00aa
            java.lang.Object r9 = r13.next()
            com.google.android.gms.internal.cl r9 = (com.google.android.gms.internal.C1003cl) r9
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Trying mediation network: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r9.f3028pX
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.C1229gs.m4677U(r4)
            java.util.List<java.lang.String> r4 = r9.f3029pY
            java.util.Iterator r14 = r4.iterator()
        L_0x0039:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x000f
            java.lang.Object r6 = r14.next()
            java.lang.String r6 = (java.lang.String) r6
            r0 = r16
            java.lang.Object r15 = r0.f3020mw
            monitor-enter(r15)
            r0 = r16
            boolean r4 = r0.f3023pS     // Catch:{ all -> 0x0096 }
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.internal.cq r4 = new com.google.android.gms.internal.cq     // Catch:{ all -> 0x0096 }
            r5 = -1
            r4.<init>(r5)     // Catch:{ all -> 0x0096 }
            monitor-exit(r15)     // Catch:{ all -> 0x0096 }
        L_0x0057:
            return r4
        L_0x0058:
            com.google.android.gms.internal.cp r4 = new com.google.android.gms.internal.cp     // Catch:{ all -> 0x0096 }
            r0 = r16
            android.content.Context r5 = r0.mContext     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.ct r7 = r0.f3019lq     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.cm r8 = r0.f3022pR     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.fi r10 = r0.f3021pQ     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.av r10 = r10.f3539tx     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.fi r11 = r0.f3021pQ     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ay r11 = r11.f3530lH     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.fi r12 = r0.f3021pQ     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.gt r12 = r12.f3529lD     // Catch:{ all -> 0x0096 }
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0096 }
            r0 = r16
            r0.f3024pT = r4     // Catch:{ all -> 0x0096 }
            monitor-exit(r15)     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.cp r4 = r0.f3024pT
            r0 = r17
            r2 = r19
            com.google.android.gms.internal.cq r4 = r4.mo8232b(r0, r2)
            int r5 = r4.f3060qx
            if (r5 != 0) goto L_0x0099
            java.lang.String r5 = "Adapter succeeded."
            com.google.android.gms.internal.C1229gs.m4675S(r5)
            goto L_0x0057
        L_0x0096:
            r4 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0096 }
            throw r4
        L_0x0099:
            com.google.android.gms.internal.cu r5 = r4.f3062qz
            if (r5 == 0) goto L_0x0039
            android.os.Handler r5 = com.google.android.gms.internal.C1228gr.f3776wC
            com.google.android.gms.internal.ck$1 r6 = new com.google.android.gms.internal.ck$1
            r0 = r16
            r6.<init>(r4)
            r5.post(r6)
            goto L_0x0039
        L_0x00aa:
            com.google.android.gms.internal.cq r4 = new com.google.android.gms.internal.cq
            r5 = 1
            r4.<init>(r5)
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1001ck.mo8216a(long, long):com.google.android.gms.internal.cq");
    }

    public void cancel() {
        synchronized (this.f3020mw) {
            this.f3023pS = true;
            if (this.f3024pT != null) {
                this.f3024pT.cancel();
            }
        }
    }
}
