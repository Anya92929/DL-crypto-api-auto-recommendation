package com.google.android.gms.analytics.internal;

import java.lang.Thread;

/* renamed from: com.google.android.gms.analytics.internal.ad */
class C0517ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ C0516ac f3718a;

    C0517ad(C0516ac acVar) {
        this.f3718a = acVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        C0562j g = this.f3718a.mo6605g();
        if (g != null) {
            g.mo6880e("Job execution failed", th);
        }
    }
}
