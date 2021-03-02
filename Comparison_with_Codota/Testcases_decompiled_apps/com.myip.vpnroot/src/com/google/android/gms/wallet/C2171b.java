package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C2171b implements Parcelable.Creator<Cart> {
    /* renamed from: a */
    static void m7297a(Cart cart, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, cart.getVersionCode());
        C0354b.m927a(parcel, 2, cart.ask, false);
        C0354b.m927a(parcel, 3, cart.asl, false);
        C0354b.m940c(parcel, 4, cart.asm, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: do */
    public Cart createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<LineItem> arrayList = new ArrayList<>();
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    arrayList = C0352a.m887c(parcel, B, LineItem.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fo */
    public Cart[] newArray(int i) {
        return new Cart[i];
    }
}
