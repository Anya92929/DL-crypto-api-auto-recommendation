package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class DetectedActivityCreator implements Parcelable.Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1967a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, detectedActivity.f1590oy);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, detectedActivity.getVersionCode());
        C0155b.m359c(parcel, 2, detectedActivity.f1591oz);
        C0155b.m340C(parcel, k);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int j = C0153a.m320j(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    i = C0153a.m314f(parcel, i4);
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
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
