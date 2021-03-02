package com.google.android.gms.internal;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@C1130ez
/* renamed from: com.google.android.gms.internal.gl */
public class C1217gl<T> implements Future<T> {

    /* renamed from: wq */
    private final T f3760wq;

    public C1217gl(T t) {
        this.f3760wq = t;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public T get() {
        return this.f3760wq;
    }

    public T get(long timeout, TimeUnit unit) {
        return this.f3760wq;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
