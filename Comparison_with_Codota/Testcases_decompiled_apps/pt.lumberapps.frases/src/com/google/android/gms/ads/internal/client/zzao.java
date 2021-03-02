package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzao implements Parcelable.Creator {
    /* renamed from: a */
    static void m5596a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, searchAdRequestParcel.versionCode);
        zzb.zzc(parcel, 2, searchAdRequestParcel.zzawz);
        zzb.zzc(parcel, 3, searchAdRequestParcel.backgroundColor);
        zzb.zzc(parcel, 4, searchAdRequestParcel.zzaxa);
        zzb.zzc(parcel, 5, searchAdRequestParcel.zzaxb);
        zzb.zzc(parcel, 6, searchAdRequestParcel.zzaxc);
        zzb.zzc(parcel, 7, searchAdRequestParcel.zzaxd);
        zzb.zzc(parcel, 8, searchAdRequestParcel.zzaxe);
        zzb.zzc(parcel, 9, searchAdRequestParcel.zzaxf);
        zzb.zza(parcel, 10, searchAdRequestParcel.zzaxg, false);
        zzb.zzc(parcel, 11, searchAdRequestParcel.zzaxh);
        zzb.zza(parcel, 12, searchAdRequestParcel.zzaxi, false);
        zzb.zzc(parcel, 13, searchAdRequestParcel.zzaxj);
        zzb.zzc(parcel, 14, searchAdRequestParcel.zzaxk);
        zzb.zza(parcel, 15, searchAdRequestParcel.zzaxl, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zze */
    public SearchAdRequestParcel createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 4:
                    i4 = zza.zzg(parcel, zzcl);
                    break;
                case 5:
                    i5 = zza.zzg(parcel, zzcl);
                    break;
                case 6:
                    i6 = zza.zzg(parcel, zzcl);
                    break;
                case 7:
                    i7 = zza.zzg(parcel, zzcl);
                    break;
                case 8:
                    i8 = zza.zzg(parcel, zzcl);
                    break;
                case 9:
                    i9 = zza.zzg(parcel, zzcl);
                    break;
                case 10:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 11:
                    i10 = zza.zzg(parcel, zzcl);
                    break;
                case 12:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 13:
                    i11 = zza.zzg(parcel, zzcl);
                    break;
                case 14:
                    i12 = zza.zzg(parcel, zzcl);
                    break;
                case 15:
                    str3 = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzu */
    public SearchAdRequestParcel[] newArray(int i) {
        return new SearchAdRequestParcel[i];
    }
}
