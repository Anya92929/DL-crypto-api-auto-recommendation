package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.x */
public class C1924x {
    /* renamed from: a */
    static void m6509a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0354b.m921a(parcel, 2, tileOverlayOptions.mo11024mP(), false);
        C0354b.m930a(parcel, 3, tileOverlayOptions.isVisible());
        C0354b.m918a(parcel, 4, tileOverlayOptions.getZIndex());
        C0354b.m915H(parcel, D);
    }
}
