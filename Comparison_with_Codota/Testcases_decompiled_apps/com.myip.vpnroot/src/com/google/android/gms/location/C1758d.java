package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.location.d */
public class C1758d implements Parcelable.Creator<C1757c> {
    /* renamed from: a */
    static void m6254a(C1757c cVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, cVar.aem);
        C0354b.m939c(parcel, 1000, cVar.getVersionCode());
        C0354b.m939c(parcel, 2, cVar.aen);
        C0354b.m919a(parcel, 3, cVar.aeo);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ct */
    public C1757c createFromParcel(Parcel parcel) {
        int i = 1;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
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
            return new C1757c(i2, i3, i, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eg */
    public C1757c[] newArray(int i) {
        return new C1757c[i];
    }
}
