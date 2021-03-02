package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.at */
class C0533at implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0549bi f3761a;

    /* renamed from: b */
    final /* synthetic */ long f3762b;

    /* renamed from: c */
    final /* synthetic */ C0528ao f3763c;

    C0533at(C0528ao aoVar, C0549bi biVar, long j) {
        this.f3763c = aoVar;
        this.f3761a = biVar;
        this.f3762b = j;
    }

    public void run() {
        this.f3763c.mo6689a(this.f3761a, this.f3762b);
    }
}
