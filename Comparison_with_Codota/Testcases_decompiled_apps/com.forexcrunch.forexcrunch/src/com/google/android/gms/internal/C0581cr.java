package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.cr */
public class C0581cr implements Parcelable.Creator<C0580cq> {
    /* renamed from: a */
    static void m1747a(C0580cq cqVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1000, cqVar.mo5378i());
        C0359b.m681b(parcel, 2, cqVar.mo5371cK(), false);
        C0359b.m681b(parcel, 3, cqVar.mo5372cL(), false);
        C0359b.m668a(parcel, 4, cqVar.mo5373cM(), false);
        C0359b.m675a(parcel, 5, cqVar.mo5374cN());
        C0359b.m682c(parcel, 6, cqVar.mo5370cJ());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: J */
    public C0580cq createFromParcel(Parcel parcel) {
        Bundle bundle = null;
        int i = 0;
        int c = C0357a.m634c(parcel);
        boolean z = false;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 2:
                    arrayList2 = C0357a.m635c(parcel, b, C0626x.CREATOR);
                    break;
                case 3:
                    arrayList = C0357a.m635c(parcel, b, C0626x.CREATOR);
                    break;
                case 4:
                    bundle = C0357a.m648n(parcel, b);
                    break;
                case 5:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 6:
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
            return new C0580cq(i2, arrayList2, arrayList, bundle, z, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: aj */
    public C0580cq[] newArray(int i) {
        return new C0580cq[i];
    }
}
