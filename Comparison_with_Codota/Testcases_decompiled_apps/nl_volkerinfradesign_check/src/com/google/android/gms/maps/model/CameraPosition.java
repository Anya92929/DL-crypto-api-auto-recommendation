package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0666R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class CameraPosition implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    private final int f3472a;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {

        /* renamed from: a */
        private LatLng f3473a;

        /* renamed from: b */
        private float f3474b;

        /* renamed from: c */
        private float f3475c;

        /* renamed from: d */
        private float f3476d;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.f3473a = cameraPosition.target;
            this.f3474b = cameraPosition.zoom;
            this.f3475c = cameraPosition.tilt;
            this.f3476d = cameraPosition.bearing;
        }

        public Builder bearing(float f) {
            this.f3476d = f;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.f3473a, this.f3474b, this.f3475c, this.f3476d);
        }

        public Builder target(LatLng latLng) {
            this.f3473a = latLng;
            return this;
        }

        public Builder tilt(float f) {
            this.f3475c = f;
            return this;
        }

        public Builder zoom(float f) {
            this.f3474b = f;
            return this;
        }
    }

    CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        zzx.zzb(latLng, (Object) "null camera target");
        zzx.zzb(BitmapDescriptorFactory.HUE_RED <= f2 && f2 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
        this.f3472a = i;
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2 + BitmapDescriptorFactory.HUE_RED;
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0666R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(C0666R.styleable.MapAttrs_cameraTargetLat, BitmapDescriptorFactory.HUE_RED) : 0.0f), (double) (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(C0666R.styleable.MapAttrs_cameraTargetLng, BitmapDescriptorFactory.HUE_RED) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(C0666R.styleable.MapAttrs_cameraZoom, BitmapDescriptorFactory.HUE_RED));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(C0666R.styleable.MapAttrs_cameraBearing, BitmapDescriptorFactory.HUE_RED));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(C0666R.styleable.MapAttrs_cameraTilt, BitmapDescriptorFactory.HUE_RED));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6679a() {
        return this.f3472a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public int hashCode() {
        return zzw.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return zzw.zzy(this).zzg("target", this.target).zzg("zoom", Float.valueOf(this.zoom)).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m4213a(this, parcel, i);
    }
}
