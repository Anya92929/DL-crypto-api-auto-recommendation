package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.C1228gr;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {

    /* renamed from: i */
    private AdView f15i;

    /* renamed from: j */
    private InterstitialAd f16j;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private static final class C0131a extends AdListener {

        /* renamed from: k */
        private final AdMobAdapter f17k;

        /* renamed from: l */
        private final MediationBannerListener f18l;

        public C0131a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f17k = adMobAdapter;
            this.f18l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f18l.onAdClosed(this.f17k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f18l.onAdFailedToLoad(this.f17k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f18l.onAdLeftApplication(this.f17k);
        }

        public void onAdLoaded() {
            this.f18l.onAdLoaded(this.f17k);
        }

        public void onAdOpened() {
            this.f18l.onAdClicked(this.f17k);
            this.f18l.onAdOpened(this.f17k);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private static final class C0132b extends AdListener {

        /* renamed from: k */
        private final AdMobAdapter f19k;

        /* renamed from: m */
        private final MediationInterstitialListener f20m;

        public C0132b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f19k = adMobAdapter;
            this.f20m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f20m.onAdClosed(this.f19k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f20m.onAdFailedToLoad(this.f19k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f20m.onAdLeftApplication(this.f19k);
        }

        public void onAdLoaded() {
            this.f20m.onAdLoaded(this.f19k);
        }

        public void onAdOpened() {
            this.f20m.onAdOpened(this.f19k);
        }
    }

    /* renamed from: a */
    static AdRequest m13a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(C1228gr.m4674v(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.f15i;
    }

    public void onDestroy() {
        if (this.f15i != null) {
            this.f15i.destroy();
            this.f15i = null;
        }
        if (this.f16j != null) {
            this.f16j = null;
        }
    }

    public void onPause() {
        if (this.f15i != null) {
            this.f15i.pause();
        }
    }

    public void onResume() {
        if (this.f15i != null) {
            this.f15i.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f15i = new AdView(context);
        this.f15i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f15i.setAdUnitId(serverParameters.getString("pubid"));
        this.f15i.setAdListener(new C0131a(this, bannerListener));
        this.f15i.loadAd(m13a(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f16j = new InterstitialAd(context);
        this.f16j.setAdUnitId(serverParameters.getString("pubid"));
        this.f16j.setAdListener(new C0132b(this, interstitialListener));
        this.f16j.loadAd(m13a(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f16j.show();
    }
}
