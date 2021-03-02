package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzqr {

    /* renamed from: a */
    private static final ExecutorService f6918a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzrm("GAC_Transform"));

    public static ExecutorService zzaqc() {
        return f6918a;
    }
}
