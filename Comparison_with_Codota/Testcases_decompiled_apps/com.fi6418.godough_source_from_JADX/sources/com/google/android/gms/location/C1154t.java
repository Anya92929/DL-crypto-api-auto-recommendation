package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.location.t */
public class C1154t implements Parcelable.Creator<LocationSettingsRequest> {
    /* renamed from: a */
    static void m4986a(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4627c(parcel, 1, locationSettingsRequest.mo7757b(), false);
        C1031c.m4610a(parcel, 1000, locationSettingsRequest.mo7756a());
        C1031c.m4619a(parcel, 2, locationSettingsRequest.mo7758c());
        C1031c.m4619a(parcel, 3, locationSettingsRequest.mo7759d());
        C1031c.m4619a(parcel, 4, locationSettingsRequest.mo7761e());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationSettingsRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    arrayList = C1029a.m4590c(parcel, a, LocationRequest.CREATOR);
                    break;
                case 2:
                    z3 = C1029a.m4591c(parcel, a);
                    break;
                case 3:
                    z2 = C1029a.m4591c(parcel, a);
                    break;
                case 4:
                    z = C1029a.m4591c(parcel, a);
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
            return new LocationSettingsRequest(i, arrayList, z3, z2, z);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationSettingsRequest[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
