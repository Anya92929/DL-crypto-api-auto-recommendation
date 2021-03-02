package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<FACLData> {
    /* renamed from: a */
    static void m3647a(FACLData fACLData, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, fACLData.f2541a);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) fACLData.f2542b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, fACLData.f2543c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, fACLData.f2544d);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, fACLData.f2545e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzX */
    public FACLData createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        FACLConfig fACLConfig = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    fACLConfig = (FACLConfig) zza.zza(parcel, zzat, FACLConfig.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FACLData(i, fACLConfig, str2, z, str);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaU */
    public FACLData[] newArray(int i) {
        return new FACLData[i];
    }
}
