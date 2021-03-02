package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.bj */
class C1919bj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppMetadata f7182a;

    /* renamed from: b */
    final /* synthetic */ UserAttributeParcel f7183b;

    /* renamed from: c */
    final /* synthetic */ zzy f7184c;

    C1919bj(zzy zzy, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.f7184c = zzy;
        this.f7182a = appMetadata;
        this.f7183b = userAttributeParcel;
    }

    public void run() {
        this.f7184c.f7392a.mo9675m();
        this.f7184c.mo9701a(this.f7182a.aig);
        this.f7184c.f7392a.mo9651a(this.f7183b, this.f7182a);
    }
}
