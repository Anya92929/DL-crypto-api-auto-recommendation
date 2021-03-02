package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GassRequestParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();

    /* renamed from: YW */
    public final String f4802YW;
    public final String packageName;
    public final int versionCode;

    GassRequestParcel(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.f4802YW = str2;
    }

    public GassRequestParcel(String str, String str2) {
        this(1, str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m6257a(this, parcel, i);
    }
}
