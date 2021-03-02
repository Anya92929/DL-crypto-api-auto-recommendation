package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: iM */
    private final int f1750iM;

    /* renamed from: qK */
    private final List<LatLng> f1751qK;

    /* renamed from: qL */
    private final List<List<LatLng>> f1752qL;

    /* renamed from: qM */
    private boolean f1753qM;

    /* renamed from: qh */
    private float f1754qh;

    /* renamed from: qi */
    private int f1755qi;

    /* renamed from: qj */
    private int f1756qj;

    /* renamed from: qk */
    private float f1757qk;

    /* renamed from: ql */
    private boolean f1758ql;

    public PolygonOptions() {
        this.f1754qh = 10.0f;
        this.f1755qi = -16777216;
        this.f1756qj = 0;
        this.f1757qk = BitmapDescriptorFactory.HUE_RED;
        this.f1758ql = true;
        this.f1753qM = false;
        this.f1750iM = 1;
        this.f1751qK = new ArrayList();
        this.f1752qL = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.f1754qh = 10.0f;
        this.f1755qi = -16777216;
        this.f1756qj = 0;
        this.f1757qk = BitmapDescriptorFactory.HUE_RED;
        this.f1758ql = true;
        this.f1753qM = false;
        this.f1750iM = versionCode;
        this.f1751qK = points;
        this.f1752qL = holes;
        this.f1754qh = strokeWidth;
        this.f1755qi = strokeColor;
        this.f1756qj = fillColor;
        this.f1757qk = zIndex;
        this.f1758ql = visible;
        this.f1753qM = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.f1751qK.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.f1751qK.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.f1751qK.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.f1752qL.add(arrayList);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cO */
    public List mo5919cO() {
        return this.f1752qL;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.f1756qj = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.f1753qM = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.f1756qj;
    }

    public List<List<LatLng>> getHoles() {
        return this.f1752qL;
    }

    public List<LatLng> getPoints() {
        return this.f1751qK;
    }

    public int getStrokeColor() {
        return this.f1755qi;
    }

    public float getStrokeWidth() {
        return this.f1754qh;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1750iM;
    }

    public float getZIndex() {
        return this.f1757qk;
    }

    public boolean isGeodesic() {
        return this.f1753qM;
    }

    public boolean isVisible() {
        return this.f1758ql;
    }

    public PolygonOptions strokeColor(int color) {
        this.f1755qi = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.f1754qh = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.f1758ql = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0717g.m2110a(this, out, flags);
        } else {
            PolygonOptionsCreator.m2095a(this, out, flags);
        }
    }

    public PolygonOptions zIndex(float zIndex) {
        this.f1757qk = zIndex;
        return this;
    }
}
