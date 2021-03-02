package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p000v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a */
    private final int f5186a;

    /* renamed from: b */
    private final List<LatLng> f5187b;

    /* renamed from: c */
    private float f5188c;

    /* renamed from: d */
    private int f5189d;

    /* renamed from: e */
    private float f5190e;

    /* renamed from: f */
    private boolean f5191f;

    /* renamed from: g */
    private boolean f5192g;

    public PolylineOptions() {
        this.f5188c = 10.0f;
        this.f5189d = ViewCompat.MEASURED_STATE_MASK;
        this.f5190e = BitmapDescriptorFactory.HUE_RED;
        this.f5191f = true;
        this.f5192g = false;
        this.f5186a = 1;
        this.f5187b = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2) {
        this.f5188c = 10.0f;
        this.f5189d = ViewCompat.MEASURED_STATE_MASK;
        this.f5190e = BitmapDescriptorFactory.HUE_RED;
        this.f5191f = true;
        this.f5192g = false;
        this.f5186a = i;
        this.f5187b = list;
        this.f5188c = f;
        this.f5189d = i2;
        this.f5190e = f2;
        this.f5191f = z;
        this.f5192g = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8686a() {
        return this.f5186a;
    }

    public PolylineOptions add(LatLng latLng) {
        this.f5187b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f5187b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f5187b.add(add);
        }
        return this;
    }

    public PolylineOptions color(int i) {
        this.f5189d = i;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f5192g = z;
        return this;
    }

    public int getColor() {
        return this.f5189d;
    }

    public List<LatLng> getPoints() {
        return this.f5187b;
    }

    public float getWidth() {
        return this.f5188c;
    }

    public float getZIndex() {
        return this.f5190e;
    }

    public boolean isGeodesic() {
        return this.f5192g;
    }

    public boolean isVisible() {
        return this.f5191f;
    }

    public PolylineOptions visible(boolean z) {
        this.f5191f = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.f5188c = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m5124a(this, parcel, i);
    }

    public PolylineOptions zIndex(float f) {
        this.f5190e = f;
        return this;
    }
}
