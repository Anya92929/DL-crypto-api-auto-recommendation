package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new C1145k();

    /* renamed from: a */
    private final int f4881a;

    /* renamed from: b */
    private final List<ParcelableGeofence> f4882b;

    /* renamed from: c */
    private final int f4883c;

    GeofencingRequest(int i, List<ParcelableGeofence> list, int i2) {
        this.f4881a = i;
        this.f4882b = list;
        this.f4883c = i2;
    }

    /* renamed from: a */
    public int mo7727a() {
        return this.f4881a;
    }

    /* renamed from: b */
    public List<ParcelableGeofence> mo7728b() {
        return this.f4882b;
    }

    /* renamed from: c */
    public int mo7729c() {
        return this.f4883c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1145k.m4969a(this, parcel, i);
    }
}
