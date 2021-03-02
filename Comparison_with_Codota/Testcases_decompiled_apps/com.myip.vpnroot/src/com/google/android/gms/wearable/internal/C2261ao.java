package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.ao */
public class C2261ao implements SafeParcelable {
    public static final Parcelable.Creator<C2261ao> CREATOR = new C2262ap();
    public final C2309m avp;
    public final int statusCode;
    public final int versionCode;

    C2261ao(int i, int i2, C2309m mVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avp = mVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2262ap.m7626a(this, dest, flags);
    }
}
