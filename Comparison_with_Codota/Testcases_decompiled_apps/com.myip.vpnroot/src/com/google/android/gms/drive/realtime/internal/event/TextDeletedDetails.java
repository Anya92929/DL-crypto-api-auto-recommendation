package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails implements SafeParcelable {
    public static final Parcelable.Creator<TextDeletedDetails> CREATOR = new C0543e();

    /* renamed from: BR */
    final int f1210BR;

    /* renamed from: RD */
    final int f1211RD;
    final int mIndex;

    TextDeletedDetails(int versionCode, int index, int stringDataIndex) {
        this.f1210BR = versionCode;
        this.mIndex = index;
        this.f1211RD = stringDataIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0543e.m1557a(this, dest, flags);
    }
}
