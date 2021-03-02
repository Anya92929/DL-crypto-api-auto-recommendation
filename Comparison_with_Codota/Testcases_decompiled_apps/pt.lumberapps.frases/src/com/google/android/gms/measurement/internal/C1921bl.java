package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.bl */
class C1921bl implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppMetadata f7187a;

    /* renamed from: b */
    final /* synthetic */ zzy f7188b;

    C1921bl(zzy zzy, AppMetadata appMetadata) {
        this.f7188b = zzy;
        this.f7187a = appMetadata;
    }

    public void run() {
        this.f7188b.f7392a.mo9675m();
        this.f7188b.mo9701a(this.f7187a.aig);
        this.f7188b.f7392a.zzd(this.f7187a);
    }
}
