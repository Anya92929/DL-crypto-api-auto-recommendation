package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class TileCreator implements Parcelable.Creator<Tile> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2057a(Tile tile, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, tile.mo6137i());
        C0359b.m682c(parcel, 2, tile.width);
        C0359b.m682c(parcel, 3, tile.height);
        C0359b.m676a(parcel, 4, tile.data, false);
        C0359b.m663C(parcel, d);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int c = C0357a.m634c(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 3:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 4:
                    bArr = C0357a.m649o(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
