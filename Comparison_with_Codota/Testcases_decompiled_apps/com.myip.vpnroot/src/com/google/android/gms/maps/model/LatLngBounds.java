package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;

public final class LatLngBounds implements SafeParcelable {
    public static final C1878g CREATOR = new C1878g();

    /* renamed from: BR */
    private final int f4470BR;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double ajN = Double.POSITIVE_INFINITY;
        private double ajO = Double.NEGATIVE_INFINITY;
        private double ajP = Double.NaN;
        private double ajQ = Double.NaN;

        /* renamed from: d */
        private boolean m6407d(double d) {
            boolean z = false;
            if (this.ajP <= this.ajQ) {
                return this.ajP <= d && d <= this.ajQ;
            }
            if (this.ajP <= d || d <= this.ajQ) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            C0348n.m852a(!Double.isNaN(this.ajP), "no included points");
            return new LatLngBounds(new LatLng(this.ajN, this.ajP), new LatLng(this.ajO, this.ajQ));
        }

        public Builder include(LatLng point) {
            this.ajN = Math.min(this.ajN, point.latitude);
            this.ajO = Math.max(this.ajO, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.ajP)) {
                this.ajP = d;
                this.ajQ = d;
            } else if (!m6407d(d)) {
                if (LatLngBounds.m6401b(this.ajP, d) < LatLngBounds.m6402c(this.ajQ, d)) {
                    this.ajP = d;
                } else {
                    this.ajQ = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest2, LatLng northeast2) {
        C0348n.m857b(southwest2, (Object) "null southwest");
        C0348n.m857b(northeast2, (Object) "null northeast");
        C0348n.m860b(northeast2.latitude >= southwest2.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest2.latitude), Double.valueOf(northeast2.latitude));
        this.f4470BR = versionCode;
        this.southwest = southwest2;
        this.northeast = northeast2;
    }

    public LatLngBounds(LatLng southwest2, LatLng northeast2) {
        this(1, southwest2, northeast2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static double m6401b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static double m6402c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* renamed from: c */
    private boolean m6403c(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: d */
    private boolean m6405d(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        }
        if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            z = true;
        }
        return z;
    }

    public boolean contains(LatLng point) {
        return m6403c(point.latitude) && m6405d(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4470BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double d;
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = point.longitude;
        if (m6405d(d4)) {
            d4 = d3;
            d = d2;
        } else if (m6401b(d3, d4) < m6402c(d2, d4)) {
            d = d2;
        } else {
            double d5 = d3;
            d = d4;
            d4 = d5;
        }
        return new LatLngBounds(new LatLng(min, d4), new LatLng(max, d));
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("southwest", this.southwest).mo4549a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1879h.m6429a(this, out, flags);
        } else {
            C1878g.m6426a(this, out, flags);
        }
    }
}
