package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new C0542d();

    /* renamed from: BR */
    final int f1205BR;

    /* renamed from: RA */
    final String f1206RA;

    /* renamed from: RB */
    final int f1207RB;

    /* renamed from: RC */
    final int f1208RC;

    /* renamed from: Rz */
    final String f1209Rz;

    ReferenceShiftedDetails(int versionCode, String oldObjectId, String newObjectId, int oldIndex, int newIndex) {
        this.f1205BR = versionCode;
        this.f1209Rz = oldObjectId;
        this.f1206RA = newObjectId;
        this.f1207RB = oldIndex;
        this.f1208RC = newIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0542d.m1554a(this, dest, flags);
    }
}
