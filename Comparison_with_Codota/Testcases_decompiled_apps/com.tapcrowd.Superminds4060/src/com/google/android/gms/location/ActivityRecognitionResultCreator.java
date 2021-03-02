package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Parcelable.Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1965a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m358b(parcel, 1, activityRecognitionResult.f1586ov, false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, activityRecognitionResult.getVersionCode());
        C0155b.m344a(parcel, 2, activityRecognitionResult.f1587ow);
        C0155b.m344a(parcel, 3, activityRecognitionResult.f1588ox);
        C0155b.m340C(parcel, k);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int j2 = C0153a.m320j(parcel);
        int i = 0;
        ArrayList arrayList = null;
        long j3 = 0;
        while (parcel.dataPosition() < j2) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    arrayList = C0153a.m310c(parcel, i2, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j3 = C0153a.m315g(parcel, i2);
                    break;
                case 3:
                    j = C0153a.m315g(parcel, i2);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0153a.m314f(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j2) {
            return new ActivityRecognitionResult(i, arrayList, j3, j);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j2, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
