package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ms */
class C1751ms implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzko f5359a;

    C1751ms(zzko zzko) {
        this.f5359a = zzko;
    }

    public void run() {
        synchronized (this.f5359a.f6637d) {
            zzkd.m7303v("Suspending the looper thread");
            while (this.f5359a.f6636c == 0) {
                try {
                    this.f5359a.f6637d.wait();
                    zzkd.m7303v("Looper thread resumed");
                } catch (InterruptedException e) {
                    zzkd.m7303v("Looper thread interrupted.");
                }
            }
        }
    }
}
