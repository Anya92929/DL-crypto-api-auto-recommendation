package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.op */
public class C1669op implements Parcelable.Creator<C1668oo> {
    /* renamed from: a */
    static void m5849a(C1668oo ooVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, ooVar.getVersionCode());
        C0354b.m934a(parcel, 2, ooVar.atD, false);
        C0354b.m935a(parcel, 3, ooVar.atE, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dC */
    public C1668oo createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        byte[][] bArr = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    strArr = C0352a.m872A(parcel, B);
                    break;
                case 3:
                    bArr = C0352a.m904s(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1668oo(i, strArr, bArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fC */
    public C1668oo[] newArray(int i) {
        return new C1668oo[i];
    }
}
