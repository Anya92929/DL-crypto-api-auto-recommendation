package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzli;

/* renamed from: com.google.android.gms.ads.internal.k */
class C1272k implements zzli.zzd {

    /* renamed from: a */
    final /* synthetic */ zzju f3718a;

    /* renamed from: b */
    final /* synthetic */ Runnable f3719b;

    /* renamed from: c */
    final /* synthetic */ zzf f3720c;

    C1272k(zzf zzf, zzju zzju, Runnable runnable) {
        this.f3720c = zzf;
        this.f3718a = zzju;
        this.f3719b = runnable;
    }

    public void zzem() {
        if (!this.f3718a.zzcif) {
            zzu.zzfq();
            zzkh.zzb(this.f3719b);
        }
    }
}
