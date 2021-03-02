package com.google.android.gms.p018c;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.c.as */
class C0630as extends ThreadPoolExecutor {

    /* renamed from: a */
    final /* synthetic */ C0628aq f4251a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0630as(C0628aq aqVar) {
        super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f4251a = aqVar;
        setThreadFactory(new C0632au((C0629ar) null));
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0631at(this, runnable, t);
    }
}
