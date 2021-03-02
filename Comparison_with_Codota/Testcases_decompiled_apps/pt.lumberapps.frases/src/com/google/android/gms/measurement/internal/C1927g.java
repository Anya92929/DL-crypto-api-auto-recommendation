package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.g */
class C1927g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7197a;

    /* renamed from: b */
    final /* synthetic */ String f7198b;

    /* renamed from: c */
    final /* synthetic */ long f7199c;

    /* renamed from: d */
    final /* synthetic */ Bundle f7200d;

    /* renamed from: e */
    final /* synthetic */ boolean f7201e;

    /* renamed from: f */
    final /* synthetic */ boolean f7202f;

    /* renamed from: g */
    final /* synthetic */ boolean f7203g;

    /* renamed from: h */
    final /* synthetic */ String f7204h;

    /* renamed from: i */
    final /* synthetic */ zzac f7205i;

    C1927g(zzac zzac, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f7205i = zzac;
        this.f7197a = str;
        this.f7198b = str2;
        this.f7199c = j;
        this.f7200d = bundle;
        this.f7201e = z;
        this.f7202f = z2;
        this.f7203g = z3;
        this.f7204h = str3;
    }

    public void run() {
        this.f7205i.m7742b(this.f7197a, this.f7198b, this.f7199c, this.f7200d, this.f7201e, this.f7202f, this.f7203g, this.f7204h);
    }
}
