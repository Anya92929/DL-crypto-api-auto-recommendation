package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1369ji;

/* renamed from: com.google.android.gms.internal.jk */
public class C1373jk implements Parcelable.Creator<C1369ji.C1370a> {
    /* renamed from: a */
    static void m5158a(C1369ji.C1370a aVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, aVar.getVersionCode());
        C0354b.m939c(parcel, 2, aVar.mo9031hd());
        C0354b.m930a(parcel, 3, aVar.mo9034hj());
        C0354b.m939c(parcel, 4, aVar.mo9032he());
        C0354b.m930a(parcel, 5, aVar.mo9035hk());
        C0354b.m927a(parcel, 6, aVar.mo9036hl(), false);
        C0354b.m939c(parcel, 7, aVar.mo9037hm());
        C0354b.m927a(parcel, 8, aVar.mo9039ho(), false);
        C0354b.m923a(parcel, 9, (Parcelable) aVar.mo9041hq(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: I */
    public C1369ji.C1370a createFromParcel(Parcel parcel) {
        C1363jd jdVar = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 6:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    jdVar = (C1363jd) C0352a.m880a(parcel, B, C1363jd.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1369ji.C1370a(i4, i3, z2, i2, z, str2, i, str, jdVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aI */
    public C1369ji.C1370a[] newArray(int i) {
        return new C1369ji.C1370a[i];
    }
}
