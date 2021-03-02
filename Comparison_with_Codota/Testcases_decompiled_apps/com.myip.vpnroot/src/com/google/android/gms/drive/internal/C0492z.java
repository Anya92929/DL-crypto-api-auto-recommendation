package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.internal.z */
public class C0492z implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> {
    /* renamed from: a */
    static void m1363a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, getDriveIdFromUniqueIdentifierRequest.f918BR);
        C0354b.m927a(parcel, 2, getDriveIdFromUniqueIdentifierRequest.f919OZ, false);
        C0354b.m930a(parcel, 3, getDriveIdFromUniqueIdentifierRequest.f920Pa);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ag */
    public GetDriveIdFromUniqueIdentifierRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bs */
    public GetDriveIdFromUniqueIdentifierRequest[] newArray(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
