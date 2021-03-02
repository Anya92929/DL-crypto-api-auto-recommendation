package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.j */
public final class C2209j implements SafeParcelable {
    public static final Parcelable.Creator<C2209j> CREATOR = new C2210k();

    /* renamed from: BR */
    private final int f4644BR;
    String auy;

    /* renamed from: tG */
    String f4645tG;

    C2209j() {
        this.f4644BR = 1;
    }

    C2209j(int i, String str, String str2) {
        this.f4644BR = i;
        this.auy = str;
        this.f4645tG = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4644BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2210k.m7438a(this, dest, flags);
    }
}
