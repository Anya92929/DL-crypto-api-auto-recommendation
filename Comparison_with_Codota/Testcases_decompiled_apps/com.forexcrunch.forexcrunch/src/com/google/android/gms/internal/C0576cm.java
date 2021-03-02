package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.cm */
public class C0576cm implements Parcelable.Creator<C0556cc.C0566h> {
    /* renamed from: a */
    static void m1720a(C0556cc.C0566h hVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = hVar.mo5292bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, hVar.mo5304i());
        }
        if (bH.contains(3)) {
            C0359b.m682c(parcel, 3, hVar.mo5293cu());
        }
        if (bH.contains(4)) {
            C0359b.m672a(parcel, 4, hVar.getValue(), true);
        }
        if (bH.contains(5)) {
            C0359b.m672a(parcel, 5, hVar.getLabel(), true);
        }
        if (bH.contains(6)) {
            C0359b.m682c(parcel, 6, hVar.getType());
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: H */
    public C0556cc.C0566h createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i3 = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 3:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(3);
                    break;
                case 4:
                    str = C0357a.m645l(parcel, b);
                    hashSet.add(4);
                    break;
                case 5:
                    str2 = C0357a.m645l(parcel, b);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = C0357a.m639f(parcel, b);
                    hashSet.add(6);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc.C0566h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: ah */
    public C0556cc.C0566h[] newArray(int i) {
        return new C0556cc.C0566h[i];
    }
}
