package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrashResourceRequest> CREATOR = new C0416bc();

    /* renamed from: BR */
    final int f975BR;

    /* renamed from: NV */
    final DriveId f976NV;

    TrashResourceRequest(int versionCode, DriveId id) {
        this.f975BR = versionCode;
        this.f976NV = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0416bc.m1201a(this, dest, flags);
    }
}
