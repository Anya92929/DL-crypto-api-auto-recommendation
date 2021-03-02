package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesAddedDetails> CREATOR = new C0546h();

    /* renamed from: BR */
    final int f1216BR;

    /* renamed from: RF */
    final String f1217RF;

    /* renamed from: RG */
    final int f1218RG;

    /* renamed from: Rj */
    final int f1219Rj;

    /* renamed from: Rk */
    final int f1220Rk;
    final int mIndex;

    ValuesAddedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedFromId, int movedFromIndex) {
        this.f1216BR = versionCode;
        this.mIndex = index;
        this.f1219Rj = valueIndex;
        this.f1220Rk = valueCount;
        this.f1217RF = movedFromId;
        this.f1218RG = movedFromIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0546h.m1566a(this, dest, flags);
    }
}
