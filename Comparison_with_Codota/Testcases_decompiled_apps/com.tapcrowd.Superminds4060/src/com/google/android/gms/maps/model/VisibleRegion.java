package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.maps.internal.C0708r;

public final class VisibleRegion implements SafeParcelable {
    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
    public final LatLng farLeft;
    public final LatLng farRight;

    /* renamed from: iM */
    private final int f1780iM;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    VisibleRegion(int versionCode, LatLng nearLeft2, LatLng nearRight2, LatLng farLeft2, LatLng farRight2, LatLngBounds latLngBounds2) {
        this.f1780iM = versionCode;
        this.nearLeft = nearLeft2;
        this.nearRight = nearRight2;
        this.farLeft = farLeft2;
        this.farRight = farRight2;
        this.latLngBounds = latLngBounds2;
    }

    public VisibleRegion(LatLng nearLeft2, LatLng nearRight2, LatLng farLeft2, LatLng farRight2, LatLngBounds latLngBounds2) {
        this(1, nearLeft2, nearRight2, farLeft2, farRight2, latLngBounds2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) o;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1780iM;
    }

    public int hashCode() {
        return C0408dl.hashCode(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    public String toString() {
        return C0408dl.m938d(this).mo4388a("nearLeft", this.nearLeft).mo4388a("nearRight", this.nearRight).mo4388a("farLeft", this.farLeft).mo4388a("farRight", this.farRight).mo4388a("latLngBounds", this.latLngBounds).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0744k.m2152a(this, out, flags);
        } else {
            VisibleRegionCreator.m2103a(this, out, flags);
        }
    }
}
