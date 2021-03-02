package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.w */
public class C0621w implements Parcelable.Creator<C0620v> {
    /* renamed from: a */
    static void m1955a(C0620v vVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, vVar.versionCode);
        C0155b.m344a(parcel, 2, vVar.f1577es);
        C0155b.m345a(parcel, 3, vVar.extras, false);
        C0155b.m359c(parcel, 4, vVar.f1578et);
        C0155b.m350a(parcel, 5, vVar.f1579eu, false);
        C0155b.m352a(parcel, 6, vVar.f1580ev);
        C0155b.m359c(parcel, 7, vVar.tagForChildDirectedTreatment);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: a */
    public C0620v createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        int i = 0;
        int j = C0153a.m320j(parcel);
        long j2 = 0;
        boolean z = false;
        int i2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    j2 = C0153a.m315g(parcel, i4);
                    break;
                case 3:
                    bundle = C0153a.m324n(parcel, i4);
                    break;
                case 4:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 5:
                    arrayList = C0153a.m334x(parcel, i4);
                    break;
                case 6:
                    z = C0153a.m311c(parcel, i4);
                    break;
                case 7:
                    i = C0153a.m314f(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0620v(i3, j2, bundle, i2, arrayList, z, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: b */
    public C0620v[] newArray(int i) {
        return new C0620v[i];
    }
}
