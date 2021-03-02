package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class MarkerOptionsCreator implements Parcelable.Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2050a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, markerOptions.mo6043i());
        C0359b.m671a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C0359b.m672a(parcel, 3, markerOptions.getTitle(), false);
        C0359b.m672a(parcel, 4, markerOptions.getSnippet(), false);
        C0359b.m669a(parcel, 5, markerOptions.mo6030bq(), false);
        C0359b.m666a(parcel, 6, markerOptions.getAnchorU());
        C0359b.m666a(parcel, 7, markerOptions.getAnchorV());
        C0359b.m675a(parcel, 8, markerOptions.isDraggable());
        C0359b.m675a(parcel, 9, markerOptions.isVisible());
        C0359b.m675a(parcel, 10, markerOptions.isFlat());
        C0359b.m666a(parcel, 11, markerOptions.getRotation());
        C0359b.m666a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0359b.m666a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0359b.m663C(parcel, d);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
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
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    latLng = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 3:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 4:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 5:
                    iBinder = C0357a.m647m(parcel, b);
                    break;
                case 6:
                    f = C0357a.m642i(parcel, b);
                    break;
                case 7:
                    f2 = C0357a.m642i(parcel, b);
                    break;
                case 8:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 9:
                    z2 = C0357a.m636c(parcel, b);
                    break;
                case 10:
                    z3 = C0357a.m636c(parcel, b);
                    break;
                case 11:
                    f3 = C0357a.m642i(parcel, b);
                    break;
                case 12:
                    f4 = C0357a.m642i(parcel, b);
                    break;
                case 13:
                    f5 = C0357a.m642i(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
