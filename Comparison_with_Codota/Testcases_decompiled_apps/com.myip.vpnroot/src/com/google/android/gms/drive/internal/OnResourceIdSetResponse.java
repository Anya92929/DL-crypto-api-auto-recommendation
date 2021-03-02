package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnResourceIdSetResponse> CREATOR = new C0404ar();

    /* renamed from: BR */
    private final int f951BR;

    /* renamed from: NU */
    private final List<String> f952NU;

    OnResourceIdSetResponse(int versionCode, List<String> resourceIds) {
        this.f951BR = versionCode;
        this.f952NU = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f951BR;
    }

    /* renamed from: hX */
    public List<String> mo4828hX() {
        return this.f952NU;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0404ar.m1167a(this, dest, flags);
    }
}
