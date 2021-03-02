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
import com.google.android.gms.internal.C0344cn;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {

    /* renamed from: m */
    private View f289m;

    /* renamed from: n */
    private CustomEventBanner f290n;

    /* renamed from: o */
    private CustomEventInterstitial f291o;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private static final class C0127a implements CustomEventBannerListener {

        /* renamed from: k */
        private final MediationBannerListener f292k;

        /* renamed from: p */
        private final CustomEventAdapter f293p;

        public C0127a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f293p = customEventAdapter;
            this.f292k = mediationBannerListener;
        }

        public void onClick() {
            C0344cn.m733m("Custom event adapter called onFailedToReceiveAd.");
            this.f292k.onClick(this.f293p);
        }

        public void onDismissScreen() {
            C0344cn.m733m("Custom event adapter called onFailedToReceiveAd.");
            this.f292k.onDismissScreen(this.f293p);
        }

        public void onFailedToReceiveAd() {
            C0344cn.m733m("Custom event adapter called onFailedToReceiveAd.");
            this.f292k.onFailedToReceiveAd(this.f293p, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            C0344cn.m733m("Custom event adapter called onFailedToReceiveAd.");
            this.f292k.onLeaveApplication(this.f293p);
        }

        public void onPresentScreen() {
            C0344cn.m733m("Custom event adapter called onFailedToReceiveAd.");
            this.f292k.onPresentScreen(this.f293p);
        }

        public void onReceivedAd(View view) {
            C0344cn.m733m("Custom event adapter called onReceivedAd.");
            this.f293p.m189a(view);
            this.f292k.onReceivedAd(this.f293p);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0128b implements CustomEventInterstitialListener {

        /* renamed from: l */
        private final MediationInterstitialListener f294l;

        /* renamed from: p */
        private final CustomEventAdapter f295p;

        public C0128b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f295p = customEventAdapter;
            this.f294l = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            C0344cn.m733m("Custom event adapter called onDismissScreen.");
            this.f294l.onDismissScreen(this.f295p);
        }

        public void onFailedToReceiveAd() {
            C0344cn.m733m("Custom event adapter called onFailedToReceiveAd.");
            this.f294l.onFailedToReceiveAd(this.f295p, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            C0344cn.m733m("Custom event adapter called onLeaveApplication.");
            this.f294l.onLeaveApplication(this.f295p);
        }

        public void onPresentScreen() {
            C0344cn.m733m("Custom event adapter called onPresentScreen.");
            this.f294l.onPresentScreen(this.f295p);
        }

        public void onReceivedAd() {
            C0344cn.m733m("Custom event adapter called onReceivedAd.");
            this.f294l.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* renamed from: a */
    private static <T> T m188a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            C0344cn.m737q("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m189a(View view) {
        this.f289m = view;
    }

    public void destroy() {
        if (this.f290n != null) {
            this.f290n.destroy();
        }
        if (this.f291o != null) {
            this.f291o.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f289m;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f290n = (CustomEventBanner) m188a(serverParameters.className);
        if (this.f290n == null) {
            listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.f290n.requestBannerAd(new C0127a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f291o = (CustomEventInterstitial) m188a(serverParameters.className);
        if (this.f291o == null) {
            listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.f291o.requestInterstitialAd(new C0128b(this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f291o.showInterstitial();
    }
}
