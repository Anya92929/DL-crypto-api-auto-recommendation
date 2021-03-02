package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzrm implements ThreadFactory {

    /* renamed from: a */
    private final String f6971a;

    /* renamed from: b */
    private final int f6972b;

    /* renamed from: c */
    private final AtomicInteger f6973c;

    /* renamed from: d */
    private final ThreadFactory f6974d;

    public zzrm(String str) {
        this(str, 0);
    }

    public zzrm(String str, int i) {
        this.f6973c = new AtomicInteger();
        this.f6974d = Executors.defaultThreadFactory();
        this.f6971a = (String) zzab.zzb((Object) str, (Object) "Name must not be null");
        this.f6972b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f6974d.newThread(new C1853qm(runnable, this.f6972b));
        String str = this.f6971a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f6973c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
