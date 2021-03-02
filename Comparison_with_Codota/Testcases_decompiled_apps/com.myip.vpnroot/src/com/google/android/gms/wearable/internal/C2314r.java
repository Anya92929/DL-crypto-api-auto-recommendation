package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C2227c;

@Deprecated
/* renamed from: com.google.android.gms.wearable.internal.r */
public class C2314r implements SafeParcelable {
    public static final Parcelable.Creator<C2314r> CREATOR = new C2315s();
    public final C2227c avm;
    public final int statusCode;
    public final int versionCode;

    C2314r(int i, int i2, C2227c cVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avm = cVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2315s.m7747a(this, dest, flags);
    }
}
