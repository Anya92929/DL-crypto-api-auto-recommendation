package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.maps.internal.C0708r;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: iM */
    private final int f1717iM;

    /* renamed from: qd */
    private float f1718qd;

    /* renamed from: qk */
    private float f1719qk;

    /* renamed from: ql */
    private boolean f1720ql;

    /* renamed from: qn */
    private BitmapDescriptor f1721qn;

    /* renamed from: qo */
    private LatLng f1722qo;

    /* renamed from: qp */
    private float f1723qp;

    /* renamed from: qq */
    private float f1724qq;

    /* renamed from: qr */
    private LatLngBounds f1725qr;

    /* renamed from: qs */
    private float f1726qs;

    /* renamed from: qt */
    private float f1727qt;

    /* renamed from: qu */
    private float f1728qu;

    public GroundOverlayOptions() {
        this.f1720ql = true;
        this.f1726qs = BitmapDescriptorFactory.HUE_RED;
        this.f1727qt = 0.5f;
        this.f1728qu = 0.5f;
        this.f1717iM = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.f1720ql = true;
        this.f1726qs = BitmapDescriptorFactory.HUE_RED;
        this.f1727qt = 0.5f;
        this.f1728qu = 0.5f;
        this.f1717iM = versionCode;
        this.f1721qn = new BitmapDescriptor(C0164b.C0165a.m377z(wrappedImage));
        this.f1722qo = location;
        this.f1723qp = width;
        this.f1724qq = height;
        this.f1725qr = bounds;
        this.f1718qd = bearing;
        this.f1719qk = zIndex;
        this.f1720ql = visible;
        this.f1726qs = transparency;
        this.f1727qt = anchorU;
        this.f1728qu = anchorV;
    }

    /* renamed from: a */
    private GroundOverlayOptions m2080a(LatLng latLng, float f, float f2) {
        this.f1722qo = latLng;
        this.f1723qp = f;
        this.f1724qq = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.f1727qt = u;
        this.f1728qu = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.f1718qd = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cM */
    public IBinder mo5794cM() {
        return this.f1721qn.mo5720cs().asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f1727qt;
    }

    public float getAnchorV() {
        return this.f1728qu;
    }

    public float getBearing() {
        return this.f1718qd;
    }

    public LatLngBounds getBounds() {
        return this.f1725qr;
    }

    public float getHeight() {
        return this.f1724qq;
    }

    public BitmapDescriptor getImage() {
        return this.f1721qn;
    }

    public LatLng getLocation() {
        return this.f1722qo;
    }

    public float getTransparency() {
        return this.f1726qs;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1717iM;
    }

    public float getWidth() {
        return this.f1723qp;
    }

    public float getZIndex() {
        return this.f1719qk;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.f1721qn = image;
        return this;
    }

    public boolean isVisible() {
        return this.f1720ql;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        C0411dm.m941a(this.f1725qr == null, (Object) "Position has already been set using positionFromBounds");
        C0411dm.m943b(location != null, "Location must be specified");
        if (width < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        C0411dm.m943b(z, "Width must be non-negative");
        return m2080a(location, width, -1.0f);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        C0411dm.m941a(this.f1725qr == null, (Object) "Position has already been set using positionFromBounds");
        C0411dm.m943b(location != null, "Location must be specified");
        C0411dm.m943b(width >= BitmapDescriptorFactory.HUE_RED, "Width must be non-negative");
        if (height < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        C0411dm.m943b(z, "Height must be non-negative");
        return m2080a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        C0411dm.m941a(this.f1722qo == null, (Object) "Position has already been set using position: " + this.f1722qo);
        this.f1725qr = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        C0411dm.m943b(transparency >= BitmapDescriptorFactory.HUE_RED && transparency <= 1.0f, "Transparency must be in the range [0..1]");
        this.f1726qs = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.f1720ql = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0713c.m2106a(this, out, flags);
        } else {
            GroundOverlayOptionsCreator.m2082a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.f1719qk = zIndex;
        return this;
    }
}
