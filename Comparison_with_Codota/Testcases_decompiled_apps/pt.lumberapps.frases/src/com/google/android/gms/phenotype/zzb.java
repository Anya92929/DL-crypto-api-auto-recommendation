package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator {
    /* renamed from: a */
    static void m8020a(Flag flag, Parcel parcel, int i) {
        int zzcn = com.google.android.gms.common.internal.safeparcel.zzb.zzcn(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, flag.f7396a);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, flag.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, flag.f7397b);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, flag.f7398c);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, flag.f7399d);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, flag.f7400e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, flag.f7401f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, flag.arn);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, flag.aro);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzqy */
    public Flag createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int zzcm = zza.zzcm(parcel);
        long j = 0;
        double d = 0.0d;
        int i2 = 0;
        String str = null;
        boolean z = false;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzcl);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 5:
                    d = zza.zzn(parcel, zzcl);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 7:
                    bArr = zza.zzt(parcel, zzcl);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new Flag(i3, str2, j, z, d, str, bArr, i2, i);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzyf */
    public Flag[] newArray(int i) {
        return new Flag[i];
    }
}
