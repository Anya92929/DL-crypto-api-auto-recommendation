package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0409ae;
import com.google.android.gms.internal.C0414ah;

/* renamed from: com.google.android.gms.internal.ag */
public class C0413ag implements Parcelable.Creator<C0414ah.C0416b> {
    /* renamed from: a */
    static void m855a(C0414ah.C0416b bVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, bVar.versionCode);
        C0359b.m672a(parcel, 2, bVar.f1004cH, false);
        C0359b.m671a(parcel, 3, (Parcelable) bVar.f1005cI, i, false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: j */
    public C0414ah.C0416b createFromParcel(Parcel parcel) {
        C0409ae.C0410a aVar = null;
        int c = C0357a.m634c(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 3:
                    aVar = (C0409ae.C0410a) C0357a.m628a(parcel, b, C0409ae.C0410a.CREATOR);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0414ah.C0416b(i, str, aVar);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: s */
    public C0414ah.C0416b[] newArray(int i) {
        return new C0414ah.C0416b[i];
    }
}
