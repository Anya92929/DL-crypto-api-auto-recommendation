package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Parcelable.Creator<Tile> {
    /* renamed from: a */
    static void m4226a(Tile tile, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, tile.mo6975a());
        zzb.zzc(parcel, 2, tile.width);
        zzb.zzc(parcel, 3, tile.height);
        zzb.zza(parcel, 4, tile.data, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfI */
    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        byte[] bArr = null;
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
                    bArr = zza.zzs(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zziw */
    public Tile[] newArray(int i) {
        return new Tile[i];
    }
}
