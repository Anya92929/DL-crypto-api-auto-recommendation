package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DrivePreferences;

/* renamed from: com.google.android.gms.drive.internal.al */
public class C0398al implements Parcelable.Creator<OnDrivePreferencesResponse> {
    /* renamed from: a */
    static void m1149a(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onDrivePreferencesResponse.f936BR);
        C0354b.m923a(parcel, 2, (Parcelable) onDrivePreferencesResponse.f937Pj, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: an */
    public OnDrivePreferencesResponse createFromParcel(Parcel parcel) {
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
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bz */
    public OnDrivePreferencesResponse[] newArray(int i) {
        return new OnDrivePreferencesResponse[i];
    }
}
