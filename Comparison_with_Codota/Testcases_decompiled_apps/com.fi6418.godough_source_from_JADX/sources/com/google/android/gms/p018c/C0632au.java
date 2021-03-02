package com.google.android.gms.p018c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.c.au */
class C0632au implements ThreadFactory {

    /* renamed from: a */
    private static final AtomicInteger f4253a = new AtomicInteger();

    private C0632au() {
    }

    /* synthetic */ C0632au(C0629ar arVar) {
        this();
    }

    public Thread newThread(Runnable runnable) {
        return new C0633av(runnable, "measurement-" + f4253a.incrementAndGet());
    }
}
