package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ly */
final class C1730ly implements Callable {

    /* renamed from: a */
    final /* synthetic */ Runnable f5323a;

    C1730ly(Runnable runnable) {
        this.f5323a = runnable;
    }

    /* renamed from: a */
    public Void call() {
        this.f5323a.run();
        return null;
    }
}
