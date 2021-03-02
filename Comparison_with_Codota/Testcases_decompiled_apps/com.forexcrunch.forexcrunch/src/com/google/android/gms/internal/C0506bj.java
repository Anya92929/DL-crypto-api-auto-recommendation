package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.android.gms.internal.bj */
public class C0506bj implements Parcelable.Creator<C0505bi> {
    /* renamed from: a */
    static void m1358a(C0505bi biVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, biVar.getRequestId(), false);
        C0359b.m682c(parcel, 1000, biVar.mo4827i());
        C0359b.m667a(parcel, 2, biVar.getExpirationTime());
        C0359b.m674a(parcel, 3, biVar.mo4817aT());
        C0359b.m665a(parcel, 4, biVar.getLatitude());
        C0359b.m665a(parcel, 5, biVar.getLongitude());
        C0359b.m666a(parcel, 6, biVar.mo4818aU());
        C0359b.m682c(parcel, 7, biVar.mo4819aV());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: R */
    public C0505bi[] newArray(int i) {
        return new C0505bi[i];
    }

    /* renamed from: t */
    public C0505bi createFromParcel(Parcel parcel) {
        double d = 0.0d;
        short s = 0;
        int c = C0357a.m634c(parcel);
        String str = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        long j = 0;
        double d2 = 0.0d;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 2:
                    j = C0357a.m640g(parcel, b);
                    break;
                case 3:
                    s = C0357a.m638e(parcel, b);
                    break;
                case 4:
                    d2 = C0357a.m643j(parcel, b);
                    break;
                case 5:
                    d = C0357a.m643j(parcel, b);
                    break;
                case 6:
                    f = C0357a.m642i(parcel, b);
                    break;
                case 7:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 1000:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0505bi(i2, str, i, s, d2, d, f, j);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
