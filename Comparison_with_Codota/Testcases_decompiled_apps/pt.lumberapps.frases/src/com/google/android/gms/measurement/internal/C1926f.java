package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.f */
class C1926f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f7195a;

    /* renamed from: b */
    final /* synthetic */ zzac f7196b;

    C1926f(zzac zzac, long j) {
        this.f7196b = zzac;
        this.f7195a = j;
    }

    public void run() {
        this.f7196b.zzbse().f7321i.set(this.f7195a);
        this.f7196b.zzbsd().zzbtb().zzj("Session timeout duration set", Long.valueOf(this.f7195a));
    }
}
