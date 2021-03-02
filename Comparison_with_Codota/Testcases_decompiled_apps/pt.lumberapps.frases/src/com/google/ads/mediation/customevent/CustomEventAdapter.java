package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private View zzfu;
    CustomEventBanner zzfv;
    CustomEventInterstitial zzfw;

    final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzfx;
        private final MediationBannerListener zzfy;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzfx = customEventAdapter;
            this.zzfy = mediationBannerListener;
        }

        public void onClick() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onClick(this.zzfx);
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onDismissScreen(this.zzfx);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onFailedToReceiveAd(this.zzfx, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onLeaveApplication(this.zzfx);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onPresentScreen(this.zzfx);
        }

        public void onReceivedAd(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onReceivedAd.");
            this.zzfx.zza(view);
            this.zzfy.onReceivedAd(this.zzfx);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzfx;
        private final MediationInterstitialListener zzfz;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzfx = customEventAdapter;
            this.zzfz = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onDismissScreen.");
            this.zzfz.onDismissScreen(this.zzfx);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onFailedToReceiveAd.");
            this.zzfz.onFailedToReceiveAd(this.zzfx, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onLeaveApplication.");
            this.zzfz.onLeaveApplication(this.zzfx);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onPresentScreen.");
            this.zzfz.onPresentScreen(this.zzfx);
        }

        public void onReceivedAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcv("Custom event adapter called onReceivedAd.");
            this.zzfz.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* access modifiers changed from: private */
    public void zza(View view) {
        this.zzfu = view;
    }

    private static Object zzj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            com.google.android.gms.ads.internal.util.client.zzb.zzcx(new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    public void destroy() {
        if (this.zzfv != null) {
            this.zzfv.destroy();
        }
        if (this.zzfw != null) {
            this.zzfw.destroy();
        }
    }

    public Class getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzfu;
    }

    public Class getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzfv = (CustomEventBanner) zzj(customEventServerParameters.className);
        if (this.zzfv == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzfv.requestBannerAd(new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzfw = (CustomEventInterstitial) zzj(customEventServerParameters.className);
        if (this.zzfw == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzfw.requestInterstitialAd(zza(mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void showInterstitial() {
        this.zzfw.showInterstitial();
    }

    /* access modifiers changed from: package-private */
    public zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
