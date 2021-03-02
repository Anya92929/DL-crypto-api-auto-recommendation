package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.lz */
final class C1731lz implements Callable {

    /* renamed from: a */
    final /* synthetic */ Runnable f5324a;

    C1731lz(Runnable runnable) {
        this.f5324a = runnable;
    }

    /* renamed from: a */
    public Void call() {
        this.f5324a.run();
        return null;
    }
}
