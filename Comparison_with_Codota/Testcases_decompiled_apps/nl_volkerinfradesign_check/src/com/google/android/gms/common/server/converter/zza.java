package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<ConverterWrapper> {
    /* renamed from: a */
    static void m3961a(ConverterWrapper converterWrapper, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, converterWrapper.mo5614a());
        zzb.zza(parcel, 2, (Parcelable) converterWrapper.mo5615b(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzax */
    public ConverterWrapper createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, StringToIntConverter.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ConverterWrapper(i, stringToIntConverter);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcd */
    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
