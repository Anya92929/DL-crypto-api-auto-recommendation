package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.internal.h;
import com.google.ads.util.i;

public class m extends i {
    public final i.b<l> a;
    public final i.b<String> b;
    public final i.d<Activity> c;
    public final i.b<Context> d;
    public final i.b<ViewGroup> e;
    public final i.b<Ad> f;
    public final i.b<AdView> g;
    public final i.b<InterstitialAd> h;
    public final i.b<h> i;
    public final i.c<AdSize[]> j;
    public final i.c<AdListener> k = new i.c<>("adListener");
    public final i.c<AppEventListener> l = new i.c<>("appEventListener");

    public boolean a() {
        return !b();
    }

    public boolean b() {
        return this.i.a().a();
    }

    public m(l lVar, Ad ad, AdView adView, InterstitialAd interstitialAd, String str, Activity activity, Context context, ViewGroup viewGroup, h hVar) {
        this.a = new i.b<>("appState", lVar);
        this.f = new i.b<>("ad", ad);
        this.g = new i.b<>("adView", adView);
        this.i = new i.b<>("adType", hVar);
        this.b = new i.b<>("adUnitId", str);
        this.c = new i.d<>("activity", activity);
        this.h = new i.b<>("interstitialAd", interstitialAd);
        this.e = new i.b<>("bannerContainer", viewGroup);
        this.d = new i.b<>("applicationContext", context);
        this.j = new i.c<>("adSizes", null);
    }

    public static m a(Ad ad, String str, Activity activity, ViewGroup viewGroup, AdSize adSize) {
        InterstitialAd interstitialAd = null;
        l a2 = l.a();
        AdView adView = ad instanceof AdView ? (AdView) ad : null;
        if (ad instanceof InterstitialAd) {
            interstitialAd = (InterstitialAd) ad;
        }
        return new m(a2, ad, adView, interstitialAd, str.trim(), activity, activity.getApplicationContext(), viewGroup, adSize == null ? h.a : h.a(adSize, activity.getApplicationContext()));
    }
}
