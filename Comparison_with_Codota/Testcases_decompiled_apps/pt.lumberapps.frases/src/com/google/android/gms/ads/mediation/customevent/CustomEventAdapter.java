package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: a */
    CustomEventBanner f4140a;

    /* renamed from: b */
    CustomEventInterstitial f4141b;

    /* renamed from: c */
    CustomEventNative f4142c;

    /* renamed from: d */
    private View f4143d;

    /* renamed from: a */
    private static Object m5876a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            zzb.zzcx(new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5877a(View view) {
        this.f4143d = view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1331b mo5986a(MediationInterstitialListener mediationInterstitialListener) {
        return new C1331b(this, this, mediationInterstitialListener);
    }

    public View getBannerView() {
        return this.f4143d;
    }

    public void onDestroy() {
        if (this.f4140a != null) {
            this.f4140a.onDestroy();
        }
        if (this.f4141b != null) {
            this.f4141b.onDestroy();
        }
        if (this.f4142c != null) {
            this.f4142c.onDestroy();
        }
    }

    public void onPause() {
        if (this.f4140a != null) {
            this.f4140a.onPause();
        }
        if (this.f4141b != null) {
            this.f4141b.onPause();
        }
        if (this.f4142c != null) {
            this.f4142c.onPause();
        }
    }

    public void onResume() {
        if (this.f4140a != null) {
            this.f4140a.onResume();
        }
        if (this.f4141b != null) {
            this.f4141b.onResume();
        }
        if (this.f4142c != null) {
            this.f4142c.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f4140a = (CustomEventBanner) m5876a(bundle.getString("class_name"));
        if (this.f4140a == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.f4140a.requestBannerAd(context, new C1330a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f4141b = (CustomEventInterstitial) m5876a(bundle.getString("class_name"));
        if (this.f4141b == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.f4141b.requestInterstitialAd(context, mo5986a(mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.f4142c = (CustomEventNative) m5876a(bundle.getString("class_name"));
        if (this.f4142c == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.f4142c.requestNativeAd(context, new C1332c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public void showInterstitial() {
        this.f4141b.showInterstitial();
    }
}
