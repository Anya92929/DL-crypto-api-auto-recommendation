package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.C0247d;
import com.google.ads.internal.C0253h;
import com.google.ads.util.C0304i;

/* renamed from: com.google.ads.n */
public class C0272n extends C0304i {

    /* renamed from: a */
    public final C0304i.C0307b<C0165Ad> f654a;

    /* renamed from: b */
    public final C0304i.C0307b<C0247d> f655b;

    /* renamed from: c */
    public final C0304i.C0309d<Activity> f656c;

    /* renamed from: d */
    public final C0304i.C0307b<C0265m> f657d;

    /* renamed from: e */
    public final C0304i.C0307b<ActivationOverlay> f658e;

    /* renamed from: f */
    public final C0304i.C0307b<Context> f659f;

    /* renamed from: g */
    public final C0304i.C0307b<C0253h> f660g;

    /* renamed from: h */
    public final C0304i.C0307b<String> f661h;

    /* renamed from: i */
    public final C0304i.C0307b<ViewGroup> f662i;

    /* renamed from: j */
    public final C0304i.C0307b<AdView> f663j;

    /* renamed from: k */
    public final C0304i.C0307b<InterstitialAd> f664k;

    /* renamed from: l */
    public final C0304i.C0308c<C0264l> f665l = new C0304i.C0308c<>("currentAd", null);

    /* renamed from: m */
    public final C0304i.C0308c<C0264l> f666m = new C0304i.C0308c<>("nextAd", null);

    /* renamed from: n */
    public final C0304i.C0308c<AdSize[]> f667n;

    /* renamed from: o */
    public final C0304i.C0308c<AdListener> f668o = new C0304i.C0308c<>("adListener");

    /* renamed from: p */
    public final C0304i.C0308c<AppEventListener> f669p = new C0304i.C0308c<>("appEventListener");

    /* renamed from: q */
    public final C0304i.C0308c<SwipeableAdListener> f670q = new C0304i.C0308c<>("swipeableEventListener");

    /* renamed from: r */
    public final C0304i.C0308c<C0190ak> f671r = new C0304i.C0308c<>("spamSignals", null);

    /* renamed from: s */
    public final C0304i.C0308c<C0192al> f672s = new C0304i.C0308c<>("spamSignalsUtil", null);

    /* renamed from: t */
    public final C0304i.C0308c<Boolean> f673t = new C0304i.C0308c<>("usesManualImpressions", false);

    /* renamed from: a */
    public boolean mo3683a() {
        return !mo3684b();
    }

    /* renamed from: b */
    public boolean mo3684b() {
        return this.f660g.mo3725a().mo3609a();
    }

    public C0272n(C0265m mVar, C0165Ad ad, AdView adView, InterstitialAd interstitialAd, String str, Activity activity, Context context, ViewGroup viewGroup, C0253h hVar, C0247d dVar) {
        ActivationOverlay activationOverlay = null;
        this.f657d = new C0304i.C0307b<>("appState", mVar);
        this.f654a = new C0304i.C0307b<>("ad", ad);
        this.f663j = new C0304i.C0307b<>("adView", adView);
        this.f660g = new C0304i.C0307b<>("adType", hVar);
        this.f661h = new C0304i.C0307b<>("adUnitId", str);
        this.f656c = new C0304i.C0309d<>("activity", activity);
        this.f664k = new C0304i.C0307b<>("interstitialAd", interstitialAd);
        this.f662i = new C0304i.C0307b<>("bannerContainer", viewGroup);
        this.f659f = new C0304i.C0307b<>("applicationContext", context);
        this.f667n = new C0304i.C0308c<>("adSizes", null);
        this.f655b = new C0304i.C0307b<>("adManager", dVar);
        if (hVar != null && hVar.mo3611b()) {
            activationOverlay = new ActivationOverlay(this);
        }
        this.f658e = new C0304i.C0307b<>("activationOverlay", activationOverlay);
    }
}
