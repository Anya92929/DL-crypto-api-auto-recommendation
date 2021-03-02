package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.internal.fp */
public class C0557fp implements Parcelable.Creator<C0555fn> {
    /* renamed from: a */
    static void m1673a(C0555fn fnVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m349a(parcel, 1, fnVar.getAccountName(), false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, fnVar.getVersionCode());
        C0155b.m355a(parcel, 2, fnVar.mo4851cZ(), false);
        C0155b.m355a(parcel, 3, fnVar.mo4852da(), false);
        C0155b.m355a(parcel, 4, fnVar.mo4853db(), false);
        C0155b.m349a(parcel, 5, fnVar.mo4854dc(), false);
        C0155b.m349a(parcel, 6, fnVar.mo4855dd(), false);
        C0155b.m349a(parcel, 7, fnVar.mo4856de(), false);
        C0155b.m349a(parcel, 8, fnVar.mo4858df(), false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: A */
    public C0555fn createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    str5 = C0153a.m322l(parcel, i2);
                    break;
                case 2:
                    strArr3 = C0153a.m333w(parcel, i2);
                    break;
                case 3:
                    strArr2 = C0153a.m333w(parcel, i2);
                    break;
                case 4:
                    strArr = C0153a.m333w(parcel, i2);
                    break;
                case 5:
                    str4 = C0153a.m322l(parcel, i2);
                    break;
                case 6:
                    str3 = C0153a.m322l(parcel, i2);
                    break;
                case 7:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 8:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0153a.m314f(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0555fn(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: af */
    public C0555fn[] newArray(int i) {
        return new C0555fn[i];
    }
}
