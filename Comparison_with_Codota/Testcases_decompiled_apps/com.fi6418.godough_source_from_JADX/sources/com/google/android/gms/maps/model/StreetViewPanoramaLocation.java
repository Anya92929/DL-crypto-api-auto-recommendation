package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final zzl CREATOR = new zzl();

    /* renamed from: a */
    private final int f5196a;
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    StreetViewPanoramaLocation(int i, StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f5196a = i;
        this.links = streetViewPanoramaLinkArr;
        this.position = latLng;
        this.panoId = str;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this(1, streetViewPanoramaLinkArr, latLng, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8721a() {
        return this.f5196a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    public int hashCode() {
        return C1006bc.m4523a(this.position, this.panoId);
    }

    public String toString() {
        return C1006bc.m4524a((Object) this).mo7604a("panoId", this.panoId).mo7604a("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.m5127a(this, parcel, i);
    }
}
