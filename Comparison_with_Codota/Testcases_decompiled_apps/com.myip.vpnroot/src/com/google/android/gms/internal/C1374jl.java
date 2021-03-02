package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1369ji;
import com.google.android.gms.internal.C1375jm;

/* renamed from: com.google.android.gms.internal.jl */
public class C1374jl implements Parcelable.Creator<C1375jm.C1377b> {
    /* renamed from: a */
    static void m5161a(C1375jm.C1377b bVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, bVar.versionCode);
        C0354b.m927a(parcel, 2, bVar.f4128fv, false);
        C0354b.m923a(parcel, 3, (Parcelable) bVar.f4127ME, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: J */
    public C1375jm.C1377b createFromParcel(Parcel parcel) {
        C1369ji.C1370a aVar = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    aVar = (C1369ji.C1370a) C0352a.m880a(parcel, B, C1369ji.C1370a.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1375jm.C1377b(i, str, aVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aJ */
    public C1375jm.C1377b[] newArray(int i) {
        return new C1375jm.C1377b[i];
    }
}
