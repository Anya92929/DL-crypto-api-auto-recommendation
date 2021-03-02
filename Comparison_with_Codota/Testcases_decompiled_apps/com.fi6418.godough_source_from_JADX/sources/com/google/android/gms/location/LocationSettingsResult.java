package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new C1155u();

    /* renamed from: a */
    private final int f4912a;

    /* renamed from: b */
    private final Status f4913b;

    /* renamed from: c */
    private final LocationSettingsStates f4914c;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.f4912a = i;
        this.f4913b = status;
        this.f4914c = locationSettingsStates;
    }

    /* renamed from: a */
    public int mo7763a() {
        return this.f4912a;
    }

    /* renamed from: b */
    public LocationSettingsStates mo7764b() {
        return this.f4914c;
    }

    /* renamed from: c */
    public Status mo7765c() {
        return this.f4913b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1155u.m4989a(this, parcel, i);
    }
}
