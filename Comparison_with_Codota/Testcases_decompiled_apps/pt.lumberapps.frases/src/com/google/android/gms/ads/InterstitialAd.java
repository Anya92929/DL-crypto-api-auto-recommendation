package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaf;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public final class InterstitialAd {

    /* renamed from: a */
    private final zzaf f3394a;

    public InterstitialAd(Context context) {
        this.f3394a = new zzaf(context);
    }

    public AdListener getAdListener() {
        return this.f3394a.getAdListener();
    }

    public String getAdUnitId() {
        return this.f3394a.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f3394a.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.f3394a.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.f3394a.isLoaded();
    }

    public boolean isLoading() {
        return this.f3394a.isLoading();
    }

    public void loadAd(AdRequest adRequest) {
        this.f3394a.zza(adRequest.zzdc());
    }

    public void setAdListener(AdListener adListener) {
        this.f3394a.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zza)) {
            this.f3394a.zza((zza) adListener);
        } else if (adListener == null) {
            this.f3394a.zza((zza) null);
        }
    }

    public void setAdUnitId(String str) {
        this.f3394a.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f3394a.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.f3394a.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f3394a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public void show() {
        this.f3394a.show();
    }

    public void zzd(boolean z) {
        this.f3394a.zzd(z);
    }
}
