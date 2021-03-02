package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new C0397ak();

    /* renamed from: BR */
    final int f934BR;

    /* renamed from: NV */
    DriveId f935NV;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.f934BR = versionCode;
        this.f935NV = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.f935NV;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0397ak.m1146a(this, dest, flags);
    }
}
