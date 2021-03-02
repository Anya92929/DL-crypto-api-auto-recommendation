package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.nx */
final class C1783nx {

    /* renamed from: a */
    private int f5409a;

    private C1783nx() {
        this.f5409a = 0;
    }

    /* synthetic */ C1783nx(C1775np npVar) {
        this();
    }

    /* renamed from: a */
    public synchronized void mo7591a() {
        this.f5409a++;
    }

    /* renamed from: b */
    public synchronized void mo7592b() {
        if (this.f5409a == 0) {
            throw new RuntimeException("too many decrements");
        }
        this.f5409a--;
        if (this.f5409a == 0) {
            notifyAll();
        }
    }
}
