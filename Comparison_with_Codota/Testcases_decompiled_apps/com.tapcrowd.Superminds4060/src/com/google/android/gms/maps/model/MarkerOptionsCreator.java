package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class MarkerOptionsCreator implements Parcelable.Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2093a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, markerOptions.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C0155b.m349a(parcel, 3, markerOptions.getTitle(), false);
        C0155b.m349a(parcel, 4, markerOptions.getSnippet(), false);
        C0155b.m346a(parcel, 5, markerOptions.mo5867cN(), false);
        C0155b.m343a(parcel, 6, markerOptions.getAnchorU());
        C0155b.m343a(parcel, 7, markerOptions.getAnchorV());
        C0155b.m352a(parcel, 8, markerOptions.isDraggable());
        C0155b.m352a(parcel, 9, markerOptions.isVisible());
        C0155b.m352a(parcel, 10, markerOptions.isFlat());
        C0155b.m343a(parcel, 11, markerOptions.getRotation());
        C0155b.m343a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0155b.m343a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0155b.m343a(parcel, 14, markerOptions.getAlpha());
        C0155b.m340C(parcel, k);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float f4 = 0.5f;
        float f5 = BitmapDescriptorFactory.HUE_RED;
        float f6 = 1.0f;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    latLng = (LatLng) C0153a.m305a(parcel, i2, LatLng.CREATOR);
                    break;
                case 3:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 4:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 5:
                    iBinder = C0153a.m323m(parcel, i2);
                    break;
                case 6:
                    f = C0153a.m317i(parcel, i2);
                    break;
                case 7:
                    f2 = C0153a.m317i(parcel, i2);
                    break;
                case 8:
                    z = C0153a.m311c(parcel, i2);
                    break;
                case 9:
                    z2 = C0153a.m311c(parcel, i2);
                    break;
                case 10:
                    z3 = C0153a.m311c(parcel, i2);
                    break;
                case 11:
                    f3 = C0153a.m317i(parcel, i2);
                    break;
                case 12:
                    f4 = C0153a.m317i(parcel, i2);
                    break;
                case 13:
                    f5 = C0153a.m317i(parcel, i2);
                    break;
                case 14:
                    f6 = C0153a.m317i(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
