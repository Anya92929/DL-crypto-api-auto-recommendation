package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0129R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.maps.internal.C0708r;

public final class CameraPosition implements SafeParcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;

    /* renamed from: iM */
    private final int f1702iM;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {

        /* renamed from: qa */
        private LatLng f1703qa;

        /* renamed from: qb */
        private float f1704qb;

        /* renamed from: qc */
        private float f1705qc;

        /* renamed from: qd */
        private float f1706qd;

        public Builder() {
        }

        public Builder(CameraPosition previous) {
            this.f1703qa = previous.target;
            this.f1704qb = previous.zoom;
            this.f1705qc = previous.tilt;
            this.f1706qd = previous.bearing;
        }

        public Builder bearing(float bearing) {
            this.f1706qd = bearing;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.f1703qa, this.f1704qb, this.f1705qc, this.f1706qd);
        }

        public Builder target(LatLng location) {
            this.f1703qa = location;
            return this;
        }

        public Builder tilt(float tilt) {
            this.f1705qc = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.f1704qb = zoom;
            return this;
        }
    }

    CameraPosition(int versionCode, LatLng target2, float zoom2, float tilt2, float bearing2) {
        C0411dm.m940a(target2, (Object) "null camera target");
        C0411dm.m943b(BitmapDescriptorFactory.HUE_RED <= tilt2 && tilt2 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive");
        this.f1702iM = versionCode;
        this.target = target2;
        this.zoom = zoom2;
        this.tilt = tilt2 + BitmapDescriptorFactory.HUE_RED;
        this.bearing = (((double) bearing2) <= 0.0d ? (bearing2 % 360.0f) + 360.0f : bearing2) % 360.0f;
    }

    public CameraPosition(LatLng target2, float zoom2, float tilt2, float bearing2) {
        this(1, target2, zoom2, tilt2, bearing2);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition camera) {
        return new Builder(camera);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0129R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(2) ? obtainAttributes.getFloat(2, BitmapDescriptorFactory.HUE_RED) : 0.0f), (double) (obtainAttributes.hasValue(3) ? obtainAttributes.getFloat(3, BitmapDescriptorFactory.HUE_RED) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(5)) {
            builder.zoom(obtainAttributes.getFloat(5, BitmapDescriptorFactory.HUE_RED));
        }
        if (obtainAttributes.hasValue(1)) {
            builder.bearing(obtainAttributes.getFloat(1, BitmapDescriptorFactory.HUE_RED));
        }
        if (obtainAttributes.hasValue(4)) {
            builder.tilt(obtainAttributes.getFloat(4, BitmapDescriptorFactory.HUE_RED));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng target2, float zoom2) {
        return new CameraPosition(target2, zoom2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) o;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1702iM;
    }

    public int hashCode() {
        return C0408dl.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return C0408dl.m938d(this).mo4388a("target", this.target).mo4388a("zoom", Float.valueOf(this.zoom)).mo4388a("tilt", Float.valueOf(this.tilt)).mo4388a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0711a.m2104a(this, out, flags);
        } else {
            CameraPositionCreator.m2078a(this, out, flags);
        }
    }
}
