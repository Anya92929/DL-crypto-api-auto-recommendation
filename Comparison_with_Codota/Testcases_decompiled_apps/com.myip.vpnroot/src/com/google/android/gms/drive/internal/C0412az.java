package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DrivePreferences;

/* renamed from: com.google.android.gms.drive.internal.az */
public class C0412az implements Parcelable.Creator<SetDrivePreferencesRequest> {
    /* renamed from: a */
    static void m1191a(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, setDrivePreferencesRequest.f970BR);
        C0354b.m923a(parcel, 2, (Parcelable) setDrivePreferencesRequest.f971Pj, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aA */
    public SetDrivePreferencesRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) C0352a.m880a(parcel, B, DrivePreferences.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bM */
    public SetDrivePreferencesRequest[] newArray(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
