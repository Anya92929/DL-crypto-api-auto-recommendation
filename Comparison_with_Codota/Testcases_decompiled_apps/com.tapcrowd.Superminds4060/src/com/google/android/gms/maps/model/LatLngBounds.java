package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.maps.internal.C0708r;

public final class LatLngBounds implements SafeParcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();

    /* renamed from: iM */
    private final int f1730iM;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {

        /* renamed from: qv */
        private double f1731qv = Double.POSITIVE_INFINITY;

        /* renamed from: qw */
        private double f1732qw = Double.NEGATIVE_INFINITY;

        /* renamed from: qx */
        private double f1733qx = Double.NaN;

        /* renamed from: qy */
        private double f1734qy = Double.NaN;

        /* renamed from: b */
        private boolean m2089b(double d) {
            boolean z = false;
            if (this.f1733qx <= this.f1734qy) {
                return this.f1733qx <= d && d <= this.f1734qy;
            }
            if (this.f1733qx <= d || d <= this.f1734qy) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            C0411dm.m941a(!Double.isNaN(this.f1733qx), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f1731qv, this.f1733qx), new LatLng(this.f1732qw, this.f1734qy));
        }

        public Builder include(LatLng point) {
            this.f1731qv = Math.min(this.f1731qv, point.latitude);
            this.f1732qw = Math.max(this.f1732qw, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.f1733qx)) {
                this.f1733qx = d;
                this.f1734qy = d;
            } else if (!m2089b(d)) {
                if (LatLngBounds.m2084b(this.f1733qx, d) < LatLngBounds.m2086c(this.f1734qy, d)) {
                    this.f1733qx = d;
                } else {
                    this.f1734qy = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest2, LatLng northeast2) {
        C0411dm.m940a(southwest2, (Object) "null southwest");
        C0411dm.m940a(northeast2, (Object) "null northeast");
        C0411dm.m942a(northeast2.latitude >= southwest2.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest2.latitude), Double.valueOf(northeast2.latitude));
        this.f1730iM = versionCode;
        this.southwest = southwest2;
        this.northeast = northeast2;
    }

    public LatLngBounds(LatLng southwest2, LatLng northeast2) {
        this(1, southwest2, northeast2);
    }

    /* renamed from: a */
    private boolean m2083a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static double m2084b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: b */
    private boolean m2085b(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        }
        if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            z = true;
        }
        return z;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static double m2086c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public boolean contains(LatLng point) {
        return m2083a(point.latitude) && m2085b(point.longitude);
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
        return this.f1730iM;
    }

    public int hashCode() {
        return C0408dl.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double d;
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = point.longitude;
        if (m2085b(d4)) {
            d4 = d3;
            d = d2;
        } else if (m2084b(d3, d4) < m2086c(d2, d4)) {
            d = d2;
        } else {
            double d5 = d3;
            d = d4;
            d4 = d5;
        }
        return new LatLngBounds(new LatLng(min, d4), new LatLng(max, d));
    }

    public String toString() {
        return C0408dl.m938d(this).mo4388a("southwest", this.southwest).mo4388a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0714d.m2107a(this, out, flags);
        } else {
            LatLngBoundsCreator.m2090a(this, out, flags);
        }
    }
}
