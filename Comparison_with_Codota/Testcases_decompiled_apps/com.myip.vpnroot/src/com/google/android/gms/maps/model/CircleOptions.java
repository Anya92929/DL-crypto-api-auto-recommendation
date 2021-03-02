package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p000v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;

public final class CircleOptions implements SafeParcelable {
    public static final C1874c CREATOR = new C1874c();

    /* renamed from: BR */
    private final int f4467BR;
    private float ajA;
    private boolean ajB;
    private LatLng ajv;
    private double ajw;
    private float ajx;
    private int ajy;
    private int ajz;

    public CircleOptions() {
        this.ajv = null;
        this.ajw = 0.0d;
        this.ajx = 10.0f;
        this.ajy = ViewCompat.MEASURED_STATE_MASK;
        this.ajz = 0;
        this.ajA = 0.0f;
        this.ajB = true;
        this.f4467BR = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.ajv = null;
        this.ajw = 0.0d;
        this.ajx = 10.0f;
        this.ajy = ViewCompat.MEASURED_STATE_MASK;
        this.ajz = 0;
        this.ajA = 0.0f;
        this.ajB = true;
        this.f4467BR = versionCode;
        this.ajv = center;
        this.ajw = radius;
        this.ajx = strokeWidth;
        this.ajy = strokeColor;
        this.ajz = fillColor;
        this.ajA = zIndex;
        this.ajB = visible;
    }

    public CircleOptions center(LatLng center) {
        this.ajv = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.ajz = color;
        return this;
    }

    public LatLng getCenter() {
        return this.ajv;
    }

    public int getFillColor() {
        return this.ajz;
    }

    public double getRadius() {
        return this.ajw;
    }

    public int getStrokeColor() {
        return this.ajy;
    }

    public float getStrokeWidth() {
        return this.ajx;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4467BR;
    }

    public float getZIndex() {
        return this.ajA;
    }

    public boolean isVisible() {
        return this.ajB;
    }

    public CircleOptions radius(double radius) {
        this.ajw = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.ajy = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.ajx = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.ajB = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1875d.m6421a(this, out, flags);
        } else {
            C1874c.m6418a(this, out, flags);
        }
    }

    public CircleOptions zIndex(float zIndex) {
        this.ajA = zIndex;
        return this;
    }
}
