package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<FieldMappingDictionary> {
    static void zza(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fieldMappingDictionary.getVersionCode());
        zzb.zzc(parcel, 2, fieldMappingDictionary.zzrA(), false);
        zzb.zza(parcel, 3, fieldMappingDictionary.zzrB(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaC */
    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzat, FieldMappingDictionary.Entry.CREATOR);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzci */
    public FieldMappingDictionary[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
