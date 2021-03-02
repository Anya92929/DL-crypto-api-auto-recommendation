package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;

public final class VisibleRegion implements SafeParcelable {
    public static final C1925y CREATOR = new C1925y();

    /* renamed from: BR */
    private final int f4483BR;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    VisibleRegion(int versionCode, LatLng nearLeft2, LatLng nearRight2, LatLng farLeft2, LatLng farRight2, LatLngBounds latLngBounds2) {
        this.f4483BR = versionCode;
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
        return this.f4483BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("nearLeft", this.nearLeft).mo4549a("nearRight", this.nearRight).mo4549a("farLeft", this.farLeft).mo4549a("farRight", this.farRight).mo4549a("latLngBounds", this.latLngBounds).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1926z.m6513a(this, out, flags);
        } else {
            C1925y.m6510a(this, out, flags);
        }
    }
}
