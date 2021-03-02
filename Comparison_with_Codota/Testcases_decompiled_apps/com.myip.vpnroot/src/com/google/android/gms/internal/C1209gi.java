package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@C1130ez
/* renamed from: com.google.android.gms.internal.gi */
public final class C1209gi {

    /* renamed from: wh */
    private static final ThreadFactory f3745wh = new ThreadFactory() {

        /* renamed from: wl */
        private final AtomicInteger f3749wl = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.f3749wl.getAndIncrement());
        }
    };

    /* renamed from: wi */
    private static final ExecutorService f3746wi = Executors.newFixedThreadPool(10, f3745wh);

    /* renamed from: a */
    public static Future<Void> m4606a(final Runnable runnable) {
        return submit(new Callable<Void>() {
            /* renamed from: dk */
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }

    public static <T> Future<T> submit(final Callable<T> callable) {
        try {
            return f3746wi.submit(new Callable<T>() {
                public T call() throws Exception {
                    try {
                        Process.setThreadPriority(10);
                        return callable.call();
                    } catch (Exception e) {
                        C1201gb.m4570e(e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            C1229gs.m4683d("Thread execution is rejected.", e);
            return new C1217gl(null);
        }
    }
}
