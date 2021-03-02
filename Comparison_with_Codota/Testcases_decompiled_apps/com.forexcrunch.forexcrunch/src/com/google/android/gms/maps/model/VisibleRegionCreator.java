package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2065a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, visibleRegion.mo6168i());
        C0359b.m671a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0359b.m671a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0359b.m671a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0359b.m671a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0359b.m671a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0359b.m663C(parcel, d);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int c = C0357a.m634c(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    latLng4 = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0357a.m628a(parcel, b, LatLngBounds.CREATOR);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
