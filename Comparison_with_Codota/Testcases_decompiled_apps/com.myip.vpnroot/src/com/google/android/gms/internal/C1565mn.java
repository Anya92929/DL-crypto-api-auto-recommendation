package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.mn */
public class C1565mn implements Parcelable.Creator<C1564mm> {
    /* renamed from: a */
    static void m5620a(C1564mm mmVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, mmVar.f4286BR);
        C0354b.m923a(parcel, 2, (Parcelable) mmVar.mo9430mf(), i, false);
        C0354b.m919a(parcel, 3, mmVar.getInterval());
        C0354b.m939c(parcel, 4, mmVar.getPriority());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cB */
    public C1564mm createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        C1560mi miVar = null;
        long j = C1564mm.afp;
        int i2 = 102;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 2:
                    miVar = (C1560mi) C0352a.m880a(parcel, B, C1560mi.CREATOR);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
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
            return new C1564mm(i, miVar, j, i2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eq */
    public C1564mm[] newArray(int i) {
        return new C1564mm[i];
    }
}
