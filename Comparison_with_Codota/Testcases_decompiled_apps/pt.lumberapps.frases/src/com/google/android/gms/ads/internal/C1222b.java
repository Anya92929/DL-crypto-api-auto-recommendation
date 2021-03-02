package com.google.android.gms.ads.internal;

import android.content.Intent;

/* renamed from: com.google.android.gms.ads.internal.b */
class C1222b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f3447a;

    /* renamed from: b */
    final /* synthetic */ zzb f3448b;

    C1222b(zzb zzb, Intent intent) {
        this.f3448b = zzb;
        this.f3447a = intent;
    }

    public void run() {
        int zzd = zzu.zzga().zzd(this.f3447a);
        zzu.zzga();
        if (!(zzd != 0 || this.f3448b.f4011f.zzapb == null || this.f3448b.f4011f.zzapb.zzbtm == null || this.f3448b.f4011f.zzapb.zzbtm.zzuh() == null)) {
            this.f3448b.f4011f.zzapb.zzbtm.zzuh().close();
        }
        this.f3448b.f4011f.f4130u = false;
    }
}
