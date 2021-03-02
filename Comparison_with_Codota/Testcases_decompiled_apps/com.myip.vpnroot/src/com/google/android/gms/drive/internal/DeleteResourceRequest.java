package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<DeleteResourceRequest> CREATOR = new C0428m();

    /* renamed from: BR */
    final int f915BR;

    /* renamed from: NV */
    final DriveId f916NV;

    DeleteResourceRequest(int versionCode, DriveId id) {
        this.f915BR = versionCode;
        this.f916NV = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0428m.m1246a(this, dest, flags);
    }
}
