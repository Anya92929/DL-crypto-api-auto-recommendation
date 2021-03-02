package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator {
    /* renamed from: a */
    static void m6257a(GassRequestParcel gassRequestParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, gassRequestParcel.versionCode);
        zzb.zza(parcel, 2, gassRequestParcel.packageName, false);
        zzb.zza(parcel, 3, gassRequestParcel.f4802YW, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzmg */
    public GassRequestParcel createFromParcel(Parcel parcel) {
        String str = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new GassRequestParcel(i, str2, str);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzsj */
    public GassRequestParcel[] newArray(int i) {
        return new GassRequestParcel[i];
    }
}
