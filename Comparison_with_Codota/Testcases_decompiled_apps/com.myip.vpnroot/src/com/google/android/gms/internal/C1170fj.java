package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.fj */
public class C1170fj implements Parcelable.Creator<C1168fi> {
    /* renamed from: a */
    static void m4458a(C1168fi fiVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, fiVar.versionCode);
        C0354b.m920a(parcel, 2, fiVar.f3538tw, false);
        C0354b.m923a(parcel, 3, (Parcelable) fiVar.f3539tx, i, false);
        C0354b.m923a(parcel, 4, (Parcelable) fiVar.f3530lH, i, false);
        C0354b.m927a(parcel, 5, fiVar.f3528lA, false);
        C0354b.m923a(parcel, 6, (Parcelable) fiVar.applicationInfo, i, false);
        C0354b.m923a(parcel, 7, (Parcelable) fiVar.f3540ty, i, false);
        C0354b.m927a(parcel, 8, fiVar.f3541tz, false);
        C0354b.m927a(parcel, 9, fiVar.f3532tA, false);
        C0354b.m927a(parcel, 10, fiVar.f3533tB, false);
        C0354b.m923a(parcel, 11, (Parcelable) fiVar.f3529lD, i, false);
        C0354b.m920a(parcel, 12, fiVar.f3534tC, false);
        C0354b.m939c(parcel, 13, fiVar.f3535tD);
        C0354b.m938b(parcel, 14, fiVar.f3531lS, false);
        C0354b.m920a(parcel, 15, fiVar.f3536tE, false);
        C0354b.m930a(parcel, 16, fiVar.f3537tF);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: h */
    public C1168fi createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        Bundle bundle = null;
        C0924av avVar = null;
        C0927ay ayVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        C1230gt gtVar = null;
        Bundle bundle2 = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        boolean z = false;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 3:
                    avVar = (C0924av) C0352a.m880a(parcel, B, C0924av.CREATOR);
                    break;
                case 4:
                    ayVar = (C0927ay) C0352a.m880a(parcel, B, C0927ay.CREATOR);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C0352a.m880a(parcel, B, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C0352a.m880a(parcel, B, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 10:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 11:
                    gtVar = (C1230gt) C0352a.m880a(parcel, B, C1230gt.CREATOR);
                    break;
                case 12:
                    bundle2 = C0352a.m902q(parcel, B);
                    break;
                case 13:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 14:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 15:
                    bundle3 = C0352a.m902q(parcel, B);
                    break;
                case 16:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1168fi(i, bundle, avVar, ayVar, str, applicationInfo, packageInfo, str2, str3, str4, gtVar, bundle2, i2, arrayList, bundle3, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: p */
    public C1168fi[] newArray(int i) {
        return new C1168fi[i];
    }
}
