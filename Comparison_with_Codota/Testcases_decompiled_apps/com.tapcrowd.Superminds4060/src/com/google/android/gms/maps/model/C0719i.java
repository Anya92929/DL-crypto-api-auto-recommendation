package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0719i {
    /* renamed from: a */
    static void m2112a(Tile tile, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, tile.getVersionCode());
        C0155b.m359c(parcel, 2, tile.width);
        C0155b.m359c(parcel, 3, tile.height);
        C0155b.m353a(parcel, 4, tile.data, false);
        C0155b.m340C(parcel, k);
    }
}
