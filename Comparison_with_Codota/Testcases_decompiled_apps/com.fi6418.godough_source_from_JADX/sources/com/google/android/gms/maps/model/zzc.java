package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzc implements Parcelable.Creator<GroundOverlayOptions> {
    /* renamed from: a */
    static void m5118a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, groundOverlayOptions.mo8521b());
        C1031c.m4613a(parcel, 2, groundOverlayOptions.mo8519a(), false);
        C1031c.m4614a(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        C1031c.m4609a(parcel, 4, groundOverlayOptions.getWidth());
        C1031c.m4609a(parcel, 5, groundOverlayOptions.getHeight());
        C1031c.m4614a(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        C1031c.m4609a(parcel, 7, groundOverlayOptions.getBearing());
        C1031c.m4609a(parcel, 8, groundOverlayOptions.getZIndex());
        C1031c.m4619a(parcel, 9, groundOverlayOptions.isVisible());
        C1031c.m4609a(parcel, 10, groundOverlayOptions.getTransparency());
        C1031c.m4609a(parcel, 11, groundOverlayOptions.getAnchorU());
        C1031c.m4609a(parcel, 12, groundOverlayOptions.getAnchorV());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzeY */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
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
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    iBinder = C1029a.m4600l(parcel, a);
                    break;
                case 3:
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    f = C1029a.m4597i(parcel, a);
                    break;
                case 5:
                    f2 = C1029a.m4597i(parcel, a);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C1029a.m4583a(parcel, a, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C1029a.m4597i(parcel, a);
                    break;
                case 8:
                    f4 = C1029a.m4597i(parcel, a);
                    break;
                case 9:
                    z = C1029a.m4591c(parcel, a);
                    break;
                case 10:
                    f5 = C1029a.m4597i(parcel, a);
                    break;
                case 11:
                    f6 = C1029a.m4597i(parcel, a);
                    break;
                case 12:
                    f7 = C1029a.m4597i(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhy */
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
