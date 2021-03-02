package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new C0422g();

    /* renamed from: BR */
    final int f895BR;

    /* renamed from: MN */
    final int f896MN;

    public CreateContentsRequest(int mode) {
        this(1, mode);
    }

    CreateContentsRequest(int versionCode, int mode) {
        this.f895BR = versionCode;
        C0348n.m859b(mode == 536870912 || mode == 805306368, (Object) "Cannot create a new read-only contents!");
        this.f896MN = mode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0422g.m1228a(this, dest, flags);
    }
}
