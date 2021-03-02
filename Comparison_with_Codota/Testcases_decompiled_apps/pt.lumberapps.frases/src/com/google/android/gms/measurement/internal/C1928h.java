package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.h */
class C1928h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7206a;

    /* renamed from: b */
    final /* synthetic */ String f7207b;

    /* renamed from: c */
    final /* synthetic */ Object f7208c;

    /* renamed from: d */
    final /* synthetic */ long f7209d;

    /* renamed from: e */
    final /* synthetic */ zzac f7210e;

    C1928h(zzac zzac, String str, String str2, Object obj, long j) {
        this.f7210e = zzac;
        this.f7206a = str;
        this.f7207b = str2;
        this.f7208c = obj;
        this.f7209d = j;
    }

    public void run() {
        this.f7210e.m7740a(this.f7206a, this.f7207b, this.f7208c, this.f7209d);
    }
}
