package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    public final StreetViewPanoramaLink[] links;
    private final int mVersionCode;
    public final String panoId;
    public final LatLng position;

    StreetViewPanoramaLocation(int versionCode, StreetViewPanoramaLink[] links2, LatLng position2, String panoId2) {
        this.mVersionCode = versionCode;
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
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return zzw.zzy(this).zzg("panoId", this.panoId).zzg("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzl.zza(this, out, flags);
    }
}
