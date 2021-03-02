package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzin
public class zzjj extends zza.C2107zza {

    /* renamed from: a */
    private zzjh f6522a;

    /* renamed from: b */
    private zzjk f6523b;

    /* renamed from: c */
    private zzji f6524c;

    public zzjj(zzji zzji) {
        this.f6524c = zzji;
    }

    public void zza(zzd zzd, RewardItemParcel rewardItemParcel) {
        if (this.f6524c != null) {
            this.f6524c.zzc(rewardItemParcel);
        }
    }

    public void zza(zzjh zzjh) {
        this.f6522a = zzjh;
    }

    public void zza(zzjk zzjk) {
        this.f6523b = zzjk;
    }

    public void zzb(zzd zzd, int i) {
        if (this.f6522a != null) {
            this.f6522a.zzaw(i);
        }
    }

    public void zzc(zzd zzd, int i) {
        if (this.f6523b != null) {
            this.f6523b.zza(zze.zzad(zzd).getClass().getName(), i);
        }
    }

    public void zzp(zzd zzd) {
        if (this.f6522a != null) {
            this.f6522a.zzrs();
        }
    }

    public void zzq(zzd zzd) {
        if (this.f6523b != null) {
            this.f6523b.zzcg(zze.zzad(zzd).getClass().getName());
        }
    }

    public void zzr(zzd zzd) {
        if (this.f6524c != null) {
            this.f6524c.onRewardedVideoAdOpened();
        }
    }

    public void zzs(zzd zzd) {
        if (this.f6524c != null) {
            this.f6524c.onRewardedVideoStarted();
        }
    }

    public void zzt(zzd zzd) {
        if (this.f6524c != null) {
            this.f6524c.onRewardedVideoAdClosed();
        }
    }

    public void zzu(zzd zzd) {
        if (this.f6524c != null) {
            this.f6524c.zzrr();
        }
    }

    public void zzv(zzd zzd) {
        if (this.f6524c != null) {
            this.f6524c.onRewardedVideoAdLeftApplication();
        }
    }
}
