package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0405ab;

/* renamed from: com.google.android.gms.internal.ad */
public class C0408ad implements Parcelable.Creator<C0405ab.C0406a> {
    /* renamed from: a */
    static void m810a(C0405ab.C0406a aVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, aVar.versionCode);
        C0359b.m672a(parcel, 2, aVar.f986cr, false);
        C0359b.m682c(parcel, 3, aVar.f987cs);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: h */
    public C0405ab.C0406a createFromParcel(Parcel parcel) {
        int i = 0;
        int c = C0357a.m634c(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 3:
                    i = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0405ab.C0406a(i2, str, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: q */
    public C0405ab.C0406a[] newArray(int i) {
        return new C0405ab.C0406a[i];
    }
}
