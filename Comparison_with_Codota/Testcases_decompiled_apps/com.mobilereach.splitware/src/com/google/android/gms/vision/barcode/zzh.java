package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode;

public class zzh implements Parcelable.Creator<Barcode.GeoPoint> {
    static void zza(Barcode.GeoPoint geoPoint, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, geoPoint.versionCode);
        zzb.zza(parcel, 2, geoPoint.lat);
        zzb.zza(parcel, 3, geoPoint.lng);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhd */
    public Barcode.GeoPoint createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int zzau = zza.zzau(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    d2 = zza.zzn(parcel, zzat);
                    break;
                case 3:
                    d = zza.zzn(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Barcode.GeoPoint(i, d2, d);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkA */
    public Barcode.GeoPoint[] newArray(int i) {
        return new Barcode.GeoPoint[i];
    }
}
