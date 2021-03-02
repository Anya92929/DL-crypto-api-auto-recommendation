package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDrivePreferencesResponse> CREATOR = new C0398al();

    /* renamed from: BR */
    final int f936BR;

    /* renamed from: Pj */
    DrivePreferences f937Pj;

    OnDrivePreferencesResponse(int versionCode, DrivePreferences prefs) {
        this.f936BR = versionCode;
        this.f937Pj = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0398al.m1149a(this, dest, flags);
    }
}
