package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<PlaceAliasResult> {
    static void zza(PlaceAliasResult placeAliasResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) placeAliasResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placeAliasResult.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) placeAliasResult.zzzC(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfr */
    public PlaceAliasResult createFromParcel(Parcel parcel) {
        PlaceUserData placeUserData;
        Status status;
        int i;
        PlaceUserData placeUserData2 = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    placeUserData = placeUserData2;
                    status = status3;
                    break;
                case 2:
                    placeUserData = (PlaceUserData) zza.zza(parcel, zzat, PlaceUserData.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    PlaceUserData placeUserData3 = placeUserData2;
                    status = status2;
                    i = zza.zzg(parcel, zzat);
                    placeUserData = placeUserData3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    placeUserData = placeUserData2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            placeUserData2 = placeUserData;
        }
        if (parcel.dataPosition() == zzau) {
            return new PlaceAliasResult(i2, status2, placeUserData2);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzie */
    public PlaceAliasResult[] newArray(int i) {
        return new PlaceAliasResult[i];
    }
}
