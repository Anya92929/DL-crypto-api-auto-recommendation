package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<LatLng> {
    static void zza(LatLng latLng, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, latLng.getVersionCode());
        zzb.zza(parcel, 2, latLng.latitude);
        zzb.zza(parcel, 3, latLng.longitude);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfz */
    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int zzau = zza.zzau(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    d2 = zza.zzn(parcel, zzat);
                    break;
                case 3:
                    d = zza.zzn(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LatLng(i, d2, d);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzin */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
