package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.mc */
public class C1554mc implements Parcelable.Creator<C1553mb> {
    /* renamed from: a */
    static void m5593a(C1553mb mbVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, mbVar.getRequestId(), false);
        C0354b.m939c(parcel, 1000, mbVar.getVersionCode());
        C0354b.m919a(parcel, 2, mbVar.getExpirationTime());
        C0354b.m929a(parcel, 3, mbVar.mo9372lY());
        C0354b.m917a(parcel, 4, mbVar.getLatitude());
        C0354b.m917a(parcel, 5, mbVar.getLongitude());
        C0354b.m918a(parcel, 6, mbVar.mo9373lZ());
        C0354b.m939c(parcel, 7, mbVar.mo9374ma());
        C0354b.m939c(parcel, 8, mbVar.getNotificationResponsiveness());
        C0354b.m939c(parcel, 9, mbVar.mo9375mb());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cw */
    public C1553mb createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    s = C0352a.m891f(parcel, B);
                    break;
                case 4:
                    d = C0352a.m898m(parcel, B);
                    break;
                case 5:
                    d2 = C0352a.m898m(parcel, B);
                    break;
                case 6:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 7:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 9:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1553mb(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: el */
    public C1553mb[] newArray(int i) {
        return new C1553mb[i];
    }
}
