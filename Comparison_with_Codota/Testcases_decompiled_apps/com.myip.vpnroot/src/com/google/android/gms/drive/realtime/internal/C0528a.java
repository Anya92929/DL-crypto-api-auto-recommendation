package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.a */
public class C0528a implements Parcelable.Creator<BeginCompoundOperationRequest> {
    /* renamed from: a */
    static void m1524a(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, beginCompoundOperationRequest.f1164BR);
        C0354b.m930a(parcel, 2, beginCompoundOperationRequest.f1165Ra);
        C0354b.m927a(parcel, 3, beginCompoundOperationRequest.mName, false);
        C0354b.m930a(parcel, 4, beginCompoundOperationRequest.f1166Rb);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aU */
    public BeginCompoundOperationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        String str = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cg */
    public BeginCompoundOperationRequest[] newArray(int i) {
        return new BeginCompoundOperationRequest[i];
    }
}
