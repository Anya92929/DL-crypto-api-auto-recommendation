package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.b */
public class C0413b implements Parcelable.Creator<AuthorizeAccessRequest> {
    /* renamed from: a */
    static void m1194a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, authorizeAccessRequest.f880BR);
        C0354b.m919a(parcel, 2, authorizeAccessRequest.f882NT);
        C0354b.m923a(parcel, 3, (Parcelable) authorizeAccessRequest.f881MO, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: W */
    public AuthorizeAccessRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    driveId = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bf */
    public AuthorizeAccessRequest[] newArray(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
