package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1375jm;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.jn */
public class C1378jn implements Parcelable.Creator<C1375jm> {
    /* renamed from: a */
    static void m5174a(C1375jm jmVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, jmVar.getVersionCode());
        C0354b.m940c(parcel, 2, jmVar.mo9060hu(), false);
        C0354b.m927a(parcel, 3, jmVar.mo9061hv(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: K */
    public C1375jm createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, C1375jm.C1376a.CREATOR);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1375jm(i, arrayList, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aK */
    public C1375jm[] newArray(int i) {
        return new C1375jm[i];
    }
}
