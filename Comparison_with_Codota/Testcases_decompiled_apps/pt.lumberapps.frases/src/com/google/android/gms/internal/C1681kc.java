package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.kc */
class C1681kc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzju f5199a;

    /* renamed from: b */
    final /* synthetic */ zzib f5200b;

    C1681kc(zzib zzib, zzju zzju) {
        this.f5200b = zzib;
        this.f5199a = zzju;
    }

    public void run() {
        synchronized (this.f5200b.f6378c) {
            this.f5200b.mo8504a(this.f5199a);
        }
    }
}
