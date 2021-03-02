package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ListParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListParentsRequest> CREATOR = new C0392af();

    /* renamed from: BR */
    final int f923BR;

    /* renamed from: Pb */
    final DriveId f924Pb;

    ListParentsRequest(int versionCode, DriveId driveId) {
        this.f923BR = versionCode;
        this.f924Pb = driveId;
    }

    public ListParentsRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0392af.m1128a(this, dest, flags);
    }
}
