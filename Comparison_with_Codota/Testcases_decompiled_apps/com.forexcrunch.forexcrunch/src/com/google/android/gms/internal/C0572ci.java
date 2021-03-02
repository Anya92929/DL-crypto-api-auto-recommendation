package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ci */
public class C0572ci implements Parcelable.Creator<C0556cc.C0561c> {
    /* renamed from: a */
    static void m1708a(C0556cc.C0561c cVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = cVar.mo5228bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, cVar.mo5235i());
        }
        if (bH.contains(2)) {
            C0359b.m672a(parcel, 2, cVar.getUrl(), true);
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: D */
    public C0556cc.C0561c createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    str = C0357a.m645l(parcel, b);
                    hashSet.add(2);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc.C0561c(hashSet, i, str);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: ad */
    public C0556cc.C0561c[] newArray(int i) {
        return new C0556cc.C0561c[i];
    }
}
