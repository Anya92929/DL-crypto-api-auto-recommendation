package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class GroundOverlayOptionsCreator implements Parcelable.Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2082a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
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

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
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
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    iBinder = C0153a.m323m(parcel, i2);
                    break;
                case 3:
                    latLng = (LatLng) C0153a.m305a(parcel, i2, LatLng.CREATOR);
                    break;
                case 4:
                    f = C0153a.m317i(parcel, i2);
                    break;
                case 5:
                    f2 = C0153a.m317i(parcel, i2);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0153a.m305a(parcel, i2, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0153a.m317i(parcel, i2);
                    break;
                case 8:
                    f4 = C0153a.m317i(parcel, i2);
                    break;
                case 9:
                    z = C0153a.m311c(parcel, i2);
                    break;
                case 10:
                    f5 = C0153a.m317i(parcel, i2);
                    break;
                case 11:
                    f6 = C0153a.m317i(parcel, i2);
                    break;
                case 12:
                    f7 = C0153a.m317i(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
