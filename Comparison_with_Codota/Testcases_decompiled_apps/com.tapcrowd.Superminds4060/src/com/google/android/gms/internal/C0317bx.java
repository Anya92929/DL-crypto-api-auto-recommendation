package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.bx */
public class C0317bx implements Parcelable.Creator<C0316bw> {
    /* renamed from: a */
    static void m647a(C0316bw bwVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, bwVar.versionCode);
        C0155b.m349a(parcel, 2, bwVar.f928fW, false);
        C0155b.m349a(parcel, 3, bwVar.f930gG, false);
        C0155b.m350a(parcel, 4, bwVar.f926eW, false);
        C0155b.m359c(parcel, 5, bwVar.errorCode);
        C0155b.m350a(parcel, 6, bwVar.f927eX, false);
        C0155b.m344a(parcel, 7, bwVar.f931gH);
        C0155b.m352a(parcel, 8, bwVar.f932gI);
        C0155b.m344a(parcel, 9, bwVar.f933gJ);
        C0155b.m350a(parcel, 10, bwVar.f934gK, false);
        C0155b.m344a(parcel, 11, bwVar.f929fa);
        C0155b.m359c(parcel, 12, bwVar.orientation);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: f */
    public C0316bw createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        int i2 = 0;
        ArrayList<String> arrayList2 = null;
        long j2 = 0;
        boolean z = false;
        long j3 = 0;
        ArrayList<String> arrayList3 = null;
        long j4 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i4);
                    break;
                case 3:
                    str2 = C0153a.m322l(parcel, i4);
                    break;
                case 4:
                    arrayList = C0153a.m334x(parcel, i4);
                    break;
                case 5:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 6:
                    arrayList2 = C0153a.m334x(parcel, i4);
                    break;
                case 7:
                    j2 = C0153a.m315g(parcel, i4);
                    break;
                case 8:
                    z = C0153a.m311c(parcel, i4);
                    break;
                case 9:
                    j3 = C0153a.m315g(parcel, i4);
                    break;
                case 10:
                    arrayList3 = C0153a.m334x(parcel, i4);
                    break;
                case 11:
                    j4 = C0153a.m315g(parcel, i4);
                    break;
                case 12:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0316bw(i, str, str2, arrayList, i2, arrayList2, j2, z, j3, arrayList3, j4, i3);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: j */
    public C0316bw[] newArray(int i) {
        return new C0316bw[i];
    }
}
