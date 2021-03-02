package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Parcelable.Creator<AuthorizeAccessRequest> CREATOR = new C0413b();

    /* renamed from: BR */
    final int f880BR;

    /* renamed from: MO */
    final DriveId f881MO;

    /* renamed from: NT */
    final long f882NT;

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.f880BR = versionCode;
        this.f882NT = appId;
        this.f881MO = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0413b.m1194a(this, dest, flags);
    }
}
