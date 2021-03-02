package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.n */
public final class C2213n implements SafeParcelable {
    public static final Parcelable.Creator<C2213n> CREATOR = new C2214o();

    /* renamed from: BR */
    private final int f4647BR;
    String auB;
    String description;

    C2213n() {
        this.f4647BR = 1;
    }

    C2213n(int i, String str, String str2) {
        this.f4647BR = i;
        this.auB = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4647BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2214o.m7444a(this, dest, flags);
    }
}
