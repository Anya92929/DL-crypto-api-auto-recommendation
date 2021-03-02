package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.location.v */
public class C1156v implements Parcelable.Creator<LocationSettingsStates> {
    /* renamed from: a */
    static void m4992a(LocationSettingsStates locationSettingsStates, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4619a(parcel, 1, locationSettingsStates.mo7769b());
        C1031c.m4610a(parcel, 1000, locationSettingsStates.mo7768a());
        C1031c.m4619a(parcel, 2, locationSettingsStates.mo7771d());
        C1031c.m4619a(parcel, 3, locationSettingsStates.mo7774f());
        C1031c.m4619a(parcel, 4, locationSettingsStates.mo7770c());
        C1031c.m4619a(parcel, 5, locationSettingsStates.mo7773e());
        C1031c.m4619a(parcel, 6, locationSettingsStates.mo7775g());
        C1031c.m4619a(parcel, 7, locationSettingsStates.mo7776h());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationSettingsStates createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    z7 = C1029a.m4591c(parcel, a);
                    break;
                case 2:
                    z6 = C1029a.m4591c(parcel, a);
                    break;
                case 3:
                    z5 = C1029a.m4591c(parcel, a);
                    break;
                case 4:
                    z4 = C1029a.m4591c(parcel, a);
                    break;
                case 5:
                    z3 = C1029a.m4591c(parcel, a);
                    break;
                case 6:
                    z2 = C1029a.m4591c(parcel, a);
                    break;
                case 7:
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
            return new LocationSettingsStates(i, z7, z6, z5, z4, z3, z2, z);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationSettingsStates[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
