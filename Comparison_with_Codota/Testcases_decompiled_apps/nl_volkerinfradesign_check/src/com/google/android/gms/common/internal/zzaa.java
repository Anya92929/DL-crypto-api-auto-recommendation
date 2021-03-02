package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaa implements Parcelable.Creator<SignInButtonConfig> {
    /* renamed from: a */
    static void m3901a(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, signInButtonConfig.f2925a);
        zzb.zzc(parcel, 2, signInButtonConfig.zzrb());
        zzb.zzc(parcel, 3, signInButtonConfig.zzrc());
        zzb.zza(parcel, 4, (T[]) signInButtonConfig.zzrd(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzar */
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzat, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbY */
    public SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
