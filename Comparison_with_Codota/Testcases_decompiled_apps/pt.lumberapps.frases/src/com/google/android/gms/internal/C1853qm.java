package com.google.android.gms.internal;

import android.os.Process;

/* renamed from: com.google.android.gms.internal.qm */
class C1853qm implements Runnable {

    /* renamed from: a */
    private final Runnable f5521a;

    /* renamed from: b */
    private final int f5522b;

    public C1853qm(Runnable runnable, int i) {
        this.f5521a = runnable;
        this.f5522b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f5522b);
        this.f5521a.run();
    }
}
