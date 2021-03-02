package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zznk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzm {

    /* renamed from: a */
    private static final ExecutorService f2794a = Executors.newFixedThreadPool(2, new zznk("GAC_Executor"));

    public static ExecutorService zzpN() {
        return f2794a;
    }
}
