package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.android.gms.location.g */
public class C1118g implements Parcelable.Creator<LocationRequest> {
    /* renamed from: a */
    static void m4839a(LocationRequest locationRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, locationRequest.f4895a);
        C1031c.m4610a(parcel, 1000, locationRequest.mo7743a());
        C1031c.m4611a(parcel, 2, locationRequest.f4896b);
        C1031c.m4611a(parcel, 3, locationRequest.f4897c);
        C1031c.m4619a(parcel, 4, locationRequest.f4898d);
        C1031c.m4611a(parcel, 5, locationRequest.f4899e);
        C1031c.m4610a(parcel, 6, locationRequest.f4900f);
        C1031c.m4609a(parcel, 7, locationRequest.f4901g);
        C1031c.m4611a(parcel, 8, locationRequest.f4902h);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationRequest createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        float f = BitmapDescriptorFactory.HUE_RED;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    j = C1029a.m4596h(parcel, a);
                    break;
                case 3:
                    j2 = C1029a.m4596h(parcel, a);
                    break;
                case 4:
                    z = C1029a.m4591c(parcel, a);
                    break;
                case 5:
                    j3 = C1029a.m4596h(parcel, a);
                    break;
                case 6:
                    i3 = C1029a.m4594f(parcel, a);
                    break;
                case 7:
                    f = C1029a.m4597i(parcel, a);
                    break;
                case 8:
                    j4 = C1029a.m4596h(parcel, a);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
