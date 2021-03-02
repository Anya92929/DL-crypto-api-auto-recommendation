package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Parcelable.Creator<LocationSettingsResult> {
    static void zza(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) locationSettingsResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, locationSettingsResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) locationSettingsResult.getLocationSettingsStates(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzeT */
    public LocationSettingsResult createFromParcel(Parcel parcel) {
        LocationSettingsStates locationSettingsStates;
        Status status;
        int i;
        LocationSettingsStates locationSettingsStates2 = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    locationSettingsStates = locationSettingsStates2;
                    status = status3;
                    break;
                case 2:
                    locationSettingsStates = (LocationSettingsStates) zza.zza(parcel, zzat, LocationSettingsStates.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates2;
                    status = status2;
                    i = zza.zzg(parcel, zzat);
                    locationSettingsStates = locationSettingsStates3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    locationSettingsStates = locationSettingsStates2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            locationSettingsStates2 = locationSettingsStates;
        }
        if (parcel.dataPosition() == zzau) {
            return new LocationSettingsResult(i2, status2, locationSettingsStates2);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhw */
    public LocationSettingsResult[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
