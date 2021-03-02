package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.oo */
public final class C1668oo implements SafeParcelable {
    public static final Parcelable.Creator<C1668oo> CREATOR = new C1669op();

    /* renamed from: BR */
    private final int f4345BR;
    String[] atD;
    byte[][] atE;

    C1668oo() {
        this(1, new String[0], new byte[0][]);
    }

    C1668oo(int i, String[] strArr, byte[][] bArr) {
        this.f4345BR = i;
        this.atD = strArr;
        this.atE = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4345BR;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1669op.m5849a(this, out, flags);
    }
}
