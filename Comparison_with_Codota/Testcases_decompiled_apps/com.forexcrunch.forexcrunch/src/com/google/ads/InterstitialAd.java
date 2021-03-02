package com.google.ads;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.ads.internal.C0247d;

public class InterstitialAd implements C0165Ad {

    /* renamed from: a */
    private C0247d f118a;

    public InterstitialAd(Activity activity, String adUnitId) {
        this(activity, adUnitId, false);
    }

    public InterstitialAd(Activity activity, String adUnitId, boolean shortTimeout) {
        this.f118a = new C0247d(this, activity, (AdSize) null, adUnitId, (ViewGroup) null, shortTimeout);
    }

    public boolean isReady() {
        return this.f118a.mo3560s();
    }

    public void loadAd(AdRequest adRequest) {
        this.f118a.mo3530a(adRequest);
    }

    public void show() {
        this.f118a.mo3517B();
    }

    public void setAdListener(AdListener adListener) {
        this.f118a.mo3550i().f668o.mo3727a(adListener);
    }

    /* access modifiers changed from: protected */
    public void setAppEventListener(AppEventListener appEventListener) {
        this.f118a.mo3550i().f669p.mo3727a(appEventListener);
    }

    public void stopLoading() {
        this.f118a.mo3518C();
    }
}
