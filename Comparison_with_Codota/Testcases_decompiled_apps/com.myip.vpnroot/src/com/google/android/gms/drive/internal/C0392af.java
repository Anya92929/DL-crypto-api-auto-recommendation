package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.af */
public class C0392af implements Parcelable.Creator<ListParentsRequest> {
    /* renamed from: a */
    static void m1128a(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, listParentsRequest.f923BR);
        C0354b.m923a(parcel, 2, (Parcelable) listParentsRequest.f924Pb, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ai */
    public ListParentsRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    driveId = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ListParentsRequest(i, driveId);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bu */
    public ListParentsRequest[] newArray(int i) {
        return new ListParentsRequest[i];
    }
}
