package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.client.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;

/* renamed from: com.google.android.gms.internal.gt */
class C1590gt extends zzd.zza {

    /* renamed from: a */
    final /* synthetic */ C1575ge f5048a;

    C1590gt(C1575ge geVar) {
        this.f5048a = geVar;
    }

    public void onRewardedVideoAdClosed() {
        this.f5048a.f5028a.add(new C1594gx(this));
    }

    public void onRewardedVideoAdFailedToLoad(int i) {
        this.f5048a.f5028a.add(new C1598ha(this, i));
    }

    public void onRewardedVideoAdLeftApplication() {
        this.f5048a.f5028a.add(new C1596gz(this));
    }

    public void onRewardedVideoAdLoaded() {
        this.f5048a.f5028a.add(new C1591gu(this));
    }

    public void onRewardedVideoAdOpened() {
        this.f5048a.f5028a.add(new C1592gv(this));
    }

    public void onRewardedVideoStarted() {
        this.f5048a.f5028a.add(new C1593gw(this));
    }

    public void zza(zza zza) {
        this.f5048a.f5028a.add(new C1595gy(this, zza));
    }
}
