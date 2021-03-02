package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class GroundOverlayOptionsCreator implements Parcelable.Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2036a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
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

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        LatLngBounds latLngBounds = null;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float f4 = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        float f5 = BitmapDescriptorFactory.HUE_RED;
        float f6 = BitmapDescriptorFactory.HUE_RED;
        float f7 = BitmapDescriptorFactory.HUE_RED;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    iBinder = C0357a.m647m(parcel, b);
                    break;
                case 3:
                    latLng = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 4:
                    f = C0357a.m642i(parcel, b);
                    break;
                case 5:
                    f2 = C0357a.m642i(parcel, b);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0357a.m628a(parcel, b, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0357a.m642i(parcel, b);
                    break;
                case 8:
                    f4 = C0357a.m642i(parcel, b);
                    break;
                case 9:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 10:
                    f5 = C0357a.m642i(parcel, b);
                    break;
                case 11:
                    f6 = C0357a.m642i(parcel, b);
                    break;
                case 12:
                    f7 = C0357a.m642i(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
