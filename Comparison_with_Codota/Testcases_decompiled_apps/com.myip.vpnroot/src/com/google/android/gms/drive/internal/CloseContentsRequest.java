package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new C0421f();

    /* renamed from: BR */
    final int f892BR;

    /* renamed from: NX */
    final Contents f893NX;

    /* renamed from: NZ */
    final Boolean f894NZ;

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults) {
        this.f892BR = versionCode;
        this.f893NX = contentsReference;
        this.f894NZ = saveResults;
    }

    public CloseContentsRequest(Contents contentsReference, boolean saveResults) {
        this(1, contentsReference, Boolean.valueOf(saveResults));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0421f.m1225a(this, dest, flags);
    }
}
