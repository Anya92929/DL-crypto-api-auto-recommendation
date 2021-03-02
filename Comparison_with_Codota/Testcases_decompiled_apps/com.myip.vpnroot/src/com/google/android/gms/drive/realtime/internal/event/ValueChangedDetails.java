package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValueChangedDetails> CREATOR = new C0545g();

    /* renamed from: BR */
    final int f1214BR;

    /* renamed from: RE */
    final int f1215RE;

    ValueChangedDetails(int versionCode, int keyIndex) {
        this.f1214BR = versionCode;
        this.f1215RE = keyIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0545g.m1563a(this, dest, flags);
    }
}
