package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzin;

@zzin
public class zzg extends zzd.zza {

    /* renamed from: a */
    private final RewardedVideoAdListener f3972a;

    public zzg(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f3972a = rewardedVideoAdListener;
    }

    public void onRewardedVideoAdClosed() {
        if (this.f3972a != null) {
            this.f3972a.onRewardedVideoAdClosed();
        }
    }

    public void onRewardedVideoAdFailedToLoad(int i) {
        if (this.f3972a != null) {
            this.f3972a.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public void onRewardedVideoAdLeftApplication() {
        if (this.f3972a != null) {
            this.f3972a.onRewardedVideoAdLeftApplication();
        }
    }

    public void onRewardedVideoAdLoaded() {
        if (this.f3972a != null) {
            this.f3972a.onRewardedVideoAdLoaded();
        }
    }

    public void onRewardedVideoAdOpened() {
        if (this.f3972a != null) {
            this.f3972a.onRewardedVideoAdOpened();
        }
    }

    public void onRewardedVideoStarted() {
        if (this.f3972a != null) {
            this.f3972a.onRewardedVideoStarted();
        }
    }

    public void zza(zza zza) {
        if (this.f3972a != null) {
            this.f3972a.onRewarded(new zze(zza));
        }
    }
}
