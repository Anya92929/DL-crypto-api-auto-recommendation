package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.hy */
class C1622hy implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzfp f5121a;

    /* renamed from: b */
    final /* synthetic */ C1616hs f5122b;

    C1622hy(C1616hs hsVar, zzfp zzfp) {
        this.f5122b = hsVar;
        this.f5121a = zzfp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r3 = this;
            com.google.android.gms.internal.hs r0 = r3.f5122b
            com.google.android.gms.internal.zzfs r0 = r0.f5111c
            java.lang.Object r1 = r0.f6193a
            monitor-enter(r1)
            com.google.android.gms.internal.hs r0 = r3.f5122b     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.zzfs$zzd r0 = r0.f5110b     // Catch:{ all -> 0x003b }
            int r0 = r0.getStatus()     // Catch:{ all -> 0x003b }
            r2 = -1
            if (r0 == r2) goto L_0x001f
            com.google.android.gms.internal.hs r0 = r3.f5122b     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.zzfs$zzd r0 = r0.f5110b     // Catch:{ all -> 0x003b }
            int r0 = r0.getStatus()     // Catch:{ all -> 0x003b }
            r2 = 1
            if (r0 != r2) goto L_0x0021
        L_0x001f:
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
        L_0x0020:
            return
        L_0x0021:
            com.google.android.gms.internal.hs r0 = r3.f5122b     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.zzfs$zzd r0 = r0.f5110b     // Catch:{ all -> 0x003b }
            r0.reject()     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.zzkh r0 = com.google.android.gms.ads.internal.zzu.zzfq()     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.hz r2 = new com.google.android.gms.internal.hz     // Catch:{ all -> 0x003b }
            r2.<init>(r3)     // Catch:{ all -> 0x003b }
            r0.runOnUiThread(r2)     // Catch:{ all -> 0x003b }
            java.lang.String r0 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.zzkd.m7303v(r0)     // Catch:{ all -> 0x003b }
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
            goto L_0x0020
        L_0x003b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1622hy.run():void");
    }
}
