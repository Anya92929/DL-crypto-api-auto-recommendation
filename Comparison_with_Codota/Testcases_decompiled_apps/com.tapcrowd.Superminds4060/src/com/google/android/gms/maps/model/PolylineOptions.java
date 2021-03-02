package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();

    /* renamed from: iM */
    private final int f1760iM;

    /* renamed from: jc */
    private int f1761jc;

    /* renamed from: qK */
    private final List<LatLng> f1762qK;

    /* renamed from: qM */
    private boolean f1763qM;

    /* renamed from: qk */
    private float f1764qk;

    /* renamed from: ql */
    private boolean f1765ql;

    /* renamed from: qp */
    private float f1766qp;

    public PolylineOptions() {
        this.f1766qp = 10.0f;
        this.f1761jc = -16777216;
        this.f1764qk = BitmapDescriptorFactory.HUE_RED;
        this.f1765ql = true;
        this.f1763qM = false;
        this.f1760iM = 1;
        this.f1762qK = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.f1766qp = 10.0f;
        this.f1761jc = -16777216;
        this.f1764qk = BitmapDescriptorFactory.HUE_RED;
        this.f1765ql = true;
        this.f1763qM = false;
        this.f1760iM = versionCode;
        this.f1762qK = points;
        this.f1766qp = width;
        this.f1761jc = color;
        this.f1764qk = zIndex;
        this.f1765ql = visible;
        this.f1763qM = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.f1762qK.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.f1762qK.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.f1762qK.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.f1761jc = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.f1763qM = geodesic;
        return this;
    }

    public int getColor() {
        return this.f1761jc;
    }

    public List<LatLng> getPoints() {
        return this.f1762qK;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1760iM;
    }

    public float getWidth() {
        return this.f1766qp;
    }

    public float getZIndex() {
        return this.f1764qk;
    }

    public boolean isGeodesic() {
        return this.f1763qM;
    }

    public boolean isVisible() {
        return this.f1765ql;
    }

    public PolylineOptions visible(boolean visible) {
        this.f1765ql = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.f1766qp = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0718h.m2111a(this, out, flags);
        } else {
            PolylineOptionsCreator.m2096a(this, out, flags);
        }
    }

    public PolylineOptions zIndex(float zIndex) {
        this.f1764qk = zIndex;
        return this;
    }
}
