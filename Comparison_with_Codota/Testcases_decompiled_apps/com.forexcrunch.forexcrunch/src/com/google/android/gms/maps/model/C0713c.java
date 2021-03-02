package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0713c {
    /* renamed from: a */
    static void m2068a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, groundOverlayOptions.mo5972i());
        C0359b.m669a(parcel, 2, groundOverlayOptions.mo5960bp(), false);
        C0359b.m671a(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        C0359b.m666a(parcel, 4, groundOverlayOptions.getWidth());
        C0359b.m666a(parcel, 5, groundOverlayOptions.getHeight());
        C0359b.m671a(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        C0359b.m666a(parcel, 7, groundOverlayOptions.getBearing());
        C0359b.m666a(parcel, 8, groundOverlayOptions.getZIndex());
        C0359b.m675a(parcel, 9, groundOverlayOptions.isVisible());
        C0359b.m666a(parcel, 10, groundOverlayOptions.getTransparency());
        C0359b.m666a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0359b.m666a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0359b.m663C(parcel, d);
    }
}
