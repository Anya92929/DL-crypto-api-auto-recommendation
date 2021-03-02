package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.b */
public final class C2201b implements SafeParcelable {
    public static final Parcelable.Creator<C2201b> CREATOR = new C2202c();

    /* renamed from: BR */
    private final int f4640BR;
    String label;
    String value;

    C2201b() {
        this.f4640BR = 1;
    }

    C2201b(int i, String str, String str2) {
        this.f4640BR = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4640BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2202c.m7426a(this, dest, flags);
    }
}
