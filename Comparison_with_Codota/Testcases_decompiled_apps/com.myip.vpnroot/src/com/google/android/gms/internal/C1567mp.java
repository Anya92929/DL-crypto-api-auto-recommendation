package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.mp */
public class C1567mp implements Parcelable.Creator<C1566mo> {
    /* renamed from: a */
    static void m5624a(C1566mo moVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, moVar.f4288uO, false);
        C0354b.m939c(parcel, 1000, moVar.f4287BR);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cC */
    public C1566mo createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
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
            return new C1566mo(i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: er */
    public C1566mo[] newArray(int i) {
        return new C1566mo[i];
    }
}
