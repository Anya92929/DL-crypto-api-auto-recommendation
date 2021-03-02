package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.C0562j;

/* renamed from: com.google.android.gms.analytics.i */
class C0512i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f3692a;

    /* renamed from: b */
    final /* synthetic */ C0562j f3693b;

    /* renamed from: c */
    final /* synthetic */ C0509f f3694c;

    C0512i(C0509f fVar, int i, C0562j jVar) {
        this.f3694c = fVar;
        this.f3692a = i;
        this.f3693b = jVar;
    }

    public void run() {
        boolean stopSelfResult = this.f3694c.stopSelfResult(this.f3692a);
        if (stopSelfResult) {
            this.f3693b.mo6866a("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
        }
    }
}
