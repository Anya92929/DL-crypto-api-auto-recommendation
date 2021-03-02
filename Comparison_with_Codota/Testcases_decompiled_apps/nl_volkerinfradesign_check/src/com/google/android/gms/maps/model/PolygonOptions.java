package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p001v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();

    /* renamed from: a */
    private final int f3525a;

    /* renamed from: b */
    private final List<LatLng> f3526b;

    /* renamed from: c */
    private final List<List<LatLng>> f3527c;

    /* renamed from: d */
    private float f3528d;

    /* renamed from: e */
    private int f3529e;

    /* renamed from: f */
    private int f3530f;

    /* renamed from: g */
    private float f3531g;

    /* renamed from: h */
    private boolean f3532h;

    /* renamed from: i */
    private boolean f3533i;

    /* renamed from: j */
    private boolean f3534j;

    public PolygonOptions() {
        this.f3528d = 10.0f;
        this.f3529e = ViewCompat.MEASURED_STATE_MASK;
        this.f3530f = 0;
        this.f3531g = BitmapDescriptorFactory.HUE_RED;
        this.f3532h = true;
        this.f3533i = false;
        this.f3534j = false;
        this.f3525a = 1;
        this.f3526b = new ArrayList();
        this.f3527c = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2, boolean z3) {
        this.f3528d = 10.0f;
        this.f3529e = ViewCompat.MEASURED_STATE_MASK;
        this.f3530f = 0;
        this.f3531g = BitmapDescriptorFactory.HUE_RED;
        this.f3532h = true;
        this.f3533i = false;
        this.f3534j = false;
        this.f3525a = i;
        this.f3526b = list;
        this.f3527c = list2;
        this.f3528d = f;
        this.f3529e = i2;
        this.f3530f = i3;
        this.f3531g = f2;
        this.f3532h = z;
        this.f3533i = z2;
        this.f3534j = z3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6881a() {
        return this.f3525a;
    }

    public PolygonOptions add(LatLng latLng) {
        this.f3526b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f3526b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f3526b.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.f3527c.add(arrayList);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List mo6886b() {
        return this.f3527c;
    }

    public PolygonOptions clickable(boolean z) {
        this.f3534j = z;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.f3530f = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f3533i = z;
        return this;
    }

    public int getFillColor() {
        return this.f3530f;
    }

    public List<List<LatLng>> getHoles() {
        return this.f3527c;
    }

    public List<LatLng> getPoints() {
        return this.f3526b;
    }

    public int getStrokeColor() {
        return this.f3529e;
    }

    public float getStrokeWidth() {
        return this.f3528d;
    }

    public float getZIndex() {
        return this.f3531g;
    }

    public boolean isClickable() {
        return this.f3534j;
    }

    public boolean isGeodesic() {
        return this.f3533i;
    }

    public boolean isVisible() {
        return this.f3532h;
    }

    public PolygonOptions strokeColor(int i) {
        this.f3529e = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f3528d = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f3532h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m4220a(this, parcel, i);
    }

    public PolygonOptions zIndex(float f) {
        this.f3531g = f;
        return this;
    }
}
