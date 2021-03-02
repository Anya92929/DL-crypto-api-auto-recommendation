package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.mk */
public class C1562mk implements SafeParcelable {
    public static final C1563ml CREATOR = new C1563ml();

    /* renamed from: BR */
    final int f4285BR;
    private final String afo;
    private final String mTag;

    C1562mk(int i, String str, String str2) {
        this.f4285BR = i;
        this.afo = str;
        this.mTag = str2;
    }

    public int describeContents() {
        C1563ml mlVar = CREATOR;
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof C1562mk)) {
            return false;
        }
        C1562mk mkVar = (C1562mk) that;
        return C0345m.equal(this.afo, mkVar.afo) && C0345m.equal(this.mTag, mkVar.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return C0345m.hashCode(this.afo, this.mTag);
    }

    /* renamed from: mi */
    public String mo9418mi() {
        return this.afo;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("mPlaceId", this.afo).mo4549a("mTag", this.mTag).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1563ml mlVar = CREATOR;
        C1563ml.m5616a(this, out, flags);
    }
}
