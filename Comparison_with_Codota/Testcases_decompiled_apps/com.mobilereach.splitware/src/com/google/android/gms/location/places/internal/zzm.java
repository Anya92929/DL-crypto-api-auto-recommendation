package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator<PlaceLikelihoodEntity> {
    static void zza(PlaceLikelihoodEntity placeLikelihoodEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) placeLikelihoodEntity.zzaQM, i, false);
        zzb.zzc(parcel, 1000, placeLikelihoodEntity.mVersionCode);
        zzb.zza(parcel, 2, placeLikelihoodEntity.zzaQN);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfm */
    public PlaceLikelihoodEntity createFromParcel(Parcel parcel) {
        float zzl;
        PlaceImpl placeImpl;
        int i;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        PlaceImpl placeImpl2 = null;
        float f = 0.0f;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = i2;
                    PlaceImpl placeImpl3 = (PlaceImpl) zza.zza(parcel, zzat, PlaceImpl.CREATOR);
                    zzl = f;
                    placeImpl = placeImpl3;
                    break;
                case 2:
                    zzl = zza.zzl(parcel, zzat);
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
                case 1000:
                    float f2 = f;
                    placeImpl = placeImpl2;
                    i = zza.zzg(parcel, zzat);
                    zzl = f2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzl = f;
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
            }
            i2 = i;
            placeImpl2 = placeImpl;
            f = zzl;
        }
        if (parcel.dataPosition() == zzau) {
            return new PlaceLikelihoodEntity(i2, placeImpl2, f);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhZ */
    public PlaceLikelihoodEntity[] newArray(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}
