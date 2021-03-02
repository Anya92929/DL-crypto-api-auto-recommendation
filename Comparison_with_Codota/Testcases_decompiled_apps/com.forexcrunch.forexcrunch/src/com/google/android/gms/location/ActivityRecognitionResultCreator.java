package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Parcelable.Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1917a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m681b(parcel, 1, activityRecognitionResult.f1451fp, false);
        C0359b.m682c(parcel, 1000, activityRecognitionResult.mo5528i());
        C0359b.m667a(parcel, 2, activityRecognitionResult.f1452fq);
        C0359b.m667a(parcel, 3, activityRecognitionResult.f1453fr);
        C0359b.m663C(parcel, d);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int c = C0357a.m634c(parcel);
        int i = 0;
        ArrayList arrayList = null;
        long j2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    arrayList = C0357a.m635c(parcel, b, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = C0357a.m640g(parcel, b);
                    break;
                case 3:
                    j = C0357a.m640g(parcel, b);
                    break;
                case 1000:
                    i = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new ActivityRecognitionResult(i, arrayList, j2, j);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
