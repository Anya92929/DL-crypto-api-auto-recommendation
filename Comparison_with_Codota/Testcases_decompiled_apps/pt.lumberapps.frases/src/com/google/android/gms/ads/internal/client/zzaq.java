package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaq implements Parcelable.Creator {
    /* renamed from: a */
    static void m5597a(VideoOptionsParcel videoOptionsParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, videoOptionsParcel.versionCode);
        zzb.zza(parcel, 2, videoOptionsParcel.zzaxm);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzf */
    public VideoOptionsParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new VideoOptionsParcel(i, z);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzv */
    public VideoOptionsParcel[] newArray(int i) {
        return new VideoOptionsParcel[i];
    }
}
