package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator {
    /* renamed from: a */
    static void m6080a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.f4444a);
        zzb.zza(parcel, 2, authAccountRequest.f4445b, false);
        zzb.zza(parcel, 3, (Parcelable[]) authAccountRequest.f4446c, i, false);
        zzb.zza(parcel, 4, authAccountRequest.f4447d, false);
        zzb.zza(parcel, 5, authAccountRequest.f4448e, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzce */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        Integer num = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    iBinder = zza.zzr(parcel, zzcl);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzcl, Scope.CREATOR);
                    break;
                case 4:
                    num2 = zza.zzh(parcel, zzcl);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzgb */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
