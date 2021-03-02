package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p000v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a */
    private final int f5130a;

    /* renamed from: b */
    private LatLng f5131b;

    /* renamed from: c */
    private double f5132c;

    /* renamed from: d */
    private float f5133d;

    /* renamed from: e */
    private int f5134e;

    /* renamed from: f */
    private int f5135f;

    /* renamed from: g */
    private float f5136g;

    /* renamed from: h */
    private boolean f5137h;

    public CircleOptions() {
        this.f5131b = null;
        this.f5132c = 0.0d;
        this.f5133d = 10.0f;
        this.f5134e = ViewCompat.MEASURED_STATE_MASK;
        this.f5135f = 0;
        this.f5136g = BitmapDescriptorFactory.HUE_RED;
        this.f5137h = true;
        this.f5130a = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.f5131b = null;
        this.f5132c = 0.0d;
        this.f5133d = 10.0f;
        this.f5134e = ViewCompat.MEASURED_STATE_MASK;
        this.f5135f = 0;
        this.f5136g = BitmapDescriptorFactory.HUE_RED;
        this.f5137h = true;
        this.f5130a = i;
        this.f5131b = latLng;
        this.f5132c = d;
        this.f5133d = f;
        this.f5134e = i2;
        this.f5135f = i3;
        this.f5136g = f2;
        this.f5137h = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8481a() {
        return this.f5130a;
    }

    public CircleOptions center(LatLng latLng) {
        this.f5131b = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.f5135f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f5131b;
    }

    public int getFillColor() {
        return this.f5135f;
    }

    public double getRadius() {
        return this.f5132c;
    }

    public int getStrokeColor() {
        return this.f5134e;
    }

    public float getStrokeWidth() {
        return this.f5133d;
    }

    public float getZIndex() {
        return this.f5136g;
    }

    public boolean isVisible() {
        return this.f5137h;
    }

    public CircleOptions radius(double d) {
        this.f5132c = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f5134e = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f5133d = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f5137h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m5117a(this, parcel, i);
    }

    public CircleOptions zIndex(float f) {
        this.f5136g = f;
        return this;
    }
}
