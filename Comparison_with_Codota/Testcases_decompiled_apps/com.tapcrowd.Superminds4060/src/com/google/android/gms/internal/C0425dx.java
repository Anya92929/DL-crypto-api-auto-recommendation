package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0422dw;

/* renamed from: com.google.android.gms.internal.dx */
public class C0425dx implements Parcelable.Creator<C0422dw.C0423a> {
    /* renamed from: a */
    static void m1017a(C0422dw.C0423a aVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, aVar.getVersionCode());
        C0155b.m359c(parcel, 2, aVar.mo4441bn());
        C0155b.m352a(parcel, 3, aVar.mo4444bt());
        C0155b.m359c(parcel, 4, aVar.mo4442bo());
        C0155b.m352a(parcel, 5, aVar.mo4445bu());
        C0155b.m349a(parcel, 6, aVar.mo4446bv(), false);
        C0155b.m359c(parcel, 7, aVar.mo4447bw());
        C0155b.m349a(parcel, 8, aVar.mo4449by(), false);
        C0155b.m348a(parcel, 9, (Parcelable) aVar.mo4439bA(), i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: C */
    public C0422dw.C0423a[] newArray(int i) {
        return new C0422dw.C0423a[i];
    }

    /* renamed from: o */
    public C0422dw.C0423a createFromParcel(Parcel parcel) {
        C0416dr drVar = null;
        int i = 0;
        int j = C0153a.m320j(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < j) {
            int i5 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i5)) {
                case 1:
                    i4 = C0153a.m314f(parcel, i5);
                    break;
                case 2:
                    i3 = C0153a.m314f(parcel, i5);
                    break;
                case 3:
                    z2 = C0153a.m311c(parcel, i5);
                    break;
                case 4:
                    i2 = C0153a.m314f(parcel, i5);
                    break;
                case 5:
                    z = C0153a.m311c(parcel, i5);
                    break;
                case 6:
                    str2 = C0153a.m322l(parcel, i5);
                    break;
                case 7:
                    i = C0153a.m314f(parcel, i5);
                    break;
                case 8:
                    str = C0153a.m322l(parcel, i5);
                    break;
                case 9:
                    drVar = (C0416dr) C0153a.m305a(parcel, i5, C0416dr.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0422dw.C0423a(i4, i3, z2, i2, z, str2, i, str, drVar);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
