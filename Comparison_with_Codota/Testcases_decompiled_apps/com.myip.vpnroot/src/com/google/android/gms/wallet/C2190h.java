package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.h */
public class C2190h implements Parcelable.Creator<InstrumentInfo> {
    /* renamed from: a */
    static void m7396a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, instrumentInfo.getVersionCode());
        C0354b.m927a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        C0354b.m927a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dt */
    public InstrumentInfo createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
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
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new InstrumentInfo(i, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ft */
    public InstrumentInfo[] newArray(int i) {
        return new InstrumentInfo[i];
    }
}
