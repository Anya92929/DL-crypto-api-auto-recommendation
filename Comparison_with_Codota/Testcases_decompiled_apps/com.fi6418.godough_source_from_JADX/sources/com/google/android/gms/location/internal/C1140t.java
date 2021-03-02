package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.location.internal.t */
public class C1140t implements Parcelable.Creator<LocationRequestUpdateData> {
    /* renamed from: a */
    static void m4961a(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, locationRequestUpdateData.f4951a);
        C1031c.m4610a(parcel, 1000, locationRequestUpdateData.mo7816a());
        C1031c.m4614a(parcel, 2, (Parcelable) locationRequestUpdateData.f4952b, i, false);
        C1031c.m4613a(parcel, 3, locationRequestUpdateData.mo7817b(), false);
        C1031c.m4614a(parcel, 4, (Parcelable) locationRequestUpdateData.f4954d, i, false);
        C1031c.m4613a(parcel, 5, locationRequestUpdateData.mo7818c(), false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public LocationRequestUpdateData createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int b = C1029a.m4587b(parcel);
        int i = 0;
        int i2 = 1;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) C1029a.m4583a(parcel, a, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder2 = C1029a.m4600l(parcel, a);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) C1029a.m4583a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder = C1029a.m4600l(parcel, a);
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder2, pendingIntent, iBinder);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public LocationRequestUpdateData[] newArray(int i) {
        return new LocationRequestUpdateData[i];
    }
}
