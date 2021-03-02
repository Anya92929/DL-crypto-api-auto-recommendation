package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;

/* renamed from: com.google.android.gms.ads.mediation.customevent.c */
class C1332c implements CustomEventNativeListener {

    /* renamed from: a */
    private final CustomEventAdapter f4150a;

    /* renamed from: b */
    private final MediationNativeListener f4151b;

    public C1332c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
        this.f4150a = customEventAdapter;
        this.f4151b = mediationNativeListener;
    }

    public void onAdClicked() {
        zzb.zzcv("Custom event adapter called onAdClicked.");
        this.f4151b.onAdClicked(this.f4150a);
    }

    public void onAdClosed() {
        zzb.zzcv("Custom event adapter called onAdClosed.");
        this.f4151b.onAdClosed(this.f4150a);
    }

    public void onAdFailedToLoad(int i) {
        zzb.zzcv("Custom event adapter called onAdFailedToLoad.");
        this.f4151b.onAdFailedToLoad(this.f4150a, i);
    }

    public void onAdImpression() {
        zzb.zzcv("Custom event adapter called onAdImpression.");
        this.f4151b.onAdImpression(this.f4150a);
    }

    public void onAdLeftApplication() {
        zzb.zzcv("Custom event adapter called onAdLeftApplication.");
        this.f4151b.onAdLeftApplication(this.f4150a);
    }

    public void onAdLoaded(NativeAdMapper nativeAdMapper) {
        zzb.zzcv("Custom event adapter called onAdLoaded.");
        this.f4151b.onAdLoaded(this.f4150a, nativeAdMapper);
    }

    public void onAdOpened() {
        zzb.zzcv("Custom event adapter called onAdOpened.");
        this.f4151b.onAdOpened(this.f4150a);
    }
}
