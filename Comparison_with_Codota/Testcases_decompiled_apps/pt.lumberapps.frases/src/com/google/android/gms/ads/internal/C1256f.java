package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzlh;

/* renamed from: com.google.android.gms.ads.internal.f */
class C1256f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzju.zza f3618a;

    /* renamed from: b */
    final /* synthetic */ zzc f3619b;

    C1256f(zzc zzc, zzju.zza zza) {
        this.f3619b = zzc;
        this.f3618a = zza;
    }

    public void run() {
        this.f3619b.zzb(new zzju(this.f3618a, (zzlh) null, (zzfz) null, (zzgk) null, (String) null, (zzgc) null, (zzh.zza) null, (String) null));
    }
}
