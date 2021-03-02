package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.be */
class C1914be implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppMetadata f7167a;

    /* renamed from: b */
    final /* synthetic */ zzy f7168b;

    C1914be(zzy zzy, AppMetadata appMetadata) {
        this.f7168b = zzy;
        this.f7167a = appMetadata;
    }

    public void run() {
        this.f7168b.f7392a.mo9675m();
        this.f7168b.mo9701a(this.f7167a.aig);
        this.f7168b.f7392a.mo9647a(this.f7167a);
    }
}
