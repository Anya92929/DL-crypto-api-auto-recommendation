package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p000v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();

    /* renamed from: a */
    private final int f5176a;

    /* renamed from: b */
    private final List<LatLng> f5177b;

    /* renamed from: c */
    private final List<List<LatLng>> f5178c;

    /* renamed from: d */
    private float f5179d;

    /* renamed from: e */
    private int f5180e;

    /* renamed from: f */
    private int f5181f;

    /* renamed from: g */
    private float f5182g;

    /* renamed from: h */
    private boolean f5183h;

    /* renamed from: i */
    private boolean f5184i;

    public PolygonOptions() {
        this.f5179d = 10.0f;
        this.f5180e = ViewCompat.MEASURED_STATE_MASK;
        this.f5181f = 0;
        this.f5182g = BitmapDescriptorFactory.HUE_RED;
        this.f5183h = true;
        this.f5184i = false;
        this.f5176a = 1;
        this.f5177b = new ArrayList();
        this.f5178c = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.f5179d = 10.0f;
        this.f5180e = ViewCompat.MEASURED_STATE_MASK;
        this.f5181f = 0;
        this.f5182g = BitmapDescriptorFactory.HUE_RED;
        this.f5183h = true;
        this.f5184i = false;
        this.f5176a = i;
        this.f5177b = list;
        this.f5178c = list2;
        this.f5179d = f;
        this.f5180e = i2;
        this.f5181f = i3;
        this.f5182g = f2;
        this.f5183h = z;
        this.f5184i = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8648a() {
        return this.f5176a;
    }

    public PolygonOptions add(LatLng latLng) {
        this.f5177b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f5177b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f5177b.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.f5178c.add(arrayList);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List mo8653b() {
        return this.f5178c;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.f5181f = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f5184i = z;
        return this;
    }

    public int getFillColor() {
        return this.f5181f;
    }

    public List<List<LatLng>> getHoles() {
        return this.f5178c;
    }

    public List<LatLng> getPoints() {
        return this.f5177b;
    }

    public int getStrokeColor() {
        return this.f5180e;
    }

    public float getStrokeWidth() {
        return this.f5179d;
    }

    public float getZIndex() {
        return this.f5182g;
    }

    public boolean isGeodesic() {
        return this.f5184i;
    }

    public boolean isVisible() {
        return this.f5183h;
    }

    public PolygonOptions strokeColor(int i) {
        this.f5180e = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f5179d = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f5183h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m5123a(this, parcel, i);
    }

    public PolygonOptions zIndex(float f) {
        this.f5182g = f;
        return this;
    }
}
