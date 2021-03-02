package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.aj */
class C0523aj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0557e f3735a;

    /* renamed from: b */
    final /* synthetic */ C0522ai f3736b;

    C0523aj(C0522ai aiVar, C0557e eVar) {
        this.f3736b = aiVar;
        this.f3735a = eVar;
    }

    public void run() {
        if (!this.f3736b.f3732a.mo6647b()) {
            this.f3736b.f3732a.mo6873c("Connected to service after a timeout");
            this.f3736b.f3732a.m3031a(this.f3735a);
        }
    }
}
