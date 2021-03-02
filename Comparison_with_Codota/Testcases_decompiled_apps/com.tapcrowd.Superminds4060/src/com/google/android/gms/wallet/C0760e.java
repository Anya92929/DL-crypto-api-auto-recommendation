package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.e */
public class C0760e implements Parcelable.Creator<LineItem> {
    /* renamed from: a */
    static void m2178a(LineItem lineItem, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, lineItem.getVersionCode());
        C0155b.m349a(parcel, 2, lineItem.description, false);
        C0155b.m349a(parcel, 3, lineItem.f1902tQ, false);
        C0155b.m349a(parcel, 4, lineItem.f1903tR, false);
        C0155b.m349a(parcel, 5, lineItem.f1900tD, false);
        C0155b.m359c(parcel, 6, lineItem.f1904tS);
        C0155b.m349a(parcel, 7, lineItem.f1901tE, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: R */
    public LineItem createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int j = C0153a.m320j(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i3);
                    break;
                case 2:
                    str5 = C0153a.m322l(parcel, i3);
                    break;
                case 3:
                    str4 = C0153a.m322l(parcel, i3);
                    break;
                case 4:
                    str3 = C0153a.m322l(parcel, i3);
                    break;
                case 5:
                    str2 = C0153a.m322l(parcel, i3);
                    break;
                case 6:
                    i = C0153a.m314f(parcel, i3);
                    break;
                case 7:
                    str = C0153a.m322l(parcel, i3);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: aw */
    public LineItem[] newArray(int i) {
        return new LineItem[i];
    }
}
