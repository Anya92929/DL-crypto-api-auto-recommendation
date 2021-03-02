package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C2227c;

/* renamed from: com.google.android.gms.wearable.internal.t */
public class C2316t implements SafeParcelable {
    public static final Parcelable.Creator<C2316t> CREATOR = new C2317u();
    public final C2227c[] avn;
    public final int statusCode;
    public final int versionCode;

    C2316t(int i, int i2, C2227c[] cVarArr) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avn = cVarArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2317u.m7750a(this, dest, flags);
    }
}
