package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new C0370a();

    /* renamed from: BR */
    final int f854BR;

    /* renamed from: MO */
    final DriveId f855MO;

    /* renamed from: NE */
    final int f856NE;

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.f854BR = versionCode;
        this.f855MO = driveId;
        this.f856NE = changeFlags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.f855MO;
    }

    public int getType() {
        return 1;
    }

    public boolean hasContentChanged() {
        return (this.f856NE & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.f856NE & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.f855MO, Integer.valueOf(this.f856NE)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0370a.m994a(this, dest, flags);
    }
}
