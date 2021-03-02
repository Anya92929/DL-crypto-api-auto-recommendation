package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0368b;
import com.google.android.gms.maps.internal.C0708q;

public final class MarkerOptions implements SafeParcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* renamed from: ab */
    private final int f1596ab;

    /* renamed from: hc */
    private boolean f1597hc;

    /* renamed from: hk */
    private float f1598hk;

    /* renamed from: hl */
    private float f1599hl;

    /* renamed from: hr */
    private LatLng f1600hr;

    /* renamed from: hs */
    private String f1601hs;

    /* renamed from: ht */
    private String f1602ht;

    /* renamed from: hu */
    private BitmapDescriptor f1603hu;

    /* renamed from: hv */
    private boolean f1604hv;

    /* renamed from: hw */
    private boolean f1605hw;

    /* renamed from: hx */
    private float f1606hx;

    /* renamed from: hy */
    private float f1607hy;

    /* renamed from: hz */
    private float f1608hz;

    public MarkerOptions() {
        this.f1598hk = 0.5f;
        this.f1599hl = 1.0f;
        this.f1597hc = true;
        this.f1605hw = false;
        this.f1606hx = BitmapDescriptorFactory.HUE_RED;
        this.f1607hy = 0.5f;
        this.f1608hz = BitmapDescriptorFactory.HUE_RED;
        this.f1596ab = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV) {
        this.f1598hk = 0.5f;
        this.f1599hl = 1.0f;
        this.f1597hc = true;
        this.f1605hw = false;
        this.f1606hx = BitmapDescriptorFactory.HUE_RED;
        this.f1607hy = 0.5f;
        this.f1608hz = BitmapDescriptorFactory.HUE_RED;
        this.f1596ab = versionCode;
        this.f1600hr = position;
        this.f1601hs = title;
        this.f1602ht = snippet;
        this.f1603hu = wrappedIcon == null ? null : new BitmapDescriptor(C0368b.C0369a.m700l(wrappedIcon));
        this.f1598hk = anchorU;
        this.f1599hl = anchorV;
        this.f1604hv = draggable;
        this.f1597hc = visible;
        this.f1605hw = flat;
        this.f1606hx = rotation;
        this.f1607hy = infoWindowAnchorU;
        this.f1608hz = infoWindowAnchorV;
    }

    public MarkerOptions anchor(float u, float v) {
        this.f1598hk = u;
        this.f1599hl = v;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bq */
    public IBinder mo6030bq() {
        if (this.f1603hu == null) {
            return null;
        }
        return this.f1603hu.mo5887aW().asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.f1604hv = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.f1605hw = flat;
        return this;
    }

    public float getAnchorU() {
        return this.f1598hk;
    }

    public float getAnchorV() {
        return this.f1599hl;
    }

    public BitmapDescriptor getIcon() {
        return this.f1603hu;
    }

    public float getInfoWindowAnchorU() {
        return this.f1607hy;
    }

    public float getInfoWindowAnchorV() {
        return this.f1608hz;
    }

    public LatLng getPosition() {
        return this.f1600hr;
    }

    public float getRotation() {
        return this.f1606hx;
    }

    public String getSnippet() {
        return this.f1602ht;
    }

    public String getTitle() {
        return this.f1601hs;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo6043i() {
        return this.f1596ab;
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.f1603hu = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.f1607hy = u;
        this.f1608hz = v;
        return this;
    }

    public boolean isDraggable() {
        return this.f1604hv;
    }

    public boolean isFlat() {
        return this.f1605hw;
    }

    public boolean isVisible() {
        return this.f1597hc;
    }

    public MarkerOptions position(LatLng position) {
        this.f1600hr = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.f1606hx = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.f1602ht = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.f1601hs = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.f1597hc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0716f.m2071a(this, out, flags);
        } else {
            MarkerOptionsCreator.m2050a(this, out, flags);
        }
    }
}
