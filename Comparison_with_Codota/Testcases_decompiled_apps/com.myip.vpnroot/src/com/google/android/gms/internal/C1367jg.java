package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1365jf;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.jg */
public class C1367jg implements Parcelable.Creator<C1365jf> {
    /* renamed from: a */
    static void m5114a(C1365jf jfVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, jfVar.getVersionCode());
        C0354b.m940c(parcel, 2, jfVar.mo9002hc(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: G */
    public C1365jf createFromParcel(Parcel parcel) {
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
                    arrayList = C0352a.m887c(parcel, B, C1365jf.C1366a.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1365jf(i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aG */
    public C1365jf[] newArray(int i) {
        return new C1365jf[i];
    }
}
