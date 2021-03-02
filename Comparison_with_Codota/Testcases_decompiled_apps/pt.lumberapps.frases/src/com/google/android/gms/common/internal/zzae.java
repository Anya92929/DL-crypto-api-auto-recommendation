package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Parcelable.Creator {
    /* renamed from: a */
    static void m6069a(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, signInButtonConfig.f4472a);
        zzb.zzc(parcel, 2, signInButtonConfig.zzatk());
        zzb.zzc(parcel, 3, signInButtonConfig.zzatl());
        zzb.zza(parcel, 4, (Parcelable[]) signInButtonConfig.zzatm(), i, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzcj */
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcm = zza.zzcm(parcel);
        Scope[] scopeArr = null;
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
                    scopeArr = (Scope[]) zza.zzb(parcel, zzcl, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzgk */
    public SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
