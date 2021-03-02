package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.C1229gs;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {

    /* renamed from: n */
    private View f47n;

    /* renamed from: xf */
    private CustomEventBanner f48xf;

    /* renamed from: xg */
    private CustomEventInterstitial f49xg;

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$a */
    private static final class C0144a implements CustomEventBannerListener {

        /* renamed from: l */
        private final MediationBannerListener f50l;

        /* renamed from: xh */
        private final CustomEventAdapter f51xh;

        public C0144a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f51xh = customEventAdapter;
            this.f50l = mediationBannerListener;
        }

        public void onAdClicked() {
            C1229gs.m4675S("Custom event adapter called onAdClicked.");
            this.f50l.onAdClicked(this.f51xh);
        }

        public void onAdClosed() {
            C1229gs.m4675S("Custom event adapter called onAdClosed.");
            this.f50l.onAdClosed(this.f51xh);
        }

        public void onAdFailedToLoad(int errorCode) {
            C1229gs.m4675S("Custom event adapter called onAdFailedToLoad.");
            this.f50l.onAdFailedToLoad(this.f51xh, errorCode);
        }

        public void onAdLeftApplication() {
            C1229gs.m4675S("Custom event adapter called onAdLeftApplication.");
            this.f50l.onAdLeftApplication(this.f51xh);
        }

        public void onAdLoaded(View view) {
            C1229gs.m4675S("Custom event adapter called onAdLoaded.");
            this.f51xh.m31a(view);
            this.f50l.onAdLoaded(this.f51xh);
        }

        public void onAdOpened() {
            C1229gs.m4675S("Custom event adapter called onAdOpened.");
            this.f50l.onAdOpened(this.f51xh);
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0145b implements CustomEventInterstitialListener {

        /* renamed from: m */
        private final MediationInterstitialListener f52m;

        /* renamed from: xh */
        private final CustomEventAdapter f53xh;

        public C0145b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f53xh = customEventAdapter;
            this.f52m = mediationInterstitialListener;
        }

        public void onAdClicked() {
            C1229gs.m4675S("Custom event adapter called onAdClicked.");
            this.f52m.onAdClicked(this.f53xh);
        }

        public void onAdClosed() {
            C1229gs.m4675S("Custom event adapter called onAdClosed.");
            this.f52m.onAdClosed(this.f53xh);
        }

        public void onAdFailedToLoad(int errorCode) {
            C1229gs.m4675S("Custom event adapter called onFailedToReceiveAd.");
            this.f52m.onAdFailedToLoad(this.f53xh, errorCode);
        }

        public void onAdLeftApplication() {
            C1229gs.m4675S("Custom event adapter called onAdLeftApplication.");
            this.f52m.onAdLeftApplication(this.f53xh);
        }

        public void onAdLoaded() {
            C1229gs.m4675S("Custom event adapter called onReceivedAd.");
            this.f52m.onAdLoaded(CustomEventAdapter.this);
        }

        public void onAdOpened() {
            C1229gs.m4675S("Custom event adapter called onAdOpened.");
            this.f52m.onAdOpened(this.f53xh);
        }
    }

    /* renamed from: a */
    private static <T> T m30a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            C1229gs.m4679W("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31a(View view) {
        this.f47n = view;
    }

    public View getBannerView() {
        return this.f47n;
    }

    public void onDestroy() {
        if (this.f48xf != null) {
            this.f48xf.onDestroy();
        }
        if (this.f49xg != null) {
            this.f49xg.onDestroy();
        }
    }

    public void onPause() {
        if (this.f48xf != null) {
            this.f48xf.onPause();
        }
        if (this.f49xg != null) {
            this.f49xg.onPause();
        }
    }

    public void onResume() {
        if (this.f48xf != null) {
            this.f48xf.onResume();
        }
        if (this.f49xg != null) {
            this.f49xg.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.f48xf = (CustomEventBanner) m30a(serverParameters.getString("class_name"));
        if (this.f48xf == null) {
            listener.onAdFailedToLoad(this, 0);
        } else {
            this.f48xf.requestBannerAd(context, new C0144a(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.f49xg = (CustomEventInterstitial) m30a(serverParameters.getString("class_name"));
        if (this.f49xg == null) {
            listener.onAdFailedToLoad(this, 0);
        } else {
            this.f49xg.requestInterstitialAd(context, new C0145b(this, listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
        }
    }

    public void showInterstitial() {
        this.f49xg.showInterstitial();
    }
}
