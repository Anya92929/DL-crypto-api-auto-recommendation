package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzin
public final class zzgv extends zzgk.zza {

    /* renamed from: a */
    private final MediationAdapter f6285a;

    /* renamed from: b */
    private final NetworkExtras f6286b;

    public zzgv(MediationAdapter mediationAdapter, NetworkExtras networkExtras) {
        this.f6285a = mediationAdapter;
        this.f6286b = networkExtras;
    }

    /* renamed from: a */
    private MediationServerParameters m7108a(String str, int i, String str2) {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzb.zzd("Could not get MediationServerParameters.", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f6285a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void destroy() {
        try {
            this.f6285a.destroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public zzd getView() {
        if (!(this.f6285a instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.f6285a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return zze.zzac(((MediationBannerAdapter) this.f6285a).getBannerView());
        } catch (Throwable th) {
            zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        return true;
    }

    public void pause() {
        throw new RemoteException();
    }

    public void resume() {
        throw new RemoteException();
    }

    public void showInterstitial() {
        if (!(this.f6285a instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.f6285a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f6285a).showInterstitial();
        } catch (Throwable th) {
            zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    public void showVideo() {
    }

    public void zza(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zza zza, String str2) {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzgl zzgl) {
        zza(zzd, adRequestParcel, str, (String) null, zzgl);
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl) {
        if (!(this.f6285a instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.f6285a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f6285a).requestInterstitialAd(new zzgw(zzgl), (Activity) zze.zzad(zzd), m7108a(str, adRequestParcel.zzatq, str2), zzgx.zzp(adRequestParcel), this.f6286b);
        } catch (Throwable th) {
            zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl, NativeAdOptionsParcel nativeAdOptionsParcel, List list) {
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzgl zzgl) {
        zza(zzd, adSizeParcel, adRequestParcel, str, (String) null, zzgl);
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl) {
        if (!(this.f6285a instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.f6285a.getClass().getCanonicalName());
            zzb.zzcx(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzb.zzcv("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.f6285a).requestBannerAd(new zzgw(zzgl), (Activity) zze.zzad(zzd), m7108a(str, adRequestParcel.zzatq, str2), zzgx.zzc(adSizeParcel), zzgx.zzp(adRequestParcel), this.f6286b);
        } catch (Throwable th) {
            zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zzc(AdRequestParcel adRequestParcel, String str) {
    }

    public void zzj(zzd zzd) {
    }

    public zzgn zzmo() {
        return null;
    }

    public zzgo zzmp() {
        return null;
    }

    public Bundle zzmq() {
        return new Bundle();
    }

    public Bundle zzmr() {
        return new Bundle();
    }
}
