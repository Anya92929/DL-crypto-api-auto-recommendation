package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.identity.intents.model.a */
public class C0878a implements Parcelable.Creator<CountrySpecification> {
    /* renamed from: a */
    static void m3786a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, countrySpecification.getVersionCode());
        C0354b.m927a(parcel, 2, countrySpecification.f2402uW, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cq */
    public CountrySpecification createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CountrySpecification(i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dY */
    public CountrySpecification[] newArray(int i) {
        return new CountrySpecification[i];
    }
}
