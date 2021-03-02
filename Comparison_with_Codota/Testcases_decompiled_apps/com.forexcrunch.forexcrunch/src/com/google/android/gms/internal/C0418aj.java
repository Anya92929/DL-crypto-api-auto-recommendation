package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0414ah;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.aj */
public class C0418aj implements Parcelable.Creator<C0414ah.C0415a> {
    /* renamed from: a */
    static void m872a(C0414ah.C0415a aVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, aVar.versionCode);
        C0359b.m672a(parcel, 2, aVar.className, false);
        C0359b.m681b(parcel, 3, aVar.f1003cG, false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: l */
    public C0414ah.C0415a createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int c = C0357a.m634c(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 3:
                    arrayList = C0357a.m635c(parcel, b, C0414ah.C0416b.CREATOR);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0414ah.C0415a(i, str, arrayList);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: u */
    public C0414ah.C0415a[] newArray(int i) {
        return new C0414ah.C0415a[i];
    }
}
