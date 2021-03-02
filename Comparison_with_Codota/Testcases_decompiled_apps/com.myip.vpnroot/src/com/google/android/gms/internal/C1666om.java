package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.om */
public final class C1666om implements SafeParcelable {
    public static final Parcelable.Creator<C1666om> CREATOR = new C1667on();

    /* renamed from: BR */
    private final int f4344BR;
    int[] atC;

    C1666om() {
        this(1, (int[]) null);
    }

    C1666om(int i, int[] iArr) {
        this.f4344BR = i;
        this.atC = iArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4344BR;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1667on.m5846a(this, out, flags);
    }
}
