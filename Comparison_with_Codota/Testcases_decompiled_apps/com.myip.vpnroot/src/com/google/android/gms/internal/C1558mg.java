package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.mg */
public final class C1558mg implements SafeParcelable {
    public static final C1559mh CREATOR = new C1559mh();

    /* renamed from: BR */
    private final int f4283BR;
    private final int adW;
    private final int afe;
    private final C1560mi aff;

    C1558mg(int i, int i2, int i3, C1560mi miVar) {
        this.f4283BR = i;
        this.adW = i2;
        this.afe = i3;
        this.aff = miVar;
    }

    public int describeContents() {
        C1559mh mhVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1558mg)) {
            return false;
        }
        C1558mg mgVar = (C1558mg) object;
        return this.adW == mgVar.adW && this.afe == mgVar.afe && this.aff.equals(mgVar.aff);
    }

    public int getVersionCode() {
        return this.f4283BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.adW), Integer.valueOf(this.afe));
    }

    /* renamed from: ma */
    public int mo9394ma() {
        return this.adW;
    }

    /* renamed from: me */
    public int mo9395me() {
        return this.afe;
    }

    /* renamed from: mf */
    public C1560mi mo9396mf() {
        return this.aff;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("transitionTypes", Integer.valueOf(this.adW)).mo4549a("loiteringTimeMillis", Integer.valueOf(this.afe)).mo4549a("placeFilter", this.aff).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1559mh mhVar = CREATOR;
        C1559mh.m5606a(this, parcel, flags);
    }
}
