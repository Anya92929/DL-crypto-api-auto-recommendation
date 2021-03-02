package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.internal.n */
public class C0429n implements Parcelable.Creator<DisconnectRequest> {
    /* renamed from: a */
    static void m1249a(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, disconnectRequest.f917BR);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: af */
    public DisconnectRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new DisconnectRequest(i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bp */
    public DisconnectRequest[] newArray(int i) {
        return new DisconnectRequest[i];
    }
}
