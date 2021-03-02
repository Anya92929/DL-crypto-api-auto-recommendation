package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.b */
final class C1951b implements Executor {

    /* renamed from: a */
    private final Handler f7430a = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.f7430a.post(runnable);
    }
}
