package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.zza;

public class zzan extends zzb.zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public zzd f3574a;

    public void destroy() {
    }

    public boolean isLoaded() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setUserId(String str) {
    }

    public void show() {
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        com.google.android.gms.ads.internal.util.client.zzb.m5769e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zza.zzcnb.post(new C1236i(this));
    }

    public void zza(zzd zzd) {
        this.f3574a = zzd;
    }

    public void zzf(com.google.android.gms.dynamic.zzd zzd) {
    }

    public void zzg(com.google.android.gms.dynamic.zzd zzd) {
    }

    public void zzh(com.google.android.gms.dynamic.zzd zzd) {
    }
}
