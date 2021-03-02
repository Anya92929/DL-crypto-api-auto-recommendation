package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzu;

/* renamed from: com.google.android.gms.internal.he */
class C1602he extends zzq.zza {

    /* renamed from: a */
    zzq f5068a;

    /* renamed from: b */
    final /* synthetic */ C1601hd f5069b;

    C1602he(C1601hd hdVar, zzq zzq) {
        this.f5069b = hdVar;
        this.f5068a = zzq;
    }

    public void onAdClosed() {
        this.f5068a.onAdClosed();
        zzu.zzgb().mo8370a();
    }

    public void onAdFailedToLoad(int i) {
        this.f5068a.onAdFailedToLoad(i);
    }

    public void onAdLeftApplication() {
        this.f5068a.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.f5068a.onAdLoaded();
    }

    public void onAdOpened() {
        this.f5068a.onAdOpened();
    }
}
