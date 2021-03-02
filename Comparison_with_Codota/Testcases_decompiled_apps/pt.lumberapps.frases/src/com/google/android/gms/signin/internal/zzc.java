package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator {
    /* renamed from: a */
    static void m8027a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, checkServerAuthResult.f7410a);
        zzb.zza(parcel, 2, checkServerAuthResult.f7411b);
        zzb.zzc(parcel, 3, checkServerAuthResult.f7412c, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzrq */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzcl, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new CheckServerAuthResult(i, z, arrayList);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzyz */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
