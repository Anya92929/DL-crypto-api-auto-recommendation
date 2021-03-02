package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.tasks.d */
final class C1953d implements C1954e {

    /* renamed from: a */
    private final CountDownLatch f7433a;

    private C1953d() {
        this.f7433a = new CountDownLatch(1);
    }

    /* synthetic */ C1953d(C1952c cVar) {
        this();
    }

    /* renamed from: a */
    public void mo9818a() {
        this.f7433a.await();
    }

    /* renamed from: a */
    public boolean mo9819a(long j, TimeUnit timeUnit) {
        return this.f7433a.await(j, timeUnit);
    }

    public void onFailure(Exception exc) {
        this.f7433a.countDown();
    }

    public void onSuccess(Object obj) {
        this.f7433a.countDown();
    }
}
