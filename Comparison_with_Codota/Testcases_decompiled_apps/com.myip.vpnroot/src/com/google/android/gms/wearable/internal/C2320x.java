package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.x */
public class C2320x implements SafeParcelable {
    public static final Parcelable.Creator<C2320x> CREATOR = new C2321y();
    public final C2309m avp;
    public final int statusCode;
    public final int versionCode;

    C2320x(int i, int i2, C2309m mVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avp = mVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2321y.m7756a(this, dest, flags);
    }
}
