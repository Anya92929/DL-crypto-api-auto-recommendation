package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.android.gms.location.internal.u */
public class C1141u implements Parcelable.Creator<ParcelableGeofence> {
    /* renamed from: a */
    static void m4964a(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4616a(parcel, 1, parcelableGeofence.mo7828f(), false);
        C1031c.m4610a(parcel, 1000, parcelableGeofence.mo7821a());
        C1031c.m4611a(parcel, 2, parcelableGeofence.mo7829g());
        C1031c.m4618a(parcel, 3, parcelableGeofence.mo7822b());
        C1031c.m4608a(parcel, 4, parcelableGeofence.mo7823c());
        C1031c.m4608a(parcel, 5, parcelableGeofence.mo7824d());
        C1031c.m4609a(parcel, 6, parcelableGeofence.mo7826e());
        C1031c.m4610a(parcel, 7, parcelableGeofence.mo7830h());
        C1031c.m4610a(parcel, 8, parcelableGeofence.mo7832i());
        C1031c.m4610a(parcel, 9, parcelableGeofence.mo7833j());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ParcelableGeofence createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = BitmapDescriptorFactory.HUE_RED;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 2:
                    j = C1029a.m4596h(parcel, a);
                    break;
                case 3:
                    s = C1029a.m4593e(parcel, a);
                    break;
                case 4:
                    d = C1029a.m4598j(parcel, a);
                    break;
                case 5:
                    d2 = C1029a.m4598j(parcel, a);
                    break;
                case 6:
                    f = C1029a.m4597i(parcel, a);
                    break;
                case 7:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 8:
                    i3 = C1029a.m4594f(parcel, a);
                    break;
                case 9:
                    i4 = C1029a.m4594f(parcel, a);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ParcelableGeofence[] newArray(int i) {
        return new ParcelableGeofence[i];
    }
}
