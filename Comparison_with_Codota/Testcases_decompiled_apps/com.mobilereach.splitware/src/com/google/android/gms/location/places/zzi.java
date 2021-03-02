package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<PlacePhotoResult> {
    static void zza(PlacePhotoResult placePhotoResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) placePhotoResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoResult.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) placePhotoResult.zzaPG, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfg */
    public PlacePhotoResult createFromParcel(Parcel parcel) {
        BitmapTeleporter bitmapTeleporter;
        Status status;
        int i;
        BitmapTeleporter bitmapTeleporter2 = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status3;
                    break;
                case 2:
                    bitmapTeleporter = (BitmapTeleporter) zza.zza(parcel, zzat, BitmapTeleporter.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    BitmapTeleporter bitmapTeleporter3 = bitmapTeleporter2;
                    status = status2;
                    i = zza.zzg(parcel, zzat);
                    bitmapTeleporter = bitmapTeleporter3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            bitmapTeleporter2 = bitmapTeleporter;
        }
        if (parcel.dataPosition() == zzau) {
            return new PlacePhotoResult(i2, status2, bitmapTeleporter2);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhR */
    public PlacePhotoResult[] newArray(int i) {
        return new PlacePhotoResult[i];
    }
}
