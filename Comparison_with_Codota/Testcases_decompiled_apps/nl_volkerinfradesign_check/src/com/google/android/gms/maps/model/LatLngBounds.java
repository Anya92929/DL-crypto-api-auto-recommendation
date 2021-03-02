package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: a */
    private final int f3503a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {

        /* renamed from: a */
        private double f3504a = Double.POSITIVE_INFINITY;

        /* renamed from: b */
        private double f3505b = Double.NEGATIVE_INFINITY;

        /* renamed from: c */
        private double f3506c = Double.NaN;

        /* renamed from: d */
        private double f3507d = Double.NaN;

        /* renamed from: a */
        private boolean m4195a(double d) {
            boolean z = false;
            if (this.f3506c <= this.f3507d) {
                return this.f3506c <= d && d <= this.f3507d;
            }
            if (this.f3506c <= d || d <= this.f3507d) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            zzx.zza(!Double.isNaN(this.f3506c), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f3504a, this.f3506c), new LatLng(this.f3505b, this.f3507d));
        }

        public Builder include(LatLng latLng) {
            this.f3504a = Math.min(this.f3504a, latLng.latitude);
            this.f3505b = Math.max(this.f3505b, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f3506c)) {
                this.f3506c = d;
                this.f3507d = d;
            } else if (!m4195a(d)) {
                if (LatLngBounds.m4192c(this.f3506c, d) < LatLngBounds.m4193d(this.f3507d, d)) {
                    this.f3506c = d;
                } else {
                    this.f3507d = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        zzx.zzb(latLng, (Object) "null southwest");
        zzx.zzb(latLng2, (Object) "null northeast");
        zzx.zzb(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.f3503a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* renamed from: a */
    private boolean m4189a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: b */
    private boolean m4191b(double d) {
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
    public static double m4192c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static double m4193d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6791a() {
        return this.f3503a;
    }

    public boolean contains(LatLng latLng) {
        return m4189a(latLng.latitude) && m4191b(latLng.longitude);
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
        return zzw.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        double d;
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng.longitude;
        if (m4191b(d4)) {
            d4 = d3;
            d = d2;
        } else if (m4192c(d3, d4) < m4193d(d2, d4)) {
            d = d2;
        } else {
            double d5 = d3;
            d = d4;
            d4 = d5;
        }
        return new LatLngBounds(new LatLng(min, d4), new LatLng(max, d));
    }

    public String toString() {
        return zzw.zzy(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.m4216a(this, parcel, i);
    }
}
