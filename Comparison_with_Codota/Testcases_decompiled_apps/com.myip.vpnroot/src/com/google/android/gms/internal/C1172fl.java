package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.fl */
public class C1172fl implements Parcelable.Creator<C1171fk> {
    /* renamed from: a */
    static void m4461a(C1171fk fkVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, fkVar.versionCode);
        C0354b.m927a(parcel, 2, fkVar.f3558rP, false);
        C0354b.m927a(parcel, 3, fkVar.f3560tG, false);
        C0354b.m938b(parcel, 4, fkVar.f3555qf, false);
        C0354b.m939c(parcel, 5, fkVar.errorCode);
        C0354b.m938b(parcel, 6, fkVar.f3556qg, false);
        C0354b.m919a(parcel, 7, fkVar.f3561tH);
        C0354b.m930a(parcel, 8, fkVar.f3562tI);
        C0354b.m919a(parcel, 9, fkVar.f3563tJ);
        C0354b.m938b(parcel, 10, fkVar.f3564tK, false);
        C0354b.m919a(parcel, 11, fkVar.f3557qj);
        C0354b.m939c(parcel, 12, fkVar.orientation);
        C0354b.m927a(parcel, 13, fkVar.f3565tL, false);
        C0354b.m919a(parcel, 14, fkVar.f3566tM);
        C0354b.m927a(parcel, 15, fkVar.f3567tN, false);
        C0354b.m927a(parcel, 19, fkVar.f3569tP, false);
        C0354b.m930a(parcel, 18, fkVar.f3568tO);
        C0354b.m927a(parcel, 21, fkVar.f3570tQ, false);
        C0354b.m930a(parcel, 23, fkVar.f3572tS);
        C0354b.m930a(parcel, 22, fkVar.f3571tR);
        C0354b.m930a(parcel, 25, fkVar.f3573tT);
        C0354b.m930a(parcel, 24, fkVar.f3559tF);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: i */
    public C1171fk createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        int i2 = 0;
        ArrayList<String> arrayList2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        ArrayList<String> arrayList3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 5:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    arrayList2 = C0352a.m876C(parcel, B);
                    break;
                case 7:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 8:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 9:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 10:
                    arrayList3 = C0352a.m876C(parcel, B);
                    break;
                case 11:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 12:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 13:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 14:
                    j4 = C0352a.m894i(parcel, B);
                    break;
                case 15:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 18:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 19:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 21:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case FitnessActivities.CIRCUIT_TRAINING:
                    z3 = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.CRICKET:
                    z4 = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.DANCING:
                    z5 = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.ELLIPTICAL:
                    z6 = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1171fk(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: q */
    public C1171fk[] newArray(int i) {
        return new C1171fk[i];
    }
}
