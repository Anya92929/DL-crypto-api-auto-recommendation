package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0409ae;

/* renamed from: com.google.android.gms.internal.af */
public class C0412af implements Parcelable.Creator<C0409ae.C0410a> {
    /* renamed from: a */
    static void m852a(C0409ae.C0410a aVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, aVar.mo4501i());
        C0359b.m682c(parcel, 2, aVar.mo4486R());
        C0359b.m675a(parcel, 3, aVar.mo4489X());
        C0359b.m682c(parcel, 4, aVar.mo4487S());
        C0359b.m675a(parcel, 5, aVar.mo4490Y());
        C0359b.m672a(parcel, 6, aVar.mo4491Z(), false);
        C0359b.m682c(parcel, 7, aVar.mo4493aa());
        C0359b.m672a(parcel, 8, aVar.mo4495ac(), false);
        C0359b.m671a(parcel, 9, (Parcelable) aVar.mo4497ae(), i, false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: i */
    public C0409ae.C0410a createFromParcel(Parcel parcel) {
        C0628z zVar = null;
        int i = 0;
        int c = C0357a.m634c(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i4 = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                case 3:
                    z2 = C0357a.m636c(parcel, b);
                    break;
                case 4:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 5:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 6:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 7:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 8:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 9:
                    zVar = (C0628z) C0357a.m628a(parcel, b, C0628z.CREATOR);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0409ae.C0410a(i4, i3, z2, i2, z, str2, i, str, zVar);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: r */
    public C0409ae.C0410a[] newArray(int i) {
        return new C0409ae.C0410a[i];
    }
}
