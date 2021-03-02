package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.v */
public class C2318v implements SafeParcelable {
    public static final Parcelable.Creator<C2318v> CREATOR = new C2319w();
    public final List<C2257ak> avo;
    public final int statusCode;
    public final int versionCode;

    C2318v(int i, int i2, List<C2257ak> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avo = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2319w.m7753a(this, dest, flags);
    }
}
