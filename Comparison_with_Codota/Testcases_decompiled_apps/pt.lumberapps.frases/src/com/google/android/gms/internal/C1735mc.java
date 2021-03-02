package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.mc */
final class C1735mc implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f5330a;

    /* renamed from: b */
    private final AtomicInteger f5331b = new AtomicInteger(1);

    C1735mc(String str) {
        this.f5330a = str;
    }

    public Thread newThread(Runnable runnable) {
        String str = this.f5330a;
        return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.f5331b.getAndIncrement()).toString());
    }
}
