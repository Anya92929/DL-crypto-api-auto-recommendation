package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zznk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzs {

    /* renamed from: a */
    private static final ExecutorService f2800a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zznk("GAC_Transform"));

    public static ExecutorService zzpN() {
        return f2800a;
    }
}
