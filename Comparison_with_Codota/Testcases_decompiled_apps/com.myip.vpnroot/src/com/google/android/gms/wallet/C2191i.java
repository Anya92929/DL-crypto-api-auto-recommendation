package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.i */
public class C2191i implements Parcelable.Creator<LineItem> {
    /* renamed from: a */
    static void m7399a(LineItem lineItem, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, lineItem.getVersionCode());
        C0354b.m927a(parcel, 2, lineItem.description, false);
        C0354b.m927a(parcel, 3, lineItem.asE, false);
        C0354b.m927a(parcel, 4, lineItem.asF, false);
        C0354b.m927a(parcel, 5, lineItem.ask, false);
        C0354b.m939c(parcel, 6, lineItem.asG);
        C0354b.m927a(parcel, 7, lineItem.asl, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: du */
    public LineItem createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fu */
    public LineItem[] newArray(int i) {
        return new LineItem[i];
    }
}
