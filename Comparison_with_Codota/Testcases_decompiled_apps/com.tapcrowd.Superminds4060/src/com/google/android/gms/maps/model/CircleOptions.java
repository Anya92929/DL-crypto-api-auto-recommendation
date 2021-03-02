package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708r;

public final class CircleOptions implements SafeParcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();

    /* renamed from: iM */
    private final int f1708iM;

    /* renamed from: qf */
    private LatLng f1709qf;

    /* renamed from: qg */
    private double f1710qg;

    /* renamed from: qh */
    private float f1711qh;

    /* renamed from: qi */
    private int f1712qi;

    /* renamed from: qj */
    private int f1713qj;

    /* renamed from: qk */
    private float f1714qk;

    /* renamed from: ql */
    private boolean f1715ql;

    public CircleOptions() {
        this.f1709qf = null;
        this.f1710qg = 0.0d;
        this.f1711qh = 10.0f;
        this.f1712qi = -16777216;
        this.f1713qj = 0;
        this.f1714qk = BitmapDescriptorFactory.HUE_RED;
        this.f1715ql = true;
        this.f1708iM = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.f1709qf = null;
        this.f1710qg = 0.0d;
        this.f1711qh = 10.0f;
        this.f1712qi = -16777216;
        this.f1713qj = 0;
        this.f1714qk = BitmapDescriptorFactory.HUE_RED;
        this.f1715ql = true;
        this.f1708iM = versionCode;
        this.f1709qf = center;
        this.f1710qg = radius;
        this.f1711qh = strokeWidth;
        this.f1712qi = strokeColor;
        this.f1713qj = fillColor;
        this.f1714qk = zIndex;
        this.f1715ql = visible;
    }

    public CircleOptions center(LatLng center) {
        this.f1709qf = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.f1713qj = color;
        return this;
    }

    public LatLng getCenter() {
        return this.f1709qf;
    }

    public int getFillColor() {
        return this.f1713qj;
    }

    public double getRadius() {
        return this.f1710qg;
    }

    public int getStrokeColor() {
        return this.f1712qi;
    }

    public float getStrokeWidth() {
        return this.f1711qh;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1708iM;
    }

    public float getZIndex() {
        return this.f1714qk;
    }

    public boolean isVisible() {
        return this.f1715ql;
    }

    public CircleOptions radius(double radius) {
        this.f1710qg = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.f1712qi = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.f1711qh = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.f1715ql = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0712b.m2105a(this, out, flags);
        } else {
            CircleOptionsCreator.m2079a(this, out, flags);
        }
    }

    public CircleOptions zIndex(float zIndex) {
        this.f1714qk = zIndex;
        return this;
    }
}
