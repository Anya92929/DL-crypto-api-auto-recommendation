package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new C0424i();

    /* renamed from: BR */
    final int f897BR;

    /* renamed from: No */
    final String f898No;

    /* renamed from: Nq */
    final DriveId f899Nq;

    /* renamed from: Od */
    final MetadataBundle f900Od;

    /* renamed from: Oe */
    final Integer f901Oe;

    /* renamed from: uQ */
    final int f902uQ;

    CreateFileIntentSenderRequest(int versionCode, MetadataBundle metadata, int requestId, String title, DriveId startFolder, Integer fileType) {
        this.f897BR = versionCode;
        this.f900Od = metadata;
        this.f902uQ = requestId;
        this.f898No = title;
        this.f899Nq = startFolder;
        this.f901Oe = fileType;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadata, int requestId, String title, DriveId startFolder, int fileType) {
        this(1, metadata, requestId, title, startFolder, Integer.valueOf(fileType));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0424i.m1235a(this, dest, flags);
    }
}
