package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new C0547i();

    /* renamed from: BR */
    final int f1221BR;

    /* renamed from: RH */
    final String f1222RH;

    /* renamed from: RI */
    final int f1223RI;

    /* renamed from: Rj */
    final int f1224Rj;

    /* renamed from: Rk */
    final int f1225Rk;
    final int mIndex;

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.f1221BR = versionCode;
        this.mIndex = index;
        this.f1224Rj = valueIndex;
        this.f1225Rk = valueCount;
        this.f1222RH = movedToId;
        this.f1223RI = movedToIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0547i.m1569a(this, dest, flags);
    }
}
