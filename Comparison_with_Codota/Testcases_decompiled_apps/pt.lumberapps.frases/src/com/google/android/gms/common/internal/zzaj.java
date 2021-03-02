package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaj implements Parcelable.Creator {
    /* renamed from: a */
    static void m6079a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, validateAccountRequest.f4476a);
        zzb.zzc(parcel, 2, validateAccountRequest.zzato());
        zzb.zza(parcel, 3, validateAccountRequest.f4477b, false);
        zzb.zza(parcel, 4, (Parcelable[]) validateAccountRequest.zzatm(), i, false);
        zzb.zza(parcel, 5, validateAccountRequest.zzatp(), false);
        zzb.zza(parcel, 6, validateAccountRequest.getCallingPackage(), false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzck */
    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzcm = zza.zzcm(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 3:
                    iBinder = zza.zzr(parcel, zzcl);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzcl, Scope.CREATOR);
                    break;
                case 5:
                    bundle = zza.zzs(parcel, zzcl);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzgl */
    public ValidateAccountRequest[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
