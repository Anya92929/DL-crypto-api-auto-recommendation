package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: a */
    private final int f5154a;
    public final LatLng northeast;
    public final LatLng southwest;

    public final class Builder {

        /* renamed from: a */
        private double f5155a = Double.POSITIVE_INFINITY;

        /* renamed from: b */
        private double f5156b = Double.NEGATIVE_INFINITY;

        /* renamed from: c */
        private double f5157c = Double.NaN;

        /* renamed from: d */
        private double f5158d = Double.NaN;

        /* renamed from: a */
        private boolean m5098a(double d) {
            boolean z = false;
            if (this.f5157c <= this.f5158d) {
                return this.f5157c <= d && d <= this.f5158d;
            }
            if (this.f5157c <= d || d <= this.f5158d) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            C1009bf.m4533a(!Double.isNaN(this.f5157c), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f5155a, this.f5157c), new LatLng(this.f5156b, this.f5158d));
        }

        public Builder include(LatLng latLng) {
            this.f5155a = Math.min(this.f5155a, latLng.latitude);
            this.f5156b = Math.max(this.f5156b, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f5157c)) {
                this.f5157c = d;
                this.f5158d = d;
            } else if (!m5098a(d)) {
                if (LatLngBounds.m5095c(this.f5157c, d) < LatLngBounds.m5096d(this.f5158d, d)) {
                    this.f5157c = d;
                } else {
                    this.f5158d = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        C1009bf.m4529a(latLng, (Object) "null southwest");
        C1009bf.m4529a(latLng2, (Object) "null northeast");
        C1009bf.m4534a(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.f5154a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* renamed from: a */
    private boolean m5092a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: b */
    private boolean m5094b(double d) {
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
    public static double m5095c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static double m5096d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8560a() {
        return this.f5154a;
    }

    public boolean contains(LatLng latLng) {
        return m5092a(latLng.latitude) && m5094b(latLng.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    public int hashCode() {
        return C1006bc.m4523a(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        double d;
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng.longitude;
        if (m5094b(d4)) {
            d4 = d3;
            d = d2;
        } else if (m5095c(d3, d4) < m5096d(d2, d4)) {
            d = d2;
        } else {
            double d5 = d3;
            d = d4;
            d4 = d5;
        }
        return new LatLngBounds(new LatLng(min, d4), new LatLng(max, d));
    }

    public String toString() {
        return C1006bc.m4524a((Object) this).mo7604a("southwest", this.southwest).mo7604a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.m5119a(this, parcel, i);
    }
}
