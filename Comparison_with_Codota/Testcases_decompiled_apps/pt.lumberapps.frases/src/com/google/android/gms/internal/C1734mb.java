package com.google.android.gms.internal;

import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.mb */
final class C1734mb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzkv f5328a;

    /* renamed from: b */
    final /* synthetic */ Future f5329b;

    C1734mb(zzkv zzkv, Future future) {
        this.f5328a = zzkv;
        this.f5329b = future;
    }

    public void run() {
        if (this.f5328a.isCancelled()) {
            this.f5329b.cancel(true);
        }
    }
}
