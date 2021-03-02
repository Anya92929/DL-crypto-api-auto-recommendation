package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.wearable.C2227c;

/* renamed from: com.google.android.gms.wearable.internal.s */
public class C2315s implements Parcelable.Creator<C2314r> {
    /* renamed from: a */
    static void m7747a(C2314r rVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, rVar.versionCode);
        C0354b.m939c(parcel, 2, rVar.statusCode);
        C0354b.m923a(parcel, 3, (Parcelable) rVar.avm, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dW */
    public C2314r createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        C2227c cVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    cVar = (C2227c) C0352a.m880a(parcel, B, C2227c.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2314r(i2, i, cVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fY */
    public C2314r[] newArray(int i) {
        return new C2314r[i];
    }
}
