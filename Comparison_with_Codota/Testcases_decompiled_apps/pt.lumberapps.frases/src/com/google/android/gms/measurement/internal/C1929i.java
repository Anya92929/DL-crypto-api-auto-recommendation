package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.i */
class C1929i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f7211a;

    /* renamed from: b */
    final /* synthetic */ boolean f7212b;

    /* renamed from: c */
    final /* synthetic */ zzac f7213c;

    C1929i(zzac zzac, AtomicReference atomicReference, boolean z) {
        this.f7213c = zzac;
        this.f7211a = atomicReference;
        this.f7212b = z;
    }

    public void run() {
        this.f7213c.zzbrx().mo9404a(this.f7211a, this.f7212b);
    }
}
