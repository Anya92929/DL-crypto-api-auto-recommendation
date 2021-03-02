package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0877a implements Parcelable.Creator<UserAddressRequest> {
    /* renamed from: a */
    static void m3783a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, userAddressRequest.getVersionCode());
        C0354b.m940c(parcel, 2, userAddressRequest.adz, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cp */
    public UserAddressRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<CountrySpecification> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, CountrySpecification.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new UserAddressRequest(i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dX */
    public UserAddressRequest[] newArray(int i) {
        return new UserAddressRequest[i];
    }
}
