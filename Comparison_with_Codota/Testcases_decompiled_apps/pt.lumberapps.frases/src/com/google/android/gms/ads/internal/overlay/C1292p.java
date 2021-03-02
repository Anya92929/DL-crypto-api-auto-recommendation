package com.google.android.gms.ads.internal.overlay;

import android.os.Looper;

/* renamed from: com.google.android.gms.ads.internal.overlay.p */
class C1292p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1291o f3756a;

    C1292p(C1291o oVar) {
        this.f3756a = oVar;
    }

    public void run() {
        Looper.myLooper().quit();
    }
}
