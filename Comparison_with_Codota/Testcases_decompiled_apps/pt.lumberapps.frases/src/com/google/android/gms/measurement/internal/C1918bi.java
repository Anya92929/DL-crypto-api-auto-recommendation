package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.bi */
class C1918bi implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppMetadata f7179a;

    /* renamed from: b */
    final /* synthetic */ UserAttributeParcel f7180b;

    /* renamed from: c */
    final /* synthetic */ zzy f7181c;

    C1918bi(zzy zzy, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.f7181c = zzy;
        this.f7179a = appMetadata;
        this.f7180b = userAttributeParcel;
    }

    public void run() {
        this.f7181c.f7392a.mo9675m();
        this.f7181c.mo9701a(this.f7179a.aig);
        this.f7181c.f7392a.mo9659b(this.f7180b, this.f7179a);
    }
}
