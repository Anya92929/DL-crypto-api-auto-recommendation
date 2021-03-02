package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.v */
public class C1922v {
    /* renamed from: a */
    static void m6505a(Tile tile, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, tile.getVersionCode());
        C0354b.m939c(parcel, 2, tile.width);
        C0354b.m939c(parcel, 3, tile.height);
        C0354b.m931a(parcel, 4, tile.data, false);
        C0354b.m915H(parcel, D);
    }
}
