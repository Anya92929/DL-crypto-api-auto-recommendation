package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzaf;

public final class PublisherInterstitialAd {

    /* renamed from: a */
    private final zzaf f3405a;

    public PublisherInterstitialAd(Context context) {
        this.f3405a = new zzaf(context, this);
    }

    public AdListener getAdListener() {
        return this.f3405a.getAdListener();
    }

    public String getAdUnitId() {
        return this.f3405a.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.f3405a.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.f3405a.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f3405a.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoaded() {
        return this.f3405a.isLoaded();
    }

    public boolean isLoading() {
        return this.f3405a.isLoading();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f3405a.zza(publisherAdRequest.zzdc());
    }

    public void setAdListener(AdListener adListener) {
        this.f3405a.setAdListener(adListener);
    }

    public void setAdUnitId(String str) {
        this.f3405a.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f3405a.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.f3405a.setCorrelator(correlator);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f3405a.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public void show() {
        this.f3405a.show();
    }
}
