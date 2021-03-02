package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.location.u */
public class C1155u implements Parcelable.Creator<LocationSettingsResult> {
    /* renamed from: a */
    static void m4989a(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4614a(parcel, 1, (Parcelable) locationSettingsResult.mo7765c(), i, false);
        C1031c.m4610a(parcel, 1000, locationSettingsResult.mo7763a());
        C1031c.m4614a(parcel, 2, (Parcelable) locationSettingsResult.mo7764b(), i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationSettingsResult createFromParcel(Parcel parcel) {
        LocationSettingsStates locationSettingsStates;
        Status status;
        int i;
        LocationSettingsStates locationSettingsStates2 = null;
        int b = C1029a.m4587b(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) C1029a.m4583a(parcel, a, Status.CREATOR);
                    locationSettingsStates = locationSettingsStates2;
                    status = status3;
                    break;
                case 2:
                    locationSettingsStates = (LocationSettingsStates) C1029a.m4583a(parcel, a, LocationSettingsStates.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates2;
                    status = status2;
                    i = C1029a.m4594f(parcel, a);
                    locationSettingsStates = locationSettingsStates3;
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    locationSettingsStates = locationSettingsStates2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            locationSettingsStates2 = locationSettingsStates;
        }
        if (parcel.dataPosition() == b) {
            return new LocationSettingsResult(i2, status2, locationSettingsStates2);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationSettingsResult[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
