package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double zzaTu = Double.POSITIVE_INFINITY;
        private double zzaTv = Double.NEGATIVE_INFINITY;
        private double zzaTw = Double.NaN;
        private double zzaTx = Double.NaN;

        private boolean zzj(double d) {
            boolean z = false;
            if (this.zzaTw <= this.zzaTx) {
                return this.zzaTw <= d && d <= this.zzaTx;
            }
            if (this.zzaTw <= d || d <= this.zzaTx) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            zzx.zza(!Double.isNaN(this.zzaTw), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.zzaTu, this.zzaTw), new LatLng(this.zzaTv, this.zzaTx));
        }

        public Builder include(LatLng point) {
            this.zzaTu = Math.min(this.zzaTu, point.latitude);
            this.zzaTv = Math.max(this.zzaTv, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.zzaTw)) {
                this.zzaTw = d;
                this.zzaTx = d;
            } else if (!zzj(d)) {
                if (LatLngBounds.zzb(this.zzaTw, d) < LatLngBounds.zzc(this.zzaTx, d)) {
                    this.zzaTw = d;
                } else {
                    this.zzaTx = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest2, LatLng northeast2) {
        zzx.zzb(southwest2, (Object) "null southwest");
        zzx.zzb(northeast2, (Object) "null northeast");
        zzx.zzb(northeast2.latitude >= southwest2.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest2.latitude), Double.valueOf(northeast2.latitude));
        this.mVersionCode = versionCode;
        this.southwest = southwest2;
        this.northeast = northeast2;
    }

    public LatLngBounds(LatLng southwest2, LatLng northeast2) {
        this(1, southwest2, northeast2);
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public static double zzb(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    public static double zzc(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean zzi(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean zzj(double d) {
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
        return zzi(point.latitude) && zzj(point.longitude);
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
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double d;
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = point.longitude;
        if (zzj(d4)) {
            d4 = d3;
            d = d2;
        } else if (zzb(d3, d4) < zzc(d2, d4)) {
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

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
