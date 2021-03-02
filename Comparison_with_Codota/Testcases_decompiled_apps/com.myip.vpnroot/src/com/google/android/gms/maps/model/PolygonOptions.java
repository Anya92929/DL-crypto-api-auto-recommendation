package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p000v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final C1913m CREATOR = new C1913m();

    /* renamed from: BR */
    private final int f4473BR;
    private float ajA;
    private boolean ajB;
    private float ajx;
    private int ajy;
    private int ajz;
    private final List<LatLng> aka;
    private final List<List<LatLng>> akb;
    private boolean akc;

    public PolygonOptions() {
        this.ajx = 10.0f;
        this.ajy = ViewCompat.MEASURED_STATE_MASK;
        this.ajz = 0;
        this.ajA = 0.0f;
        this.ajB = true;
        this.akc = false;
        this.f4473BR = 1;
        this.aka = new ArrayList();
        this.akb = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.ajx = 10.0f;
        this.ajy = ViewCompat.MEASURED_STATE_MASK;
        this.ajz = 0;
        this.ajA = 0.0f;
        this.ajB = true;
        this.akc = false;
        this.f4473BR = versionCode;
        this.aka = points;
        this.akb = holes;
        this.ajx = strokeWidth;
        this.ajy = strokeColor;
        this.ajz = fillColor;
        this.ajA = zIndex;
        this.ajB = visible;
        this.akc = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.aka.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.aka.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.aka.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.akb.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.ajz = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.akc = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.ajz;
    }

    public List<List<LatLng>> getHoles() {
        return this.akb;
    }

    public List<LatLng> getPoints() {
        return this.aka;
    }

    public int getStrokeColor() {
        return this.ajy;
    }

    public float getStrokeWidth() {
        return this.ajx;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4473BR;
    }

    public float getZIndex() {
        return this.ajA;
    }

    public boolean isGeodesic() {
        return this.akc;
    }

    public boolean isVisible() {
        return this.ajB;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mO */
    public List mo10931mO() {
        return this.akb;
    }

    public PolygonOptions strokeColor(int color) {
        this.ajy = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.ajx = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.ajB = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1914n.m6485a(this, out, flags);
        } else {
            C1913m.m6482a(this, out, flags);
        }
    }

    public PolygonOptions zIndex(float zIndex) {
        this.ajA = zIndex;
        return this;
    }
}
