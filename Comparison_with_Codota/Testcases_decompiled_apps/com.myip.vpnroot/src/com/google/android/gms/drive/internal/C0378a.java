package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.a */
public class C0378a implements Parcelable.Creator<AddEventListenerRequest> {
    /* renamed from: a */
    static void m1026a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, addEventListenerRequest.f877BR);
        C0354b.m923a(parcel, 2, (Parcelable) addEventListenerRequest.f878MO, i, false);
        C0354b.m939c(parcel, 3, addEventListenerRequest.f879NS);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: V */
    public AddEventListenerRequest createFromParcel(Parcel parcel) {
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
            return new AddEventListenerRequest(i3, driveId2, i2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: be */
    public AddEventListenerRequest[] newArray(int i) {
        return new AddEventListenerRequest[i];
    }
}
