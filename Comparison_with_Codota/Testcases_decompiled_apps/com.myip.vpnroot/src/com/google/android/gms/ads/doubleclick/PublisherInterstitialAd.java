package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.C0947bi;

public final class PublisherInterstitialAd {

    /* renamed from: lj */
    private final C0947bi f41lj;

    public PublisherInterstitialAd(Context context) {
        this.f41lj = new C0947bi(context, this);
    }

    public AdListener getAdListener() {
        return this.f41lj.getAdListener();
    }

    public String getAdUnitId() {
        return this.f41lj.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.f41lj.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.f41lj.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.f41lj.isLoaded();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f41lj.mo8109a(publisherAdRequest.mo3311V());
    }

    public void setAdListener(AdListener adListener) {
        this.f41lj.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.f41lj.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f41lj.setAppEventListener(appEventListener);
    }

    public void show() {
        this.f41lj.show();
    }
}
