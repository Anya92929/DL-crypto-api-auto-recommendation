package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C0757b implements Parcelable.Creator<Cart> {
    /* renamed from: a */
    static void m2169a(Cart cart, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, cart.getVersionCode());
        C0155b.m349a(parcel, 2, cart.f1882tD, false);
        C0155b.m349a(parcel, 3, cart.f1883tE, false);
        C0155b.m358b(parcel, 4, cart.f1884tF, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: O */
    public Cart createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        ArrayList<LineItem> arrayList = new ArrayList<>();
        String str2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 4:
                    arrayList = C0153a.m310c(parcel, i2, LineItem.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: at */
    public Cart[] newArray(int i) {
        return new Cart[i];
    }
}
