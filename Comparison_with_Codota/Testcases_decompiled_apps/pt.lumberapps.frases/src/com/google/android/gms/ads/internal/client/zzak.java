package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhs;

public class zzak extends zzu.zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public zzq f3573a;

    public void destroy() {
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
    }

    public void stopLoading() {
    }

    public void zza(AdSizeParcel adSizeParcel) {
    }

    public void zza(VideoOptionsParcel videoOptionsParcel) {
    }

    public void zza(zzp zzp) {
    }

    public void zza(zzq zzq) {
        this.f3573a = zzq;
    }

    public void zza(zzw zzw) {
    }

    public void zza(zzy zzy) {
    }

    public void zza(zzd zzd) {
    }

    public void zza(zzdo zzdo) {
    }

    public void zza(zzho zzho) {
    }

    public void zza(zzhs zzhs, String str) {
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzb.m5769e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zza.zzcnb.post(new C1235h(this));
        return false;
    }

    public com.google.android.gms.dynamic.zzd zzdm() {
        return null;
    }

    public AdSizeParcel zzdn() {
        return null;
    }

    public void zzdp() {
    }

    public zzab zzdq() {
        return null;
    }
}
