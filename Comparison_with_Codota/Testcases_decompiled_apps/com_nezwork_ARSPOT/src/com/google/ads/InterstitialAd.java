package com.google.ads;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.ads.internal.d;

public class InterstitialAd implements Ad {
    private d a;
    private m b;

    public InterstitialAd(Activity activity, String adUnitId) {
        this(activity, adUnitId, false);
    }

    public InterstitialAd(Activity activity, String adUnitId, boolean shortTimeout) {
        this.b = m.a(this, adUnitId, activity, (ViewGroup) null, (AdSize) null);
        this.a = new d(this.b, shortTimeout);
    }

    public boolean isReady() {
        return this.a.r();
    }

    public void loadAd(AdRequest adRequest) {
        this.a.a(adRequest);
    }

    public void show() {
        this.a.z();
    }

    public void setAdListener(AdListener adListener) {
        this.b.k.a(adListener);
    }

    /* access modifiers changed from: protected */
    public void setAppEventListener(AppEventListener appEventListener) {
        this.b.l.a(appEventListener);
    }

    public void stopLoading() {
        this.a.A();
    }
}
