package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanoramaCamera implements SafeParcelable {
    public static final zzj CREATOR = new zzj();

    /* renamed from: a */
    private final int f5193a;

    /* renamed from: b */
    private StreetViewPanoramaOrientation f5194b;
    public final float bearing;
    public final float tilt;
    public final float zoom;

    public final class Builder {
        public float bearing;
        public float tilt;
        public float zoom;

        public Builder(StreetViewPanoramaCamera streetViewPanoramaCamera) {
            this.zoom = streetViewPanoramaCamera.zoom;
            this.bearing = streetViewPanoramaCamera.bearing;
            this.tilt = streetViewPanoramaCamera.tilt;
        }

        public Builder bearing(float f) {
            this.bearing = f;
            return this;
        }

        public StreetViewPanoramaCamera build() {
            return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
        }

        public Builder orientation(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            this.tilt = streetViewPanoramaOrientation.tilt;
            this.bearing = streetViewPanoramaOrientation.bearing;
            return this;
        }

        public Builder tilt(float f) {
            this.tilt = f;
            return this;
        }

        public Builder zoom(float f) {
            this.zoom = f;
            return this;
        }
    }

    public StreetViewPanoramaCamera(float f, float f2, float f3) {
        this(1, f, f2, f3);
    }

    StreetViewPanoramaCamera(int i, float f, float f2, float f3) {
        C1009bf.m4537b(-90.0f <= f2 && f2 <= 90.0f, "Tilt needs to be between -90 and 90 inclusive");
        this.f5193a = i;
        this.zoom = ((double) f) <= 0.0d ? 0.0f : f;
        this.tilt = f2 + BitmapDescriptorFactory.HUE_RED;
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        this.f5194b = new StreetViewPanoramaOrientation.Builder().tilt(f2).bearing(f3).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        return new Builder(streetViewPanoramaCamera);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8703a() {
        return this.f5193a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.zoom) == Float.floatToIntBits(streetViewPanoramaCamera.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaCamera.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaCamera.bearing);
    }

    public StreetViewPanoramaOrientation getOrientation() {
        return this.f5194b;
    }

    public int hashCode() {
        return C1006bc.m4523a(Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return C1006bc.m4524a((Object) this).mo7604a("zoom", Float.valueOf(this.zoom)).mo7604a("tilt", Float.valueOf(this.tilt)).mo7604a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m5125a(this, parcel, i);
    }
}
