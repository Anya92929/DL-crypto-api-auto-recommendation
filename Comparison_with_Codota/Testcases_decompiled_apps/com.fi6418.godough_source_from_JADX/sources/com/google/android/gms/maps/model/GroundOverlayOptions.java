package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p017b.C0606k;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: a */
    private final int f5139a;

    /* renamed from: b */
    private BitmapDescriptor f5140b;

    /* renamed from: c */
    private LatLng f5141c;

    /* renamed from: d */
    private float f5142d;

    /* renamed from: e */
    private float f5143e;

    /* renamed from: f */
    private LatLngBounds f5144f;

    /* renamed from: g */
    private float f5145g;

    /* renamed from: h */
    private float f5146h;

    /* renamed from: i */
    private boolean f5147i;

    /* renamed from: j */
    private float f5148j;

    /* renamed from: k */
    private float f5149k;

    /* renamed from: l */
    private float f5150l;

    public GroundOverlayOptions() {
        this.f5147i = true;
        this.f5148j = BitmapDescriptorFactory.HUE_RED;
        this.f5149k = 0.5f;
        this.f5150l = 0.5f;
        this.f5139a = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.f5147i = true;
        this.f5148j = BitmapDescriptorFactory.HUE_RED;
        this.f5149k = 0.5f;
        this.f5150l = 0.5f;
        this.f5139a = i;
        this.f5140b = new BitmapDescriptor(C0606k.m3535a(iBinder));
        this.f5141c = latLng;
        this.f5142d = f;
        this.f5143e = f2;
        this.f5144f = latLngBounds;
        this.f5145g = f3;
        this.f5146h = f4;
        this.f5147i = z;
        this.f5148j = f5;
        this.f5149k = f6;
        this.f5150l = f7;
    }

    /* renamed from: a */
    private GroundOverlayOptions m5087a(LatLng latLng, float f, float f2) {
        this.f5141c = latLng;
        this.f5142d = f;
        this.f5143e = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IBinder mo8519a() {
        return this.f5140b.zzwB().asBinder();
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f5149k = f;
        this.f5150l = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo8521b() {
        return this.f5139a;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f5145g = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f5149k;
    }

    public float getAnchorV() {
        return this.f5150l;
    }

    public float getBearing() {
        return this.f5145g;
    }

    public LatLngBounds getBounds() {
        return this.f5144f;
    }

    public float getHeight() {
        return this.f5143e;
    }

    public BitmapDescriptor getImage() {
        return this.f5140b;
    }

    public LatLng getLocation() {
        return this.f5141c;
    }

    public float getTransparency() {
        return this.f5148j;
    }

    public float getWidth() {
        return this.f5142d;
    }

    public float getZIndex() {
        return this.f5146h;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f5140b = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.f5147i;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        C1009bf.m4533a(this.f5144f == null, (Object) "Position has already been set using positionFromBounds");
        C1009bf.m4537b(latLng != null, "Location must be specified");
        if (f < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        C1009bf.m4537b(z, "Width must be non-negative");
        return m5087a(latLng, f, -1.0f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        C1009bf.m4533a(this.f5144f == null, (Object) "Position has already been set using positionFromBounds");
        C1009bf.m4537b(latLng != null, "Location must be specified");
        C1009bf.m4537b(f >= BitmapDescriptorFactory.HUE_RED, "Width must be non-negative");
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        C1009bf.m4537b(z, "Height must be non-negative");
        return m5087a(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        C1009bf.m4533a(this.f5141c == null, (Object) "Position has already been set using position: " + this.f5141c);
        this.f5144f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        C1009bf.m4537b(f >= BitmapDescriptorFactory.HUE_RED && f <= 1.0f, "Transparency must be in the range [0..1]");
        this.f5148j = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f5147i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m5118a(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f5146h = f;
        return this;
    }
}
