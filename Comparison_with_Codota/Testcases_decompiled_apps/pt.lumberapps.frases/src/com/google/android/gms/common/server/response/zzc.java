package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator {
    /* renamed from: a */
    static void m6178a(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, fieldMappingDictionary.mo6828a());
        zzb.zzc(parcel, 2, fieldMappingDictionary.mo6829b(), false);
        zzb.zza(parcel, 3, fieldMappingDictionary.zzauj(), false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzcu */
    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        String str = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzcl, FieldMappingDictionary.Entry.CREATOR);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzgu */
    public FieldMappingDictionary[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
