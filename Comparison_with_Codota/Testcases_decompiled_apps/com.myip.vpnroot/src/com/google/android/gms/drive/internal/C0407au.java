package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.au */
public class C0407au implements Parcelable.Creator<OpenContentsRequest> {
    /* renamed from: a */
    static void m1176a(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, openContentsRequest.f957BR);
        C0354b.m923a(parcel, 2, (Parcelable) openContentsRequest.f959NV, i, false);
        C0354b.m939c(parcel, 3, openContentsRequest.f958MN);
        C0354b.m939c(parcel, 4, openContentsRequest.f960Pp);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aw */
    public OpenContentsRequest createFromParcel(Parcel parcel) {
        int g;
        int i;
        DriveId driveId;
        int i2;
        int i3 = 0;
        int C = C0352a.m875C(parcel);
        DriveId driveId2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    int i6 = i3;
                    i = i4;
                    driveId = driveId2;
                    i2 = C0352a.m892g(parcel, B);
                    g = i6;
                    break;
                case 2:
                    i2 = i5;
                    int i7 = i4;
                    driveId = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    g = i3;
                    i = i7;
                    break;
                case 3:
                    driveId = driveId2;
                    i2 = i5;
                    int i8 = i3;
                    i = C0352a.m892g(parcel, B);
                    g = i8;
                    break;
                case 4:
                    g = C0352a.m892g(parcel, B);
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    g = i3;
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            driveId2 = driveId;
            i4 = i;
            i3 = g;
        }
        if (parcel.dataPosition() == C) {
            return new OpenContentsRequest(i5, driveId2, i4, i3);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bI */
    public OpenContentsRequest[] newArray(int i) {
        return new OpenContentsRequest[i];
    }
}
