package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.cl */
public class C0575cl implements Parcelable.Creator<C0556cc.C0565g> {
    /* renamed from: a */
    static void m1717a(C0556cc.C0565g gVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = gVar.mo5281bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, gVar.mo5289i());
        }
        if (bH.contains(2)) {
            C0359b.m675a(parcel, 2, gVar.isPrimary());
        }
        if (bH.contains(3)) {
            C0359b.m672a(parcel, 3, gVar.getValue(), true);
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: G */
    public C0556cc.C0565g createFromParcel(Parcel parcel) {
        boolean z = false;
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    z = C0357a.m636c(parcel, b);
                    hashSet.add(2);
                    break;
                case 3:
                    str = C0357a.m645l(parcel, b);
                    hashSet.add(3);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc.C0565g(hashSet, i, z, str);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: ag */
    public C0556cc.C0565g[] newArray(int i) {
        return new C0556cc.C0565g[i];
    }
}
