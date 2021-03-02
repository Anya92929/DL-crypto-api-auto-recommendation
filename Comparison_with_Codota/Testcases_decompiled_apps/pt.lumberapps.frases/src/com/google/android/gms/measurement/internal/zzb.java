package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator {
    /* renamed from: a */
    static void m7813a(AppMetadata appMetadata, Parcel parcel, int i) {
        int zzcn = com.google.android.gms.common.internal.safeparcel.zzb.zzcn(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, appMetadata.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, appMetadata.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, appMetadata.aic, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, appMetadata.aav, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, appMetadata.aid, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, appMetadata.aie);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, appMetadata.aif);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, appMetadata.aig, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, appMetadata.aih);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, appMetadata.aii);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, appMetadata.aij);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, appMetadata.aik, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzon */
    public AppMetadata createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        String str6 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzcl);
                    break;
                case 5:
                    str4 = zza.zzq(parcel, zzcl);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzcl);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzcl);
                    break;
                case 8:
                    str5 = zza.zzq(parcel, zzcl);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 10:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 11:
                    j3 = zza.zzi(parcel, zzcl);
                    break;
                case 12:
                    str6 = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2, j3, str6);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzvi */
    public AppMetadata[] newArray(int i) {
        return new AppMetadata[i];
    }
}
