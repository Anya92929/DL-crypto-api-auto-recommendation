package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new C0407au();

    /* renamed from: BR */
    final int f957BR;

    /* renamed from: MN */
    final int f958MN;

    /* renamed from: NV */
    final DriveId f959NV;

    /* renamed from: Pp */
    final int f960Pp;

    OpenContentsRequest(int versionCode, DriveId id, int mode, int baseRequestId) {
        this.f957BR = versionCode;
        this.f959NV = id;
        this.f958MN = mode;
        this.f960Pp = baseRequestId;
    }

    public OpenContentsRequest(DriveId id, int mode, int baseRequestId) {
        this(1, id, mode, baseRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0407au.m1176a(this, dest, flags);
    }
}
