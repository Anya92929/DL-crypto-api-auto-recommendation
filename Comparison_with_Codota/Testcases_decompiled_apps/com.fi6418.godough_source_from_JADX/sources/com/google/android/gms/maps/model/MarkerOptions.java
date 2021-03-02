package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p017b.C0606k;

public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();

    /* renamed from: a */
    private final int f5160a;

    /* renamed from: b */
    private LatLng f5161b;

    /* renamed from: c */
    private String f5162c;

    /* renamed from: d */
    private String f5163d;

    /* renamed from: e */
    private BitmapDescriptor f5164e;

    /* renamed from: f */
    private float f5165f;

    /* renamed from: g */
    private float f5166g;

    /* renamed from: h */
    private boolean f5167h;

    /* renamed from: i */
    private boolean f5168i;

    /* renamed from: j */
    private boolean f5169j;

    /* renamed from: k */
    private float f5170k;

    /* renamed from: l */
    private float f5171l;

    /* renamed from: m */
    private float f5172m;

    /* renamed from: n */
    private float f5173n;

    public MarkerOptions() {
        this.f5165f = 0.5f;
        this.f5166g = 1.0f;
        this.f5168i = true;
        this.f5169j = false;
        this.f5170k = BitmapDescriptorFactory.HUE_RED;
        this.f5171l = 0.5f;
        this.f5172m = BitmapDescriptorFactory.HUE_RED;
        this.f5173n = 1.0f;
        this.f5160a = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.f5165f = 0.5f;
        this.f5166g = 1.0f;
        this.f5168i = true;
        this.f5169j = false;
        this.f5170k = BitmapDescriptorFactory.HUE_RED;
        this.f5171l = 0.5f;
        this.f5172m = BitmapDescriptorFactory.HUE_RED;
        this.f5173n = 1.0f;
        this.f5160a = i;
        this.f5161b = latLng;
        this.f5162c = str;
        this.f5163d = str2;
        this.f5164e = iBinder == null ? null : new BitmapDescriptor(C0606k.m3535a(iBinder));
        this.f5165f = f;
        this.f5166g = f2;
        this.f5167h = z;
        this.f5168i = z2;
        this.f5169j = z3;
        this.f5170k = f3;
        this.f5171l = f4;
        this.f5172m = f5;
        this.f5173n = f6;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8597a() {
        return this.f5160a;
    }

    public MarkerOptions alpha(float f) {
        this.f5173n = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f5165f = f;
        this.f5166g = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IBinder mo8600b() {
        if (this.f5164e == null) {
            return null;
        }
        return this.f5164e.zzwB().asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z) {
        this.f5167h = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.f5169j = z;
        return this;
    }

    public float getAlpha() {
        return this.f5173n;
    }

    public float getAnchorU() {
        return this.f5165f;
    }

    public float getAnchorV() {
        return this.f5166g;
    }

    public BitmapDescriptor getIcon() {
        return this.f5164e;
    }

    public float getInfoWindowAnchorU() {
        return this.f5171l;
    }

    public float getInfoWindowAnchorV() {
        return this.f5172m;
    }

    public LatLng getPosition() {
        return this.f5161b;
    }

    public float getRotation() {
        return this.f5170k;
    }

    public String getSnippet() {
        return this.f5163d;
    }

    public String getTitle() {
        return this.f5162c;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f5164e = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f2) {
        this.f5171l = f;
        this.f5172m = f2;
        return this;
    }

    public boolean isDraggable() {
        return this.f5167h;
    }

    public boolean isFlat() {
        return this.f5169j;
    }

    public boolean isVisible() {
        return this.f5168i;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f5161b = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.f5170k = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f5163d = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f5162c = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f5168i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m5121a(this, parcel, i);
    }
}
