package com.google.android.gms.p018c;

/* renamed from: com.google.android.gms.c.ar */
class C0629ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0624am f4249a;

    /* renamed from: b */
    final /* synthetic */ C0628aq f4250b;

    C0629ar(C0628aq aqVar, C0624am amVar) {
        this.f4250b = aqVar;
        this.f4249a = amVar;
    }

    public void run() {
        this.f4249a.mo7005h().mo6934a(this.f4249a);
        for (C0634aw a : this.f4250b.f4244c) {
            a.mo7027a(this.f4249a);
        }
        this.f4250b.m3621b(this.f4249a);
    }
}
