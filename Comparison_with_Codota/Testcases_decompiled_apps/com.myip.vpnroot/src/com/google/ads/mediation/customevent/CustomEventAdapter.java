package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.C1229gs;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {

    /* renamed from: n */
    private View f21n;

    /* renamed from: o */
    private CustomEventBanner f22o;

    /* renamed from: p */
    private CustomEventInterstitial f23p;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private static final class C0133a implements CustomEventBannerListener {

        /* renamed from: q */
        private final CustomEventAdapter f24q;

        /* renamed from: r */
        private final MediationBannerListener f25r;

        public C0133a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f24q = customEventAdapter;
            this.f25r = mediationBannerListener;
        }

        public void onClick() {
            C1229gs.m4675S("Custom event adapter called onFailedToReceiveAd.");
            this.f25r.onClick(this.f24q);
        }

        public void onDismissScreen() {
            C1229gs.m4675S("Custom event adapter called onFailedToReceiveAd.");
            this.f25r.onDismissScreen(this.f24q);
        }

        public void onFailedToReceiveAd() {
            C1229gs.m4675S("Custom event adapter called onFailedToReceiveAd.");
            this.f25r.onFailedToReceiveAd(this.f24q, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            C1229gs.m4675S("Custom event adapter called onFailedToReceiveAd.");
            this.f25r.onLeaveApplication(this.f24q);
        }

        public void onPresentScreen() {
            C1229gs.m4675S("Custom event adapter called onFailedToReceiveAd.");
            this.f25r.onPresentScreen(this.f24q);
        }

        public void onReceivedAd(View view) {
            C1229gs.m4675S("Custom event adapter called onReceivedAd.");
            this.f24q.m15a(view);
            this.f25r.onReceivedAd(this.f24q);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0134b implements CustomEventInterstitialListener {

        /* renamed from: q */
        private final CustomEventAdapter f26q;

        /* renamed from: s */
        private final MediationInterstitialListener f27s;

        public C0134b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f26q = customEventAdapter;
            this.f27s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            C1229gs.m4675S("Custom event adapter called onDismissScreen.");
            this.f27s.onDismissScreen(this.f26q);
        }

        public void onFailedToReceiveAd() {
            C1229gs.m4675S("Custom event adapter called onFailedToReceiveAd.");
            this.f27s.onFailedToReceiveAd(this.f26q, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            C1229gs.m4675S("Custom event adapter called onLeaveApplication.");
            this.f27s.onLeaveApplication(this.f26q);
        }

        public void onPresentScreen() {
            C1229gs.m4675S("Custom event adapter called onPresentScreen.");
            this.f27s.onPresentScreen(this.f26q);
        }

        public void onReceivedAd() {
            C1229gs.m4675S("Custom event adapter called onReceivedAd.");
            this.f27s.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* renamed from: a */
    private static <T> T m14a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            C1229gs.m4679W("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15a(View view) {
        this.f21n = view;
    }

    public void destroy() {
        if (this.f22o != null) {
            this.f22o.destroy();
        }
        if (this.f23p != null) {
            this.f23p.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f21n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f22o = (CustomEventBanner) m14a(serverParameters.className);
        if (this.f22o == null) {
            listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.f22o.requestBannerAd(new C0133a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f23p = (CustomEventInterstitial) m14a(serverParameters.className);
        if (this.f23p == null) {
            listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.f23p.requestInterstitialAd(new C0134b(this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f23p.showInterstitial();
    }
}
