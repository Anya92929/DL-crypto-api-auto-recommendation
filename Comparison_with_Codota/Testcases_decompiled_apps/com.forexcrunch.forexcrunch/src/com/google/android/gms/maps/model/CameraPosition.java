package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0334R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.C0708q;

public final class CameraPosition implements SafeParcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();

    /* renamed from: ab */
    private final int f1562ab;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {

        /* renamed from: gR */
        private LatLng f1563gR;

        /* renamed from: gS */
        private float f1564gS;

        /* renamed from: gT */
        private float f1565gT;

        /* renamed from: gU */
        private float f1566gU;

        public Builder() {
        }

        public Builder(CameraPosition previous) {
            this.f1563gR = previous.target;
            this.f1564gS = previous.zoom;
            this.f1565gT = previous.tilt;
            this.f1566gU = previous.bearing;
        }

        public Builder bearing(float bearing) {
            this.f1566gU = bearing;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.f1563gR, this.f1564gS, this.f1565gT, this.f1566gU);
        }

        public Builder target(LatLng location) {
            this.f1563gR = location;
            return this;
        }

        public Builder tilt(float tilt) {
            this.f1565gT = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.f1564gS = zoom;
            return this;
        }
    }

    CameraPosition(int versionCode, LatLng target2, float zoom2, float tilt2, float bearing2) {
        C0621s.m1887b(target2, (Object) "null camera target");
        C0621s.m1888b(BitmapDescriptorFactory.HUE_RED <= tilt2 && tilt2 <= 90.0f, (Object) "Tilt needs to be between 0 and 90 inclusive");
        this.f1562ab = versionCode;
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
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0334R.styleable.MapAttrs);
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

    public int hashCode() {
        return C0618r.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5891i() {
        return this.f1562ab;
    }

    public String toString() {
        return C0618r.m1882c(this).mo5486a("target", this.target).mo5486a("zoom", Float.valueOf(this.zoom)).mo5486a("tilt", Float.valueOf(this.tilt)).mo5486a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0711a.m2066a(this, out, flags);
        } else {
            CameraPositionCreator.m2030a(this, out, flags);
        }
    }
}
