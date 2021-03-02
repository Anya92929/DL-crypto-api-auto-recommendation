package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new C0393ag();

    /* renamed from: BR */
    final int f925BR;

    /* renamed from: MO */
    final DriveId f926MO;

    /* renamed from: Pc */
    final boolean f927Pc;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode) {
        this.f925BR = versionCode;
        this.f926MO = driveId;
        this.f927Pc = useTestMode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0393ag.m1131a(this, dest, flags);
    }
}
