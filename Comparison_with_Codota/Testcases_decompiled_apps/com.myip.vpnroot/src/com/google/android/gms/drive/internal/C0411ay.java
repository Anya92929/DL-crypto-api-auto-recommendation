package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.ay */
public class C0411ay implements Parcelable.Creator<RemoveEventListenerRequest> {
    /* renamed from: a */
    static void m1188a(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, removeEventListenerRequest.f967BR);
        C0354b.m923a(parcel, 2, (Parcelable) removeEventListenerRequest.f968MO, i, false);
        C0354b.m939c(parcel, 3, removeEventListenerRequest.f969NS);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: az */
    public RemoveEventListenerRequest createFromParcel(Parcel parcel) {
        int g;
        DriveId driveId;
        int i;
        int i2 = 0;
        int C = C0352a.m875C(parcel);
        DriveId driveId2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    int i4 = i2;
                    driveId = driveId2;
                    i = C0352a.m892g(parcel, B);
                    g = i4;
                    break;
                case 2:
                    i = i3;
                    DriveId driveId3 = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    g = i2;
                    driveId = driveId3;
                    break;
                case 3:
                    g = C0352a.m892g(parcel, B);
                    driveId = driveId2;
                    i = i3;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    g = i2;
                    driveId = driveId2;
                    i = i3;
                    break;
            }
            i3 = i;
            driveId2 = driveId;
            i2 = g;
        }
        if (parcel.dataPosition() == C) {
            return new RemoveEventListenerRequest(i3, driveId2, i2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bL */
    public RemoveEventListenerRequest[] newArray(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
