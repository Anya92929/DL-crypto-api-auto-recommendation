package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.dp */
class C1505dp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzk f4940a;

    /* renamed from: b */
    final /* synthetic */ zzc f4941b;

    C1505dp(zzc zzc, zzk zzk) {
        this.f4941b = zzc;
        this.f4940a = zzk;
    }

    public void run() {
        try {
            this.f4941b.f5997c.put(this.f4940a);
        } catch (InterruptedException e) {
        }
    }
}
