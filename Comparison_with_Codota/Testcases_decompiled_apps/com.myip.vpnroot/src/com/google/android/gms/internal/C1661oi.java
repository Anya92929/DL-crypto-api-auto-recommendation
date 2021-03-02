package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1639ny;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.oi */
public class C1661oi implements Parcelable.Creator<C1639ny.C1649h> {
    /* renamed from: a */
    static void m5833a(C1639ny.C1649h hVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = hVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, hVar.f4338BR);
        }
        if (set.contains(3)) {
            C0354b.m939c(parcel, 3, hVar.mo9872nB());
        }
        if (set.contains(4)) {
            C0354b.m927a(parcel, 4, hVar.mValue, true);
        }
        if (set.contains(5)) {
            C0354b.m927a(parcel, 5, hVar.anw, true);
        }
        if (set.contains(6)) {
            C0354b.m939c(parcel, 6, hVar.f4339FD);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dm */
    public C1639ny.C1649h createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(3);
                    break;
                case 4:
                    str = C0352a.m900o(parcel, B);
                    hashSet.add(4);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = C0352a.m892g(parcel, B);
                    hashSet.add(6);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny.C1649h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fd */
    public C1639ny.C1649h[] newArray(int i) {
        return new C1639ny.C1649h[i];
    }
}
