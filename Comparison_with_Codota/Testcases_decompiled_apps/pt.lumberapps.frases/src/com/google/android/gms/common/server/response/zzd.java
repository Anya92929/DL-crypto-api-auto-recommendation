package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator {
    /* renamed from: a */
    static void m6179a(FieldMappingDictionary.Entry entry, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, entry.f4651a);
        zzb.zza(parcel, 2, entry.f4652b, false);
        zzb.zzc(parcel, 3, entry.f4653c, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzcv */
    public FieldMappingDictionary.Entry createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzcl, FieldMappingDictionary.FieldMapPair.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new FieldMappingDictionary.Entry(i, str, arrayList);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzgv */
    public FieldMappingDictionary.Entry[] newArray(int i) {
        return new FieldMappingDictionary.Entry[i];
    }
}
