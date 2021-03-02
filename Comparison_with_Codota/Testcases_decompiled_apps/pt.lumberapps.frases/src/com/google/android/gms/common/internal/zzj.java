package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator {
    /* renamed from: a */
    static void m6114a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, getServiceRequest.f4454a);
        zzb.zzc(parcel, 2, getServiceRequest.f4455b);
        zzb.zzc(parcel, 3, getServiceRequest.f4456c);
        zzb.zza(parcel, 4, getServiceRequest.f4457d, false);
        zzb.zza(parcel, 5, getServiceRequest.f4458e, false);
        zzb.zza(parcel, 6, (Parcelable[]) getServiceRequest.f4459f, i, false);
        zzb.zza(parcel, 7, getServiceRequest.f4460g, false);
        zzb.zza(parcel, 8, (Parcelable) getServiceRequest.f4461h, i, false);
        zzb.zza(parcel, 9, getServiceRequest.f4462i);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzcg */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Account account = null;
        int zzcm = zza.zzcm(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 5:
                    iBinder = zza.zzr(parcel, zzcl);
                    break;
                case 6:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzcl, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zza.zzs(parcel, zzcl);
                    break;
                case 8:
                    account = (Account) zza.zza(parcel, zzcl, Account.CREATOR);
                    break;
                case 9:
                    j = zza.zzi(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzge */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
