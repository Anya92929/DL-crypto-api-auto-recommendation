package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.request.y */
public class C0689y implements Parcelable.Creator<C0686x> {
    /* renamed from: a */
    static void m2076a(C0686x xVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, xVar.getName(), false);
        C0354b.m939c(parcel, 1000, xVar.getVersionCode());
        C0354b.m927a(parcel, 2, xVar.getIdentifier(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bO */
    public C0686x createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 2:
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
            return new C0686x(i, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dg */
    public C0686x[] newArray(int i) {
        return new C0686x[i];
    }
}
