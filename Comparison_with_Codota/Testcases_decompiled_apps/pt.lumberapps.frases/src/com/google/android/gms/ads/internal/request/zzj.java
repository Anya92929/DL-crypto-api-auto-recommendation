package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator {
    /* renamed from: a */
    static void m5752a(CapabilityParcel capabilityParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, capabilityParcel.versionCode);
        zzb.zza(parcel, 2, capabilityParcel.zzccw);
        zzb.zza(parcel, 3, capabilityParcel.zzccx);
        zzb.zza(parcel, 4, capabilityParcel.zzccy);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzar */
    public CapabilityParcel[] newArray(int i) {
        return new CapabilityParcel[i];
    }

    /* renamed from: zzn */
    public CapabilityParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzcl);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new CapabilityParcel(i, z3, z2, z);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
