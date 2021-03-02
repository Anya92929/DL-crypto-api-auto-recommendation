package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.q */
public class C2313q implements Parcelable.Creator<C2312p> {
    /* renamed from: a */
    static void m7744a(C2312p pVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, pVar.versionCode);
        C0354b.m939c(parcel, 2, pVar.statusCode);
        C0354b.m939c(parcel, 3, pVar.avl);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dV */
    public C2312p createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2312p(i3, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fX */
    public C2312p[] newArray(int i) {
        return new C2312p[i];
    }
}
