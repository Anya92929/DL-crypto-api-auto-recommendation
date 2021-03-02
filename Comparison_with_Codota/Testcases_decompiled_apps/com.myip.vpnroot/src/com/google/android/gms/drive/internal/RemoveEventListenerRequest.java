package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new C0411ay();

    /* renamed from: BR */
    final int f967BR;

    /* renamed from: MO */
    final DriveId f968MO;

    /* renamed from: NS */
    final int f969NS;

    RemoveEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.f967BR = versionCode;
        this.f968MO = driveId;
        this.f969NS = eventType;
    }

    public RemoveEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0411ay.m1188a(this, dest, flags);
    }
}
