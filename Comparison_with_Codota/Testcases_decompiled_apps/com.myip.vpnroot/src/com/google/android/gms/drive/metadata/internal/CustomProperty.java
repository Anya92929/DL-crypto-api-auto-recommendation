package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty implements SafeParcelable {
    public static final Parcelable.Creator<CustomProperty> CREATOR = new C0501c();

    /* renamed from: BR */
    final int f1101BR;

    /* renamed from: PB */
    final CustomPropertyKey f1102PB;
    final String mValue;

    CustomProperty(int versionCode, CustomPropertyKey key, String value) {
        this.f1101BR = versionCode;
        C0348n.m857b(key, (Object) "key");
        this.f1102PB = key;
        this.mValue = value;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0501c.m1399a(this, dest, flags);
    }
}
