package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetDrivePreferencesRequest> CREATOR = new C0412az();

    /* renamed from: BR */
    final int f970BR;

    /* renamed from: Pj */
    final DrivePreferences f971Pj;

    SetDrivePreferencesRequest(int versionCode, DrivePreferences prefs) {
        this.f970BR = versionCode;
        this.f971Pj = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0412az.m1191a(this, dest, flags);
    }
}
