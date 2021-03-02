package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.mj */
public class C1561mj implements Parcelable.Creator<C1560mi> {
    /* renamed from: a */
    static void m5612a(C1560mi miVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, miVar.afg, false);
        C0354b.m939c(parcel, 1000, miVar.f4284BR);
        C0354b.m927a(parcel, 2, miVar.mo9406mg(), false);
        C0354b.m930a(parcel, 3, miVar.mo9407mh());
        C0354b.m940c(parcel, 4, miVar.afj, false);
        C0354b.m938b(parcel, 6, miVar.afk, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cz */
    public C1560mi createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList<String> arrayList = null;
        int C = C0352a.m875C(parcel);
        ArrayList arrayList2 = null;
        String str = null;
        ArrayList arrayList3 = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList3 = C0352a.m887c(parcel, B, C1566mo.CREATOR);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    arrayList2 = C0352a.m887c(parcel, B, C1570ms.CREATOR);
                    break;
                case 6:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1560mi(i, arrayList3, str, z, arrayList2, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eo */
    public C1560mi[] newArray(int i) {
        return new C1560mi[i];
    }
}
