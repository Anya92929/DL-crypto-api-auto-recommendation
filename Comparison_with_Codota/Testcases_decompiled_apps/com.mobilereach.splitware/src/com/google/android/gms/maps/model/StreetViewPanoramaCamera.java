package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanoramaCamera implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final float bearing;
    private final int mVersionCode;
    public final float tilt;
    public final float zoom;
    private StreetViewPanoramaOrientation zzaTN;

    public static final class Builder {
        public float bearing;
        public float tilt;
        public float zoom;

        public Builder() {
        }

        public Builder(StreetViewPanoramaCamera previous) {
            this.zoom = previous.zoom;
            this.bearing = previous.bearing;
            this.tilt = previous.tilt;
        }

        public Builder bearing(float bearing2) {
            this.bearing = bearing2;
            return this;
        }

        public StreetViewPanoramaCamera build() {
            return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
        }

        public Builder orientation(StreetViewPanoramaOrientation orientation) {
            this.tilt = orientation.tilt;
            this.bearing = orientation.bearing;
            return this;
        }

        public Builder tilt(float tilt2) {
            this.tilt = tilt2;
            return this;
        }

        public Builder zoom(float zoom2) {
            this.zoom = zoom2;
            return this;
        }
    }

    public StreetViewPanoramaCamera(float zoom2, float tilt2, float bearing2) {
        this(1, zoom2, tilt2, bearing2);
    }

    StreetViewPanoramaCamera(int versionCode, float zoom2, float tilt2, float bearing2) {
        zzx.zzb(-90.0f <= tilt2 && tilt2 <= 90.0f, (Object) "Tilt needs to be between -90 and 90 inclusive");
        this.mVersionCode = versionCode;
        this.zoom = ((double) zoom2) <= 0.0d ? 0.0f : zoom2;
        this.tilt = tilt2 + 0.0f;
        this.bearing = (((double) bearing2) <= 0.0d ? (bearing2 % 360.0f) + 360.0f : bearing2) % 360.0f;
        this.zzaTN = new StreetViewPanoramaOrientation.Builder().tilt(tilt2).bearing(bearing2).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaCamera camera) {
        return new Builder(camera);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) o;
        return Float.floatToIntBits(this.zoom) == Float.floatToIntBits(streetViewPanoramaCamera.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaCamera.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaCamera.bearing);
    }

    public StreetViewPanoramaOrientation getOrientation() {
        return this.zzaTN;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return zzw.zzy(this).zzg("zoom", Float.valueOf(this.zoom)).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }
}
