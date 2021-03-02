package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences implements SafeParcelable {
    public static final Parcelable.Creator<DrivePreferences> CREATOR = new C0365d();

    /* renamed from: BR */
    final int f819BR;

    /* renamed from: Ne */
    final boolean f820Ne;

    DrivePreferences(int versionCode, boolean syncOverWifiOnly) {
        this.f819BR = versionCode;
        this.f820Ne = syncOverWifiOnly;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0365d.m978a(this, parcel, flags);
    }
}
