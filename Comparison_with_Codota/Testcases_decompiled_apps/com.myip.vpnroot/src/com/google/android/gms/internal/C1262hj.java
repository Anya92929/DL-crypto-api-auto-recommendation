package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.hj */
public class C1262hj implements Parcelable.Creator<C1261hi> {
    /* renamed from: a */
    static void m4770a(C1261hi hiVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, hiVar.f3850Ce, false);
        C0354b.m939c(parcel, 1000, hiVar.f3849BR);
        C0354b.m923a(parcel, 3, (Parcelable) hiVar.f3851Cf, i, false);
        C0354b.m939c(parcel, 4, hiVar.f3852Cg);
        C0354b.m931a(parcel, 5, hiVar.f3853Ch, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: K */
    public C1261hi[] newArray(int i) {
        return new C1261hi[i];
    }

    /* renamed from: n */
    public C1261hi createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        int i2 = -1;
        C1271hq hqVar = null;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    hqVar = (C1271hq) C0352a.m880a(parcel, B, C1271hq.CREATOR);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    bArr = C0352a.m903r(parcel, B);
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
            return new C1261hi(i, str, hqVar, i2, bArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
