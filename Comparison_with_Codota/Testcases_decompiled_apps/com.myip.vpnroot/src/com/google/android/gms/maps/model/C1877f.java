package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C1877f {
    /* renamed from: a */
    static void m6425a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0354b.m921a(parcel, 2, groundOverlayOptions.mo10805mM(), false);
        C0354b.m923a(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        C0354b.m918a(parcel, 4, groundOverlayOptions.getWidth());
        C0354b.m918a(parcel, 5, groundOverlayOptions.getHeight());
        C0354b.m923a(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        C0354b.m918a(parcel, 7, groundOverlayOptions.getBearing());
        C0354b.m918a(parcel, 8, groundOverlayOptions.getZIndex());
        C0354b.m930a(parcel, 9, groundOverlayOptions.isVisible());
        C0354b.m918a(parcel, 10, groundOverlayOptions.getTransparency());
        C0354b.m918a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0354b.m918a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0354b.m915H(parcel, D);
    }
}
