package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.achartengine.renderer.DefaultRenderer;

public final class PolylineOptions implements SafeParcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();

    /* renamed from: P */
    private int f1620P;

    /* renamed from: ab */
    private final int f1621ab;

    /* renamed from: hB */
    private final List<LatLng> f1622hB;

    /* renamed from: hD */
    private boolean f1623hD;

    /* renamed from: hb */
    private float f1624hb;

    /* renamed from: hc */
    private boolean f1625hc;

    /* renamed from: hg */
    private float f1626hg;

    public PolylineOptions() {
        this.f1626hg = 10.0f;
        this.f1620P = DefaultRenderer.BACKGROUND_COLOR;
        this.f1624hb = BitmapDescriptorFactory.HUE_RED;
        this.f1625hc = true;
        this.f1623hD = false;
        this.f1621ab = 1;
        this.f1622hB = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.f1626hg = 10.0f;
        this.f1620P = DefaultRenderer.BACKGROUND_COLOR;
        this.f1624hb = BitmapDescriptorFactory.HUE_RED;
        this.f1625hc = true;
        this.f1623hD = false;
        this.f1621ab = versionCode;
        this.f1622hB = points;
        this.f1626hg = width;
        this.f1620P = color;
        this.f1624hb = zIndex;
        this.f1625hc = visible;
        this.f1623hD = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.f1622hB.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.f1622hB.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.f1622hB.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.f1620P = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.f1623hD = geodesic;
        return this;
    }

    public int getColor() {
        return this.f1620P;
    }

    public List<LatLng> getPoints() {
        return this.f1622hB;
    }

    public float getWidth() {
        return this.f1626hg;
    }

    public float getZIndex() {
        return this.f1624hb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo6127i() {
        return this.f1621ab;
    }

    public boolean isGeodesic() {
        return this.f1623hD;
    }

    public boolean isVisible() {
        return this.f1625hc;
    }

    public PolylineOptions visible(boolean visible) {
        this.f1625hc = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.f1626hg = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0718h.m2073a(this, out, flags);
        } else {
            PolylineOptionsCreator.m2055a(this, out, flags);
        }
    }

    public PolylineOptions zIndex(float zIndex) {
        this.f1624hb = zIndex;
        return this;
    }
}
