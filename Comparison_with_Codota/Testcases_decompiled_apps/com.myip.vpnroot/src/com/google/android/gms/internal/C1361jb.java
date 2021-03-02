package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jb */
public class C1361jb implements SafeParcelable {
    public static final C1362jc CREATOR = new C1362jc();

    /* renamed from: BR */
    final int f4100BR;

    /* renamed from: Mi */
    public final String f4101Mi;

    /* renamed from: Mj */
    public final int f4102Mj;

    public C1361jb(int i, String str, int i2) {
        this.f4100BR = i;
        this.f4101Mi = str;
        this.f4102Mj = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1362jc.m5099a(this, out, flags);
    }
}
