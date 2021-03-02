package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.C0708q;

public final class LatLngBounds implements SafeParcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();

    /* renamed from: ab */
    private final int f1590ab;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {

        /* renamed from: hm */
        private double f1591hm = Double.POSITIVE_INFINITY;

        /* renamed from: hn */
        private double f1592hn = Double.NEGATIVE_INFINITY;

        /* renamed from: ho */
        private double f1593ho = Double.NaN;

        /* renamed from: hp */
        private double f1594hp = Double.NaN;

        /* renamed from: b */
        private boolean m2045b(double d) {
            boolean z = false;
            if (this.f1593ho <= this.f1594hp) {
                return this.f1593ho <= d && d <= this.f1594hp;
            }
            if (this.f1593ho <= d || d <= this.f1594hp) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            C0621s.m1885a(!Double.isNaN(this.f1593ho), "no included points");
            return new LatLngBounds(new LatLng(this.f1591hm, this.f1593ho), new LatLng(this.f1592hn, this.f1594hp));
        }

        public Builder include(LatLng point) {
            this.f1591hm = Math.min(this.f1591hm, point.latitude);
            this.f1592hn = Math.max(this.f1592hn, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.f1593ho)) {
                this.f1593ho = d;
                this.f1594hp = d;
            } else if (!m2045b(d)) {
                if (LatLngBounds.m2039b(this.f1593ho, d) < LatLngBounds.m2041c(this.f1594hp, d)) {
                    this.f1593ho = d;
                } else {
                    this.f1594hp = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest2, LatLng northeast2) {
        C0621s.m1887b(southwest2, (Object) "null southwest");
        C0621s.m1887b(northeast2, (Object) "null northeast");
        C0621s.m1886a(northeast2.latitude >= southwest2.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest2.latitude), Double.valueOf(northeast2.latitude));
        this.f1590ab = versionCode;
        this.southwest = southwest2;
        this.northeast = northeast2;
    }

    public LatLngBounds(LatLng southwest2, LatLng northeast2) {
        this(1, southwest2, northeast2);
    }

    /* renamed from: a */
    private boolean m2038a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static double m2039b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: b */
    private boolean m2040b(double d) {
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
    public static double m2041c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public boolean contains(LatLng point) {
        return m2038a(point.latitude) && m2040b(point.longitude);
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

    public int hashCode() {
        return C0618r.hashCode(this.southwest, this.northeast);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5995i() {
        return this.f1590ab;
    }

    public LatLngBounds including(LatLng point) {
        double d;
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = point.longitude;
        if (m2040b(d4)) {
            d4 = d3;
            d = d2;
        } else if (m2039b(d3, d4) < m2041c(d2, d4)) {
            d = d2;
        } else {
            double d5 = d3;
            d = d4;
            d4 = d5;
        }
        return new LatLngBounds(new LatLng(min, d4), new LatLng(max, d));
    }

    public String toString() {
        return C0618r.m1882c(this).mo5486a("southwest", this.southwest).mo5486a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0714d.m2069a(this, out, flags);
        } else {
            LatLngBoundsCreator.m2046a(this, out, flags);
        }
    }
}
