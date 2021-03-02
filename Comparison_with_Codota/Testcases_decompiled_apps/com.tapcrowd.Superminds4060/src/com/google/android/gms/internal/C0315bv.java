package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.internal.bv */
public class C0315bv implements Parcelable.Creator<C0313bu> {
    /* renamed from: a */
    static void m644a(C0313bu buVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, buVar.versionCode);
        C0155b.m345a(parcel, 2, buVar.f913gA, false);
        C0155b.m348a(parcel, 3, (Parcelable) buVar.f914gB, i, false);
        C0155b.m348a(parcel, 4, (Parcelable) buVar.f911ed, i, false);
        C0155b.m349a(parcel, 5, buVar.adUnitId, false);
        C0155b.m348a(parcel, 6, (Parcelable) buVar.applicationInfo, i, false);
        C0155b.m348a(parcel, 7, (Parcelable) buVar.f915gC, i, false);
        C0155b.m349a(parcel, 8, buVar.f916gD, false);
        C0155b.m349a(parcel, 9, buVar.f917gE, false);
        C0155b.m349a(parcel, 10, buVar.f918gF, false);
        C0155b.m348a(parcel, 11, (Parcelable) buVar.f912eg, i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: e */
    public C0313bu createFromParcel(Parcel parcel) {
        C0345co coVar = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        PackageInfo packageInfo = null;
        ApplicationInfo applicationInfo = null;
        String str4 = null;
        C0622x xVar = null;
        C0620v vVar = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    bundle = C0153a.m324n(parcel, i2);
                    break;
                case 3:
                    vVar = (C0620v) C0153a.m305a(parcel, i2, C0620v.CREATOR);
                    break;
                case 4:
                    xVar = (C0622x) C0153a.m305a(parcel, i2, C0622x.CREATOR);
                    break;
                case 5:
                    str4 = C0153a.m322l(parcel, i2);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C0153a.m305a(parcel, i2, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C0153a.m305a(parcel, i2, PackageInfo.CREATOR);
                    break;
                case 8:
                    str3 = C0153a.m322l(parcel, i2);
                    break;
                case 9:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 10:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 11:
                    coVar = (C0345co) C0153a.m305a(parcel, i2, C0345co.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0313bu(i, bundle, vVar, xVar, str4, applicationInfo, packageInfo, str3, str2, str, coVar);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: i */
    public C0313bu[] newArray(int i) {
        return new C0313bu[i];
    }
}
