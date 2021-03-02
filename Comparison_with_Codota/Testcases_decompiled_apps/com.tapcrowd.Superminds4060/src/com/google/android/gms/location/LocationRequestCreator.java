package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.actionbarsherlock.widget.ActivityChooserView;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class LocationRequestCreator implements Parcelable.Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1972a(LocationRequest locationRequest, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, locationRequest.mPriority);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequest.getVersionCode());
        C0155b.m344a(parcel, 2, locationRequest.f1604oJ);
        C0155b.m344a(parcel, 3, locationRequest.f1605oK);
        C0155b.m352a(parcel, 4, locationRequest.f1606oL);
        C0155b.m344a(parcel, 5, locationRequest.f1603oC);
        C0155b.m359c(parcel, 6, locationRequest.f1607oM);
        C0155b.m343a(parcel, 7, locationRequest.f1608oN);
        C0155b.m340C(parcel, k);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int j = C0153a.m320j(parcel);
        int i = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j2 = 3600000;
        long j3 = 600000;
        long j4 = Long.MAX_VALUE;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = BitmapDescriptorFactory.HUE_RED;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    j2 = C0153a.m315g(parcel, i4);
                    break;
                case 3:
                    j3 = C0153a.m315g(parcel, i4);
                    break;
                case 4:
                    z = C0153a.m311c(parcel, i4);
                    break;
                case 5:
                    j4 = C0153a.m315g(parcel, i4);
                    break;
                case 6:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 7:
                    f = C0153a.m317i(parcel, i4);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LocationRequest(i3, i, j2, j3, z, j4, i2, f);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
