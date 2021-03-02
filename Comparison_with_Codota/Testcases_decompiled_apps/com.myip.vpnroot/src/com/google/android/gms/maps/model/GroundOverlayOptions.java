package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.maps.internal.C1869v;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final C1876e CREATOR = new C1876e();
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: BR */
    private final int f4468BR;
    private float ajA;
    private boolean ajB;
    private BitmapDescriptor ajD;
    private LatLng ajE;
    private float ajF;
    private float ajG;
    private LatLngBounds ajH;
    private float ajI;
    private float ajJ;
    private float ajK;
    private float ajt;

    public GroundOverlayOptions() {
        this.ajB = true;
        this.ajI = 0.0f;
        this.ajJ = 0.5f;
        this.ajK = 0.5f;
        this.f4468BR = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.ajB = true;
        this.ajI = 0.0f;
        this.ajJ = 0.5f;
        this.ajK = 0.5f;
        this.f4468BR = versionCode;
        this.ajD = new BitmapDescriptor(C0594d.C0595a.m1741am(wrappedImage));
        this.ajE = location;
        this.ajF = width;
        this.ajG = height;
        this.ajH = bounds;
        this.ajt = bearing;
        this.ajA = zIndex;
        this.ajB = visible;
        this.ajI = transparency;
        this.ajJ = anchorU;
        this.ajK = anchorV;
    }

    /* renamed from: a */
    private GroundOverlayOptions m6399a(LatLng latLng, float f, float f2) {
        this.ajE = latLng;
        this.ajF = f;
        this.ajG = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.ajJ = u;
        this.ajK = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.ajt = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.ajJ;
    }

    public float getAnchorV() {
        return this.ajK;
    }

    public float getBearing() {
        return this.ajt;
    }

    public LatLngBounds getBounds() {
        return this.ajH;
    }

    public float getHeight() {
        return this.ajG;
    }

    public BitmapDescriptor getImage() {
        return this.ajD;
    }

    public LatLng getLocation() {
        return this.ajE;
    }

    public float getTransparency() {
        return this.ajI;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4468BR;
    }

    public float getWidth() {
        return this.ajF;
    }

    public float getZIndex() {
        return this.ajA;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.ajD = image;
        return this;
    }

    public boolean isVisible() {
        return this.ajB;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mM */
    public IBinder mo10805mM() {
        return this.ajD.mo10721mm().asBinder();
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        C0348n.m852a(this.ajH == null, "Position has already been set using positionFromBounds");
        C0348n.m859b(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        C0348n.m859b(z, (Object) "Width must be non-negative");
        return m6399a(location, width, -1.0f);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        C0348n.m852a(this.ajH == null, "Position has already been set using positionFromBounds");
        C0348n.m859b(location != null, (Object) "Location must be specified");
        C0348n.m859b(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        C0348n.m859b(z, (Object) "Height must be non-negative");
        return m6399a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        C0348n.m852a(this.ajE == null, "Position has already been set using position: " + this.ajE);
        this.ajH = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        C0348n.m859b(transparency >= 0.0f && transparency <= 1.0f, (Object) "Transparency must be in the range [0..1]");
        this.ajI = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.ajB = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1877f.m6425a(this, out, flags);
        } else {
            C1876e.m6422a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.ajA = zIndex;
        return this;
    }
}
