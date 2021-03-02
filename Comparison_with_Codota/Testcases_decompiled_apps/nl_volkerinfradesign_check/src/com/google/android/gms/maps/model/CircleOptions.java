package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p001v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a */
    private final int f3478a;

    /* renamed from: b */
    private LatLng f3479b;

    /* renamed from: c */
    private double f3480c;

    /* renamed from: d */
    private float f3481d;

    /* renamed from: e */
    private int f3482e;

    /* renamed from: f */
    private int f3483f;

    /* renamed from: g */
    private float f3484g;

    /* renamed from: h */
    private boolean f3485h;

    public CircleOptions() {
        this.f3479b = null;
        this.f3480c = 0.0d;
        this.f3481d = 10.0f;
        this.f3482e = ViewCompat.MEASURED_STATE_MASK;
        this.f3483f = 0;
        this.f3484g = BitmapDescriptorFactory.HUE_RED;
        this.f3485h = true;
        this.f3478a = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.f3479b = null;
        this.f3480c = 0.0d;
        this.f3481d = 10.0f;
        this.f3482e = ViewCompat.MEASURED_STATE_MASK;
        this.f3483f = 0;
        this.f3484g = BitmapDescriptorFactory.HUE_RED;
        this.f3485h = true;
        this.f3478a = i;
        this.f3479b = latLng;
        this.f3480c = d;
        this.f3481d = f;
        this.f3482e = i2;
        this.f3483f = i3;
        this.f3484g = f2;
        this.f3485h = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6708a() {
        return this.f3478a;
    }

    public CircleOptions center(LatLng latLng) {
        this.f3479b = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.f3483f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f3479b;
    }

    public int getFillColor() {
        return this.f3483f;
    }

    public double getRadius() {
        return this.f3480c;
    }

    public int getStrokeColor() {
        return this.f3482e;
    }

    public float getStrokeWidth() {
        return this.f3481d;
    }

    public float getZIndex() {
        return this.f3484g;
    }

    public boolean isVisible() {
        return this.f3485h;
    }

    public CircleOptions radius(double d) {
        this.f3480c = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f3482e = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f3481d = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f3485h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m4214a(this, parcel, i);
    }

    public CircleOptions zIndex(float f) {
        this.f3484g = f;
        return this;
    }
}
