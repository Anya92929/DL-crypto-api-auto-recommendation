package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

@zzin
public final class zzkg {

    /* renamed from: a */
    private static final ExecutorService f6610a = Executors.newFixedThreadPool(10, m7304a("Default"));

    /* renamed from: b */
    private static final ExecutorService f6611b = Executors.newFixedThreadPool(5, m7304a("Loader"));

    /* renamed from: a */
    private static ThreadFactory m7304a(String str) {
        return new C1735mc(str);
    }

    public static zzky zza(int i, Runnable runnable) {
        return i == 1 ? zza(f6611b, (Callable) new C1730ly(runnable)) : zza(f6610a, (Callable) new C1731lz(runnable));
    }

    public static zzky zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static zzky zza(Callable callable) {
        return zza(f6610a, callable);
    }

    public static zzky zza(ExecutorService executorService, Callable callable) {
        zzkv zzkv = new zzkv();
        try {
            zzkv.zzd(new C1734mb(zzkv, executorService.submit(new C1733ma(zzkv, callable))));
        } catch (RejectedExecutionException e) {
            zzkd.zzd("Thread execution is rejected.", e);
            zzkv.cancel(true);
        }
        return zzkv;
    }
}
