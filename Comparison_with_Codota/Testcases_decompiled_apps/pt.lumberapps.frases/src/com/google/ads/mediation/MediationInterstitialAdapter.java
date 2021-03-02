package com.google.ads.mediation;

import android.app.Activity;

@Deprecated
public interface MediationInterstitialAdapter extends MediationAdapter {
    void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, MediationServerParameters mediationServerParameters, MediationAdRequest mediationAdRequest, NetworkExtras networkExtras);

    void showInterstitial();
}
