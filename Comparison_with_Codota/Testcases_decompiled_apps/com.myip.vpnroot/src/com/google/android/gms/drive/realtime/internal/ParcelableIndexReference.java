package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new C0580q();

    /* renamed from: BR */
    final int f1176BR;

    /* renamed from: Rh */
    final String f1177Rh;

    /* renamed from: Ri */
    final boolean f1178Ri;
    final int mIndex;

    ParcelableIndexReference(int versionCode, String objectId, int index, boolean canBeDeleted) {
        this.f1176BR = versionCode;
        this.f1177Rh = objectId;
        this.mIndex = index;
        this.f1178Ri = canBeDeleted;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0580q.m1700a(this, dest, flags);
    }
}
