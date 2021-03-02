package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.cf */
public class C0569cf implements Parcelable.Creator<C0556cc.C0558b> {
    /* renamed from: a */
    static void m1699a(C0556cc.C0558b bVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = bVar.mo5189bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, bVar.mo5202i());
        }
        if (bH.contains(2)) {
            C0359b.m671a(parcel, 2, (Parcelable) bVar.mo5190cl(), i, true);
        }
        if (bH.contains(3)) {
            C0359b.m671a(parcel, 3, (Parcelable) bVar.mo5191cm(), i, true);
        }
        if (bH.contains(4)) {
            C0359b.m682c(parcel, 4, bVar.getLayout());
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: A */
    public C0556cc.C0558b createFromParcel(Parcel parcel) {
        C0556cc.C0558b.C0560b bVar = null;
        int i = 0;
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        C0556cc.C0558b.C0559a aVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i2 = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    aVar = (C0556cc.C0558b.C0559a) C0357a.m628a(parcel, b, C0556cc.C0558b.C0559a.CREATOR);
                    break;
                case 3:
                    hashSet.add(3);
                    bVar = (C0556cc.C0558b.C0560b) C0357a.m628a(parcel, b, C0556cc.C0558b.C0560b.CREATOR);
                    break;
                case 4:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(4);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc.C0558b(hashSet, i2, aVar, bVar, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: aa */
    public C0556cc.C0558b[] newArray(int i) {
        return new C0556cc.C0558b[i];
    }
}
