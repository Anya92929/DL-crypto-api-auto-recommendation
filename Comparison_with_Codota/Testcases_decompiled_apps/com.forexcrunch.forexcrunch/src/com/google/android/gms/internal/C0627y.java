package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.internal.y */
public class C0627y implements Parcelable.Creator<C0626x> {
    /* renamed from: a */
    static void m1909a(C0626x xVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, xVar.getType());
        C0359b.m682c(parcel, 1000, xVar.mo5508i());
        C0359b.m682c(parcel, 2, xVar.mo5497I());
        C0359b.m672a(parcel, 3, xVar.mo5498J(), false);
        C0359b.m672a(parcel, 4, xVar.mo5499K(), false);
        C0359b.m672a(parcel, 5, xVar.getDisplayName(), false);
        C0359b.m672a(parcel, 6, xVar.mo5500L(), false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: e */
    public C0626x createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int c = C0357a.m634c(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 3:
                    str4 = C0357a.m645l(parcel, b);
                    break;
                case 4:
                    str3 = C0357a.m645l(parcel, b);
                    break;
                case 5:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 6:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 1000:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0626x(i3, i2, i, str4, str3, str2, str);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: n */
    public C0626x[] newArray(int i) {
        return new C0626x[i];
    }
}
