package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p000v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final C1915o CREATOR = new C1915o();

    /* renamed from: BR */
    private final int f4474BR;
    private float ajA;
    private boolean ajB;
    private float ajF;
    private final List<LatLng> aka;
    private boolean akc;
    private int mColor;

    public PolylineOptions() {
        this.ajF = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.ajA = 0.0f;
        this.ajB = true;
        this.akc = false;
        this.f4474BR = 1;
        this.aka = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.ajF = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.ajA = 0.0f;
        this.ajB = true;
        this.akc = false;
        this.f4474BR = versionCode;
        this.aka = points;
        this.ajF = width;
        this.mColor = color;
        this.ajA = zIndex;
        this.ajB = visible;
        this.akc = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.aka.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.aka.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.aka.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.mColor = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.akc = geodesic;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.aka;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4474BR;
    }

    public float getWidth() {
        return this.ajF;
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

    public PolylineOptions visible(boolean visible) {
        this.ajB = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.ajF = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1916p.m6489a(this, out, flags);
        } else {
            C1915o.m6486a(this, out, flags);
        }
    }

    public PolylineOptions zIndex(float zIndex) {
        this.ajA = zIndex;
        return this;
    }
}
