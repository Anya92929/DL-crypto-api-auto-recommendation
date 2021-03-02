package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0615ad;

/* renamed from: com.google.android.gms.analytics.internal.q */
class C0569q {

    /* renamed from: a */
    private final C0615ad f3888a;

    /* renamed from: b */
    private long f3889b;

    public C0569q(C0615ad adVar) {
        C1009bf.m4528a(adVar);
        this.f3888a = adVar;
    }

    public C0569q(C0615ad adVar, long j) {
        C1009bf.m4528a(adVar);
        this.f3888a = adVar;
        this.f3889b = j;
    }

    /* renamed from: a */
    public void mo6833a() {
        this.f3889b = this.f3888a.mo6991b();
    }

    /* renamed from: a */
    public boolean mo6834a(long j) {
        return this.f3889b == 0 || this.f3888a.mo6991b() - this.f3889b > j;
    }

    /* renamed from: b */
    public void mo6835b() {
        this.f3889b = 0;
    }
}
