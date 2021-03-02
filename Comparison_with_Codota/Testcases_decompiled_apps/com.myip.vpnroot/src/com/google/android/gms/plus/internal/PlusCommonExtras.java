package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.C0355c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlusCommonExtras implements SafeParcelable {
    public static final C1964f CREATOR = new C1964f();
    public static String TAG = "PlusCommonExtras";

    /* renamed from: BR */
    private final int f4499BR;
    private String alp;
    private String alq;

    public PlusCommonExtras() {
        this.f4499BR = 1;
        this.alp = "";
        this.alq = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.f4499BR = versionCode;
        this.alp = gpsrc;
        this.alq = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.f4499BR == plusCommonExtras.f4499BR && C0345m.equal(this.alp, plusCommonExtras.alp) && C0345m.equal(this.alq, plusCommonExtras.alq);
    }

    public int getVersionCode() {
        return this.f4499BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f4499BR), this.alp, this.alq);
    }

    /* renamed from: nc */
    public String mo11308nc() {
        return this.alp;
    }

    /* renamed from: nd */
    public String mo11309nd() {
        return this.alq;
    }

    /* renamed from: o */
    public void mo11310o(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", C0355c.m945a(this));
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("versionCode", Integer.valueOf(this.f4499BR)).mo4549a("Gpsrc", this.alp).mo4549a("ClientCallingPackage", this.alq).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1964f.m6645a(this, out, flags);
    }
}
