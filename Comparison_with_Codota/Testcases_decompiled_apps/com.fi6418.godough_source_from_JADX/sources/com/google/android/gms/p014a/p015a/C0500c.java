package com.google.android.gms.p014a.p015a;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.a.a.c */
class C0500c extends Thread {

    /* renamed from: a */
    CountDownLatch f3662a = new CountDownLatch(1);

    /* renamed from: b */
    boolean f3663b = false;

    /* renamed from: c */
    private WeakReference<C0498a> f3664c;

    /* renamed from: d */
    private long f3665d;

    public C0500c(C0498a aVar, long j) {
        this.f3664c = new WeakReference<>(aVar);
        this.f3665d = j;
        start();
    }

    /* renamed from: c */
    private void m2949c() {
        C0498a aVar = (C0498a) this.f3664c.get();
        if (aVar != null) {
            aVar.mo6552b();
            this.f3663b = true;
        }
    }

    /* renamed from: a */
    public void mo6557a() {
        this.f3662a.countDown();
    }

    /* renamed from: b */
    public boolean mo6558b() {
        return this.f3663b;
    }

    public void run() {
        try {
            if (!this.f3662a.await(this.f3665d, TimeUnit.MILLISECONDS)) {
                m2949c();
            }
        } catch (InterruptedException e) {
            m2949c();
        }
    }
}
