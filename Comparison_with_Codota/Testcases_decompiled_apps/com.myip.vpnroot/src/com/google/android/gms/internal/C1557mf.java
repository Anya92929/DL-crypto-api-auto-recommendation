package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.mf */
public class C1557mf implements Parcelable.Creator<C1556me> {
    /* renamed from: a */
    static void m5600a(C1556me meVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m930a(parcel, 1, meVar.mo9383mc());
        C0354b.m939c(parcel, 1000, meVar.f4282BR);
        C0354b.m940c(parcel, 2, meVar.mo9384md(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cx */
    public C1556me createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, C1566mo.CREATOR);
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
            return new C1556me(i, z, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: em */
    public C1556me[] newArray(int i) {
        return new C1556me[i];
    }
}
