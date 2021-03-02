package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PointOfInterest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();

    /* renamed from: a */
    private final int f3523a;
    public final String name;
    public final LatLng zzaTG;
    public final String zzaTH;

    PointOfInterest(int i, LatLng latLng, String str, String str2) {
        this.f3523a = i;
        this.zzaTG = latLng;
        this.zzaTH = str;
        this.name = str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6856a() {
        return this.f3523a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m4219a(this, parcel, i);
    }
}
