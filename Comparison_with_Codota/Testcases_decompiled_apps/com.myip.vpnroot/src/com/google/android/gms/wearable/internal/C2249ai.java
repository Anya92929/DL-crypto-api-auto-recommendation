package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.ai */
public class C2249ai implements Parcelable.Creator<C2248ah> {
    /* renamed from: a */
    static void m7601a(C2248ah ahVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, ahVar.f4671BR);
        C0354b.m939c(parcel, 2, ahVar.getRequestId());
        C0354b.m927a(parcel, 3, ahVar.getPath(), false);
        C0354b.m931a(parcel, 4, ahVar.getData(), false);
        C0354b.m927a(parcel, 5, ahVar.getSourceNodeId(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ec */
    public C2248ah createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        byte[] bArr = null;
        String str2 = null;
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
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2248ah(i2, i, str2, bArr, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ge */
    public C2248ah[] newArray(int i) {
        return new C2248ah[i];
    }
}
