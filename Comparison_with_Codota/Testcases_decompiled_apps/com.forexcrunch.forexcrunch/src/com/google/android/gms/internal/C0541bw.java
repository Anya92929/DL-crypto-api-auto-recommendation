package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.bw */
public class C0541bw implements Parcelable.Creator<C0540bv> {
    /* renamed from: a */
    static void m1538a(C0540bv bvVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, bvVar.getDescription(), false);
        C0359b.m682c(parcel, 1000, bvVar.mo4937i());
        C0359b.m681b(parcel, 2, bvVar.mo4932bE(), false);
        C0359b.m681b(parcel, 3, bvVar.mo4933bF(), false);
        C0359b.m675a(parcel, 4, bvVar.mo4934bG());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: V */
    public C0540bv[] newArray(int i) {
        return new C0540bv[i];
    }

    /* renamed from: v */
    public C0540bv createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int c = C0357a.m634c(parcel);
        ArrayList arrayList2 = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 2:
                    arrayList2 = C0357a.m635c(parcel, b, C0626x.CREATOR);
                    break;
                case 3:
                    arrayList = C0357a.m635c(parcel, b, C0626x.CREATOR);
                    break;
                case 4:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 1000:
                    i = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0540bv(i, str, arrayList2, arrayList, z);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
