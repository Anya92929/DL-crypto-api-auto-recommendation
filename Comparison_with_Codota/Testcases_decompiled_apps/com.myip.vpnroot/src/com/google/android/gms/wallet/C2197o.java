package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.o */
public class C2197o implements Parcelable.Creator<ProxyCard> {
    /* renamed from: a */
    static void m7417a(ProxyCard proxyCard, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, proxyCard.getVersionCode());
        C0354b.m927a(parcel, 2, proxyCard.atu, false);
        C0354b.m927a(parcel, 3, proxyCard.atv, false);
        C0354b.m939c(parcel, 4, proxyCard.atw);
        C0354b.m939c(parcel, 5, proxyCard.atx);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dA */
    public ProxyCard createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fA */
    public ProxyCard[] newArray(int i) {
        return new ProxyCard[i];
    }
}
