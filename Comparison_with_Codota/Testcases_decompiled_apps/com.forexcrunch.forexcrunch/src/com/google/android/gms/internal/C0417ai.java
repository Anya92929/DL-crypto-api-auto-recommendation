package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0414ah;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ai */
public class C0417ai implements Parcelable.Creator<C0414ah> {
    /* renamed from: a */
    static void m869a(C0414ah ahVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, ahVar.mo4519i());
        C0359b.m681b(parcel, 2, ahVar.mo4515ai(), false);
        C0359b.m672a(parcel, 3, ahVar.mo4516aj(), false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: k */
    public C0414ah createFromParcel(Parcel parcel) {
        String str = null;
        int c = C0357a.m634c(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    arrayList = C0357a.m635c(parcel, b, C0414ah.C0415a.CREATOR);
                    break;
                case 3:
                    str = C0357a.m645l(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0414ah(i, arrayList, str);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: t */
    public C0414ah[] newArray(int i) {
        return new C0414ah[i];
    }
}
