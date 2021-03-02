package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.l */
public final class C2211l implements SafeParcelable {
    public static final Parcelable.Creator<C2211l> CREATOR = new C2212m();

    /* renamed from: BR */
    private final int f4646BR;
    long auA;
    long auz;

    C2211l() {
        this.f4646BR = 1;
    }

    C2211l(int i, long j, long j2) {
        this.f4646BR = i;
        this.auz = j;
        this.auA = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4646BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2212m.m7441a(this, dest, flags);
    }
}
