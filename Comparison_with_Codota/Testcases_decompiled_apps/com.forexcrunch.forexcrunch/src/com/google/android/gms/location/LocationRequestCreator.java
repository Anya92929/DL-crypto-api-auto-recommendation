package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class LocationRequestCreator implements Parcelable.Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1926a(LocationRequest locationRequest, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, locationRequest.mPriority);
        C0359b.m682c(parcel, 1000, locationRequest.mo5570i());
        C0359b.m667a(parcel, 2, locationRequest.f1466fB);
        C0359b.m667a(parcel, 3, locationRequest.f1467fC);
        C0359b.m675a(parcel, 4, locationRequest.f1468fD);
        C0359b.m667a(parcel, 5, locationRequest.f1471fw);
        C0359b.m682c(parcel, 6, locationRequest.f1469fE);
        C0359b.m666a(parcel, 7, locationRequest.f1470fF);
        C0359b.m663C(parcel, d);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int c = C0357a.m634c(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        float f = BitmapDescriptorFactory.HUE_RED;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    j = C0357a.m640g(parcel, b);
                    break;
                case 3:
                    j2 = C0357a.m640g(parcel, b);
                    break;
                case 4:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 5:
                    j3 = C0357a.m640g(parcel, b);
                    break;
                case 6:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 7:
                    f = C0357a.m642i(parcel, b);
                    break;
                case 1000:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
