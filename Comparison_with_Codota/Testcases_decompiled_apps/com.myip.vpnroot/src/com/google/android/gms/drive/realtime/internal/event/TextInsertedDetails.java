package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextInsertedDetails implements SafeParcelable {
    public static final Parcelable.Creator<TextInsertedDetails> CREATOR = new C0544f();

    /* renamed from: BR */
    final int f1212BR;

    /* renamed from: RD */
    final int f1213RD;
    final int mIndex;

    TextInsertedDetails(int versionCode, int index, int stringDataIndex) {
        this.f1212BR = versionCode;
        this.mIndex = index;
        this.f1213RD = stringDataIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0544f.m1560a(this, dest, flags);
    }
}
