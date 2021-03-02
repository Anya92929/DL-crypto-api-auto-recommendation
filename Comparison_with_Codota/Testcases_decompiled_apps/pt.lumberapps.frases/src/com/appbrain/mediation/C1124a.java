package com.appbrain.mediation;

import com.appbrain.AppBrainBanner;
import com.appbrain.C1138z;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;

/* renamed from: com.appbrain.mediation.a */
final class C1124a implements C1138z {

    /* renamed from: a */
    final /* synthetic */ CustomEventBannerListener f3157a;

    /* renamed from: b */
    final /* synthetic */ AppBrainBanner f3158b;

    /* renamed from: c */
    final /* synthetic */ AdmobAdapter f3159c;

    C1124a(AdmobAdapter admobAdapter, CustomEventBannerListener customEventBannerListener, AppBrainBanner appBrainBanner) {
        this.f3159c = admobAdapter;
        this.f3157a = customEventBannerListener;
        this.f3158b = appBrainBanner;
    }

    /* renamed from: a */
    public final void mo4444a(boolean z) {
        if (z) {
            this.f3157a.onAdLoaded(this.f3158b);
        } else {
            this.f3157a.onAdFailedToLoad(3);
        }
    }

    public final void onClick() {
        this.f3157a.onAdClicked();
    }
}
