package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.location.a */
public class C1109a implements Parcelable.Creator<ActivityRecognitionResult> {
    /* renamed from: a */
    static void m4824a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4627c(parcel, 1, activityRecognitionResult.f4872a, false);
        C1031c.m4610a(parcel, 1000, activityRecognitionResult.mo7713a());
        C1031c.m4611a(parcel, 2, activityRecognitionResult.f4873b);
        C1031c.m4611a(parcel, 3, activityRecognitionResult.f4874c);
        C1031c.m4610a(parcel, 4, activityRecognitionResult.f4875d);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int b = C1029a.m4587b(parcel);
        ArrayList arrayList = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    arrayList = C1029a.m4590c(parcel, a, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = C1029a.m4596h(parcel, a);
                    break;
                case 3:
                    j = C1029a.m4596h(parcel, a);
                    break;
                case 4:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 1000:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ActivityRecognitionResult(i2, arrayList, j2, j, i);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ActivityRecognitionResult[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
