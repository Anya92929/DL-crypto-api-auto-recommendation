package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zznk implements ThreadFactory {

    /* renamed from: a */
    private final String f3236a;

    /* renamed from: b */
    private final int f3237b;

    /* renamed from: c */
    private final AtomicInteger f3238c;

    /* renamed from: d */
    private final ThreadFactory f3239d;

    public zznk(String str) {
        this(str, 0);
    }

    public zznk(String str, int i) {
        this.f3238c = new AtomicInteger();
        this.f3239d = Executors.defaultThreadFactory();
        this.f3236a = (String) zzx.zzb(str, (Object) "Name must not be null");
        this.f3237b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f3239d.newThread(new C1202hg(runnable, this.f3237b));
        newThread.setName(this.f3236a + "[" + this.f3238c.getAndIncrement() + "]");
        return newThread;
    }
}
