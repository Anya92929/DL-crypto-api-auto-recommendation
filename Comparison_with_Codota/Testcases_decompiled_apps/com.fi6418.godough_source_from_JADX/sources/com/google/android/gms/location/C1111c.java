package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.location.c */
public class C1111c implements Parcelable.Creator<DetectedActivity> {
    /* renamed from: a */
    static void m4828a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, detectedActivity.f4878b);
        C1031c.m4610a(parcel, 1000, detectedActivity.mo7721c());
        C1031c.m4610a(parcel, 2, detectedActivity.f4879c);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int b = C1029a.m4587b(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 1000:
                    i3 = C1029a.m4594f(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public DetectedActivity[] newArray(int i) {
        return new DetectedActivity[i];
    }
}
