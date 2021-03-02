package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.common.data.e */
public class C0143e implements Parcelable.Creator<C0140d> {
    /* renamed from: a */
    static void m262a(C0140d dVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m355a(parcel, 1, dVar.mo3597aK(), false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dVar.getVersionCode());
        C0155b.m354a(parcel, 2, (T[]) dVar.mo3598aL(), i, false);
        C0155b.m359c(parcel, 3, dVar.getStatusCode());
        C0155b.m345a(parcel, 4, dVar.mo3599aM(), false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: h */
    public C0140d createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int j = C0153a.m320j(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    strArr = C0153a.m333w(parcel, i3);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0153a.m309b(parcel, i3, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0153a.m314f(parcel, i3);
                    break;
                case 4:
                    bundle = C0153a.m324n(parcel, i3);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0153a.m314f(parcel, i3);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() != j) {
            throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
        }
        C0140d dVar = new C0140d(i2, strArr, cursorWindowArr, i, bundle);
        dVar.mo3596aJ();
        return dVar;
    }

    /* renamed from: s */
    public C0140d[] newArray(int i) {
        return new C0140d[i];
    }
}
