package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0165Ad;
import com.google.ads.InterstitialAd;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.AdUtil;

public class AdMobAdapter implements MediationBannerAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters>, MediationInterstitialAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MediationBannerListener f636a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationInterstitialListener f637b;

    /* renamed from: c */
    private AdView f638c;

    /* renamed from: d */
    private InterstitialAd f639d;

    /* renamed from: a */
    private void m415a() {
        if (m417b()) {
            throw new IllegalStateException("Adapter has already been destroyed");
        }
    }

    /* renamed from: b */
    private boolean m417b() {
        return this.f638c == null && this.f639d == null;
    }

    /* renamed from: a */
    private AdRequest m413a(Activity activity, AdMobAdapterServerParameters adMobAdapterServerParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras adMobAdapterExtras) {
        AdMobAdapterExtras adMobAdapterExtras2 = new AdMobAdapterExtras(adMobAdapterExtras);
        adMobAdapterExtras2.addExtra("_norefresh", "t");
        adMobAdapterExtras2.addExtra("gw", 1);
        if (adMobAdapterServerParameters.allowHouseAds != null) {
            adMobAdapterExtras2.addExtra("mad_hac", adMobAdapterServerParameters.allowHouseAds);
        }
        AdRequest networkExtras = new AdRequest().setBirthday(mediationAdRequest.getBirthday()).setGender(mediationAdRequest.getGender()).setKeywords(mediationAdRequest.getKeywords()).setLocation(mediationAdRequest.getLocation()).setNetworkExtras(adMobAdapterExtras2);
        if (mediationAdRequest.isTesting()) {
            networkExtras.addTestDevice(AdUtil.m441a((Context) activity));
        }
        return networkExtras;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdView mo3658a(Activity activity, AdSize adSize, String str) {
        return new AdView(activity, adSize, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InterstitialAd mo3659a(Activity activity, String str) {
        return new InterstitialAd(activity, str);
    }

    public Class<AdMobAdapterExtras> getAdditionalParametersType() {
        return AdMobAdapterExtras.class;
    }

    public Class<AdMobAdapterServerParameters> getServerParametersType() {
        return AdMobAdapterServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f636a = listener;
        if (adSize.isAutoHeight() || adSize.isFullWidth() || ((extras != null && extras.getUseExactAdSize()) || (adSize = adSize.findBestSize(AdSize.BANNER, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_MRECT, AdSize.IAB_WIDE_SKYSCRAPER)) != null)) {
            this.f638c = mo3658a(activity, adSize, serverParameters.adUnitId);
            this.f638c.setAdListener(new C0268a());
            this.f638c.loadAd(m413a(activity, serverParameters, mediationAdRequest, extras));
            return;
        }
        listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.NO_FILL);
    }

    public View getBannerView() {
        return this.f638c;
    }

    public void destroy() {
        m415a();
        if (this.f638c != null) {
            this.f638c.stopLoading();
            this.f638c.destroy();
            this.f638c = null;
        }
        if (this.f639d != null) {
            this.f639d.stopLoading();
            this.f639d = null;
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f637b = listener;
        this.f639d = mo3659a(activity, serverParameters.adUnitId);
        this.f639d.setAdListener(new C0269b());
        this.f639d.loadAd(m413a(activity, serverParameters, mediationAdRequest, extras));
    }

    public void showInterstitial() {
        this.f639d.show();
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private class C0268a implements AdListener {
        private C0268a() {
        }

        public void onReceiveAd(C0165Ad ad) {
            AdMobAdapter.this.f636a.onReceivedAd(AdMobAdapter.this);
        }

        public void onFailedToReceiveAd(C0165Ad ad, AdRequest.ErrorCode error) {
            AdMobAdapter.this.f636a.onFailedToReceiveAd(AdMobAdapter.this, error);
        }

        public void onPresentScreen(C0165Ad ad) {
            AdMobAdapter.this.f636a.onClick(AdMobAdapter.this);
            AdMobAdapter.this.f636a.onPresentScreen(AdMobAdapter.this);
        }

        public void onDismissScreen(C0165Ad ad) {
            AdMobAdapter.this.f636a.onDismissScreen(AdMobAdapter.this);
        }

        public void onLeaveApplication(C0165Ad ad) {
            AdMobAdapter.this.f636a.onLeaveApplication(AdMobAdapter.this);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private class C0269b implements AdListener {
        private C0269b() {
        }

        public void onReceiveAd(C0165Ad ad) {
            AdMobAdapter.this.f637b.onReceivedAd(AdMobAdapter.this);
        }

        public void onFailedToReceiveAd(C0165Ad ad, AdRequest.ErrorCode error) {
            AdMobAdapter.this.f637b.onFailedToReceiveAd(AdMobAdapter.this, error);
        }

        public void onPresentScreen(C0165Ad ad) {
            AdMobAdapter.this.f637b.onPresentScreen(AdMobAdapter.this);
        }

        public void onDismissScreen(C0165Ad ad) {
            AdMobAdapter.this.f637b.onDismissScreen(AdMobAdapter.this);
        }

        public void onLeaveApplication(C0165Ad ad) {
            AdMobAdapter.this.f637b.onLeaveApplication(AdMobAdapter.this);
        }
    }
}
