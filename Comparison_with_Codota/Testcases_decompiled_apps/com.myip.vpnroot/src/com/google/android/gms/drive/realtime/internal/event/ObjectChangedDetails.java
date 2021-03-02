package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ObjectChangedDetails> CREATOR = new C0539a();

    /* renamed from: BR */
    final int f1182BR;

    /* renamed from: Rj */
    final int f1183Rj;

    /* renamed from: Rk */
    final int f1184Rk;

    ObjectChangedDetails(int versionCode, int valueIndex, int valueCount) {
        this.f1182BR = versionCode;
        this.f1183Rj = valueIndex;
        this.f1184Rk = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0539a.m1545a(this, dest, flags);
    }
}
