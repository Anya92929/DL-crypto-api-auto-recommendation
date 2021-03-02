package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class TileCreator implements Parcelable.Creator<Tile> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2097a(Tile tile, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, tile.getVersionCode());
        C0155b.m359c(parcel, 2, tile.width);
        C0155b.m359c(parcel, 3, tile.height);
        C0155b.m353a(parcel, 4, tile.data, false);
        C0155b.m340C(parcel, k);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int j = C0153a.m320j(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 3:
                    i = C0153a.m314f(parcel, i4);
                    break;
                case 4:
                    bArr = C0153a.m325o(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
