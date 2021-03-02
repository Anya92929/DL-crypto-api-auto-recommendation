package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode;

public class zzl implements Parcelable.Creator<Barcode.UrlBookmark> {
    static void zza(Barcode.UrlBookmark urlBookmark, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, urlBookmark.versionCode);
        zzb.zza(parcel, 2, urlBookmark.title, false);
        zzb.zza(parcel, 3, urlBookmark.url, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhh */
    public Barcode.UrlBookmark createFromParcel(Parcel parcel) {
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
            return new Barcode.UrlBookmark(i, str2, str);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkE */
    public Barcode.UrlBookmark[] newArray(int i) {
        return new Barcode.UrlBookmark[i];
    }
}
