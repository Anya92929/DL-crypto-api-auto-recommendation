package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.ml */
public class C1563ml implements Parcelable.Creator<C1562mk> {
    /* renamed from: a */
    static void m5616a(C1562mk mkVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, mkVar.f4285BR);
        C0354b.m927a(parcel, 2, mkVar.mo9418mi(), false);
        C0354b.m927a(parcel, 3, mkVar.getTag(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cA */
    public C1562mk createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1562mk(i, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ep */
    public C1562mk[] newArray(int i) {
        return new C1562mk[i];
    }
}
