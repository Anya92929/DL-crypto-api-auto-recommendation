package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final C1919s CREATOR = new C1919s();

    /* renamed from: BR */
    private final int f4477BR;
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    StreetViewPanoramaLocation(int versionCode, StreetViewPanoramaLink[] links2, LatLng position2, String panoId2) {
        this.f4477BR = versionCode;
        this.links = links2;
        this.position = position2;
        this.panoId = panoId2;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] links2, LatLng position2, String panoId2) {
        this(1, links2, position2, panoId2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) o;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4477BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("panoId", this.panoId).mo4549a("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1919s.m6496a(this, out, flags);
    }
}
