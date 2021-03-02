package com.google.android.gms.internal;

import android.os.Process;

/* renamed from: com.google.android.gms.internal.nr */
class C1777nr implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f5401a;

    /* renamed from: b */
    final /* synthetic */ C1776nq f5402b;

    C1777nr(C1776nq nqVar, Runnable runnable) {
        this.f5402b = nqVar;
        this.f5401a = runnable;
    }

    public void run() {
        Process.setThreadPriority(10);
        this.f5401a.run();
    }
}
