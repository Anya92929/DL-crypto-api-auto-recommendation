package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@C1130ez
/* renamed from: com.google.android.gms.internal.gk */
public class C1216gk<T> implements Future<T> {

    /* renamed from: mw */
    private final Object f3756mw = new Object();

    /* renamed from: pS */
    private boolean f3757pS = false;

    /* renamed from: wq */
    private T f3758wq = null;

    /* renamed from: wr */
    private boolean f3759wr = false;

    /* renamed from: a */
    public void mo8592a(T t) {
        synchronized (this.f3756mw) {
            if (this.f3759wr) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.f3759wr = true;
            this.f3758wq = t;
            this.f3756mw.notifyAll();
        }
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!mayInterruptIfRunning) {
            return false;
        }
        synchronized (this.f3756mw) {
            if (this.f3759wr) {
                return false;
            }
            this.f3757pS = true;
            this.f3759wr = true;
            this.f3756mw.notifyAll();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.f3756mw) {
            if (!this.f3759wr) {
                try {
                    this.f3756mw.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.f3757pS) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.f3758wq;
        }
        return t;
    }

    public T get(long timeout, TimeUnit unit) throws TimeoutException {
        T t;
        synchronized (this.f3756mw) {
            if (!this.f3759wr) {
                try {
                    long millis = unit.toMillis(timeout);
                    if (millis != 0) {
                        this.f3756mw.wait(millis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.f3759wr) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.f3757pS) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.f3758wq;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f3756mw) {
            z = this.f3757pS;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.f3756mw) {
            z = this.f3759wr;
        }
        return z;
    }
}
