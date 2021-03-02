package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.nj */
public class C1607nj implements Parcelable.Creator<C1603nh> {
    /* renamed from: a */
    static void m5697a(C1603nh nhVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, nhVar.versionCode);
        C0354b.m919a(parcel, 2, nhVar.akw);
        C0354b.m927a(parcel, 3, nhVar.tag, false);
        C0354b.m931a(parcel, 4, nhVar.akx, false);
        C0354b.m920a(parcel, 5, nhVar.aky, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cX */
    public C1603nh createFromParcel(Parcel parcel) {
        Bundle bundle = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 5:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1603nh(i, j, str, bArr, bundle);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eN */
    public C1603nh[] newArray(int i) {
        return new C1603nh[i];
    }
}
