package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.android.gms.internal.fb */
public class C0521fb implements Parcelable.Creator<C0520fa> {
    /* renamed from: a */
    static void m1552a(C0520fa faVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m349a(parcel, 1, faVar.getRequestId(), false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, faVar.getVersionCode());
        C0155b.m344a(parcel, 2, faVar.getExpirationTime());
        C0155b.m351a(parcel, 3, faVar.mo4763co());
        C0155b.m342a(parcel, 4, faVar.getLatitude());
        C0155b.m342a(parcel, 5, faVar.getLongitude());
        C0155b.m343a(parcel, 6, faVar.mo4764cp());
        C0155b.m359c(parcel, 7, faVar.mo4765cq());
        C0155b.m359c(parcel, 8, faVar.getNotificationResponsiveness());
        C0155b.m359c(parcel, 9, faVar.mo4766cr());
        C0155b.m340C(parcel, k);
    }

    /* renamed from: ac */
    public C0520fa[] newArray(int i) {
        return new C0520fa[i];
    }

    /* renamed from: z */
    public C0520fa createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = BitmapDescriptorFactory.HUE_RED;
        long j2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < j) {
            int i5 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i5)) {
                case 1:
                    str = C0153a.m322l(parcel, i5);
                    break;
                case 2:
                    j2 = C0153a.m315g(parcel, i5);
                    break;
                case 3:
                    s = C0153a.m313e(parcel, i5);
                    break;
                case 4:
                    d = C0153a.m319j(parcel, i5);
                    break;
                case 5:
                    d2 = C0153a.m319j(parcel, i5);
                    break;
                case 6:
                    f = C0153a.m317i(parcel, i5);
                    break;
                case 7:
                    i2 = C0153a.m314f(parcel, i5);
                    break;
                case 8:
                    i3 = C0153a.m314f(parcel, i5);
                    break;
                case 9:
                    i4 = C0153a.m314f(parcel, i5);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0153a.m314f(parcel, i5);
                    break;
                default:
                    C0153a.m308b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0520fa(i, str, i2, s, d, d2, f, j2, i3, i4);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
