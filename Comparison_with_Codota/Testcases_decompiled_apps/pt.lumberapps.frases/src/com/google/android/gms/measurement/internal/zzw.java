package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class zzw extends C1923c {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final AtomicLong f7354j = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1908az f7355a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1908az f7356b;

    /* renamed from: c */
    private final PriorityBlockingQueue f7357c = new PriorityBlockingQueue();

    /* renamed from: d */
    private final BlockingQueue f7358d = new LinkedBlockingQueue();

    /* renamed from: e */
    private final Thread.UncaughtExceptionHandler f7359e = new C1906ax(this, "Thread death: Uncaught exception on worker thread");

    /* renamed from: f */
    private final Thread.UncaughtExceptionHandler f7360f = new C1906ax(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Object f7361g = new Object();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Semaphore f7362h = new Semaphore(2);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f7363i;

    zzw(zzx zzx) {
        super(zzx);
    }

    /* renamed from: a */
    private void m7958a(C1907ay ayVar) {
        synchronized (this.f7361g) {
            this.f7357c.add(ayVar);
            if (this.f7355a == null) {
                this.f7355a = new C1908az(this, "Measurement Worker", this.f7357c);
                this.f7355a.setUncaughtExceptionHandler(this.f7359e);
                this.f7355a.start();
            } else {
                this.f7355a.mo9262a();
            }
        }
    }

    /* renamed from: a */
    private void m7959a(FutureTask futureTask) {
        synchronized (this.f7361g) {
            this.f7358d.add(futureTask);
            if (this.f7356b == null) {
                this.f7356b = new C1908az(this, "Measurement Network", this.f7358d);
                this.f7356b.setUncaughtExceptionHandler(this.f7360f);
                this.f7356b.start();
            } else {
                this.f7356b.mo9262a();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzbrs() {
        if (Thread.currentThread() != this.f7356b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ C1889ag zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public Future zzd(Callable callable) {
        mo9339c();
        zzab.zzy(callable);
        C1907ay ayVar = new C1907ay(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f7355a) {
            ayVar.run();
        } else {
            m7958a(ayVar);
        }
        return ayVar;
    }

    public Future zze(Callable callable) {
        mo9339c();
        zzab.zzy(callable);
        C1907ay ayVar = new C1907ay(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f7355a) {
            ayVar.run();
        } else {
            m7958a(ayVar);
        }
        return ayVar;
    }

    public void zzm(Runnable runnable) {
        mo9339c();
        zzab.zzy(runnable);
        m7958a(new C1907ay(this, runnable, false, "Task exception on worker thread"));
    }

    public void zzn(Runnable runnable) {
        mo9339c();
        zzab.zzy(runnable);
        m7959a((FutureTask) new C1907ay(this, runnable, false, "Task exception on network thread"));
    }

    public void zzwu() {
        if (Thread.currentThread() != this.f7355a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
