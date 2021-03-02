package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.location.k */
public class C1145k implements Parcelable.Creator<GeofencingRequest> {
    /* renamed from: a */
    static void m4969a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4627c(parcel, 1, geofencingRequest.mo7728b(), false);
        C1031c.m4610a(parcel, 1000, geofencingRequest.mo7727a());
        C1031c.m4610a(parcel, 2, geofencingRequest.mo7729c());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public GeofencingRequest createFromParcel(Parcel parcel) {
        int i = 0;
        int b = C1029a.m4587b(parcel);
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    arrayList = C1029a.m4590c(parcel, a, ParcelableGeofence.CREATOR);
                    break;
                case 2:
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
            return new GeofencingRequest(i2, arrayList, i);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public GeofencingRequest[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}
