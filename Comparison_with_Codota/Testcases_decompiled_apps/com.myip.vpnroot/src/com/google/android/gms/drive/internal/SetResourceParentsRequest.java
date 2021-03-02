package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetResourceParentsRequest> CREATOR = new C0414ba();

    /* renamed from: BR */
    final int f972BR;

    /* renamed from: Pr */
    final DriveId f973Pr;

    /* renamed from: Ps */
    final List<DriveId> f974Ps;

    SetResourceParentsRequest(int versionCode, DriveId targetId, List<DriveId> parentIds) {
        this.f972BR = versionCode;
        this.f973Pr = targetId;
        this.f974Ps = parentIds;
    }

    public SetResourceParentsRequest(DriveId targetId, List<DriveId> parentIds) {
        this(1, targetId, parentIds);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0414ba.m1197a(this, dest, flags);
    }
}
