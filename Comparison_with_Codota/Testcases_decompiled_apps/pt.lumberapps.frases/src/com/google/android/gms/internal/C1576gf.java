package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.zzq;

/* renamed from: com.google.android.gms.internal.gf */
class C1576gf extends zzq.zza {

    /* renamed from: a */
    final /* synthetic */ C1575ge f5029a;

    C1576gf(C1575ge geVar) {
        this.f5029a = geVar;
    }

    public void onAdClosed() {
        this.f5029a.f5028a.add(new C1577gg(this));
    }

    public void onAdFailedToLoad(int i) {
        this.f5029a.f5028a.add(new C1578gh(this, i));
        zzkd.m7303v("Pooled interstitial failed to load.");
    }

    public void onAdLeftApplication() {
        this.f5029a.f5028a.add(new C1579gi(this));
    }

    public void onAdLoaded() {
        this.f5029a.f5028a.add(new C1580gj(this));
        zzkd.m7303v("Pooled interstitial loaded.");
    }

    public void onAdOpened() {
        this.f5029a.f5028a.add(new C1581gk(this));
    }
}
