package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.on */
public class C1667on implements Parcelable.Creator<C1666om> {
    /* renamed from: a */
    static void m5846a(C1666om omVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, omVar.getVersionCode());
        C0354b.m932a(parcel, 2, omVar.atC, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dB */
    public C1666om createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    iArr = C0352a.m906u(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1666om(i, iArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fB */
    public C1666om[] newArray(int i) {
        return new C1666om[i];
    }
}
