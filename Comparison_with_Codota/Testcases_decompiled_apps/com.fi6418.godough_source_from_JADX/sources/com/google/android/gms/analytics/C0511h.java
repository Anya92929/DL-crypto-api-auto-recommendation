package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.C0562j;

/* renamed from: com.google.android.gms.analytics.h */
class C0511h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0562j f3688a;

    /* renamed from: b */
    final /* synthetic */ Handler f3689b;

    /* renamed from: c */
    final /* synthetic */ int f3690c;

    /* renamed from: d */
    final /* synthetic */ C0509f f3691d;

    C0511h(C0509f fVar, C0562j jVar, Handler handler, int i) {
        this.f3691d = fVar;
        this.f3688a = jVar;
        this.f3689b = handler;
        this.f3690c = i;
    }

    public void run() {
        this.f3691d.mo6579a(this.f3688a, this.f3689b, this.f3690c);
    }
}
