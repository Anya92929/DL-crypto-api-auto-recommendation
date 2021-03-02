package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzqb {

    /* renamed from: a */
    private static final ExecutorService f6876a = Executors.newFixedThreadPool(2, new zzrm("GAC_Executor"));

    public static ExecutorService zzaqc() {
        return f6876a;
    }
}
