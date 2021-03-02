package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.i */
public class C0764i implements Parcelable.Creator<NotifyTransactionStatusRequest> {
    /* renamed from: a */
    static void m2190a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, notifyTransactionStatusRequest.f1933iM);
        C0155b.m349a(parcel, 2, notifyTransactionStatusRequest.f1934tH, false);
        C0155b.m359c(parcel, 3, notifyTransactionStatusRequest.status);
        C0155b.m349a(parcel, 4, notifyTransactionStatusRequest.f1935uj, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: V */
    public NotifyTransactionStatusRequest createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int j = C0153a.m320j(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i3);
                    break;
                case 2:
                    str2 = C0153a.m322l(parcel, i3);
                    break;
                case 3:
                    i = C0153a.m314f(parcel, i3);
                    break;
                case 4:
                    str = C0153a.m322l(parcel, i3);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: aA */
    public NotifyTransactionStatusRequest[] newArray(int i) {
        return new NotifyTransactionStatusRequest[i];
    }
}
