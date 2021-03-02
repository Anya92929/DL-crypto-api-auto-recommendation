package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnStorageStatsResponse> CREATOR = new C0405as();

    /* renamed from: BR */
    final int f953BR;

    /* renamed from: Po */
    StorageStats f954Po;

    OnStorageStatsResponse(int versionCode, StorageStats storageStats) {
        this.f953BR = versionCode;
        this.f954Po = storageStats;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0405as.m1170a(this, dest, flags);
    }
}
