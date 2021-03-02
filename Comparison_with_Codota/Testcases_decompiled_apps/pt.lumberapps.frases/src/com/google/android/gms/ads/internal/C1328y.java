package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzlh;

/* renamed from: com.google.android.gms.ads.internal.y */
class C1328y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzju.zza f4002a;

    /* renamed from: b */
    final /* synthetic */ zzq f4003b;

    C1328y(zzq zzq, zzju.zza zza) {
        this.f4003b = zzq;
        this.f4002a = zza;
    }

    public void run() {
        this.f4003b.zzb(new zzju(this.f4002a, (zzlh) null, (zzfz) null, (zzgk) null, (String) null, (zzgc) null, (zzh.zza) null, (String) null));
    }
}
