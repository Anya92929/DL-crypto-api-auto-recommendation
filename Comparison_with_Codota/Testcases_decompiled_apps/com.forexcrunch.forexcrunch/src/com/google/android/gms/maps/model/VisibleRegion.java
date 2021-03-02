package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.maps.internal.C0708q;

public final class VisibleRegion implements SafeParcelable {
    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();

    /* renamed from: ab */
    private final int f1640ab;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    VisibleRegion(int versionCode, LatLng nearLeft2, LatLng nearRight2, LatLng farLeft2, LatLng farRight2, LatLngBounds latLngBounds2) {
        this.f1640ab = versionCode;
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

    public int hashCode() {
        return C0618r.hashCode(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo6168i() {
        return this.f1640ab;
    }

    public String toString() {
        return C0618r.m1882c(this).mo5486a("nearLeft", this.nearLeft).mo5486a("nearRight", this.nearRight).mo5486a("farLeft", this.farLeft).mo5486a("farRight", this.farRight).mo5486a("latLngBounds", this.latLngBounds).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0744k.m2112a(this, out, flags);
        } else {
            VisibleRegionCreator.m2065a(this, out, flags);
        }
    }
}
