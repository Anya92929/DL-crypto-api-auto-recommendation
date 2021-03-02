package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new C0402ap();

    /* renamed from: BR */
    final int f949BR;

    /* renamed from: Od */
    final MetadataBundle f950Od;

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.f949BR = versionCode;
        this.f950Od = metadata;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: il */
    public MetadataBundle mo4824il() {
        return this.f950Od;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0402ap.m1161a(this, dest, flags);
    }
}
