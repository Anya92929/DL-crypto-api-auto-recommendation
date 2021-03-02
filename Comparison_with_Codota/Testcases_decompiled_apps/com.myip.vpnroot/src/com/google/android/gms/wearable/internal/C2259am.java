package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.am */
public class C2259am implements SafeParcelable {
    public static final Parcelable.Creator<C2259am> CREATOR = new C2260an();
    public final long avC;
    public final String label;
    public final String packageName;
    public final int versionCode;

    C2259am(int i, String str, String str2, long j) {
        this.versionCode = i;
        this.packageName = str;
        this.label = str2;
        this.avC = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C2260an.m7623a(this, out, flags);
    }
}
