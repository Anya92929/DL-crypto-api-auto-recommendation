package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.maps.internal.C0708r;

public final class MarkerOptions implements SafeParcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* renamed from: iM */
    private final int f1736iM;
    private float mAlpha;

    /* renamed from: qA */
    private LatLng f1737qA;

    /* renamed from: qB */
    private String f1738qB;

    /* renamed from: qC */
    private String f1739qC;

    /* renamed from: qD */
    private BitmapDescriptor f1740qD;

    /* renamed from: qE */
    private boolean f1741qE;

    /* renamed from: qF */
    private boolean f1742qF;

    /* renamed from: qG */
    private float f1743qG;

    /* renamed from: qH */
    private float f1744qH;

    /* renamed from: qI */
    private float f1745qI;

    /* renamed from: ql */
    private boolean f1746ql;

    /* renamed from: qt */
    private float f1747qt;

    /* renamed from: qu */
    private float f1748qu;

    public MarkerOptions() {
        this.f1747qt = 0.5f;
        this.f1748qu = 1.0f;
        this.f1746ql = true;
        this.f1742qF = false;
        this.f1743qG = BitmapDescriptorFactory.HUE_RED;
        this.f1744qH = 0.5f;
        this.f1745qI = BitmapDescriptorFactory.HUE_RED;
        this.mAlpha = 1.0f;
        this.f1736iM = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV, float alpha) {
        this.f1747qt = 0.5f;
        this.f1748qu = 1.0f;
        this.f1746ql = true;
        this.f1742qF = false;
        this.f1743qG = BitmapDescriptorFactory.HUE_RED;
        this.f1744qH = 0.5f;
        this.f1745qI = BitmapDescriptorFactory.HUE_RED;
        this.mAlpha = 1.0f;
        this.f1736iM = versionCode;
        this.f1737qA = position;
        this.f1738qB = title;
        this.f1739qC = snippet;
        this.f1740qD = wrappedIcon == null ? null : new BitmapDescriptor(C0164b.C0165a.m377z(wrappedIcon));
        this.f1747qt = anchorU;
        this.f1748qu = anchorV;
        this.f1741qE = draggable;
        this.f1746ql = visible;
        this.f1742qF = flat;
        this.f1743qG = rotation;
        this.f1744qH = infoWindowAnchorU;
        this.f1745qI = infoWindowAnchorV;
        this.mAlpha = alpha;
    }

    public MarkerOptions alpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public MarkerOptions anchor(float u, float v) {
        this.f1747qt = u;
        this.f1748qu = v;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cN */
    public IBinder mo5867cN() {
        if (this.f1740qD == null) {
            return null;
        }
        return this.f1740qD.mo5720cs().asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.f1741qE = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.f1742qF = flat;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.f1747qt;
    }

    public float getAnchorV() {
        return this.f1748qu;
    }

    public BitmapDescriptor getIcon() {
        return this.f1740qD;
    }

    public float getInfoWindowAnchorU() {
        return this.f1744qH;
    }

    public float getInfoWindowAnchorV() {
        return this.f1745qI;
    }

    public LatLng getPosition() {
        return this.f1737qA;
    }

    public float getRotation() {
        return this.f1743qG;
    }

    public String getSnippet() {
        return this.f1739qC;
    }

    public String getTitle() {
        return this.f1738qB;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1736iM;
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.f1740qD = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.f1744qH = u;
        this.f1745qI = v;
        return this;
    }

    public boolean isDraggable() {
        return this.f1741qE;
    }

    public boolean isFlat() {
        return this.f1742qF;
    }

    public boolean isVisible() {
        return this.f1746ql;
    }

    public MarkerOptions position(LatLng position) {
        this.f1737qA = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.f1743qG = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.f1739qC = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.f1738qB = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.f1746ql = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0716f.m2109a(this, out, flags);
        } else {
            MarkerOptionsCreator.m2093a(this, out, flags);
        }
    }
}
