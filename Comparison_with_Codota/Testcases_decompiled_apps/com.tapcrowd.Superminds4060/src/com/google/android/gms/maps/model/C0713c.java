package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0713c {
    /* renamed from: a */
    static void m2106a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0155b.m346a(parcel, 2, groundOverlayOptions.mo5794cM(), false);
        C0155b.m348a(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        C0155b.m343a(parcel, 4, groundOverlayOptions.getWidth());
        C0155b.m343a(parcel, 5, groundOverlayOptions.getHeight());
        C0155b.m348a(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        C0155b.m343a(parcel, 7, groundOverlayOptions.getBearing());
        C0155b.m343a(parcel, 8, groundOverlayOptions.getZIndex());
        C0155b.m352a(parcel, 9, groundOverlayOptions.isVisible());
        C0155b.m343a(parcel, 10, groundOverlayOptions.getTransparency());
        C0155b.m343a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0155b.m343a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0155b.m340C(parcel, k);
    }
}
