package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.fy */
public class C0576fy implements Parcelable.Creator<C0563fv.C0565b> {
    /* renamed from: a */
    static void m1803a(C0563fv.C0565b bVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = bVar.mo5109di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, bVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m348a(parcel, 2, (Parcelable) bVar.mo5105dM(), i, true);
        }
        if (di.contains(3)) {
            C0155b.m348a(parcel, 3, (Parcelable) bVar.mo5106dN(), i, true);
        }
        if (di.contains(4)) {
            C0155b.m359c(parcel, 4, bVar.getLayout());
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: F */
    public C0563fv.C0565b createFromParcel(Parcel parcel) {
        C0563fv.C0565b.C0567b bVar = null;
        int i = 0;
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        C0563fv.C0565b.C0566a aVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i3);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    aVar = (C0563fv.C0565b.C0566a) C0153a.m305a(parcel, i3, C0563fv.C0565b.C0566a.CREATOR);
                    break;
                case 3:
                    hashSet.add(3);
                    bVar = (C0563fv.C0565b.C0567b) C0153a.m305a(parcel, i3, C0563fv.C0565b.C0567b.CREATOR);
                    break;
                case 4:
                    i = C0153a.m314f(parcel, i3);
                    hashSet.add(4);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0563fv.C0565b(hashSet, i2, aVar, bVar, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ak */
    public C0563fv.C0565b[] newArray(int i) {
        return new C0563fv.C0565b[i];
    }
}
