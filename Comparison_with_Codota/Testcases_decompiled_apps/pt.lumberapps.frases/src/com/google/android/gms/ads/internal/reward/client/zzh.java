package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator {
    /* renamed from: a */
    static void m5765a(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, rewardedVideoAdRequestParcel.versionCode);
        zzb.zza(parcel, 2, (Parcelable) rewardedVideoAdRequestParcel.zzcar, i, false);
        zzb.zza(parcel, 3, rewardedVideoAdRequestParcel.zzaou, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzav */
    public RewardedVideoAdRequestParcel[] newArray(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    /* renamed from: zzq */
    public RewardedVideoAdRequestParcel createFromParcel(Parcel parcel) {
        String zzq;
        AdRequestParcel adRequestParcel;
        int i;
        String str = null;
        int zzcm = zza.zzcm(parcel);
        int i2 = 0;
        AdRequestParcel adRequestParcel2 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    String str2 = str;
                    adRequestParcel = adRequestParcel2;
                    i = zza.zzg(parcel, zzcl);
                    zzq = str2;
                    break;
                case 2:
                    i = i2;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) zza.zza(parcel, zzcl, AdRequestParcel.CREATOR);
                    zzq = str;
                    adRequestParcel = adRequestParcel3;
                    break;
                case 3:
                    zzq = zza.zzq(parcel, zzcl);
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    zzq = str;
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
            }
            i2 = i;
            adRequestParcel2 = adRequestParcel;
            str = zzq;
        }
        if (parcel.dataPosition() == zzcm) {
            return new RewardedVideoAdRequestParcel(i2, adRequestParcel2, str);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
