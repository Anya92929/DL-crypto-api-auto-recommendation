package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new C0378a();

    /* renamed from: BR */
    final int f877BR;

    /* renamed from: MO */
    final DriveId f878MO;

    /* renamed from: NS */
    final int f879NS;

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.f877BR = versionCode;
        this.f878MO = driveId;
        this.f879NS = eventType;
    }

    public AddEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0378a.m1026a(this, dest, flags);
    }
}
