package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: a */
    private final int f3487a;

    /* renamed from: b */
    private BitmapDescriptor f3488b;

    /* renamed from: c */
    private LatLng f3489c;

    /* renamed from: d */
    private float f3490d;

    /* renamed from: e */
    private float f3491e;

    /* renamed from: f */
    private LatLngBounds f3492f;

    /* renamed from: g */
    private float f3493g;

    /* renamed from: h */
    private float f3494h;

    /* renamed from: i */
    private boolean f3495i;

    /* renamed from: j */
    private float f3496j;

    /* renamed from: k */
    private float f3497k;

    /* renamed from: l */
    private float f3498l;

    /* renamed from: m */
    private boolean f3499m;

    public GroundOverlayOptions() {
        this.f3495i = true;
        this.f3496j = BitmapDescriptorFactory.HUE_RED;
        this.f3497k = 0.5f;
        this.f3498l = 0.5f;
        this.f3499m = false;
        this.f3487a = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        this.f3495i = true;
        this.f3496j = BitmapDescriptorFactory.HUE_RED;
        this.f3497k = 0.5f;
        this.f3498l = 0.5f;
        this.f3499m = false;
        this.f3487a = i;
        this.f3488b = new BitmapDescriptor(zzd.zza.zzbs(iBinder));
        this.f3489c = latLng;
        this.f3490d = f;
        this.f3491e = f2;
        this.f3492f = latLngBounds;
        this.f3493g = f3;
        this.f3494h = f4;
        this.f3495i = z;
        this.f3496j = f5;
        this.f3497k = f6;
        this.f3498l = f7;
        this.f3499m = z2;
    }

    /* renamed from: a */
    private GroundOverlayOptions m4184a(LatLng latLng, float f, float f2) {
        this.f3489c = latLng;
        this.f3490d = f;
        this.f3491e = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IBinder mo6748a() {
        return this.f3488b.zzzH().asBinder();
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f3497k = f;
        this.f3498l = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo6750b() {
        return this.f3487a;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f3493g = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public GroundOverlayOptions clickable(boolean z) {
        this.f3499m = z;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f3497k;
    }

    public float getAnchorV() {
        return this.f3498l;
    }

    public float getBearing() {
        return this.f3493g;
    }

    public LatLngBounds getBounds() {
        return this.f3492f;
    }

    public float getHeight() {
        return this.f3491e;
    }

    public BitmapDescriptor getImage() {
        return this.f3488b;
    }

    public LatLng getLocation() {
        return this.f3489c;
    }

    public float getTransparency() {
        return this.f3496j;
    }

    public float getWidth() {
        return this.f3490d;
    }

    public float getZIndex() {
        return this.f3494h;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f3488b = bitmapDescriptor;
        return this;
    }

    public boolean isClickable() {
        return this.f3499m;
    }

    public boolean isVisible() {
        return this.f3495i;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        zzx.zza(this.f3492f == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(latLng != null, (Object) "Location must be specified");
        if (f < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        zzx.zzb(z, (Object) "Width must be non-negative");
        return m4184a(latLng, f, -1.0f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        zzx.zza(this.f3492f == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(latLng != null, (Object) "Location must be specified");
        zzx.zzb(f >= BitmapDescriptorFactory.HUE_RED, (Object) "Width must be non-negative");
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            z = false;
        }
        zzx.zzb(z, (Object) "Height must be non-negative");
        return m4184a(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        zzx.zza(this.f3489c == null, (Object) "Position has already been set using position: " + this.f3489c);
        this.f3492f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        zzx.zzb(f >= BitmapDescriptorFactory.HUE_RED && f <= 1.0f, (Object) "Transparency must be in the range [0..1]");
        this.f3496j = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f3495i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m4215a(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f3494h = f;
        return this;
    }
}
