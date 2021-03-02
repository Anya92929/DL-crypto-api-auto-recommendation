package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats implements SafeParcelable {
    public static final Parcelable.Creator<StorageStats> CREATOR = new C0375g();

    /* renamed from: BR */
    final int f842BR;

    /* renamed from: Nt */
    final long f843Nt;

    /* renamed from: Nu */
    final long f844Nu;

    /* renamed from: Nv */
    final long f845Nv;

    /* renamed from: Nw */
    final long f846Nw;

    /* renamed from: Nx */
    final int f847Nx;

    StorageStats(int versionCode, long metadataSizeBytes, long cachedContentsSizeBytes, long pinnedItemsSizeBytes, long totalSizeBytes, int numPinnedItems) {
        this.f842BR = versionCode;
        this.f843Nt = metadataSizeBytes;
        this.f844Nu = cachedContentsSizeBytes;
        this.f845Nv = pinnedItemsSizeBytes;
        this.f846Nw = totalSizeBytes;
        this.f847Nx = numPinnedItems;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0375g.m1005a(this, out, flags);
    }
}
