package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator {
    /* renamed from: a */
    static void m5753a(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, largeParcelTeleporter.f3905a);
        zzb.zza(parcel, 2, (Parcelable) largeParcelTeleporter.f3906b, i, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzas */
    public LargeParcelTeleporter[] newArray(int i) {
        return new LargeParcelTeleporter[i];
    }

    /* renamed from: zzo */
    public LargeParcelTeleporter createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzcl, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new LargeParcelTeleporter(i, parcelFileDescriptor);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
