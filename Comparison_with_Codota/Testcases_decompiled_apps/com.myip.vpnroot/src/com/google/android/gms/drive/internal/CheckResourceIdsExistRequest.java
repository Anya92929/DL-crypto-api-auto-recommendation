package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Parcelable.Creator<CheckResourceIdsExistRequest> CREATOR = new C0419d();

    /* renamed from: BR */
    private final int f883BR;

    /* renamed from: NU */
    private final List<String> f884NU;

    CheckResourceIdsExistRequest(int versionCode, List<String> resourceIds) {
        this.f883BR = versionCode;
        this.f884NU = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f883BR;
    }

    /* renamed from: hX */
    public List<String> mo4774hX() {
        return this.f884NU;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0419d.m1219a(this, dest, flags);
    }
}
