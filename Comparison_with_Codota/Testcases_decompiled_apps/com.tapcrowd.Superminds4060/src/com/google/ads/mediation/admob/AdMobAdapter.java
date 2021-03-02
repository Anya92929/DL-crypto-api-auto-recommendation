package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.C0275bb;
import com.google.android.gms.internal.C0343cm;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>, MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters> {

    /* renamed from: h */
    private AdView f283h;

    /* renamed from: i */
    private InterstitialAd f284i;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private static final class C0125a extends AdListener {

        /* renamed from: j */
        private final AdMobAdapter f285j;

        /* renamed from: k */
        private final MediationBannerListener f286k;

        public C0125a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f285j = adMobAdapter;
            this.f286k = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f286k.onDismissScreen(this.f285j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f286k.onFailedToReceiveAd(this.f285j, C0275bb.m559f(errorCode));
        }

        public void onAdLeftApplication() {
            this.f286k.onLeaveApplication(this.f285j);
        }

        public void onAdLoaded() {
            this.f286k.onReceivedAd(this.f285j);
        }

        public void onAdOpened() {
            this.f286k.onClick(this.f285j);
            this.f286k.onPresentScreen(this.f285j);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private static final class C0126b extends AdListener {

        /* renamed from: j */
        private final AdMobAdapter f287j;

        /* renamed from: l */
        private final MediationInterstitialListener f288l;

        public C0126b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f287j = adMobAdapter;
            this.f288l = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f288l.onDismissScreen(this.f287j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f288l.onFailedToReceiveAd(this.f287j, C0275bb.m559f(errorCode));
        }

        public void onAdLeftApplication() {
            this.f288l.onLeaveApplication(this.f287j);
        }

        public void onAdLoaded() {
            this.f288l.onReceivedAd(this.f287j);
        }

        public void onAdOpened() {
            this.f288l.onPresentScreen(this.f287j);
        }
    }

    /* renamed from: a */
    private static AdRequest m187a(Context context, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras, AdMobServerParameters adMobServerParameters) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        AdRequest.Gender gender = mediationAdRequest.getGender();
        if (gender != null) {
            builder.setGender(C0275bb.m555a(gender));
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(C0343cm.m728l(context));
        }
        if (adMobServerParameters.tagForChildDirectedTreatment != -1) {
            builder.tagForChildDirectedTreatment(adMobServerParameters.tagForChildDirectedTreatment == 1);
        }
        if (adMobExtras == null) {
            adMobExtras = new AdMobExtras(new Bundle());
        }
        Bundle extras = adMobExtras.getExtras();
        extras.putInt("gw", 1);
        extras.putString("mad_hac", adMobServerParameters.allowHouseAds);
        extras.putBoolean("_noRefresh", true);
        builder.addNetworkExtras(adMobExtras);
        return builder.build();
    }

    public void destroy() {
        if (this.f283h != null) {
            this.f283h.destroy();
            this.f283h = null;
        }
        if (this.f284i != null) {
            this.f284i = null;
        }
    }

    public Class<AdMobExtras> getAdditionalParametersType() {
        return AdMobExtras.class;
    }

    public View getBannerView() {
        return this.f283h;
    }

    public Class<AdMobServerParameters> getServerParametersType() {
        return AdMobServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener bannerListener, Activity activity, AdMobServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f283h = new AdView(activity);
        this.f283h.setAdSize(new com.google.android.gms.ads.AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f283h.setAdUnitId(serverParameters.adUnitId);
        this.f283h.setAdListener(new C0125a(this, bannerListener));
        this.f283h.loadAd(m187a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(MediationInterstitialListener interstitialListener, Activity activity, AdMobServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f284i = new InterstitialAd(activity);
        this.f284i.setAdUnitId(serverParameters.adUnitId);
        this.f284i.setAdListener(new C0126b(this, interstitialListener));
        this.f284i.loadAd(m187a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f284i.show();
    }
}
