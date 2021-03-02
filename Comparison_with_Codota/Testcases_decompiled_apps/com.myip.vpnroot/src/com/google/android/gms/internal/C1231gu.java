package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.gu */
public class C1231gu implements Parcelable.Creator<C1230gt> {
    /* renamed from: a */
    static void m4685a(C1230gt gtVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, gtVar.versionCode);
        C0354b.m927a(parcel, 2, gtVar.f3777wD, false);
        C0354b.m939c(parcel, 3, gtVar.f3778wE);
        C0354b.m939c(parcel, 4, gtVar.f3779wF);
        C0354b.m930a(parcel, 5, gtVar.f3780wG);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: j */
    public C1230gt createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1230gt(i3, str, i2, i, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: v */
    public C1230gt[] newArray(int i) {
        return new C1230gt[i];
    }
}
