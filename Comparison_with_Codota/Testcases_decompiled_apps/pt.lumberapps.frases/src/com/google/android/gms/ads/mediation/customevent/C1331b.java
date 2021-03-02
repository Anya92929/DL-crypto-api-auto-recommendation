package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* renamed from: com.google.android.gms.ads.mediation.customevent.b */
class C1331b implements CustomEventInterstitialListener {

    /* renamed from: a */
    final /* synthetic */ CustomEventAdapter f4147a;

    /* renamed from: b */
    private final CustomEventAdapter f4148b;

    /* renamed from: c */
    private final MediationInterstitialListener f4149c;

    public C1331b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.f4147a = customEventAdapter;
        this.f4148b = customEventAdapter2;
        this.f4149c = mediationInterstitialListener;
    }

    public void onAdClicked() {
        zzb.zzcv("Custom event adapter called onAdClicked.");
        this.f4149c.onAdClicked(this.f4148b);
    }

    public void onAdClosed() {
        zzb.zzcv("Custom event adapter called onAdClosed.");
        this.f4149c.onAdClosed(this.f4148b);
    }

    public void onAdFailedToLoad(int i) {
        zzb.zzcv("Custom event adapter called onFailedToReceiveAd.");
        this.f4149c.onAdFailedToLoad(this.f4148b, i);
    }

    public void onAdLeftApplication() {
        zzb.zzcv("Custom event adapter called onAdLeftApplication.");
        this.f4149c.onAdLeftApplication(this.f4148b);
    }

    public void onAdLoaded() {
        zzb.zzcv("Custom event adapter called onReceivedAd.");
        this.f4149c.onAdLoaded(this.f4147a);
    }

    public void onAdOpened() {
        zzb.zzcv("Custom event adapter called onAdOpened.");
        this.f4149c.onAdOpened(this.f4148b);
    }
}
