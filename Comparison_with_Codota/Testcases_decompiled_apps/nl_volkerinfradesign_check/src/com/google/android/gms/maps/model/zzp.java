package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Parcelable.Creator<VisibleRegion> {
    /* renamed from: a */
    static void m4228a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, visibleRegion.mo7004a());
        zzb.zza(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        zzb.zza(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        zzb.zza(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        zzb.zza(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        zzb.zza(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfK */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    latLng4 = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzat, LatLngBounds.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zziy */
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
