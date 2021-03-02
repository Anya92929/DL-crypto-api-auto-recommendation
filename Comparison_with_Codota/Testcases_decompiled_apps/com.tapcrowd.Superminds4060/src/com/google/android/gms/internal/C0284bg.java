package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.internal.bg */
public class C0284bg implements Parcelable.Creator<C0285bh> {
    /* renamed from: a */
    static void m577a(C0285bh bhVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, bhVar.versionCode);
        C0155b.m348a(parcel, 2, (Parcelable) bhVar.f861fR, i, false);
        C0155b.m346a(parcel, 3, bhVar.mo4119U(), false);
        C0155b.m346a(parcel, 4, bhVar.mo4120V(), false);
        C0155b.m346a(parcel, 5, bhVar.mo4121W(), false);
        C0155b.m346a(parcel, 6, bhVar.mo4122X(), false);
        C0155b.m349a(parcel, 7, bhVar.f866fW, false);
        C0155b.m352a(parcel, 8, bhVar.f867fX);
        C0155b.m349a(parcel, 9, bhVar.f868fY, false);
        C0155b.m346a(parcel, 10, bhVar.mo4123Y(), false);
        C0155b.m359c(parcel, 11, bhVar.orientation);
        C0155b.m359c(parcel, 12, bhVar.f871ga);
        C0155b.m349a(parcel, 13, bhVar.f870fz, false);
        C0155b.m348a(parcel, 14, (Parcelable) bhVar.f860eg, i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: d */
    public C0285bh createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        int i = 0;
        C0279be beVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        C0345co coVar = null;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    beVar = (C0279be) C0153a.m305a(parcel, i4, C0279be.CREATOR);
                    break;
                case 3:
                    iBinder = C0153a.m323m(parcel, i4);
                    break;
                case 4:
                    iBinder2 = C0153a.m323m(parcel, i4);
                    break;
                case 5:
                    iBinder3 = C0153a.m323m(parcel, i4);
                    break;
                case 6:
                    iBinder4 = C0153a.m323m(parcel, i4);
                    break;
                case 7:
                    str = C0153a.m322l(parcel, i4);
                    break;
                case 8:
                    z = C0153a.m311c(parcel, i4);
                    break;
                case 9:
                    str2 = C0153a.m322l(parcel, i4);
                    break;
                case 10:
                    iBinder5 = C0153a.m323m(parcel, i4);
                    break;
                case 11:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 12:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                case 13:
                    str3 = C0153a.m322l(parcel, i4);
                    break;
                case 14:
                    coVar = (C0345co) C0153a.m305a(parcel, i4, C0345co.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0285bh(i, beVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, coVar);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: h */
    public C0285bh[] newArray(int i) {
        return new C0285bh[i];
    }
}
