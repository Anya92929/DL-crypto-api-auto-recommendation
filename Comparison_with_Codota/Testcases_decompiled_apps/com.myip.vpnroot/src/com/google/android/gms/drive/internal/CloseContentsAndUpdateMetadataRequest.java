package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new C0420e();

    /* renamed from: BR */
    final int f885BR;

    /* renamed from: NV */
    final DriveId f886NV;

    /* renamed from: NW */
    final MetadataBundle f887NW;

    /* renamed from: NX */
    final Contents f888NX;

    /* renamed from: NY */
    final int f889NY;

    /* renamed from: Nf */
    final String f890Nf;

    /* renamed from: Ng */
    final boolean f891Ng;

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean notifyOnCompletion, String trackingTag, int commitStrategy) {
        this.f885BR = versionCode;
        this.f886NV = id;
        this.f887NW = metadataChangeSet;
        this.f888NX = contentsReference;
        this.f891Ng = notifyOnCompletion;
        this.f890Nf = trackingTag;
        this.f889NY = commitStrategy;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, ExecutionOptions executionOptions) {
        this(1, id, metadataChangeSet, contentsReference, executionOptions.mo4639hP(), executionOptions.mo4638hO(), executionOptions.mo4640hQ());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0420e.m1222a(this, dest, flags);
    }
}
