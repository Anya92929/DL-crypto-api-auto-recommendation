package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1639ny;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ob */
public class C1654ob implements Parcelable.Creator<C1639ny.C1641b> {
    /* renamed from: a */
    static void m5812a(C1639ny.C1641b bVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = bVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, bVar.f4324BR);
        }
        if (set.contains(2)) {
            C0354b.m923a(parcel, 2, (Parcelable) bVar.ank, i, true);
        }
        if (set.contains(3)) {
            C0354b.m923a(parcel, 3, (Parcelable) bVar.anl, i, true);
        }
        if (set.contains(4)) {
            C0354b.m939c(parcel, 4, bVar.anm);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: df */
    public C1639ny.C1641b createFromParcel(Parcel parcel) {
        C1639ny.C1641b.C1643b bVar = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        C1639ny.C1641b.C1642a aVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    aVar = (C1639ny.C1641b.C1642a) C0352a.m880a(parcel, B, C1639ny.C1641b.C1642a.CREATOR);
                    break;
                case 3:
                    hashSet.add(3);
                    bVar = (C1639ny.C1641b.C1643b) C0352a.m880a(parcel, B, C1639ny.C1641b.C1643b.CREATOR);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(4);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny.C1641b(hashSet, i2, aVar, bVar, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eW */
    public C1639ny.C1641b[] newArray(int i) {
        return new C1639ny.C1641b[i];
    }
}
