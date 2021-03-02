package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.e */
class C1925e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f7193a;

    /* renamed from: b */
    final /* synthetic */ zzac f7194b;

    C1925e(zzac zzac, long j) {
        this.f7194b = zzac;
        this.f7193a = j;
    }

    public void run() {
        this.f7194b.zzbse().f7320h.set(this.f7193a);
        this.f7194b.zzbsd().zzbtb().zzj("Minimum session duration set", Long.valueOf(this.f7193a));
    }
}
