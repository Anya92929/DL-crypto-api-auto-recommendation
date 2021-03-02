package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new C0426k();

    /* renamed from: BR */
    final int f912BR;

    /* renamed from: Od */
    final MetadataBundle f913Od;

    /* renamed from: Of */
    final DriveId f914Of;

    CreateFolderRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata) {
        this.f912BR = versionCode;
        this.f914Of = (DriveId) C0348n.m861i(parentDriveId);
        this.f913Od = (MetadataBundle) C0348n.m861i(metadata);
    }

    public CreateFolderRequest(DriveId parentDriveId, MetadataBundle metadata) {
        this(1, parentDriveId, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0426k.m1241a(this, dest, flags);
    }
}
