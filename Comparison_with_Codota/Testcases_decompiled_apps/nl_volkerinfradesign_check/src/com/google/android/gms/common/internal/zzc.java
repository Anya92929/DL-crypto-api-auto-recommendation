package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<AuthAccountRequest> {
    /* renamed from: a */
    static void m3910a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.f2898a);
        zzb.zza(parcel, 2, authAccountRequest.f2899b, false);
        zzb.zza(parcel, 3, (T[]) authAccountRequest.f2900c, i, false);
        zzb.zza(parcel, 4, authAccountRequest.f2901d, false);
        zzb.zza(parcel, 5, authAccountRequest.f2902e, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzam */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        Integer num = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzat, Scope.CREATOR);
                    break;
                case 4:
                    num2 = zza.zzh(parcel, zzat);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbP */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
