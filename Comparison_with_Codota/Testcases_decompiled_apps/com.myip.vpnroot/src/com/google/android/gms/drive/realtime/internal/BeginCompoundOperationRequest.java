package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new C0528a();

    /* renamed from: BR */
    final int f1164BR;

    /* renamed from: Ra */
    final boolean f1165Ra;

    /* renamed from: Rb */
    final boolean f1166Rb;
    final String mName;

    BeginCompoundOperationRequest(int versionCode, boolean isCreation, String name, boolean isUndoable) {
        this.f1164BR = versionCode;
        this.f1165Ra = isCreation;
        this.mName = name;
        this.f1166Rb = isUndoable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0528a.m1524a(this, dest, flags);
    }
}
