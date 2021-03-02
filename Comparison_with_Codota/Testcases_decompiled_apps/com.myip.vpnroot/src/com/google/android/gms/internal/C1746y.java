package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.y */
public class C1746y implements Parcelable.Creator<C1745x> {
    /* renamed from: a */
    static void m6228a(C1745x xVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, xVar.versionCode);
        C0354b.m930a(parcel, 2, xVar.f4409lX);
        C0354b.m930a(parcel, 3, xVar.f4410mh);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: a */
    public C1745x createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1745x(i, z2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: b */
    public C1745x[] newArray(int i) {
        return new C1745x[i];
    }
}
