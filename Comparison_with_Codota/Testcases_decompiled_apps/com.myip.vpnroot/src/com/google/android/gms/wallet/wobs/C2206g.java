package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.g */
public final class C2206g implements SafeParcelable {
    public static final Parcelable.Creator<C2206g> CREATOR = new C2207h();

    /* renamed from: BR */
    private final int f4643BR;
    int aus;
    String aut;
    double auu;
    String auv;
    long auw;
    int aux;

    C2206g() {
        this.f4643BR = 1;
        this.aux = -1;
        this.aus = -1;
        this.auu = -1.0d;
    }

    C2206g(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.f4643BR = i;
        this.aus = i2;
        this.aut = str;
        this.auu = d;
        this.auv = str2;
        this.auw = j;
        this.aux = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4643BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2207h.m7432a(this, dest, flags);
    }
}
