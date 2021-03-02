package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0743j {
    /* renamed from: a */
    static void m2111a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, tileOverlayOptions.mo6154i());
        C0359b.m669a(parcel, 2, tileOverlayOptions.mo6150bs(), false);
        C0359b.m675a(parcel, 3, tileOverlayOptions.isVisible());
        C0359b.m666a(parcel, 4, tileOverlayOptions.getZIndex());
        C0359b.m663C(parcel, d);
    }
}
