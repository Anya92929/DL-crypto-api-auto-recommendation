package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Parcelable.Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m6235a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, activityRecognitionResult.adQ, false);
        C0354b.m939c(parcel, 1000, activityRecognitionResult.getVersionCode());
        C0354b.m919a(parcel, 2, activityRecognitionResult.adR);
        C0354b.m919a(parcel, 3, activityRecognitionResult.adS);
        C0354b.m915H(parcel, D);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList arrayList = null;
        long j2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ActivityRecognitionResult(i, arrayList, j2, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
