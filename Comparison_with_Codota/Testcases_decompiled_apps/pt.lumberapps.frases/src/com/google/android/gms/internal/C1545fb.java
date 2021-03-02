package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.fb */
class C1545fb implements Executor {

    /* renamed from: a */
    final /* synthetic */ Handler f4983a;

    /* renamed from: b */
    final /* synthetic */ zze f4984b;

    C1545fb(zze zze, Handler handler) {
        this.f4984b = zze;
        this.f4983a = handler;
    }

    public void execute(Runnable runnable) {
        this.f4983a.post(runnable);
    }
}
