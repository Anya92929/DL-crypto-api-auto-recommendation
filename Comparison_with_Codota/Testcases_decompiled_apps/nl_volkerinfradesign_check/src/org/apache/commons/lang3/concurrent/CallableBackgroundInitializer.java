package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class CallableBackgroundInitializer<T> extends BackgroundInitializer<T> {

    /* renamed from: a */
    private final Callable<T> f7107a;

    public CallableBackgroundInitializer(Callable<T> callable) {
        m7402a(callable);
        this.f7107a = callable;
    }

    public CallableBackgroundInitializer(Callable<T> callable, ExecutorService executorService) {
        super(executorService);
        m7402a(callable);
        this.f7107a = callable;
    }

    /* access modifiers changed from: protected */
    public T initialize() throws Exception {
        return this.f7107a.call();
    }

    /* renamed from: a */
    private void m7402a(Callable<T> callable) {
        if (callable == null) {
            throw new IllegalArgumentException("Callable must not be null!");
        }
    }
}
