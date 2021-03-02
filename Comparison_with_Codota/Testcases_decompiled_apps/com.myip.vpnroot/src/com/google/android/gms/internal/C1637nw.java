package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.nw */
public class C1637nw implements Parcelable.Creator<C1636nv> {
    /* renamed from: a */
    static void m5755a(C1636nv nvVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = nvVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, nvVar.f4315BR);
        }
        if (set.contains(2)) {
            C0354b.m927a(parcel, 2, nvVar.f4314BL, true);
        }
        if (set.contains(4)) {
            C0354b.m923a(parcel, 4, (Parcelable) nvVar.amM, i, true);
        }
        if (set.contains(5)) {
            C0354b.m927a(parcel, 5, nvVar.amE, true);
        }
        if (set.contains(6)) {
            C0354b.m923a(parcel, 6, (Parcelable) nvVar.amN, i, true);
        }
        if (set.contains(7)) {
            C0354b.m927a(parcel, 7, nvVar.f4316uO, true);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dc */
    public C1636nv createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C1634nt ntVar = null;
        String str2 = null;
        C1634nt ntVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    str3 = C0352a.m900o(parcel, B);
                    hashSet.add(2);
                    break;
                case 4:
                    hashSet.add(4);
                    ntVar2 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
                    hashSet.add(5);
                    break;
                case 6:
                    hashSet.add(6);
                    ntVar = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
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
            return new C1636nv(hashSet, i, str3, ntVar2, str2, ntVar, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eT */
    public C1636nv[] newArray(int i) {
        return new C1636nv[i];
    }
}
