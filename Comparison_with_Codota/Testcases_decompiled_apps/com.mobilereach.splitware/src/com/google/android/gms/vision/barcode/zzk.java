package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode;

public class zzk implements Parcelable.Creator<Barcode.Sms> {
    static void zza(Barcode.Sms sms, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, sms.versionCode);
        zzb.zza(parcel, 2, sms.message, false);
        zzb.zza(parcel, 3, sms.phoneNumber, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhg */
    public Barcode.Sms createFromParcel(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Barcode.Sms(i, str2, str);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkD */
    public Barcode.Sms[] newArray(int i) {
        return new Barcode.Sms[i];
    }
}
