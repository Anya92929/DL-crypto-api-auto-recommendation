package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.location.l */
public class C1146l implements Parcelable.Creator<GestureRequest> {
    /* renamed from: a */
    static void m4972a(GestureRequest gestureRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4617a(parcel, 1, gestureRequest.mo7733b(), false);
        C1031c.m4610a(parcel, 1000, gestureRequest.mo7732a());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public GestureRequest createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        ArrayList<Integer> arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    arrayList = C1029a.m4603o(parcel, a);
                    break;
                case 1000:
                    i = C1029a.m4594f(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GestureRequest(i, arrayList);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public GestureRequest[] newArray(int i) {
        return new GestureRequest[i];
    }
}
