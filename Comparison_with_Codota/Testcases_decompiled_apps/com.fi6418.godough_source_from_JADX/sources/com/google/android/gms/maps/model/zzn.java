package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzn implements Parcelable.Creator<Tile> {
    /* renamed from: a */
    static void m5129a(Tile tile, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, tile.mo8736a());
        C1031c.m4610a(parcel, 2, tile.width);
        C1031c.m4610a(parcel, 3, tile.height);
        C1031c.m4620a(parcel, 4, tile.data, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfj */
    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int b = C1029a.m4587b(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i3 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 3:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 4:
                    bArr = C1029a.m4602n(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhJ */
    public Tile[] newArray(int i) {
        return new Tile[i];
    }
}
