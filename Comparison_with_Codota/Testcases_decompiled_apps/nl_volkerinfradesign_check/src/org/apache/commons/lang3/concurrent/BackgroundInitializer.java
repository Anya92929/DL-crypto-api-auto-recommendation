package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {

    /* renamed from: a */
    private ExecutorService f7091a;

    /* renamed from: b */
    private ExecutorService f7092b;

    /* renamed from: c */
    private Future<T> f7093c;

    /* access modifiers changed from: protected */
    public abstract T initialize() throws Exception;

    protected BackgroundInitializer() {
        this((ExecutorService) null);
    }

    protected BackgroundInitializer(ExecutorService executorService) {
        setExternalExecutor(executorService);
    }

    public final synchronized ExecutorService getExternalExecutor() {
        return this.f7091a;
    }

    public synchronized boolean isStarted() {
        return this.f7093c != null;
    }

    public final synchronized void setExternalExecutor(ExecutorService executorService) {
        if (isStarted()) {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
        this.f7091a = executorService;
    }

    public synchronized boolean start() {
        boolean z;
        ExecutorService executorService;
        if (!isStarted()) {
            this.f7092b = getExternalExecutor();
            if (this.f7092b == null) {
                executorService = m7395a();
                this.f7092b = executorService;
            } else {
                executorService = null;
            }
            this.f7093c = this.f7092b.submit(m7394a(executorService));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public T get() throws ConcurrentException {
        try {
            return getFuture().get();
        } catch (ExecutionException e) {
            ConcurrentUtils.handleCause(e);
            return null;
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e2);
        }
    }

    public synchronized Future<T> getFuture() {
        if (this.f7093c == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return this.f7093c;
    }

    /* access modifiers changed from: protected */
    public final synchronized ExecutorService getActiveExecutor() {
        return this.f7092b;
    }

    /* access modifiers changed from: protected */
    public int getTaskCount() {
        return 1;
    }

    /* renamed from: a */
    private Callable<T> m7394a(ExecutorService executorService) {
        return new C1959a(executorService);
    }

    /* renamed from: a */
    private ExecutorService m7395a() {
        return Executors.newFixedThreadPool(getTaskCount());
    }

    /* renamed from: org.apache.commons.lang3.concurrent.BackgroundInitializer$a */
    class C1959a implements Callable<T> {

        /* renamed from: b */
        private final ExecutorService f7095b;

        public C1959a(ExecutorService executorService) {
            this.f7095b = executorService;
        }

        public T call() throws Exception {
            try {
                return BackgroundInitializer.this.initialize();
            } finally {
                if (this.f7095b != null) {
                    this.f7095b.shutdown();
                }
            }
        }
    }
}
