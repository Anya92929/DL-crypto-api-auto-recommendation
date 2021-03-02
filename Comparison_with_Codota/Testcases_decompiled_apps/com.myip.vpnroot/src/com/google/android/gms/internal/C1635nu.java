package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.nu */
public class C1635nu implements Parcelable.Creator<C1634nt> {
    /* renamed from: a */
    static void m5748a(C1634nt ntVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        Set<Integer> set = ntVar.alR;
        if (set.contains(1)) {
            C0354b.m939c(parcel, 1, ntVar.f4309BR);
        }
        if (set.contains(2)) {
            C0354b.m923a(parcel, 2, (Parcelable) ntVar.alS, i, true);
        }
        if (set.contains(3)) {
            C0354b.m938b(parcel, 3, ntVar.alT, true);
        }
        if (set.contains(4)) {
            C0354b.m923a(parcel, 4, (Parcelable) ntVar.alU, i, true);
        }
        if (set.contains(5)) {
            C0354b.m927a(parcel, 5, ntVar.alV, true);
        }
        if (set.contains(6)) {
            C0354b.m927a(parcel, 6, ntVar.alW, true);
        }
        if (set.contains(7)) {
            C0354b.m927a(parcel, 7, ntVar.alX, true);
        }
        if (set.contains(8)) {
            C0354b.m940c(parcel, 8, ntVar.alY, true);
        }
        if (set.contains(9)) {
            C0354b.m939c(parcel, 9, ntVar.alZ);
        }
        if (set.contains(10)) {
            C0354b.m940c(parcel, 10, ntVar.ama, true);
        }
        if (set.contains(11)) {
            C0354b.m923a(parcel, 11, (Parcelable) ntVar.amb, i, true);
        }
        if (set.contains(12)) {
            C0354b.m940c(parcel, 12, ntVar.amc, true);
        }
        if (set.contains(13)) {
            C0354b.m927a(parcel, 13, ntVar.amd, true);
        }
        if (set.contains(14)) {
            C0354b.m927a(parcel, 14, ntVar.ame, true);
        }
        if (set.contains(15)) {
            C0354b.m923a(parcel, 15, (Parcelable) ntVar.amf, i, true);
        }
        if (set.contains(17)) {
            C0354b.m927a(parcel, 17, ntVar.amh, true);
        }
        if (set.contains(16)) {
            C0354b.m927a(parcel, 16, ntVar.amg, true);
        }
        if (set.contains(19)) {
            C0354b.m940c(parcel, 19, ntVar.ami, true);
        }
        if (set.contains(18)) {
            C0354b.m927a(parcel, 18, ntVar.f4311ol, true);
        }
        if (set.contains(21)) {
            C0354b.m927a(parcel, 21, ntVar.amk, true);
        }
        if (set.contains(20)) {
            C0354b.m927a(parcel, 20, ntVar.amj, true);
        }
        if (set.contains(23)) {
            C0354b.m927a(parcel, 23, ntVar.f4310Tg, true);
        }
        if (set.contains(22)) {
            C0354b.m927a(parcel, 22, ntVar.aml, true);
        }
        if (set.contains(25)) {
            C0354b.m927a(parcel, 25, ntVar.amn, true);
        }
        if (set.contains(24)) {
            C0354b.m927a(parcel, 24, ntVar.amm, true);
        }
        if (set.contains(27)) {
            C0354b.m927a(parcel, 27, ntVar.amp, true);
        }
        if (set.contains(26)) {
            C0354b.m927a(parcel, 26, ntVar.amo, true);
        }
        if (set.contains(29)) {
            C0354b.m923a(parcel, 29, (Parcelable) ntVar.amr, i, true);
        }
        if (set.contains(28)) {
            C0354b.m927a(parcel, 28, ntVar.amq, true);
        }
        if (set.contains(31)) {
            C0354b.m927a(parcel, 31, ntVar.amt, true);
        }
        if (set.contains(30)) {
            C0354b.m927a(parcel, 30, ntVar.ams, true);
        }
        if (set.contains(34)) {
            C0354b.m923a(parcel, 34, (Parcelable) ntVar.amv, i, true);
        }
        if (set.contains(32)) {
            C0354b.m927a(parcel, 32, ntVar.f4308BL, true);
        }
        if (set.contains(33)) {
            C0354b.m927a(parcel, 33, ntVar.amu, true);
        }
        if (set.contains(38)) {
            C0354b.m917a(parcel, 38, ntVar.aea);
        }
        if (set.contains(39)) {
            C0354b.m927a(parcel, 39, ntVar.mName, true);
        }
        if (set.contains(36)) {
            C0354b.m917a(parcel, 36, ntVar.adZ);
        }
        if (set.contains(37)) {
            C0354b.m923a(parcel, 37, (Parcelable) ntVar.amw, i, true);
        }
        if (set.contains(42)) {
            C0354b.m927a(parcel, 42, ntVar.amz, true);
        }
        if (set.contains(43)) {
            C0354b.m927a(parcel, 43, ntVar.amA, true);
        }
        if (set.contains(40)) {
            C0354b.m923a(parcel, 40, (Parcelable) ntVar.amx, i, true);
        }
        if (set.contains(41)) {
            C0354b.m940c(parcel, 41, ntVar.amy, true);
        }
        if (set.contains(46)) {
            C0354b.m923a(parcel, 46, (Parcelable) ntVar.amD, i, true);
        }
        if (set.contains(47)) {
            C0354b.m927a(parcel, 47, ntVar.amE, true);
        }
        if (set.contains(44)) {
            C0354b.m927a(parcel, 44, ntVar.amB, true);
        }
        if (set.contains(45)) {
            C0354b.m927a(parcel, 45, ntVar.amC, true);
        }
        if (set.contains(51)) {
            C0354b.m927a(parcel, 51, ntVar.amI, true);
        }
        if (set.contains(50)) {
            C0354b.m923a(parcel, 50, (Parcelable) ntVar.amH, i, true);
        }
        if (set.contains(49)) {
            C0354b.m927a(parcel, 49, ntVar.amG, true);
        }
        if (set.contains(48)) {
            C0354b.m927a(parcel, 48, ntVar.amF, true);
        }
        if (set.contains(55)) {
            C0354b.m927a(parcel, 55, ntVar.amK, true);
        }
        if (set.contains(54)) {
            C0354b.m927a(parcel, 54, ntVar.f4313uR, true);
        }
        if (set.contains(53)) {
            C0354b.m927a(parcel, 53, ntVar.f4312uO, true);
        }
        if (set.contains(52)) {
            C0354b.m927a(parcel, 52, ntVar.amJ, true);
        }
        if (set.contains(56)) {
            C0354b.m927a(parcel, 56, ntVar.amL, true);
        }
        C0354b.m915H(parcel, D);
    }

    /* renamed from: db */
    public C1634nt createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C1634nt ntVar = null;
        ArrayList<String> arrayList = null;
        C1634nt ntVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        C1634nt ntVar3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        C1634nt ntVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        C1634nt ntVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        C1634nt ntVar6 = null;
        double d = 0.0d;
        C1634nt ntVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        C1634nt ntVar8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        C1634nt ntVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        C1634nt ntVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    ntVar = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case 3:
                    arrayList = C0352a.m876C(parcel, B);
                    hashSet.add(3);
                    break;
                case 4:
                    hashSet.add(4);
                    ntVar2 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = C0352a.m900o(parcel, B);
                    hashSet.add(6);
                    break;
                case 7:
                    str3 = C0352a.m900o(parcel, B);
                    hashSet.add(7);
                    break;
                case 8:
                    arrayList2 = C0352a.m887c(parcel, B, C1634nt.CREATOR);
                    hashSet.add(8);
                    break;
                case 9:
                    i2 = C0352a.m892g(parcel, B);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayList3 = C0352a.m887c(parcel, B, C1634nt.CREATOR);
                    hashSet.add(10);
                    break;
                case 11:
                    hashSet.add(11);
                    ntVar3 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case 12:
                    arrayList4 = C0352a.m887c(parcel, B, C1634nt.CREATOR);
                    hashSet.add(12);
                    break;
                case 13:
                    str4 = C0352a.m900o(parcel, B);
                    hashSet.add(13);
                    break;
                case 14:
                    str5 = C0352a.m900o(parcel, B);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    ntVar4 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case 16:
                    str6 = C0352a.m900o(parcel, B);
                    hashSet.add(16);
                    break;
                case 17:
                    str7 = C0352a.m900o(parcel, B);
                    hashSet.add(17);
                    break;
                case 18:
                    str8 = C0352a.m900o(parcel, B);
                    hashSet.add(18);
                    break;
                case 19:
                    arrayList5 = C0352a.m887c(parcel, B, C1634nt.CREATOR);
                    hashSet.add(19);
                    break;
                case FitnessActivities.BOXING:
                    str9 = C0352a.m900o(parcel, B);
                    hashSet.add(20);
                    break;
                case 21:
                    str10 = C0352a.m900o(parcel, B);
                    hashSet.add(21);
                    break;
                case FitnessActivities.CIRCUIT_TRAINING:
                    str11 = C0352a.m900o(parcel, B);
                    hashSet.add(22);
                    break;
                case FitnessActivities.CRICKET:
                    str12 = C0352a.m900o(parcel, B);
                    hashSet.add(23);
                    break;
                case FitnessActivities.DANCING:
                    str13 = C0352a.m900o(parcel, B);
                    hashSet.add(24);
                    break;
                case FitnessActivities.ELLIPTICAL:
                    str14 = C0352a.m900o(parcel, B);
                    hashSet.add(25);
                    break;
                case FitnessActivities.FENCING:
                    str15 = C0352a.m900o(parcel, B);
                    hashSet.add(26);
                    break;
                case FitnessActivities.FOOTBALL_AMERICAN:
                    str16 = C0352a.m900o(parcel, B);
                    hashSet.add(27);
                    break;
                case FitnessActivities.FOOTBALL_AUSTRALIAN:
                    str17 = C0352a.m900o(parcel, B);
                    hashSet.add(28);
                    break;
                case FitnessActivities.FOOTBALL_SOCCER:
                    hashSet.add(29);
                    ntVar5 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case FitnessActivities.FRISBEE_DISC:
                    str18 = C0352a.m900o(parcel, B);
                    hashSet.add(30);
                    break;
                case 31:
                    str19 = C0352a.m900o(parcel, B);
                    hashSet.add(31);
                    break;
                case 32:
                    str20 = C0352a.m900o(parcel, B);
                    hashSet.add(32);
                    break;
                case FitnessActivities.GYMNASTICS:
                    str21 = C0352a.m900o(parcel, B);
                    hashSet.add(33);
                    break;
                case FitnessActivities.HANDBALL:
                    hashSet.add(34);
                    ntVar6 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case FitnessActivities.HOCKEY:
                    d = C0352a.m898m(parcel, B);
                    hashSet.add(36);
                    break;
                case FitnessActivities.HORSEBACK_RIDING:
                    hashSet.add(37);
                    ntVar7 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case FitnessActivities.HOUSEWORK:
                    d2 = C0352a.m898m(parcel, B);
                    hashSet.add(38);
                    break;
                case FitnessActivities.JUMP_ROPE:
                    str22 = C0352a.m900o(parcel, B);
                    hashSet.add(39);
                    break;
                case FitnessActivities.KAYAKING:
                    hashSet.add(40);
                    ntVar8 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case FitnessActivities.KETTLEBELL_TRAINING:
                    arrayList6 = C0352a.m887c(parcel, B, C1634nt.CREATOR);
                    hashSet.add(41);
                    break;
                case FitnessActivities.KICKBOXING:
                    str23 = C0352a.m900o(parcel, B);
                    hashSet.add(42);
                    break;
                case FitnessActivities.KITESURFING:
                    str24 = C0352a.m900o(parcel, B);
                    hashSet.add(43);
                    break;
                case FitnessActivities.MARTIAL_ARTS:
                    str25 = C0352a.m900o(parcel, B);
                    hashSet.add(44);
                    break;
                case FitnessActivities.MEDITATION:
                    str26 = C0352a.m900o(parcel, B);
                    hashSet.add(45);
                    break;
                case FitnessActivities.MIXED_MARTIAL_ARTS:
                    hashSet.add(46);
                    ntVar9 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case FitnessActivities.P90X:
                    str27 = C0352a.m900o(parcel, B);
                    hashSet.add(47);
                    break;
                case FitnessActivities.PARAGLIDING:
                    str28 = C0352a.m900o(parcel, B);
                    hashSet.add(48);
                    break;
                case FitnessActivities.PILATES:
                    str29 = C0352a.m900o(parcel, B);
                    hashSet.add(49);
                    break;
                case 50:
                    hashSet.add(50);
                    ntVar10 = (C1634nt) C0352a.m880a(parcel, B, C1634nt.CREATOR);
                    break;
                case FitnessActivities.RACQUETBALL:
                    str30 = C0352a.m900o(parcel, B);
                    hashSet.add(51);
                    break;
                case FitnessActivities.ROCK_CLIMBING:
                    str31 = C0352a.m900o(parcel, B);
                    hashSet.add(52);
                    break;
                case FitnessActivities.ROWING:
                    str32 = C0352a.m900o(parcel, B);
                    hashSet.add(53);
                    break;
                case FitnessActivities.ROWING_MACHINE:
                    str33 = C0352a.m900o(parcel, B);
                    hashSet.add(54);
                    break;
                case FitnessActivities.RUGBY:
                    str34 = C0352a.m900o(parcel, B);
                    hashSet.add(55);
                    break;
                case FitnessActivities.RUNNING_JOGGING:
                    str35 = C0352a.m900o(parcel, B);
                    hashSet.add(56);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1634nt(hashSet, i, ntVar, arrayList, ntVar2, str, str2, str3, arrayList2, i2, arrayList3, ntVar3, arrayList4, str4, str5, ntVar4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, ntVar5, str18, str19, str20, str21, ntVar6, d, ntVar7, d2, str22, ntVar8, arrayList6, str23, str24, str25, str26, ntVar9, str27, str28, str29, ntVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eS */
    public C1634nt[] newArray(int i) {
        return new C1634nt[i];
    }
}
