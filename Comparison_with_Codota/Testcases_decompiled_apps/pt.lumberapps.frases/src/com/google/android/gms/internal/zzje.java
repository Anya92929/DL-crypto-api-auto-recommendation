package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.dynamic.zze;

@zzin
public class zzje extends zzb.zza {

    /* renamed from: a */
    private final Context f6505a;

    /* renamed from: b */
    private final VersionInfoParcel f6506b;

    /* renamed from: c */
    private final zzjf f6507c;

    /* renamed from: d */
    private final Object f6508d = new Object();

    public zzje(Context context, zzd zzd, zzgj zzgj, VersionInfoParcel versionInfoParcel) {
        this.f6505a = context;
        this.f6506b = versionInfoParcel;
        this.f6507c = new zzjf(context, zzd, AdSizeParcel.zzii(), zzgj, versionInfoParcel);
    }

    public void destroy() {
        zzh((com.google.android.gms.dynamic.zzd) null);
    }

    public boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.f6508d) {
            isLoaded = this.f6507c.isLoaded();
        }
        return isLoaded;
    }

    public void pause() {
        zzf((com.google.android.gms.dynamic.zzd) null);
    }

    public void resume() {
        zzg((com.google.android.gms.dynamic.zzd) null);
    }

    public void setUserId(String str) {
        zzkd.zzcx("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.f6508d) {
            this.f6507c.zzrq();
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.f6508d) {
            this.f6507c.zza(rewardedVideoAdRequestParcel);
        }
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) {
        synchronized (this.f6508d) {
            this.f6507c.zza(zzd);
        }
    }

    public void zzf(com.google.android.gms.dynamic.zzd zzd) {
        synchronized (this.f6508d) {
            this.f6507c.pause();
        }
    }

    public void zzg(com.google.android.gms.dynamic.zzd zzd) {
        synchronized (this.f6508d) {
            Context context = zzd == null ? null : (Context) zze.zzad(zzd);
            if (context != null) {
                try {
                    this.f6507c.onContextChanged(context);
                } catch (Exception e) {
                    zzkd.zzd("Unable to extract updated context.", e);
                }
            }
            this.f6507c.resume();
        }
    }

    public void zzh(com.google.android.gms.dynamic.zzd zzd) {
        synchronized (this.f6508d) {
            this.f6507c.destroy();
        }
    }
}
