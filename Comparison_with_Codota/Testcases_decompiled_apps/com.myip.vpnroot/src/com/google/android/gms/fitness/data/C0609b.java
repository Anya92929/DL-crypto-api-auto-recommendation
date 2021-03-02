package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.b */
public class C0609b implements Parcelable.Creator<C0608a> {
    /* renamed from: a */
    static void m1831a(C0608a aVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, aVar.getPackageName(), false);
        C0354b.m939c(parcel, 1000, aVar.getVersionCode());
        C0354b.m927a(parcel, 2, aVar.getVersion(), false);
        C0354b.m927a(parcel, 3, aVar.mo5781iz(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bi */
    public C0608a createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
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
            return new C0608a(i, str3, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cx */
    public C0608a[] newArray(int i) {
        return new C0608a[i];
    }
}
