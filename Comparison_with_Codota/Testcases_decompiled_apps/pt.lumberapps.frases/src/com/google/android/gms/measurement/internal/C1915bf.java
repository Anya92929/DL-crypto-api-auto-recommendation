package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.bf */
class C1915bf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppMetadata f7169a;

    /* renamed from: b */
    final /* synthetic */ EventParcel f7170b;

    /* renamed from: c */
    final /* synthetic */ zzy f7171c;

    C1915bf(zzy zzy, AppMetadata appMetadata, EventParcel eventParcel) {
        this.f7171c = zzy;
        this.f7169a = appMetadata;
        this.f7170b = eventParcel;
    }

    public void run() {
        this.f7171c.f7392a.mo9675m();
        this.f7171c.mo9701a(this.f7169a.aig);
        this.f7171c.f7392a.mo9649a(this.f7170b, this.f7169a);
    }
}
