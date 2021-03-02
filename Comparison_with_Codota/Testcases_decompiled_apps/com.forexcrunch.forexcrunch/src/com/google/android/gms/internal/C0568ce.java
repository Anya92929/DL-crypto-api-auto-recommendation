package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ce */
public class C0568ce implements Parcelable.Creator<C0556cc.C0557a> {
    /* renamed from: a */
    static void m1696a(C0556cc.C0557a aVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = aVar.mo5178bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, aVar.mo5187i());
        }
        if (bH.contains(2)) {
            C0359b.m682c(parcel, 2, aVar.getMax());
        }
        if (bH.contains(3)) {
            C0359b.m682c(parcel, 3, aVar.getMin());
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: Z */
    public C0556cc.C0557a[] newArray(int i) {
        return new C0556cc.C0557a[i];
    }

    /* renamed from: z */
    public C0556cc.C0557a createFromParcel(Parcel parcel) {
        int i = 0;
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i3 = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    i2 = C0357a.m639f(parcel, b);
                    hashSet.add(2);
                    break;
                case 3:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(3);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc.C0557a(hashSet, i3, i2, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
