package com.google.android.gms.internal;

import com.google.android.gms.internal.zzla;

/* renamed from: com.google.android.gms.internal.ks */
class C1697ks implements zzla.zzc {

    /* renamed from: a */
    final /* synthetic */ zzdi f5246a;

    /* renamed from: b */
    final /* synthetic */ C1696kr f5247b;

    C1697ks(C1696kr krVar, zzdi zzdi) {
        this.f5247b = krVar;
        this.f5246a = zzdi;
    }

    /* renamed from: a */
    public void zzd(zzft zzft) {
        this.f5247b.f5243c.zza(this.f5246a, "jsf");
        this.f5247b.f5243c.zzkh();
        zzft.zza("/invalidRequest", this.f5247b.f5242b.zzcep);
        zzft.zza("/loadAdURL", this.f5247b.f5242b.zzceq);
        zzft.zza("/loadAd", this.f5247b.f5242b.zzcer);
        try {
            zzft.zzj("AFMA_getAd", this.f5247b.f5245e);
        } catch (Exception e) {
            zzkd.zzb("Error requesting an ad url", e);
        }
    }
}
