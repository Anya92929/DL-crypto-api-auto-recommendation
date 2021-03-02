package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileRequest> CREATOR = new C0425j();

    /* renamed from: BR */
    final int f903BR;

    /* renamed from: NX */
    final Contents f904NX;

    /* renamed from: Nf */
    final String f905Nf;

    /* renamed from: Od */
    final MetadataBundle f906Od;

    /* renamed from: Oe */
    final Integer f907Oe;

    /* renamed from: Of */
    final DriveId f908Of;

    /* renamed from: Og */
    final boolean f909Og;

    /* renamed from: Oh */
    final int f910Oh;

    /* renamed from: Oi */
    final int f911Oi;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean sendEventOnCompletion, String trackingTag, int createStrategy, int openContentsRequestId) {
        if (!(contentsReference == null || openContentsRequestId == 0)) {
            C0348n.m859b(contentsReference.getRequestId() == openContentsRequestId, (Object) "inconsistent contents reference");
        }
        if ((fileType == null || fileType.intValue() == 0) && contentsReference == null && openContentsRequestId == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.f903BR = versionCode;
        this.f908Of = (DriveId) C0348n.m861i(parentDriveId);
        this.f906Od = (MetadataBundle) C0348n.m861i(metadata);
        this.f904NX = contentsReference;
        this.f907Oe = fileType;
        this.f905Nf = trackingTag;
        this.f910Oh = createStrategy;
        this.f909Og = sendEventOnCompletion;
        this.f911Oi = openContentsRequestId;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, int openContentsRequestId, int fileType, ExecutionOptions executionOptions) {
        this(2, parentDriveId, metadata, (Contents) null, Integer.valueOf(fileType), executionOptions.mo4639hP(), executionOptions.mo4638hO(), executionOptions.mo4640hQ(), openContentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0425j.m1238a(this, dest, flags);
    }
}
