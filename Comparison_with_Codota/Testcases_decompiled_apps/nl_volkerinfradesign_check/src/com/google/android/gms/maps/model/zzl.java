package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<StreetViewPanoramaLocation> {
    /* renamed from: a */
    static void m4224a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaLocation.mo6960a());
        zzb.zza(parcel, 2, (T[]) streetViewPanoramaLocation.links, i, false);
        zzb.zza(parcel, 3, (Parcelable) streetViewPanoramaLocation.position, i, false);
        zzb.zza(parcel, 4, streetViewPanoramaLocation.panoId, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfG */
    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String zzp;
        LatLng latLng;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr;
        int i;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        LatLng latLng2 = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    String str2 = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = zza.zzg(parcel, zzat);
                    zzp = str2;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng3 = latLng2;
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) zza.zzb(parcel, zzat, StreetViewPanoramaLink.CREATOR);
                    zzp = str;
                    latLng = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    String str3 = str;
                    latLng = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    zzp = str3;
                    break;
                case 4:
                    zzp = zza.zzp(parcel, zzat);
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzp = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
            }
            i2 = i;
            streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
            latLng2 = latLng;
            str = zzp;
        }
        if (parcel.dataPosition() == zzau) {
            return new StreetViewPanoramaLocation(i2, streetViewPanoramaLinkArr2, latLng2, str);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zziu */
    public StreetViewPanoramaLocation[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
