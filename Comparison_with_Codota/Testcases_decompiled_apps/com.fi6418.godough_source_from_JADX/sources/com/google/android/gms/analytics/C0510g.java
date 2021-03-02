package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.C0562j;

/* renamed from: com.google.android.gms.analytics.g */
class C0510g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0562j f3684a;

    /* renamed from: b */
    final /* synthetic */ Handler f3685b;

    /* renamed from: c */
    final /* synthetic */ int f3686c;

    /* renamed from: d */
    final /* synthetic */ C0509f f3687d;

    C0510g(C0509f fVar, C0562j jVar, Handler handler, int i) {
        this.f3687d = fVar;
        this.f3684a = jVar;
        this.f3685b = handler;
        this.f3686c = i;
    }

    public void run() {
        this.f3687d.mo6579a(this.f3684a, this.f3685b, this.f3686c);
    }
}
