package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.v */
class C1942v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzx f7234a;

    /* renamed from: b */
    final /* synthetic */ int f7235b;

    /* renamed from: c */
    final /* synthetic */ zzp f7236c;

    /* renamed from: d */
    final /* synthetic */ zzae f7237d;

    C1942v(zzae zzae, zzx zzx, int i, zzp zzp) {
        this.f7237d = zzae;
        this.f7234a = zzx;
        this.f7235b = i;
        this.f7236c = zzp;
    }

    public void run() {
        this.f7234a.mo9675m();
        this.f7234a.zzbuc();
        this.f7237d.f7258a.post(new C1943w(this));
    }
}
