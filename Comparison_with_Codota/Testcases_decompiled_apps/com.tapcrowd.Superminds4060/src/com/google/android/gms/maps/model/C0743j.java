package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0743j {
    /* renamed from: a */
    static void m2151a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0155b.m346a(parcel, 2, tileOverlayOptions.mo5988cP(), false);
        C0155b.m352a(parcel, 3, tileOverlayOptions.isVisible());
        C0155b.m343a(parcel, 4, tileOverlayOptions.getZIndex());
        C0155b.m340C(parcel, k);
    }
}
