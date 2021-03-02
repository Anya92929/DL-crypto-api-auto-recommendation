package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<PlacePhotoMetadataResult> {
    static void zza(PlacePhotoMetadataResult placePhotoMetadataResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) placePhotoMetadataResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoMetadataResult.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) placePhotoMetadataResult.zzaPE, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzff */
    public PlacePhotoMetadataResult createFromParcel(Parcel parcel) {
        DataHolder dataHolder;
        Status status;
        int i;
        DataHolder dataHolder2 = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    dataHolder = dataHolder2;
                    status = status3;
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    DataHolder dataHolder3 = dataHolder2;
                    status = status2;
                    i = zza.zzg(parcel, zzat);
                    dataHolder = dataHolder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    dataHolder = dataHolder2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataHolder2 = dataHolder;
        }
        if (parcel.dataPosition() == zzau) {
            return new PlacePhotoMetadataResult(i2, status2, dataHolder2);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhQ */
    public PlacePhotoMetadataResult[] newArray(int i) {
        return new PlacePhotoMetadataResult[i];
    }
}
