package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzin
public class zzkw implements zzky {

    /* renamed from: a */
    private final Object f6658a;

    /* renamed from: b */
    private final C1754mv f6659b = new C1754mv();

    public zzkw(Object obj) {
        this.f6658a = obj;
        this.f6659b.mo7499a();
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public Object get() {
        return this.f6658a;
    }

    public Object get(long j, TimeUnit timeUnit) {
        return this.f6658a;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public void zzc(Runnable runnable) {
        this.f6659b.mo7500a(runnable);
    }
}
