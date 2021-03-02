package com.google.android.gms.p018c;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.android.gms.c.at */
class C0631at extends FutureTask<T> {

    /* renamed from: a */
    final /* synthetic */ C0630as f4252a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0631at(C0630as asVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f4252a = asVar;
    }

    /* access modifiers changed from: protected */
    public void setException(Throwable th) {
        Thread.UncaughtExceptionHandler b = this.f4252a.f4251a.f4248g;
        if (b != null) {
            b.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            Log.e("GAv4", "MeasurementExecutor: job failed with " + th);
        }
        super.setException(th);
    }
}
