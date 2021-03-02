package org.apache.commons.lang3.concurrent;

public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {

    /* renamed from: a */
    private volatile T f7110a;

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;

    public T get() throws ConcurrentException {
        T t = this.f7110a;
        if (t == null) {
            synchronized (this) {
                t = this.f7110a;
                if (t == null) {
                    t = initialize();
                    this.f7110a = t;
                }
            }
        }
        return t;
    }
}
