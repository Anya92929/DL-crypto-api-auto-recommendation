package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.f */
public final class C2205f implements SafeParcelable {
    public static final Parcelable.Creator<C2205f> CREATOR = new C2208i();

    /* renamed from: BR */
    private final int f4642BR;
    C2211l asR;
    C2206g aur;
    String label;
    String type;

    C2205f() {
        this.f4642BR = 1;
    }

    C2205f(int i, String str, C2206g gVar, String str2, C2211l lVar) {
        this.f4642BR = i;
        this.label = str;
        this.aur = gVar;
        this.type = str2;
        this.asR = lVar;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4642BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2208i.m7435a(this, dest, flags);
    }
}
