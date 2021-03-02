package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetMetadataRequest> CREATOR = new C0379aa();

    /* renamed from: BR */
    final int f921BR;

    /* renamed from: NV */
    final DriveId f922NV;

    GetMetadataRequest(int versionCode, DriveId id) {
        this.f921BR = versionCode;
        this.f922NV = id;
    }

    public GetMetadataRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0379aa.m1029a(this, dest, flags);
    }
}
