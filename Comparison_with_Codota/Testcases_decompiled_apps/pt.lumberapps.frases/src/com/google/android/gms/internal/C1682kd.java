package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzn;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.internal.kd */
class C1682kd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f5201a;

    /* renamed from: b */
    final /* synthetic */ zzif f5202b;

    C1682kd(zzif zzif, CountDownLatch countDownLatch) {
        this.f5202b = zzif;
        this.f5201a = countDownLatch;
    }

    public void run() {
        synchronized (this.f5202b.f6379d) {
            boolean unused = this.f5202b.f6392m = zzn.zza(this.f5202b.f6391l, this.f5202b.f6387h, this.f5201a);
        }
    }
}
