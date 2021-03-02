package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.C0947bi;

public final class InterstitialAd {

    /* renamed from: lj */
    private final C0947bi f37lj;

    public InterstitialAd(Context context) {
        this.f37lj = new C0947bi(context);
    }

    public AdListener getAdListener() {
        return this.f37lj.getAdListener();
    }

    public String getAdUnitId() {
        return this.f37lj.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f37lj.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.f37lj.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.f37lj.isLoaded();
    }

    public void loadAd(AdRequest adRequest) {
        this.f37lj.mo8109a(adRequest.mo3253V());
    }

    public void setAdListener(AdListener adListener) {
        this.f37lj.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.f37lj.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f37lj.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.f37lj.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }

    public void show() {
        this.f37lj.show();
    }
}
