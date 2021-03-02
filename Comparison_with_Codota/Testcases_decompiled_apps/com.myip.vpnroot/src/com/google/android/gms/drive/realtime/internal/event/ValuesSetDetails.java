package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesSetDetails> CREATOR = new C0548j();

    /* renamed from: BR */
    final int f1226BR;

    /* renamed from: Rj */
    final int f1227Rj;

    /* renamed from: Rk */
    final int f1228Rk;
    final int mIndex;

    ValuesSetDetails(int versionCode, int index, int valueIndex, int valueCount) {
        this.f1226BR = versionCode;
        this.mIndex = index;
        this.f1227Rj = valueIndex;
        this.f1228Rk = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0548j.m1572a(this, dest, flags);
    }
}
