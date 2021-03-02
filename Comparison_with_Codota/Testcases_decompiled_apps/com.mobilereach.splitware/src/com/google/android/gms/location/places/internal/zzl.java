package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public class zzl implements Parcelable.Creator<PlaceImpl> {
    static void zza(PlaceImpl placeImpl, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, placeImpl.getId(), false);
        zzb.zza(parcel, 2, placeImpl.zzzt(), false);
        zzb.zza(parcel, 3, (Parcelable) placeImpl.zzzv(), i, false);
        zzb.zza(parcel, 4, (Parcelable) placeImpl.getLatLng(), i, false);
        zzb.zza(parcel, 5, placeImpl.zzzo());
        zzb.zza(parcel, 6, (Parcelable) placeImpl.getViewport(), i, false);
        zzb.zza(parcel, 7, placeImpl.zzzu(), false);
        zzb.zza(parcel, 8, (Parcelable) placeImpl.getWebsiteUri(), i, false);
        zzb.zza(parcel, 9, placeImpl.zzzr());
        zzb.zza(parcel, 10, placeImpl.getRating());
        zzb.zzc(parcel, 11, placeImpl.getPriceLevel());
        zzb.zza(parcel, 12, placeImpl.zzzs());
        zzb.zza(parcel, 13, placeImpl.zzzn(), false);
        zzb.zza(parcel, 14, placeImpl.getAddress(), false);
        zzb.zza(parcel, 15, placeImpl.getPhoneNumber(), false);
        zzb.zzb(parcel, 17, placeImpl.zzzq(), false);
        zzb.zza(parcel, 16, placeImpl.zzzp(), false);
        zzb.zzc(parcel, 1000, placeImpl.mVersionCode);
        zzb.zza(parcel, 19, placeImpl.getName(), false);
        zzb.zza(parcel, 20, placeImpl.getPlaceTypes(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfl */
    public PlaceImpl createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        ArrayList<Integer> arrayList = null;
        ArrayList<Integer> arrayList2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        PlaceLocalization placeLocalization = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 3:
                    placeLocalization = (PlaceLocalization) zza.zza(parcel, zzat, PlaceLocalization.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    break;
                case 5:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzat, LatLngBounds.CREATOR);
                    break;
                case 7:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    f2 = zza.zzl(parcel, zzat);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 12:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 13:
                    arrayList2 = zza.zzC(parcel, zzat);
                    break;
                case 14:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 15:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 16:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 17:
                    arrayList3 = zza.zzD(parcel, zzat);
                    break;
                case 19:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 20:
                    arrayList = zza.zzC(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlaceImpl(i, str, arrayList, arrayList2, bundle, str2, str3, str4, str5, arrayList3, latLng, f, latLngBounds, str6, uri, z, f2, i2, j, placeLocalization);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhY */
    public PlaceImpl[] newArray(int i) {
        return new PlaceImpl[i];
    }
}
