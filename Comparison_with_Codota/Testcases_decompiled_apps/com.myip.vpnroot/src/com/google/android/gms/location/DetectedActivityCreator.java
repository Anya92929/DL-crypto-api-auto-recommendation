package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class DetectedActivityCreator implements Parcelable.Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m6238a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, detectedActivity.adU);
        C0354b.m939c(parcel, 1000, detectedActivity.getVersionCode());
        C0354b.m939c(parcel, 2, detectedActivity.adV);
        C0354b.m915H(parcel, D);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 1000:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
