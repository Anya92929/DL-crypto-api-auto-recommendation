package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerListener;

/* renamed from: com.google.android.gms.ads.mediation.customevent.a */
final class C1330a implements CustomEventBannerListener {

    /* renamed from: a */
    private final CustomEventAdapter f4145a;

    /* renamed from: b */
    private final MediationBannerListener f4146b;

    public C1330a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.f4145a = customEventAdapter;
        this.f4146b = mediationBannerListener;
    }

    public void onAdClicked() {
        zzb.zzcv("Custom event adapter called onAdClicked.");
        this.f4146b.onAdClicked(this.f4145a);
    }

    public void onAdClosed() {
        zzb.zzcv("Custom event adapter called onAdClosed.");
        this.f4146b.onAdClosed(this.f4145a);
    }

    public void onAdFailedToLoad(int i) {
        zzb.zzcv("Custom event adapter called onAdFailedToLoad.");
        this.f4146b.onAdFailedToLoad(this.f4145a, i);
    }

    public void onAdLeftApplication() {
        zzb.zzcv("Custom event adapter called onAdLeftApplication.");
        this.f4146b.onAdLeftApplication(this.f4145a);
    }

    public void onAdLoaded(View view) {
        zzb.zzcv("Custom event adapter called onAdLoaded.");
        this.f4145a.m5877a(view);
        this.f4146b.onAdLoaded(this.f4145a);
    }

    public void onAdOpened() {
        zzb.zzcv("Custom event adapter called onAdOpened.");
        this.f4146b.onAdOpened(this.f4145a);
    }
}
