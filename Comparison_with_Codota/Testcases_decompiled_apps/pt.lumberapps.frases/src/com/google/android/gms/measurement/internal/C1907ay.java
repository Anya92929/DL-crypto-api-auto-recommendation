package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.android.gms.measurement.internal.ay */
final class C1907ay extends FutureTask implements Comparable {

    /* renamed from: a */
    final /* synthetic */ zzw f7129a;

    /* renamed from: b */
    private final long f7130b = zzw.f7354j.getAndIncrement();

    /* renamed from: c */
    private final boolean f7131c;

    /* renamed from: d */
    private final String f7132d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1907ay(zzw zzw, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.f7129a = zzw;
        zzab.zzy(str);
        this.f7132d = str;
        this.f7131c = z;
        if (this.f7130b == Long.MAX_VALUE) {
            zzw.zzbsd().zzbsv().log("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1907ay(zzw zzw, Callable callable, boolean z, String str) {
        super(callable);
        this.f7129a = zzw;
        zzab.zzy(str);
        this.f7132d = str;
        this.f7131c = z;
        if (this.f7130b == Long.MAX_VALUE) {
            zzw.zzbsd().zzbsv().log("Tasks index overflow");
        }
    }

    /* renamed from: a */
    public int compareTo(C1907ay ayVar) {
        if (this.f7131c != ayVar.f7131c) {
            return this.f7131c ? -1 : 1;
        }
        if (this.f7130b < ayVar.f7130b) {
            return -1;
        }
        if (this.f7130b > ayVar.f7130b) {
            return 1;
        }
        this.f7129a.zzbsd().zzbsw().zzj("Two tasks share the same index. index", Long.valueOf(this.f7130b));
        return 0;
    }

    /* access modifiers changed from: protected */
    public void setException(Throwable th) {
        this.f7129a.zzbsd().zzbsv().zzj(this.f7132d, th);
        if (th instanceof C1905aw) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
