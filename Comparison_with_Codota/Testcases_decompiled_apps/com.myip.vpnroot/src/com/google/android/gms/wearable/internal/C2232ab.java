package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.ab */
public class C2232ab implements SafeParcelable {
    public static final Parcelable.Creator<C2232ab> CREATOR = new C2233ac();
    public final C2257ak avr;
    public final int statusCode;
    public final int versionCode;

    C2232ab(int i, int i2, C2257ak akVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avr = akVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2233ac.m7506a(this, dest, flags);
    }
}
