package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnLoadRealtimeResponse> CREATOR = new C0403aq();

    /* renamed from: BR */
    final int f947BR;

    /* renamed from: vR */
    final boolean f948vR;

    OnLoadRealtimeResponse(int versionCode, boolean isInitialized) {
        this.f947BR = versionCode;
        this.f948vR = isInitialized;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0403aq.m1164a(this, dest, flags);
    }
}
