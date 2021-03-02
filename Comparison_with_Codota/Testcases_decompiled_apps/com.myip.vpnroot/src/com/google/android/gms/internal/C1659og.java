package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1639ny;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.og */
public class C1659og implements Parcelable.Creator<C1639ny.C1647f> {
    /* renamed from: a */
    static void m5827a(C1639ny.C1647f fVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = fVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, fVar.f4333BR);
        }
        if (set.contains(2)) {
            C0354b.m927a(parcel, 2, fVar.ant, true);
        }
        if (set.contains(3)) {
            C0354b.m927a(parcel, 3, fVar.f4336Tg, true);
        }
        if (set.contains(4)) {
            C0354b.m927a(parcel, 4, fVar.amo, true);
        }
        if (set.contains(5)) {
            C0354b.m927a(parcel, 5, fVar.anu, true);
        }
        if (set.contains(6)) {
            C0354b.m927a(parcel, 6, fVar.mName, true);
        }
        if (set.contains(7)) {
            C0354b.m930a(parcel, 7, fVar.anv);
        }
        if (set.contains(8)) {
            C0354b.m927a(parcel, 8, fVar.amE, true);
        }
        if (set.contains(9)) {
            C0354b.m927a(parcel, 9, fVar.f4335No, true);
        }
        if (set.contains(10)) {
            C0354b.m939c(parcel, 10, fVar.f4334FD);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dk */
    public C1639ny.C1647f createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    str7 = C0352a.m900o(parcel, B);
                    hashSet.add(2);
                    break;
                case 3:
                    str6 = C0352a.m900o(parcel, B);
                    hashSet.add(3);
                    break;
                case 4:
                    str5 = C0352a.m900o(parcel, B);
                    hashSet.add(4);
                    break;
                case 5:
                    str4 = C0352a.m900o(parcel, B);
                    hashSet.add(5);
                    break;
                case 6:
                    str3 = C0352a.m900o(parcel, B);
                    hashSet.add(6);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    hashSet.add(7);
                    break;
                case 8:
                    str2 = C0352a.m900o(parcel, B);
                    hashSet.add(8);
                    break;
                case 9:
                    str = C0352a.m900o(parcel, B);
                    hashSet.add(9);
                    break;
                case 10:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(10);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny.C1647f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fb */
    public C1639ny.C1647f[] newArray(int i) {
        return new C1639ny.C1647f[i];
    }
}
