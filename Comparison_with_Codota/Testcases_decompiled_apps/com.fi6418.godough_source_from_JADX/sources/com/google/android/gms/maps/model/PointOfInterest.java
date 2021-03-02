package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PointOfInterest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();

    /* renamed from: a */
    private final int f5174a;
    public final String name;
    public final LatLng zzaHy;
    public final String zzaHz;

    PointOfInterest(int i, LatLng latLng, String str, String str2) {
        this.f5174a = i;
        this.zzaHy = latLng;
        this.zzaHz = str;
        this.name = str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8625a() {
        return this.f5174a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m5122a(this, parcel, i);
    }
}
