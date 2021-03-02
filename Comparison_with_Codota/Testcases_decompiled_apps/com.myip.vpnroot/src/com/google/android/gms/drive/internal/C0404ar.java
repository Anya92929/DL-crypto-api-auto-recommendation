package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.internal.ar */
public class C0404ar implements Parcelable.Creator<OnResourceIdSetResponse> {
    /* renamed from: a */
    static void m1167a(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onResourceIdSetResponse.getVersionCode());
        C0354b.m938b(parcel, 2, onResourceIdSetResponse.mo4828hX(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: at */
    public OnResourceIdSetResponse createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OnResourceIdSetResponse(i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bF */
    public OnResourceIdSetResponse[] newArray(int i) {
        return new OnResourceIdSetResponse[i];
    }
}
