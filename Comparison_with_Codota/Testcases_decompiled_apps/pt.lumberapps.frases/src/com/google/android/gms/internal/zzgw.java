package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzin
public final class zzgw implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzgl f6287a;

    public zzgw(zzgl zzgl) {
        this.f6287a = zzgl;
    }

    public void onClick(MediationBannerAdapter mediationBannerAdapter) {
        zzb.zzcv("Adapter called onClick.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onClick must be called on the main UI thread.");
            zza.zzcnb.post(new C1646iv(this));
            return;
        }
        try {
            this.f6287a.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onDismissScreen(MediationBannerAdapter mediationBannerAdapter) {
        zzb.zzcv("Adapter called onDismissScreen.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onDismissScreen must be called on the main UI thread.");
            zza.zzcnb.post(new C1652ja(this));
            return;
        }
        try {
            this.f6287a.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzb.zzcv("Adapter called onDismissScreen.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onDismissScreen must be called on the main UI thread.");
            zza.zzcnb.post(new C1657jf(this));
            return;
        }
        try {
            this.f6287a.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzb.zzcv(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzcnb.post(new C1653jb(this, errorCode));
            return;
        }
        try {
            this.f6287a.onAdFailedToLoad(zzgx.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzb.zzcv(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzcnb.post(new C1647iw(this, errorCode));
            return;
        }
        try {
            this.f6287a.onAdFailedToLoad(zzgx.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter mediationBannerAdapter) {
        zzb.zzcv("Adapter called onLeaveApplication.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onLeaveApplication must be called on the main UI thread.");
            zza.zzcnb.post(new C1654jc(this));
            return;
        }
        try {
            this.f6287a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzb.zzcv("Adapter called onLeaveApplication.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onLeaveApplication must be called on the main UI thread.");
            zza.zzcnb.post(new C1648ix(this));
            return;
        }
        try {
            this.f6287a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onPresentScreen(MediationBannerAdapter mediationBannerAdapter) {
        zzb.zzcv("Adapter called onPresentScreen.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onPresentScreen must be called on the main UI thread.");
            zza.zzcnb.post(new C1655jd(this));
            return;
        }
        try {
            this.f6287a.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzb.zzcv("Adapter called onPresentScreen.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onPresentScreen must be called on the main UI thread.");
            zza.zzcnb.post(new C1649iy(this));
            return;
        }
        try {
            this.f6287a.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onReceivedAd(MediationBannerAdapter mediationBannerAdapter) {
        zzb.zzcv("Adapter called onReceivedAd.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onReceivedAd must be called on the main UI thread.");
            zza.zzcnb.post(new C1656je(this));
            return;
        }
        try {
            this.f6287a.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzb.zzcv("Adapter called onReceivedAd.");
        if (!zzm.zziw().zztx()) {
            zzb.zzcx("onReceivedAd must be called on the main UI thread.");
            zza.zzcnb.post(new C1650iz(this));
            return;
        }
        try {
            this.f6287a.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }
}
