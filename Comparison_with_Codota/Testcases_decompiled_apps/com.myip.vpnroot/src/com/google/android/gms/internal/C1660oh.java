package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1639ny;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.oh */
public class C1660oh implements Parcelable.Creator<C1639ny.C1648g> {
    /* renamed from: a */
    static void m5830a(C1639ny.C1648g gVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = gVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, gVar.f4337BR);
        }
        if (set.contains(2)) {
            C0354b.m930a(parcel, 2, gVar.anv);
        }
        if (set.contains(3)) {
            C0354b.m927a(parcel, 3, gVar.mValue, true);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dl */
    public C1639ny.C1648g createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    z = C0352a.m888c(parcel, B);
                    hashSet.add(2);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    hashSet.add(3);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny.C1648g(hashSet, i, z, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fc */
    public C1639ny.C1648g[] newArray(int i) {
        return new C1639ny.C1648g[i];
    }
}
