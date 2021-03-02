package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaOrientation implements SafeParcelable {
    public static final zzm CREATOR = new zzm();

    /* renamed from: a */
    private final int f5197a;
    public final float bearing;
    public final float tilt;

    public final class Builder {
        public float bearing;
        public float tilt;

        public Builder(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            this.bearing = streetViewPanoramaOrientation.bearing;
            this.tilt = streetViewPanoramaOrientation.tilt;
        }

        public Builder bearing(float f) {
            this.bearing = f;
            return this;
        }

        public StreetViewPanoramaOrientation build() {
            return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
        }

        public Builder tilt(float f) {
            this.tilt = f;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f, float f2) {
        this(1, f, f2);
    }

    StreetViewPanoramaOrientation(int i, float f, float f2) {
        C1009bf.m4537b(-90.0f <= f && f <= 90.0f, "Tilt needs to be between -90 and 90 inclusive");
        this.f5197a = i;
        this.tilt = BitmapDescriptorFactory.HUE_RED + f;
        this.bearing = (((double) f2) <= 0.0d ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        return new Builder(streetViewPanoramaOrientation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8727a() {
        return this.f5197a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaOrientation.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaOrientation.bearing);
    }

    public int hashCode() {
        return C1006bc.m4523a(Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return C1006bc.m4524a((Object) this).mo7604a("tilt", Float.valueOf(this.tilt)).mo7604a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.m5128a(this, parcel, i);
    }
}
