package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.internal.al */
public class C0420al implements Parcelable.Creator<C0419ak> {
    /* renamed from: a */
    static void m893a(C0419ak akVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, akVar.mo4539i());
        C0359b.m670a(parcel, 2, akVar.mo4536al(), false);
        C0359b.m671a(parcel, 3, (Parcelable) akVar.mo4537am(), i, false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: m */
    public C0419ak createFromParcel(Parcel parcel) {
        C0414ah ahVar = null;
        int c = C0357a.m634c(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    parcel2 = C0357a.m659y(parcel, b);
                    break;
                case 3:
                    ahVar = (C0414ah) C0357a.m628a(parcel, b, C0414ah.CREATOR);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0419ak(i, parcel2, ahVar);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: v */
    public C0419ak[] newArray(int i) {
        return new C0419ak[i];
    }
}
