package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {

    /* renamed from: a */
    private final AtomicReference<T> f7088a = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;

    public T get() throws ConcurrentException {
        T t = this.f7088a.get();
        if (t != null) {
            return t;
        }
        T initialize = initialize();
        if (!this.f7088a.compareAndSet((Object) null, initialize)) {
            return this.f7088a.get();
        }
        return initialize;
    }
}
