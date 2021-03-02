package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.ls */
public class C1517ls implements Parcelable.Creator<C1516lr> {
    /* renamed from: a */
    static void m5463a(C1516lr lrVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, lrVar.uid);
        C0354b.m939c(parcel, 1000, lrVar.getVersionCode());
        C0354b.m927a(parcel, 2, lrVar.packageName, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cu */
    public C1516lr createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1516lr(i2, i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eh */
    public C1516lr[] newArray(int i) {
        return new C1516lr[i];
    }
}
