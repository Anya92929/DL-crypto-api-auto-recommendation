package com.google.android.gms.common.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.common.api.aw */
public abstract class C0725aw {

    /* renamed from: a */
    private static final ExecutorService f4481a = Executors.newFixedThreadPool(2);

    /* renamed from: a */
    public static ExecutorService m4035a() {
        return f4481a;
    }
}
