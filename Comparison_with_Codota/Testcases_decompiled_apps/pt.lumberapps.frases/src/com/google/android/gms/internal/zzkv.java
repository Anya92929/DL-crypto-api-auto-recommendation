package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzin
public class zzkv implements zzky {

    /* renamed from: a */
    private final Object f6653a = new Object();

    /* renamed from: b */
    private Object f6654b;

    /* renamed from: c */
    private boolean f6655c;

    /* renamed from: d */
    private boolean f6656d;

    /* renamed from: e */
    private final C1754mv f6657e = new C1754mv();

    /* renamed from: a */
    private boolean m7334a() {
        return 0 != 0 || this.f6655c;
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f6653a) {
            if (m7334a()) {
                return false;
            }
            this.f6656d = true;
            this.f6655c = true;
            this.f6653a.notifyAll();
            this.f6657e.mo7499a();
            return true;
        }
    }

    public Object get() {
        Object obj;
        synchronized (this.f6653a) {
            if (!m7334a()) {
                try {
                    this.f6653a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f6656d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            obj = this.f6654b;
        }
        return obj;
    }

    public Object get(long j, TimeUnit timeUnit) {
        Object obj;
        synchronized (this.f6653a) {
            if (!m7334a()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.f6653a.wait(millis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (!this.f6655c) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.f6656d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                obj = this.f6654b;
            }
        }
        return obj;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f6653a) {
            z = this.f6656d;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.f6653a) {
            a = m7334a();
        }
        return a;
    }

    public void zzc(Runnable runnable) {
        this.f6657e.mo7500a(runnable);
    }

    public void zzd(Runnable runnable) {
        this.f6657e.mo7501b(runnable);
    }

    public void zzh(Object obj) {
        synchronized (this.f6653a) {
            if (!this.f6656d) {
                if (m7334a()) {
                    zzu.zzft().zzb((Throwable) new IllegalStateException("Provided CallbackFuture with multiple values."), true);
                    return;
                }
                this.f6655c = true;
                this.f6654b = obj;
                this.f6653a.notifyAll();
                this.f6657e.mo7499a();
            }
        }
    }
}
