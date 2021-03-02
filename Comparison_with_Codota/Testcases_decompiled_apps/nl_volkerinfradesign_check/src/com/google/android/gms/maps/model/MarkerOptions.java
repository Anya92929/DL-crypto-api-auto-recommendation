package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;

public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();

    /* renamed from: a */
    private final int f3509a;

    /* renamed from: b */
    private LatLng f3510b;

    /* renamed from: c */
    private String f3511c;

    /* renamed from: d */
    private String f3512d;

    /* renamed from: e */
    private BitmapDescriptor f3513e;

    /* renamed from: f */
    private float f3514f;

    /* renamed from: g */
    private float f3515g;

    /* renamed from: h */
    private boolean f3516h;

    /* renamed from: i */
    private boolean f3517i;

    /* renamed from: j */
    private boolean f3518j;

    /* renamed from: k */
    private float f3519k;

    /* renamed from: l */
    private float f3520l;

    /* renamed from: m */
    private float f3521m;

    /* renamed from: n */
    private float f3522n;

    public MarkerOptions() {
        this.f3514f = 0.5f;
        this.f3515g = 1.0f;
        this.f3517i = true;
        this.f3518j = false;
        this.f3519k = BitmapDescriptorFactory.HUE_RED;
        this.f3520l = 0.5f;
        this.f3521m = BitmapDescriptorFactory.HUE_RED;
        this.f3522n = 1.0f;
        this.f3509a = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.f3514f = 0.5f;
        this.f3515g = 1.0f;
        this.f3517i = true;
        this.f3518j = false;
        this.f3519k = BitmapDescriptorFactory.HUE_RED;
        this.f3520l = 0.5f;
        this.f3521m = BitmapDescriptorFactory.HUE_RED;
        this.f3522n = 1.0f;
        this.f3509a = i;
        this.f3510b = latLng;
        this.f3511c = str;
        this.f3512d = str2;
        this.f3513e = iBinder == null ? null : new BitmapDescriptor(zzd.zza.zzbs(iBinder));
        this.f3514f = f;
        this.f3515g = f2;
        this.f3516h = z;
        this.f3517i = z2;
        this.f3518j = z3;
        this.f3519k = f3;
        this.f3520l = f4;
        this.f3521m = f5;
        this.f3522n = f6;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6828a() {
        return this.f3509a;
    }

    public MarkerOptions alpha(float f) {
        this.f3522n = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f3514f = f;
        this.f3515g = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IBinder mo6831b() {
        if (this.f3513e == null) {
            return null;
        }
        return this.f3513e.zzzH().asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z) {
        this.f3516h = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.f3518j = z;
        return this;
    }

    public float getAlpha() {
        return this.f3522n;
    }

    public float getAnchorU() {
        return this.f3514f;
    }

    public float getAnchorV() {
        return this.f3515g;
    }

    public BitmapDescriptor getIcon() {
        return this.f3513e;
    }

    public float getInfoWindowAnchorU() {
        return this.f3520l;
    }

    public float getInfoWindowAnchorV() {
        return this.f3521m;
    }

    public LatLng getPosition() {
        return this.f3510b;
    }

    public float getRotation() {
        return this.f3519k;
    }

    public String getSnippet() {
        return this.f3512d;
    }

    public String getTitle() {
        return this.f3511c;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f3513e = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f2) {
        this.f3520l = f;
        this.f3521m = f2;
        return this;
    }

    public boolean isDraggable() {
        return this.f3516h;
    }

    public boolean isFlat() {
        return this.f3518j;
    }

    public boolean isVisible() {
        return this.f3517i;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f3510b = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.f3519k = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f3512d = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f3511c = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f3517i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m4218a(this, parcel, i);
    }
}
