package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class DetectedActivityCreator implements Parcelable.Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1920a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, detectedActivity.f1455fs);
        C0359b.m682c(parcel, 1000, detectedActivity.mo5536i());
        C0359b.m682c(parcel, 2, detectedActivity.f1456ft);
        C0359b.m663C(parcel, d);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int c = C0357a.m634c(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    i = C0357a.m639f(parcel, b);
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
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
