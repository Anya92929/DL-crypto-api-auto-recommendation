package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgk;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzin
public final class zzgq extends zzgk.zza {

    /* renamed from: a */
    private final MediationAdapter f6270a;

    /* renamed from: b */
    private zzgr f6271b;

    public zzgq(MediationAdapter mediationAdapter) {
        this.f6270a = mediationAdapter;
    }

    /* renamed from: a */
    private Bundle m7107a(String str, int i, String str2) {
        String valueOf = String.valueOf(str);
        zzb.zzcx(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.f6270a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            zzb.zzd("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    public void destroy() {
        try {
            this.f6270a.onDestroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        if (this.f6270a instanceof zzlt) {
            return ((zzlt) this.f6270a).getInterstitialAdapterInfo();
        }
        String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
        zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationInterstitialAdapter: "));
        return new Bundle();
    }

    public zzd getView() {
        if (!(this.f6270a instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return zze.zzac(((MediationBannerAdapter) this.f6270a).getBannerView());
        } catch (Throwable th) {
            zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        if (!(this.f6270a instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.f6270a).isInitialized();
        } catch (Throwable th) {
            zzb.zzd("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    public void pause() {
        try {
            this.f6270a.onPause();
        } catch (Throwable th) {
            zzb.zzd("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    public void resume() {
        try {
            this.f6270a.onResume();
        } catch (Throwable th) {
            zzb.zzd("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    public void showInterstitial() {
        if (!(this.f6270a instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f6270a).showInterstitial();
        } catch (Throwable th) {
            zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    public void showVideo() {
        if (!(this.f6270a instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.f6270a).showVideo();
        } catch (Throwable th) {
            zzb.zzd("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(AdRequestParcel adRequestParcel, String str, String str2) {
        if (!(this.f6270a instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f6270a;
            mediationRewardedVideoAdAdapter.loadAd(new zzgp(adRequestParcel.zzatm == -1 ? null : new Date(adRequestParcel.zzatm), adRequestParcel.zzatn, adRequestParcel.zzato != null ? new HashSet(adRequestParcel.zzato) : null, adRequestParcel.zzatu, adRequestParcel.zzatp, adRequestParcel.zzatq, adRequestParcel.zzaub), m7107a(str, adRequestParcel.zzatq, str2), adRequestParcel.zzatw != null ? adRequestParcel.zzatw.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zza zza, String str2) {
        if (!(this.f6270a instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f6270a;
            mediationRewardedVideoAdAdapter.initialize((Context) zze.zzad(zzd), new zzgp(adRequestParcel.zzatm == -1 ? null : new Date(adRequestParcel.zzatm), adRequestParcel.zzatn, adRequestParcel.zzato != null ? new HashSet(adRequestParcel.zzato) : null, adRequestParcel.zzatu, adRequestParcel.zzatp, adRequestParcel.zzatq, adRequestParcel.zzaub), str, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zza), m7107a(str2, adRequestParcel.zzatq, (String) null), adRequestParcel.zzatw != null ? adRequestParcel.zzatw.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzgl zzgl) {
        zza(zzd, adRequestParcel, str, (String) null, zzgl);
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl) {
        if (!(this.f6270a instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f6270a;
            mediationInterstitialAdapter.requestInterstitialAd((Context) zze.zzad(zzd), new zzgr(zzgl), m7107a(str, adRequestParcel.zzatq, str2), new zzgp(adRequestParcel.zzatm == -1 ? null : new Date(adRequestParcel.zzatm), adRequestParcel.zzatn, adRequestParcel.zzato != null ? new HashSet(adRequestParcel.zzato) : null, adRequestParcel.zzatu, adRequestParcel.zzatp, adRequestParcel.zzatq, adRequestParcel.zzaub), adRequestParcel.zzatw != null ? adRequestParcel.zzatw.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl, NativeAdOptionsParcel nativeAdOptionsParcel, List list) {
        if (!(this.f6270a instanceof MediationNativeAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationNativeAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.f6270a;
            zzgu zzgu = new zzgu(adRequestParcel.zzatm == -1 ? null : new Date(adRequestParcel.zzatm), adRequestParcel.zzatn, adRequestParcel.zzato != null ? new HashSet(adRequestParcel.zzato) : null, adRequestParcel.zzatu, adRequestParcel.zzatp, adRequestParcel.zzatq, nativeAdOptionsParcel, list, adRequestParcel.zzaub);
            Bundle bundle = adRequestParcel.zzatw != null ? adRequestParcel.zzatw.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.f6271b = new zzgr(zzgl);
            mediationNativeAdapter.requestNativeAd((Context) zze.zzad(zzd), this.f6271b, m7107a(str, adRequestParcel.zzatq, str2), zzgu, bundle);
        } catch (Throwable th) {
            zzb.zzd("Could not request native ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzgl zzgl) {
        zza(zzd, adSizeParcel, adRequestParcel, str, (String) null, zzgl);
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl) {
        if (!(this.f6270a instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f6270a;
            mediationBannerAdapter.requestBannerAd((Context) zze.zzad(zzd), new zzgr(zzgl), m7107a(str, adRequestParcel.zzatq, str2), com.google.android.gms.ads.zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zzaur), new zzgp(adRequestParcel.zzatm == -1 ? null : new Date(adRequestParcel.zzatm), adRequestParcel.zzatn, adRequestParcel.zzato != null ? new HashSet(adRequestParcel.zzato) : null, adRequestParcel.zzatu, adRequestParcel.zzatp, adRequestParcel.zzatq, adRequestParcel.zzaub), adRequestParcel.zzatw != null ? adRequestParcel.zzatw.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zzc(AdRequestParcel adRequestParcel, String str) {
        zza(adRequestParcel, str, (String) null);
    }

    public void zzj(zzd zzd) {
        try {
            ((OnContextChangedListener) this.f6270a).onContextChanged((Context) zze.zzad(zzd));
        } catch (Throwable th) {
            zzb.zza("Could not inform adapter of changed context", th);
        }
    }

    public zzgn zzmo() {
        NativeAdMapper zzms = this.f6271b.zzms();
        if (zzms instanceof NativeAppInstallAdMapper) {
            return new zzgs((NativeAppInstallAdMapper) zzms);
        }
        return null;
    }

    public zzgo zzmp() {
        NativeAdMapper zzms = this.f6271b.zzms();
        if (zzms instanceof NativeContentAdMapper) {
            return new zzgt((NativeContentAdMapper) zzms);
        }
        return null;
    }

    public Bundle zzmq() {
        if (this.f6270a instanceof zzls) {
            return ((zzls) this.f6270a).zzmq();
        }
        String valueOf = String.valueOf(this.f6270a.getClass().getCanonicalName());
        zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationBannerAdapter: "));
        return new Bundle();
    }

    public Bundle zzmr() {
        return new Bundle();
    }
}
