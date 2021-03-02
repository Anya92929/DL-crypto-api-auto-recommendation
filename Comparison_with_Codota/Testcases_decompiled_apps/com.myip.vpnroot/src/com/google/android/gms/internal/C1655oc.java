package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1639ny;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.oc */
public class C1655oc implements Parcelable.Creator<C1639ny.C1641b.C1642a> {
    /* renamed from: a */
    static void m5815a(C1639ny.C1641b.C1642a aVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = aVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, aVar.f4325BR);
        }
        if (set.contains(2)) {
            C0354b.m939c(parcel, 2, aVar.ann);
        }
        if (set.contains(3)) {
            C0354b.m939c(parcel, 3, aVar.ano);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dg */
    public C1639ny.C1641b.C1642a createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    hashSet.add(2);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(3);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny.C1641b.C1642a(hashSet, i3, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eX */
    public C1639ny.C1641b.C1642a[] newArray(int i) {
        return new C1639ny.C1641b.C1642a[i];
    }
}
