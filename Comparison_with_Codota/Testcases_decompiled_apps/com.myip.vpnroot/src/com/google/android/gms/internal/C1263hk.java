package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.hk */
public class C1263hk implements SafeParcelable {
    public static final C1264hl CREATOR = new C1264hl();

    /* renamed from: BR */
    final int f3854BR;

    /* renamed from: Ci */
    final Bundle f3855Ci;

    /* renamed from: id */
    public final int f3856id;

    C1263hk(int i, int i2, Bundle bundle) {
        this.f3854BR = i;
        this.f3856id = i2;
        this.f3855Ci = bundle;
    }

    public int describeContents() {
        C1264hl hlVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1264hl hlVar = CREATOR;
        C1264hl.m4773a(this, dest, flags);
    }
}
