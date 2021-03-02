package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0719i {
    /* renamed from: a */
    static void m2074a(Tile tile, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, tile.mo6137i());
        C0359b.m682c(parcel, 2, tile.width);
        C0359b.m682c(parcel, 3, tile.height);
        C0359b.m676a(parcel, 4, tile.data, false);
        C0359b.m663C(parcel, d);
    }
}
