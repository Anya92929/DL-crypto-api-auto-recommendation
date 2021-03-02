package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1639ny;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.of */
public class C1658of implements Parcelable.Creator<C1639ny.C1645d> {
    /* renamed from: a */
    static void m5824a(C1639ny.C1645d dVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = dVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, dVar.f4332BR);
        }
        if (set.contains(2)) {
            C0354b.m927a(parcel, 2, dVar.amp, true);
        }
        if (set.contains(3)) {
            C0354b.m927a(parcel, 3, dVar.anp, true);
        }
        if (set.contains(4)) {
            C0354b.m927a(parcel, 4, dVar.ams, true);
        }
        if (set.contains(5)) {
            C0354b.m927a(parcel, 5, dVar.anq, true);
        }
        if (set.contains(6)) {
            C0354b.m927a(parcel, 6, dVar.anr, true);
        }
        if (set.contains(7)) {
            C0354b.m927a(parcel, 7, dVar.ans, true);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dj */
    public C1639ny.C1645d createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    str6 = C0352a.m900o(parcel, B);
                    hashSet.add(2);
                    break;
                case 3:
                    str5 = C0352a.m900o(parcel, B);
                    hashSet.add(3);
                    break;
                case 4:
                    str4 = C0352a.m900o(parcel, B);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = C0352a.m900o(parcel, B);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = C0352a.m900o(parcel, B);
                    hashSet.add(6);
                    break;
                case 7:
                    str = C0352a.m900o(parcel, B);
                    hashSet.add(7);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny.C1645d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fa */
    public C1639ny.C1645d[] newArray(int i) {
        return new C1639ny.C1645d[i];
    }
}
