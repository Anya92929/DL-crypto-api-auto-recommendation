package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: com.google.android.gms.location.internal.s */
public class C1139s implements Parcelable.Creator<LocationRequestInternal> {
    /* renamed from: a */
    static void m4958a(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4614a(parcel, 1, (Parcelable) locationRequestInternal.f4943b, i, false);
        C1031c.m4610a(parcel, 1000, locationRequestInternal.mo7810a());
        C1031c.m4619a(parcel, 2, locationRequestInternal.f4944c);
        C1031c.m4619a(parcel, 3, locationRequestInternal.f4945d);
        C1031c.m4619a(parcel, 4, locationRequestInternal.f4946e);
        C1031c.m4627c(parcel, 5, locationRequestInternal.f4947f, false);
        C1031c.m4616a(parcel, 6, locationRequestInternal.f4948g, false);
        C1031c.m4619a(parcel, 7, locationRequestInternal.f4949h);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationRequestInternal createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int b = C1029a.m4587b(parcel);
        List<ClientIdentity> list = LocationRequestInternal.f4942a;
        boolean z3 = true;
        boolean z4 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    locationRequest = (LocationRequest) C1029a.m4583a(parcel, a, LocationRequest.CREATOR);
                    break;
                case 2:
                    z4 = C1029a.m4591c(parcel, a);
                    break;
                case 3:
                    z3 = C1029a.m4591c(parcel, a);
                    break;
                case 4:
                    z = C1029a.m4591c(parcel, a);
                    break;
                case 5:
                    list = C1029a.m4590c(parcel, a, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 7:
                    z2 = C1029a.m4591c(parcel, a);
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
            return new LocationRequestInternal(i, locationRequest, z4, z3, z, list, str, z2);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationRequestInternal[] newArray(int i) {
        return new LocationRequestInternal[i];
    }
}
