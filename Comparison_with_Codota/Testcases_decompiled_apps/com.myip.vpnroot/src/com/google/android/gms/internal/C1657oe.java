package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1639ny;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.oe */
public class C1657oe implements Parcelable.Creator<C1639ny.C1644c> {
    /* renamed from: a */
    static void m5821a(C1639ny.C1644c cVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = cVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, cVar.f4330BR);
        }
        if (set.contains(2)) {
            C0354b.m927a(parcel, 2, cVar.f4331uR, true);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: di */
    public C1639ny.C1644c createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    hashSet.add(2);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny.C1644c(hashSet, i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eZ */
    public C1639ny.C1644c[] newArray(int i) {
        return new C1639ny.C1644c[i];
    }
}
