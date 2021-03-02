package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Parcelable.Creator {
    /* renamed from: a */
    static void m6068a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, resolveAccountResponse.f4467a);
        zzb.zza(parcel, 2, resolveAccountResponse.f4468b, false);
        zzb.zza(parcel, 3, (Parcelable) resolveAccountResponse.zzath(), i, false);
        zzb.zza(parcel, 4, resolveAccountResponse.zzati());
        zzb.zza(parcel, 5, resolveAccountResponse.zzatj());
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzci */
    public ResolveAccountResponse createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) zza.zza(parcel, zzcl, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzgj */
    public ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
