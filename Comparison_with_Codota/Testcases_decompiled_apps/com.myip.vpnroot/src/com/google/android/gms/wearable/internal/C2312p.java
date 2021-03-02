package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.p */
public class C2312p implements SafeParcelable {
    public static final Parcelable.Creator<C2312p> CREATOR = new C2313q();
    public final int avl;
    public final int statusCode;
    public final int versionCode;

    C2312p(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avl = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2313q.m7744a(this, dest, flags);
    }
}
