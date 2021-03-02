package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator {
    /* renamed from: a */
    static void m5625a(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, nativeAdOptionsParcel.versionCode);
        zzb.zza(parcel, 2, nativeAdOptionsParcel.zzbgp);
        zzb.zzc(parcel, 3, nativeAdOptionsParcel.zzbgq);
        zzb.zza(parcel, 4, nativeAdOptionsParcel.zzbgr);
        zzb.zzc(parcel, 5, nativeAdOptionsParcel.zzbgs);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzg */
    public NativeAdOptionsParcel createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcm = zza.zzcm(parcel);
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new NativeAdOptionsParcel(i3, z2, i2, z, i);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzw */
    public NativeAdOptionsParcel[] newArray(int i) {
        return new NativeAdOptionsParcel[i];
    }
}
