package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.au */
public class C2267au implements SafeParcelable {
    public static final Parcelable.Creator<C2267au> CREATOR = new C2268av();
    public final long avC;
    public final List<C2259am> avE;
    public final int statusCode;
    public final int versionCode;

    C2267au(int i, int i2, long j, List<C2259am> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avC = j;
        this.avE = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C2268av.m7636a(this, out, flags);
    }
}
