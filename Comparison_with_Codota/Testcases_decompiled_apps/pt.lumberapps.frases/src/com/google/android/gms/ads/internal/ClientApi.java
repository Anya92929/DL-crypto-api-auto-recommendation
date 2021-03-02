package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.formats.zzk;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzhi;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzje;

@Keep
@DynamiteApi
@zzin
public class ClientApi extends zzx.zza {
    public zzs createAdLoaderBuilder(zzd zzd, String str, zzgj zzgj, int i) {
        return new zzk((Context) zze.zzad(zzd), str, zzgj, new VersionInfoParcel(com.google.android.gms.common.internal.zze.f4556xM, i, true), zzd.zzek());
    }

    public zzhi createAdOverlay(zzd zzd) {
        return new com.google.android.gms.ads.internal.overlay.zzd((Activity) zze.zzad(zzd));
    }

    public zzu createBannerAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgj zzgj, int i) {
        return new zzf((Context) zze.zzad(zzd), adSizeParcel, str, zzgj, new VersionInfoParcel(com.google.android.gms.common.internal.zze.f4556xM, i, true), zzd.zzek());
    }

    public zzhp createInAppPurchaseManager(zzd zzd) {
        return new com.google.android.gms.ads.internal.purchase.zze((Activity) zze.zzad(zzd));
    }

    public zzu createInterstitialAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgj zzgj, int i) {
        Context context = (Context) zze.zzad(zzd);
        zzdc.initialize(context);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(com.google.android.gms.common.internal.zze.f4556xM, i, true);
        boolean equals = "reward_mb".equals(adSizeParcel.zzaur);
        if ((!equals && ((Boolean) zzdc.zzbae.get()).booleanValue()) || (equals && ((Boolean) zzdc.zzbaf.get()).booleanValue())) {
            return new zzfn(context, str, zzgj, versionInfoParcel, zzd.zzek());
        }
        return new zzl(context, adSizeParcel, str, zzgj, versionInfoParcel, zzd.zzek());
    }

    public zzdt createNativeAdViewDelegate(zzd zzd, zzd zzd2) {
        return new zzk((FrameLayout) zze.zzad(zzd), (FrameLayout) zze.zzad(zzd2));
    }

    public zzb createRewardedVideoAd(zzd zzd, zzgj zzgj, int i) {
        return new zzje((Context) zze.zzad(zzd), zzd.zzek(), zzgj, new VersionInfoParcel(com.google.android.gms.common.internal.zze.f4556xM, i, true));
    }

    public zzu createSearchAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, int i) {
        return new zzt((Context) zze.zzad(zzd), adSizeParcel, str, new VersionInfoParcel(com.google.android.gms.common.internal.zze.f4556xM, i, true));
    }

    public zzz getMobileAdsSettingsManager(zzd zzd) {
        return null;
    }

    public zzz getMobileAdsSettingsManagerWithClientJarVersion(zzd zzd, int i) {
        return zzo.zza((Context) zze.zzad(zzd), new VersionInfoParcel(com.google.android.gms.common.internal.zze.f4556xM, i, true));
    }
}
