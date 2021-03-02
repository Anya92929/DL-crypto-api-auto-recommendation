package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708q;
import org.achartengine.renderer.DefaultRenderer;

public final class CircleOptions implements SafeParcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();

    /* renamed from: ab */
    private final int f1568ab;

    /* renamed from: gW */
    private LatLng f1569gW;

    /* renamed from: gX */
    private double f1570gX;

    /* renamed from: gY */
    private float f1571gY;

    /* renamed from: gZ */
    private int f1572gZ;

    /* renamed from: ha */
    private int f1573ha;

    /* renamed from: hb */
    private float f1574hb;

    /* renamed from: hc */
    private boolean f1575hc;

    public CircleOptions() {
        this.f1569gW = null;
        this.f1570gX = 0.0d;
        this.f1571gY = 10.0f;
        this.f1572gZ = DefaultRenderer.BACKGROUND_COLOR;
        this.f1573ha = 0;
        this.f1574hb = BitmapDescriptorFactory.HUE_RED;
        this.f1575hc = true;
        this.f1568ab = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.f1569gW = null;
        this.f1570gX = 0.0d;
        this.f1571gY = 10.0f;
        this.f1572gZ = DefaultRenderer.BACKGROUND_COLOR;
        this.f1573ha = 0;
        this.f1574hb = BitmapDescriptorFactory.HUE_RED;
        this.f1575hc = true;
        this.f1568ab = versionCode;
        this.f1569gW = center;
        this.f1570gX = radius;
        this.f1571gY = strokeWidth;
        this.f1572gZ = strokeColor;
        this.f1573ha = fillColor;
        this.f1574hb = zIndex;
        this.f1575hc = visible;
    }

    public CircleOptions center(LatLng center) {
        this.f1569gW = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.f1573ha = color;
        return this;
    }

    public LatLng getCenter() {
        return this.f1569gW;
    }

    public int getFillColor() {
        return this.f1573ha;
    }

    public double getRadius() {
        return this.f1570gX;
    }

    public int getStrokeColor() {
        return this.f1572gZ;
    }

    public float getStrokeWidth() {
        return this.f1571gY;
    }

    public float getZIndex() {
        return this.f1574hb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5928i() {
        return this.f1568ab;
    }

    public boolean isVisible() {
        return this.f1575hc;
    }

    public CircleOptions radius(double radius) {
        this.f1570gX = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.f1572gZ = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.f1571gY = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.f1575hc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0712b.m2067a(this, out, flags);
        } else {
            CircleOptionsCreator.m2032a(this, out, flags);
        }
    }

    public CircleOptions zIndex(float zIndex) {
        this.f1574hb = zIndex;
        return this;
    }
}
