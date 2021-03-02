package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.as */
public class C2265as implements SafeParcelable {
    public static final Parcelable.Creator<C2265as> CREATOR = new C2266at();
    public final int avD;
    public final int statusCode;
    public final int versionCode;

    C2265as(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avD = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2266at.m7633a(this, dest, flags);
    }
}
