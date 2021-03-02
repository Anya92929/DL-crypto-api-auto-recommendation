package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.internal.ba */
public class C0414ba implements Parcelable.Creator<SetResourceParentsRequest> {
    /* renamed from: a */
    static void m1197a(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, setResourceParentsRequest.f972BR);
        C0354b.m923a(parcel, 2, (Parcelable) setResourceParentsRequest.f973Pr, i, false);
        C0354b.m940c(parcel, 3, setResourceParentsRequest.f974Ps, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aB */
    public SetResourceParentsRequest createFromParcel(Parcel parcel) {
        ArrayList<DriveId> c;
        DriveId driveId;
        int i;
        ArrayList<DriveId> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    ArrayList<DriveId> arrayList2 = arrayList;
                    driveId = driveId2;
                    i = C0352a.m892g(parcel, B);
                    c = arrayList2;
                    break;
                case 2:
                    i = i2;
                    DriveId driveId3 = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    c = arrayList;
                    driveId = driveId3;
                    break;
                case 3:
                    c = C0352a.m887c(parcel, B, DriveId.CREATOR);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = arrayList;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            arrayList = c;
        }
        if (parcel.dataPosition() == C) {
            return new SetResourceParentsRequest(i2, driveId2, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bN */
    public SetResourceParentsRequest[] newArray(int i) {
        return new SetResourceParentsRequest[i];
    }
}
