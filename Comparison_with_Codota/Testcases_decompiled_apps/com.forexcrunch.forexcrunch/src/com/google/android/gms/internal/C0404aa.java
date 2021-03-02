package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.internal.aa */
public class C0404aa implements Parcelable.Creator<C0628z> {
    /* renamed from: a */
    static void m796a(C0628z zVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, zVar.mo5518i());
        C0359b.m671a(parcel, 2, (Parcelable) zVar.mo5515O(), i, false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: f */
    public C0628z createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
        int i = 0;
        C0405ab abVar = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    abVar = (C0405ab) C0357a.m628a(parcel, b, C0405ab.CREATOR);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0628z(i, abVar);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: o */
    public C0628z[] newArray(int i) {
        return new C0628z[i];
    }
}
