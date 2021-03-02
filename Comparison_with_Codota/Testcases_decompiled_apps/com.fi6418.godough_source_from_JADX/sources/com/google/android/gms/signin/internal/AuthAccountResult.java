package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements SafeParcelable {
    public static final Parcelable.Creator<AuthAccountResult> CREATOR = new C1250a();

    /* renamed from: a */
    final int f5276a;

    public AuthAccountResult() {
        this(1);
    }

    AuthAccountResult(int i) {
        this.f5276a = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1250a.m5190a(this, parcel, i);
    }
}
