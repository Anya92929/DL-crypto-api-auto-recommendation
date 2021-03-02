package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.achartengine.renderer.DefaultRenderer;

public final class PolygonOptions implements SafeParcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: ab */
    private final int f1610ab;

    /* renamed from: gY */
    private float f1611gY;

    /* renamed from: gZ */
    private int f1612gZ;

    /* renamed from: hB */
    private final List<LatLng> f1613hB;

    /* renamed from: hC */
    private final List<List<LatLng>> f1614hC;

    /* renamed from: hD */
    private boolean f1615hD;

    /* renamed from: ha */
    private int f1616ha;

    /* renamed from: hb */
    private float f1617hb;

    /* renamed from: hc */
    private boolean f1618hc;

    public PolygonOptions() {
        this.f1611gY = 10.0f;
        this.f1612gZ = DefaultRenderer.BACKGROUND_COLOR;
        this.f1616ha = 0;
        this.f1617hb = BitmapDescriptorFactory.HUE_RED;
        this.f1618hc = true;
        this.f1615hD = false;
        this.f1610ab = 1;
        this.f1613hB = new ArrayList();
        this.f1614hC = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.f1611gY = 10.0f;
        this.f1612gZ = DefaultRenderer.BACKGROUND_COLOR;
        this.f1616ha = 0;
        this.f1617hb = BitmapDescriptorFactory.HUE_RED;
        this.f1618hc = true;
        this.f1615hD = false;
        this.f1610ab = versionCode;
        this.f1613hB = points;
        this.f1614hC = holes;
        this.f1611gY = strokeWidth;
        this.f1612gZ = strokeColor;
        this.f1616ha = fillColor;
        this.f1617hb = zIndex;
        this.f1618hc = visible;
        this.f1615hD = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.f1613hB.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.f1613hB.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.f1613hB.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.f1614hC.add(arrayList);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: br */
    public List mo6081br() {
        return this.f1614hC;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.f1616ha = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.f1615hD = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.f1616ha;
    }

    public List<List<LatLng>> getHoles() {
        return this.f1614hC;
    }

    public List<LatLng> getPoints() {
        return this.f1613hB;
    }

    public int getStrokeColor() {
        return this.f1612gZ;
    }

    public float getStrokeWidth() {
        return this.f1611gY;
    }

    public float getZIndex() {
        return this.f1617hb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo6091i() {
        return this.f1610ab;
    }

    public boolean isGeodesic() {
        return this.f1615hD;
    }

    public boolean isVisible() {
        return this.f1618hc;
    }

    public PolygonOptions strokeColor(int color) {
        this.f1612gZ = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.f1611gY = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.f1618hc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0717g.m2072a(this, out, flags);
        } else {
            PolygonOptionsCreator.m2053a(this, out, flags);
        }
    }

    public PolygonOptions zIndex(float zIndex) {
        this.f1617hb = zIndex;
        return this;
    }
}
