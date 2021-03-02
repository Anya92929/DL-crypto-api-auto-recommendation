package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.location.f */
public class C1117f implements Parcelable.Creator<LocationAvailability> {
    /* renamed from: a */
    static void m4836a(LocationAvailability locationAvailability, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, locationAvailability.f4890a);
        C1031c.m4610a(parcel, 1000, locationAvailability.mo7737b());
        C1031c.m4610a(parcel, 2, locationAvailability.f4891b);
        C1031c.m4611a(parcel, 3, locationAvailability.f4892c);
        C1031c.m4610a(parcel, 4, locationAvailability.f4893d);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationAvailability createFromParcel(Parcel parcel) {
        int i = 1;
        int b = C1029a.m4587b(parcel);
        int i2 = 0;
        int i3 = 1000;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i4 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 3:
                    j = C1029a.m4596h(parcel, a);
                    break;
                case 4:
                    i3 = C1029a.m4594f(parcel, a);
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
            return new LocationAvailability(i2, i3, i4, i, j);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationAvailability[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
