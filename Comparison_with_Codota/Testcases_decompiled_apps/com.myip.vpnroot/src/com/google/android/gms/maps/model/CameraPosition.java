package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0135R;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;

public final class CameraPosition implements SafeParcelable {
    public static final C1872a CREATOR = new C1872a();

    /* renamed from: BR */
    private final int f4466BR;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private LatLng ajq;
        private float ajr;
        private float ajs;
        private float ajt;

        public Builder() {
        }

        public Builder(CameraPosition previous) {
            this.ajq = previous.target;
            this.ajr = previous.zoom;
            this.ajs = previous.tilt;
            this.ajt = previous.bearing;
        }

        public Builder bearing(float bearing) {
            this.ajt = bearing;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.ajq, this.ajr, this.ajs, this.ajt);
        }

        public Builder target(LatLng location) {
            this.ajq = location;
            return this;
        }

        public Builder tilt(float tilt) {
            this.ajs = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.ajr = zoom;
            return this;
        }
    }

    CameraPosition(int versionCode, LatLng target2, float zoom2, float tilt2, float bearing2) {
        C0348n.m857b(target2, (Object) "null camera target");
        C0348n.m859b(0.0f <= tilt2 && tilt2 <= 90.0f, (Object) "Tilt needs to be between 0 and 90 inclusive");
        this.f4466BR = versionCode;
        this.target = target2;
        this.zoom = zoom2;
        this.tilt = tilt2 + 0.0f;
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
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0135R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(C0135R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(C0135R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(C0135R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(C0135R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(C0135R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng target2, float zoom2) {
        return new CameraPosition(target2, zoom2, 0.0f, 0.0f);
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
        return this.f4466BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("target", this.target).mo4549a("zoom", Float.valueOf(this.zoom)).mo4549a("tilt", Float.valueOf(this.tilt)).mo4549a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1873b.m6417a(this, out, flags);
        } else {
            C1872a.m6414a(this, out, flags);
        }
    }
}
