package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<AccountChangeEvent> {
    /* renamed from: a */
    static void m3649a(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, accountChangeEvent.f2456a);
        zzb.zza(parcel, 2, accountChangeEvent.f2457b);
        zzb.zza(parcel, 3, accountChangeEvent.f2458c, false);
        zzb.zzc(parcel, 4, accountChangeEvent.f2459d);
        zzb.zzc(parcel, 5, accountChangeEvent.f2460e);
        zzb.zza(parcel, 6, accountChangeEvent.f2461f, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzau */
    public AccountChangeEvent[] newArray(int i) {
        return new AccountChangeEvent[i];
    }

    /* renamed from: zzz */
    public AccountChangeEvent createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }
}
