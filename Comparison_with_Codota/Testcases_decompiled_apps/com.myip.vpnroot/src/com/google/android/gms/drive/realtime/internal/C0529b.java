package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.b */
public class C0529b implements Parcelable.Creator<EndCompoundOperationRequest> {
    /* renamed from: a */
    static void m1527a(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, endCompoundOperationRequest.f1167BR);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aV */
    public EndCompoundOperationRequest createFromParcel(Parcel parcel) {
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
            return new EndCompoundOperationRequest(i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ch */
    public EndCompoundOperationRequest[] newArray(int i) {
        return new EndCompoundOperationRequest[i];
    }
}
