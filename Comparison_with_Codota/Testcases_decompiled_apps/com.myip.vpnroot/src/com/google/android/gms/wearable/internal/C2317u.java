package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.wearable.C2227c;

/* renamed from: com.google.android.gms.wearable.internal.u */
public class C2317u implements Parcelable.Creator<C2316t> {
    /* renamed from: a */
    static void m7750a(C2316t tVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, tVar.versionCode);
        C0354b.m939c(parcel, 2, tVar.statusCode);
        C0354b.m933a(parcel, 3, (T[]) tVar.avn, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dX */
    public C2316t createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        C2227c[] cVarArr = null;
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
                    cVarArr = (C2227c[]) C0352a.m886b(parcel, B, C2227c.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2316t(i2, i, cVarArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fZ */
    public C2316t[] newArray(int i) {
        return new C2316t[i];
    }
}
