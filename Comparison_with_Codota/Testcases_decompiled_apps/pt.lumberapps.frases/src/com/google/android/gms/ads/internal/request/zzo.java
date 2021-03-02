package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Parcelable.Creator {
    /* renamed from: a */
    static void m5763a(StringParcel stringParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, stringParcel.f3909a);
        zzb.zza(parcel, 2, stringParcel.f3910b, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzat */
    public StringParcel[] newArray(int i) {
        return new StringParcel[i];
    }

    /* renamed from: zzp */
    public StringParcel createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new StringParcel(i, str);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
