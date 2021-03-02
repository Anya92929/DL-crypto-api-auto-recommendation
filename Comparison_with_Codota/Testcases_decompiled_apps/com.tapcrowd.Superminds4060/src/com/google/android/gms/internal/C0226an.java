package com.google.android.gms.internal;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.an */
public final class C0226an {

    /* renamed from: dZ */
    private final C0238aw f572dZ;

    /* renamed from: eI */
    private final C0313bu f573eI;

    /* renamed from: eJ */
    private final Object f574eJ = new Object();

    /* renamed from: eK */
    private final C0229ap f575eK;

    /* renamed from: eL */
    private boolean f576eL = false;

    /* renamed from: eM */
    private C0232as f577eM;
    private final Context mContext;

    public C0226an(Context context, C0313bu buVar, C0238aw awVar, C0229ap apVar) {
        this.mContext = context;
        this.f573eI = buVar;
        this.f572dZ = awVar;
        this.f575eK = apVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0068, code lost:
        r0 = r11.f577eM.mo4057b(r12, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0070, code lost:
        if (r0.f606fl != 0) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
        com.google.android.gms.internal.C0344cn.m733m("Adapter succeeded.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        if (r0.f608fn == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        com.google.android.gms.internal.C0343cm.f1013hO.post(new com.google.android.gms.internal.C0226an.C02271(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.C0234at mo4041a(long r12, long r14) {
        /*
            r11 = this;
            java.lang.String r0 = "Starting mediation."
            com.google.android.gms.internal.C0344cn.m733m(r0)
            com.google.android.gms.internal.ap r0 = r11.f575eK
            java.util.List<com.google.android.gms.internal.ao> r0 = r0.f585eU
            java.util.Iterator r8 = r0.iterator()
        L_0x000d:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x008a
            java.lang.Object r5 = r8.next()
            com.google.android.gms.internal.ao r5 = (com.google.android.gms.internal.C0228ao) r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Trying mediation network: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r5.f580eP
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.C0344cn.m735o(r0)
            java.util.List<java.lang.String> r0 = r5.f581eQ
            java.util.Iterator r9 = r0.iterator()
        L_0x0037:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r2 = r9.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r10 = r11.f574eJ
            monitor-enter(r10)
            boolean r0 = r11.f576eL     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0052
            com.google.android.gms.internal.at r0 = new com.google.android.gms.internal.at     // Catch:{ all -> 0x0078 }
            r1 = -1
            r0.<init>(r1)     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)     // Catch:{ all -> 0x0078 }
        L_0x0051:
            return r0
        L_0x0052:
            com.google.android.gms.internal.as r0 = new com.google.android.gms.internal.as     // Catch:{ all -> 0x0078 }
            android.content.Context r1 = r11.mContext     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.aw r3 = r11.f572dZ     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.ap r4 = r11.f575eK     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.bu r6 = r11.f573eI     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.v r6 = r6.f914gB     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.bu r7 = r11.f573eI     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.x r7 = r7.f911ed     // Catch:{ all -> 0x0078 }
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0078 }
            r11.f577eM = r0     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.as r0 = r11.f577eM
            com.google.android.gms.internal.at r0 = r0.mo4057b(r12, r14)
            int r1 = r0.f606fl
            if (r1 != 0) goto L_0x007b
            java.lang.String r1 = "Adapter succeeded."
            com.google.android.gms.internal.C0344cn.m733m(r1)
            goto L_0x0051
        L_0x0078:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0078 }
            throw r0
        L_0x007b:
            com.google.android.gms.internal.ax r1 = r0.f608fn
            if (r1 == 0) goto L_0x0037
            android.os.Handler r1 = com.google.android.gms.internal.C0343cm.f1013hO
            com.google.android.gms.internal.an$1 r2 = new com.google.android.gms.internal.an$1
            r2.<init>(r0)
            r1.post(r2)
            goto L_0x0037
        L_0x008a:
            com.google.android.gms.internal.at r0 = new com.google.android.gms.internal.at
            r1 = 1
            r0.<init>(r1)
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0226an.mo4041a(long, long):com.google.android.gms.internal.at");
    }

    public void cancel() {
        synchronized (this.f574eJ) {
            this.f576eL = true;
            if (this.f577eM != null) {
                this.f577eM.cancel();
            }
        }
    }
}
