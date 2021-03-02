package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator {
    /* renamed from: a */
    static void m5770a(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, versionInfoParcel.versionCode);
        zzb.zza(parcel, 2, versionInfoParcel.zzcs, false);
        zzb.zzc(parcel, 3, versionInfoParcel.zzcnk);
        zzb.zzc(parcel, 4, versionInfoParcel.zzcnl);
        zzb.zza(parcel, 5, versionInfoParcel.zzcnm);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzba */
    public VersionInfoParcel[] newArray(int i) {
        return new VersionInfoParcel[i];
    }

    /* renamed from: zzs */
    public VersionInfoParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
