package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnSyncMoreResponse> CREATOR = new C0406at();

    /* renamed from: BR */
    final int f955BR;

    /* renamed from: Or */
    final boolean f956Or;

    OnSyncMoreResponse(int versionCode, boolean moreEntriesMayExist) {
        this.f955BR = versionCode;
        this.f956Or = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0406at.m1173a(this, dest, flags);
    }
}
