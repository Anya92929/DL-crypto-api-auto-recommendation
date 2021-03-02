package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {

    /* renamed from: a */
    private final AtomicReference<AtomicSafeInitializer<T>> f7089a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<T> f7090b = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;

    public final T get() throws ConcurrentException {
        while (true) {
            T t = this.f7090b.get();
            if (t != null) {
                return t;
            }
            if (this.f7089a.compareAndSet((Object) null, this)) {
                this.f7090b.set(initialize());
            }
        }
    }
}
