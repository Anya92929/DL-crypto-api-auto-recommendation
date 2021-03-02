package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.bh */
class C1917bh implements Callable {

    /* renamed from: a */
    final /* synthetic */ EventParcel f7176a;

    /* renamed from: b */
    final /* synthetic */ String f7177b;

    /* renamed from: c */
    final /* synthetic */ zzy f7178c;

    C1917bh(zzy zzy, EventParcel eventParcel, String str) {
        this.f7178c = zzy;
        this.f7176a = eventParcel;
        this.f7177b = str;
    }

    /* renamed from: a */
    public byte[] call() {
        this.f7178c.f7392a.mo9675m();
        return this.f7178c.f7392a.zza(this.f7176a, this.f7177b);
    }
}
