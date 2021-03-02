package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.ads.internal.client.f */
class C1233f extends zzr.zza {

    /* renamed from: a */
    final /* synthetic */ zzaj f3458a;

    private C1233f(zzaj zzaj) {
        this.f3458a = zzaj;
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public void zzf(AdRequestParcel adRequestParcel) {
        zzb.m5769e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zza.zzcnb.post(new C1234g(this));
    }
}
