package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Parcelable.Creator<PointOfInterest> {
    static void zza(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, pointOfInterest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) pointOfInterest.zzaTG, i, false);
        zzb.zza(parcel, 3, pointOfInterest.zzaTH, false);
        zzb.zza(parcel, 4, pointOfInterest.name, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfB */
    public PointOfInterest createFromParcel(Parcel parcel) {
        String zzp;
        String str;
        LatLng latLng;
        int i;
        String str2 = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        String str3 = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    String str4 = str2;
                    str = str3;
                    latLng = latLng2;
                    i = zza.zzg(parcel, zzat);
                    zzp = str4;
                    break;
                case 2:
                    i = i2;
                    String str5 = str3;
                    latLng = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    zzp = str2;
                    str = str5;
                    break;
                case 3:
                    latLng = latLng2;
                    i = i2;
                    String str6 = str2;
                    str = zza.zzp(parcel, zzat);
                    zzp = str6;
                    break;
                case 4:
                    zzp = zza.zzp(parcel, zzat);
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzp = str2;
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng2 = latLng;
            str3 = str;
            str2 = zzp;
        }
        if (parcel.dataPosition() == zzau) {
            return new PointOfInterest(i2, latLng2, str3, str2);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzip */
    public PointOfInterest[] newArray(int i) {
        return new PointOfInterest[i];
    }
}
