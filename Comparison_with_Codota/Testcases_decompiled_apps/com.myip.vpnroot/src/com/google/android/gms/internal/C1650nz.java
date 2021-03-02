package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1639ny;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.nz */
public class C1650nz implements Parcelable.Creator<C1639ny> {
    /* renamed from: a */
    static void m5803a(C1639ny nyVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = nyVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, nyVar.f4318BR);
        }
        if (set.contains(2)) {
            C0354b.m927a(parcel, 2, nyVar.amP, true);
        }
        if (set.contains(3)) {
            C0354b.m923a(parcel, 3, (Parcelable) nyVar.amQ, i, true);
        }
        if (set.contains(4)) {
            C0354b.m927a(parcel, 4, nyVar.amR, true);
        }
        if (set.contains(5)) {
            C0354b.m927a(parcel, 5, nyVar.amS, true);
        }
        if (set.contains(6)) {
            C0354b.m939c(parcel, 6, nyVar.amT);
        }
        if (set.contains(7)) {
            C0354b.m923a(parcel, 7, (Parcelable) nyVar.amU, i, true);
        }
        if (set.contains(8)) {
            C0354b.m927a(parcel, 8, nyVar.amV, true);
        }
        if (set.contains(9)) {
            C0354b.m927a(parcel, 9, nyVar.f4320Nz, true);
        }
        if (set.contains(12)) {
            C0354b.m939c(parcel, 12, nyVar.f4321om);
        }
        if (set.contains(14)) {
            C0354b.m927a(parcel, 14, nyVar.f4317BL, true);
        }
        if (set.contains(15)) {
            C0354b.m923a(parcel, 15, (Parcelable) nyVar.amW, i, true);
        }
        if (set.contains(16)) {
            C0354b.m930a(parcel, 16, nyVar.amX);
        }
        if (set.contains(19)) {
            C0354b.m923a(parcel, 19, (Parcelable) nyVar.amY, i, true);
        }
        if (set.contains(18)) {
            C0354b.m927a(parcel, 18, nyVar.f4319Fc, true);
        }
        if (set.contains(21)) {
            C0354b.m939c(parcel, 21, nyVar.ana);
        }
        if (set.contains(20)) {
            C0354b.m927a(parcel, 20, nyVar.amZ, true);
        }
        if (set.contains(23)) {
            C0354b.m940c(parcel, 23, nyVar.anc, true);
        }
        if (set.contains(22)) {
            C0354b.m940c(parcel, 22, nyVar.anb, true);
        }
        if (set.contains(25)) {
            C0354b.m939c(parcel, 25, nyVar.ane);
        }
        if (set.contains(24)) {
            C0354b.m939c(parcel, 24, nyVar.and);
        }
        if (set.contains(27)) {
            C0354b.m927a(parcel, 27, nyVar.f4322uR, true);
        }
        if (set.contains(26)) {
            C0354b.m927a(parcel, 26, nyVar.anf, true);
        }
        if (set.contains(29)) {
            C0354b.m930a(parcel, 29, nyVar.anh);
        }
        if (set.contains(28)) {
            C0354b.m940c(parcel, 28, nyVar.ang, true);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dd */
    public C1639ny createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1639ny.C1640a aVar = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1639ny.C1641b bVar = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1639ny.C1644c cVar = null;
        boolean z = false;
        String str7 = null;
        C1639ny.C1645d dVar = null;
        String str8 = null;
        int i4 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        ArrayList arrayList3 = null;
        boolean z2 = false;
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
                case 3:
                    hashSet.add(3);
                    aVar = (C1639ny.C1640a) C0352a.m880a(parcel, B, C1639ny.C1640a.CREATOR);
                    break;
                case 4:
                    str2 = C0352a.m900o(parcel, B);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = C0352a.m900o(parcel, B);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = C0352a.m892g(parcel, B);
                    hashSet.add(6);
                    break;
                case 7:
                    hashSet.add(7);
                    bVar = (C1639ny.C1641b) C0352a.m880a(parcel, B, C1639ny.C1641b.CREATOR);
                    break;
                case 8:
                    str4 = C0352a.m900o(parcel, B);
                    hashSet.add(8);
                    break;
                case 9:
                    str5 = C0352a.m900o(parcel, B);
                    hashSet.add(9);
                    break;
                case 12:
                    i3 = C0352a.m892g(parcel, B);
                    hashSet.add(12);
                    break;
                case 14:
                    str6 = C0352a.m900o(parcel, B);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    cVar = (C1639ny.C1644c) C0352a.m880a(parcel, B, C1639ny.C1644c.CREATOR);
                    break;
                case 16:
                    z = C0352a.m888c(parcel, B);
                    hashSet.add(16);
                    break;
                case 18:
                    str7 = C0352a.m900o(parcel, B);
                    hashSet.add(18);
                    break;
                case 19:
                    hashSet.add(19);
                    dVar = (C1639ny.C1645d) C0352a.m880a(parcel, B, C1639ny.C1645d.CREATOR);
                    break;
                case FitnessActivities.BOXING:
                    str8 = C0352a.m900o(parcel, B);
                    hashSet.add(20);
                    break;
                case 21:
                    i4 = C0352a.m892g(parcel, B);
                    hashSet.add(21);
                    break;
                case FitnessActivities.CIRCUIT_TRAINING:
                    arrayList = C0352a.m887c(parcel, B, C1639ny.C1647f.CREATOR);
                    hashSet.add(22);
                    break;
                case FitnessActivities.CRICKET:
                    arrayList2 = C0352a.m887c(parcel, B, C1639ny.C1648g.CREATOR);
                    hashSet.add(23);
                    break;
                case FitnessActivities.DANCING:
                    i5 = C0352a.m892g(parcel, B);
                    hashSet.add(24);
                    break;
                case FitnessActivities.ELLIPTICAL:
                    i6 = C0352a.m892g(parcel, B);
                    hashSet.add(25);
                    break;
                case FitnessActivities.FENCING:
                    str9 = C0352a.m900o(parcel, B);
                    hashSet.add(26);
                    break;
                case FitnessActivities.FOOTBALL_AMERICAN:
                    str10 = C0352a.m900o(parcel, B);
                    hashSet.add(27);
                    break;
                case FitnessActivities.FOOTBALL_AUSTRALIAN:
                    arrayList3 = C0352a.m887c(parcel, B, C1639ny.C1649h.CREATOR);
                    hashSet.add(28);
                    break;
                case FitnessActivities.FOOTBALL_SOCCER:
                    z2 = C0352a.m888c(parcel, B);
                    hashSet.add(29);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1639ny(hashSet, i, str, aVar, str2, str3, i2, bVar, str4, str5, i3, str6, cVar, z, str7, dVar, str8, i4, arrayList, arrayList2, i5, i6, str9, str10, arrayList3, z2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eU */
    public C1639ny[] newArray(int i) {
        return new C1639ny[i];
    }
}
