package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator {
    /* renamed from: a */
    static void m6258a(GassResponseParcel gassResponseParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, gassResponseParcel.versionCode);
        zzb.zza(parcel, 2, gassResponseParcel.zzblc(), false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzmh */
    public GassResponseParcel createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    bArr = zza.zzt(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new GassResponseParcel(i, bArr);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzsk */
    public GassResponseParcel[] newArray(int i) {
        return new GassResponseParcel[i];
    }
}
