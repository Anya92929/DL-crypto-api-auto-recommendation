package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.p */
public final class C2215p implements SafeParcelable {
    public static final Parcelable.Creator<C2215p> CREATOR = new C2216q();

    /* renamed from: BR */
    private final int f4648BR;
    C2211l auC;
    C2213n auD;
    C2213n auE;
    String auy;

    /* renamed from: tG */
    String f4649tG;

    C2215p() {
        this.f4648BR = 1;
    }

    C2215p(int i, String str, String str2, C2211l lVar, C2213n nVar, C2213n nVar2) {
        this.f4648BR = i;
        this.auy = str;
        this.f4649tG = str2;
        this.auC = lVar;
        this.auD = nVar;
        this.auE = nVar2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4648BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2216q.m7447a(this, dest, flags);
    }
}
