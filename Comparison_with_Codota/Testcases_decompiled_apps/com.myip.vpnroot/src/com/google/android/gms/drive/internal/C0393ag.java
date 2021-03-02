package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.ag */
public class C0393ag implements Parcelable.Creator<LoadRealtimeRequest> {
    /* renamed from: a */
    static void m1131a(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, loadRealtimeRequest.f925BR);
        C0354b.m923a(parcel, 2, (Parcelable) loadRealtimeRequest.f926MO, i, false);
        C0354b.m930a(parcel, 3, loadRealtimeRequest.f927Pc);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aj */
    public LoadRealtimeRequest createFromParcel(Parcel parcel) {
        boolean c;
        DriveId driveId;
        int i;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        DriveId driveId2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    boolean z2 = z;
                    driveId = driveId2;
                    i = C0352a.m892g(parcel, B);
                    c = z2;
                    break;
                case 2:
                    i = i2;
                    DriveId driveId3 = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    c = z;
                    driveId = driveId3;
                    break;
                case 3:
                    c = C0352a.m888c(parcel, B);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = z;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            z = c;
        }
        if (parcel.dataPosition() == C) {
            return new LoadRealtimeRequest(i2, driveId2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bv */
    public LoadRealtimeRequest[] newArray(int i) {
        return new LoadRealtimeRequest[i];
    }
}
