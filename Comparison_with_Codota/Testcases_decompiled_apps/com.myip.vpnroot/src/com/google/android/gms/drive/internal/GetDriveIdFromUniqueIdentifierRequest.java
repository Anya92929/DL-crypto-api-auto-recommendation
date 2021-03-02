package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new C0492z();

    /* renamed from: BR */
    final int f918BR;

    /* renamed from: OZ */
    final String f919OZ;

    /* renamed from: Pa */
    final boolean f920Pa;

    GetDriveIdFromUniqueIdentifierRequest(int versionCode, String uniqueIdentifier, boolean isInAppFolder) {
        this.f918BR = versionCode;
        this.f919OZ = uniqueIdentifier;
        this.f920Pa = isInAppFolder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0492z.m1363a(this, dest, flags);
    }
}
