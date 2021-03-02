package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0405ab;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ac */
public class C0407ac implements Parcelable.Creator<C0405ab> {
    /* renamed from: a */
    static void m807a(C0405ab abVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, abVar.mo4463i());
        C0359b.m681b(parcel, 2, abVar.mo4456Q(), false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: g */
    public C0405ab createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    arrayList = C0357a.m635c(parcel, b, C0405ab.C0406a.CREATOR);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0405ab(i, arrayList);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: p */
    public C0405ab[] newArray(int i) {
        return new C0405ab[i];
    }
}
