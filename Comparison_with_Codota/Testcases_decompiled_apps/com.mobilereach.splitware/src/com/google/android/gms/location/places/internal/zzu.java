package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;

public class zzu implements Parcelable.Creator<AutocompletePredictionEntity.SubstringEntity> {
    static void zza(AutocompletePredictionEntity.SubstringEntity substringEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, substringEntity.mOffset);
        zzb.zzc(parcel, 1000, substringEntity.mVersionCode);
        zzb.zzc(parcel, 2, substringEntity.mLength);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfp */
    public AutocompletePredictionEntity.SubstringEntity createFromParcel(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AutocompletePredictionEntity.SubstringEntity(i3, i2, i);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzic */
    public AutocompletePredictionEntity.SubstringEntity[] newArray(int i) {
        return new AutocompletePredictionEntity.SubstringEntity[i];
    }
}
