package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0368b;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.C0708q;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: ab */
    private final int f1577ab;

    /* renamed from: gU */
    private float f1578gU;

    /* renamed from: hb */
    private float f1579hb;

    /* renamed from: hc */
    private boolean f1580hc;

    /* renamed from: he */
    private BitmapDescriptor f1581he;

    /* renamed from: hf */
    private LatLng f1582hf;

    /* renamed from: hg */
    private float f1583hg;

    /* renamed from: hh */
    private float f1584hh;

    /* renamed from: hi */
    private LatLngBounds f1585hi;

    /* renamed from: hj */
    private float f1586hj;

    /* renamed from: hk */
    private float f1587hk;

    /* renamed from: hl */
    private float f1588hl;

    public GroundOverlayOptions() {
        this.f1580hc = true;
        this.f1586hj = BitmapDescriptorFactory.HUE_RED;
        this.f1587hk = 0.5f;
        this.f1588hl = 0.5f;
        this.f1577ab = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.f1580hc = true;
        this.f1586hj = BitmapDescriptorFactory.HUE_RED;
        this.f1587hk = 0.5f;
        this.f1588hl = 0.5f;
        this.f1577ab = versionCode;
        this.f1581he = new BitmapDescriptor(C0368b.C0369a.m700l(wrappedImage));
        this.f1582hf = location;
        this.f1583hg = width;
        this.f1584hh = height;
        this.f1585hi = bounds;
        this.f1578gU = bearing;
        this.f1579hb = zIndex;
        this.f1580hc = visible;
        this.f1586hj = transparency;
        this.f1587hk = anchorU;
        this.f1588hl = anchorV;
    }

    /* renamed from: a */
    private GroundOverlayOptions m2033a(LatLng latLng, float f, float f2) {
        this.f1582hf = latLng;
        this.f1583hg = f;
        this.f1584hh = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.f1587hk = u;
        this.f1588hl = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.f1578gU = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bp */
    public IBinder mo5960bp() {
        return this.f1581he.mo5887aW().asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f1587hk;
    }

    public float getAnchorV() {
        return this.f1588hl;
    }

    public float getBearing() {
        return this.f1578gU;
    }

    public LatLngBounds getBounds() {
        return this.f1585hi;
    }

    public float getHeight() {
        return this.f1584hh;
    }

    public BitmapDescriptor getImage() {
        return this.f1581he;
    }

    public LatLng getLocation() {
        return this.f1582hf;
    }

    public float getTransparency() {
        return this.f1586hj;
    }

    public float getWidth() {
        return this.f1583hg;
    }

    public float getZIndex() {
        return this.f1579hb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5972i() {
        return this.f1577ab;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.f1581he = image;
        return this;
    }

    public boolean isVisible() {
        return this.f1580hc;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        C0621s.m1885a(this.f1585hi == null, "Position has already been set using positionFromBounds");
        C0621s.m1888b(location != null, (Object) "Location must be specified");
        if (width < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        C0621s.m1888b(z, (Object) "Width must be non-negative");
        return m2033a(location, width, -1.0f);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        C0621s.m1885a(this.f1585hi == null, "Position has already been set using positionFromBounds");
        C0621s.m1888b(location != null, (Object) "Location must be specified");
        C0621s.m1888b(width >= BitmapDescriptorFactory.HUE_RED, (Object) "Width must be non-negative");
        if (height < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        C0621s.m1888b(z, (Object) "Height must be non-negative");
        return m2033a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        C0621s.m1885a(this.f1582hf == null, "Position has already been set using position: " + this.f1582hf);
        this.f1585hi = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        C0621s.m1888b(transparency >= BitmapDescriptorFactory.HUE_RED && transparency <= 1.0f, (Object) "Transparency must be in the range [0..1]");
        this.f1586hj = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.f1580hc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0713c.m2068a(this, out, flags);
        } else {
            GroundOverlayOptionsCreator.m2036a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.f1579hb = zIndex;
        return this;
    }
}
