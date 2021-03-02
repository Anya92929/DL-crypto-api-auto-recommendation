package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.jq */
public class C1381jq implements Parcelable.Creator<C1380jp> {
    /* renamed from: a */
    static void m5197a(C1380jp jpVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, jpVar.getVersionCode());
        C0354b.m922a(parcel, 2, jpVar.mo9079hx(), false);
        C0354b.m923a(parcel, 3, (Parcelable) jpVar.mo9080hy(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: M */
    public C1380jp createFromParcel(Parcel parcel) {
        C1375jm jmVar = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    parcel2 = C0352a.m877D(parcel, B);
                    break;
                case 3:
                    jmVar = (C1375jm) C0352a.m880a(parcel, B, C1375jm.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1380jp(i, parcel2, jmVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aM */
    public C1380jp[] newArray(int i) {
        return new C1380jp[i];
    }
}
