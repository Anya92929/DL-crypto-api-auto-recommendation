package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<AutocompleteFilter> {
    static void zza(AutocompleteFilter autocompleteFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, autocompleteFilter.zzaPg);
        zzb.zzc(parcel, 1000, autocompleteFilter.mVersionCode);
        zzb.zza(parcel, 2, autocompleteFilter.zzaPh, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfb */
    public AutocompleteFilter createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        ArrayList<Integer> arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 2:
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
            return new AutocompleteFilter(i, z, arrayList);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhL */
    public AutocompleteFilter[] newArray(int i) {
        return new AutocompleteFilter[i];
    }
}
