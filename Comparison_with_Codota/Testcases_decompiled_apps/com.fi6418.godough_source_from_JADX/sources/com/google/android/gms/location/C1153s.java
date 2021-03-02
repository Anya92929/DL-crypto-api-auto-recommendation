package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import java.util.List;

/* renamed from: com.google.android.gms.location.s */
public class C1153s implements Parcelable.Creator<LocationResult> {
    /* renamed from: a */
    static void m4983a(LocationResult locationResult, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4627c(parcel, 1, locationResult.mo7749a(), false);
        C1031c.m4610a(parcel, 1000, locationResult.mo7750b());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationResult createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        List<Location> list = LocationResult.f4904a;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    list = C1029a.m4590c(parcel, a, Location.CREATOR);
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
            return new LocationResult(i, list);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationResult[] newArray(int i) {
        return new LocationResult[i];
    }
}
