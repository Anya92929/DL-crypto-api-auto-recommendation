package com.appbrain.mediation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import cmn.Proguard;
import com.appbrain.AppBrainBanner;
import com.appbrain.C0783a;
import com.appbrain.C0980aa;
import com.appbrain.C0982ac;
import com.appbrain.C1027e;
import com.appbrain.C1121k;
import com.appbrain.C1135w;
import com.appbrain.KeepClass;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import java.util.Locale;
import org.json.JSONObject;

public class AdmobAdapter implements Proguard.KeepMembers, KeepClass, CustomEventBanner, CustomEventInterstitial {

    /* renamed from: a */
    private static final String f3153a = AdmobAdapter.class.getSimpleName();

    /* renamed from: b */
    private Context f3154b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CustomEventInterstitialListener f3155c;

    /* renamed from: d */
    private String f3156d;

    private static C0783a getAdId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return C0783a.m3582b(new JSONObject(str.toUpperCase(Locale.US)).optString("ADID"));
        } catch (Exception e) {
            Log.println(5, f3153a, "Error parsing server parameter: " + e.getMessage() + "\n" + str);
            return null;
        }
    }

    private static C1027e getScreenType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return C1027e.valueOf(new JSONObject(str.toUpperCase(Locale.US)).optString("SCREENTYPE"));
        } catch (Exception e) {
            Log.println(5, f3153a, "Error parsing server parameter: " + e.getMessage() + "\n" + str);
            return null;
        }
    }

    public void onDestroy() {
        this.f3154b = null;
        this.f3155c = null;
        this.f3156d = null;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestBannerAd(Context context, CustomEventBannerListener customEventBannerListener, String str, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle) {
        AppBrainBanner appBrainBanner = new AppBrainBanner(context);
        C1135w wVar = C1135w.DEFAULT;
        if (adSize.isAutoHeight()) {
            wVar = C1135w.RESPONSIVE;
        } else if (adSize.getHeight() > 80) {
            wVar = C1135w.LARGE;
        }
        appBrainBanner.setSize(wVar);
        appBrainBanner.setBannerListener(new C1124a(this, customEventBannerListener, appBrainBanner));
        appBrainBanner.setAdId(getAdId(str));
        appBrainBanner.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        appBrainBanner.mo3598a(true, "admob");
        appBrainBanner.mo3599b();
    }

    public void requestInterstitialAd(Context context, CustomEventInterstitialListener customEventInterstitialListener, String str, MediationAdRequest mediationAdRequest, Bundle bundle) {
        C1121k.m5210b(context);
        boolean a = C1121k.m5207a().mo3694a(context);
        this.f3154b = context;
        if (a) {
            customEventInterstitialListener.onAdLoaded();
        } else {
            customEventInterstitialListener.onAdFailedToLoad(3);
        }
        this.f3155c = customEventInterstitialListener;
        this.f3156d = str;
    }

    public void showInterstitial() {
        try {
            C0980aa.m4089a().mo3905a(getAdId(this.f3156d)).mo3908a("admob_int").mo3907a(getScreenType(this.f3156d)).mo3906a((C0982ac) new C1125b(this)).mo3909a(this.f3154b);
        } catch (Exception e) {
        }
    }
}
