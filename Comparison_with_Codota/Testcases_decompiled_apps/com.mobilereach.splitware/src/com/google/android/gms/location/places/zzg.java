package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Parcelable.Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, placeFilter.zzaPk, false);
        zzb.zzc(parcel, 1000, placeFilter.mVersionCode);
        zzb.zza(parcel, 3, placeFilter.zzaPA);
        zzb.zzc(parcel, 4, placeFilter.zzaPl, false);
        zzb.zzb(parcel, 6, placeFilter.zzaPj, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfe */
    public PlaceFilter createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int zzau = zza.zzau(parcel);
        ArrayList<String> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    arrayList3 = zza.zzC(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzat, UserDataType.CREATOR);
                    break;
                case 6:
                    arrayList2 = zza.zzD(parcel, zzat);
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
            return new PlaceFilter(i, arrayList3, z, arrayList2, arrayList);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhO */
    public PlaceFilter[] newArray(int i) {
        return new PlaceFilter[i];
    }
}
