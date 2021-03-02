package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator {
    /* renamed from: a */
    static void m5828a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, interstitialAdParameterParcel.versionCode);
        zzb.zza(parcel, 2, interstitialAdParameterParcel.zzame);
        zzb.zza(parcel, 3, interstitialAdParameterParcel.zzamf);
        zzb.zza(parcel, 4, interstitialAdParameterParcel.zzamg, false);
        zzb.zza(parcel, 5, interstitialAdParameterParcel.zzamh);
        zzb.zza(parcel, 6, interstitialAdParameterParcel.zzami);
        zzb.zzc(parcel, 7, interstitialAdParameterParcel.zzamj);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzb */
    public InterstitialAdParameterParcel createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcm = zza.zzcm(parcel);
        String str = null;
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzcl);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 6:
                    f = zza.zzl(parcel, zzcl);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new InterstitialAdParameterParcel(i2, z3, z2, str, z, f, i);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzi */
    public InterstitialAdParameterParcel[] newArray(int i) {
        return new InterstitialAdParameterParcel[i];
    }
}
