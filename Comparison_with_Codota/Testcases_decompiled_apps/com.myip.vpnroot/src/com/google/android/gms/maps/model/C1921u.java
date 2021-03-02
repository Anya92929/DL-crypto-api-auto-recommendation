package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.u */
public class C1921u implements Parcelable.Creator<Tile> {
    /* renamed from: a */
    static void m6502a(Tile tile, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, tile.getVersionCode());
        C0354b.m939c(parcel, 2, tile.width);
        C0354b.m939c(parcel, 3, tile.height);
        C0354b.m931a(parcel, 4, tile.data, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cU */
    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eJ */
    public Tile[] newArray(int i) {
        return new Tile[i];
    }
}
