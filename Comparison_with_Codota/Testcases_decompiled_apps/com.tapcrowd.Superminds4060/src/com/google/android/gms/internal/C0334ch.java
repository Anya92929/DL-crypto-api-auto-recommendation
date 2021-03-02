package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ch */
public final class C0334ch {

    /* renamed from: hF */
    private static final ThreadFactory f1002hF = new ThreadFactory() {

        /* renamed from: hI */
        private final AtomicInteger f1005hI = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.f1005hI.getAndIncrement());
        }
    };

    /* renamed from: hG */
    private static final ThreadPoolExecutor f1003hG = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), f1002hF);

    public static void execute(final Runnable task) {
        try {
            f1003hG.execute(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    task.run();
                }
            });
        } catch (RejectedExecutionException e) {
            C0344cn.m731b("Too many background threads already running. Aborting task.", e);
        }
    }
}
