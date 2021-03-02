package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<FACLConfig> {
    static void zza(FACLConfig fACLConfig, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fACLConfig.version);
        zzb.zza(parcel, 2, fACLConfig.zzYm);
        zzb.zza(parcel, 3, fACLConfig.zzYn, false);
        zzb.zza(parcel, 4, fACLConfig.zzYo);
        zzb.zza(parcel, 5, fACLConfig.zzYp);
        zzb.zza(parcel, 6, fACLConfig.zzYq);
        zzb.zza(parcel, 7, fACLConfig.zzYr);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzW */
    public FACLConfig createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FACLConfig(i, z5, str, z4, z3, z2, z);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaT */
    public FACLConfig[] newArray(int i) {
        return new FACLConfig[i];
    }
}
