package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import java.lang.Thread;

/* renamed from: com.google.android.gms.measurement.internal.ax */
final class C1906ax implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ zzw f7127a;

    /* renamed from: b */
    private final String f7128b;

    public C1906ax(zzw zzw, String str) {
        this.f7127a = zzw;
        zzab.zzy(str);
        this.f7128b = str;
    }

    public synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f7127a.zzbsd().zzbsv().zzj(this.f7128b, th);
    }
}
