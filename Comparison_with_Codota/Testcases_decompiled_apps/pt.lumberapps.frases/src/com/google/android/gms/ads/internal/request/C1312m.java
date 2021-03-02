package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzla;

/* renamed from: com.google.android.gms.ads.internal.request.m */
class C1312m implements zzla.zzc {

    /* renamed from: a */
    final /* synthetic */ C1311l f3929a;

    C1312m(C1311l lVar) {
        this.f3929a = lVar;
    }

    /* renamed from: a */
    public void zzd(zzft zzft) {
        try {
            zzft.zza("AFMA_getAdapterLessMediationAd", this.f3929a.f3926a);
        } catch (Exception e) {
            zzkd.zzb("Error requesting an ad url", e);
            zzn.f3960f.zzax(this.f3929a.f3927b);
        }
    }
}
