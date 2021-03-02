package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnContentsResponse> CREATOR = new C0395ai();

    /* renamed from: BR */
    final int f928BR;

    /* renamed from: Op */
    final Contents f929Op;

    /* renamed from: Pg */
    final boolean f930Pg;

    OnContentsResponse(int versionCode, Contents contents, boolean outOfDate) {
        this.f928BR = versionCode;
        this.f929Op = contents;
        this.f930Pg = outOfDate;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: id */
    public Contents mo4801id() {
        return this.f929Op;
    }

    /* renamed from: ie */
    public boolean mo4802ie() {
        return this.f930Pg;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0395ai.m1140a(this, dest, flags);
    }
}
