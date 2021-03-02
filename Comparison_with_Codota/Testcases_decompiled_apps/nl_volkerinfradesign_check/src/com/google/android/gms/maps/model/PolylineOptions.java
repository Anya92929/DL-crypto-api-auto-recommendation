package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p001v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a */
    private final int f3536a;

    /* renamed from: b */
    private final List<LatLng> f3537b;

    /* renamed from: c */
    private float f3538c;

    /* renamed from: d */
    private int f3539d;

    /* renamed from: e */
    private float f3540e;

    /* renamed from: f */
    private boolean f3541f;

    /* renamed from: g */
    private boolean f3542g;

    /* renamed from: h */
    private boolean f3543h;

    public PolylineOptions() {
        this.f3538c = 10.0f;
        this.f3539d = ViewCompat.MEASURED_STATE_MASK;
        this.f3540e = BitmapDescriptorFactory.HUE_RED;
        this.f3541f = true;
        this.f3542g = false;
        this.f3543h = false;
        this.f3536a = 1;
        this.f3537b = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2, boolean z3) {
        this.f3538c = 10.0f;
        this.f3539d = ViewCompat.MEASURED_STATE_MASK;
        this.f3540e = BitmapDescriptorFactory.HUE_RED;
        this.f3541f = true;
        this.f3542g = false;
        this.f3543h = false;
        this.f3536a = i;
        this.f3537b = list;
        this.f3538c = f;
        this.f3539d = i2;
        this.f3540e = f2;
        this.f3541f = z;
        this.f3542g = z2;
        this.f3543h = z3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6923a() {
        return this.f3536a;
    }

    public PolylineOptions add(LatLng latLng) {
        this.f3537b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f3537b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f3537b.add(add);
        }
        return this;
    }

    public PolylineOptions clickable(boolean z) {
        this.f3543h = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f3539d = i;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f3542g = z;
        return this;
    }

    public int getColor() {
        return this.f3539d;
    }

    public List<LatLng> getPoints() {
        return this.f3537b;
    }

    public float getWidth() {
        return this.f3538c;
    }

    public float getZIndex() {
        return this.f3540e;
    }

    public boolean isClickable() {
        return this.f3543h;
    }

    public boolean isGeodesic() {
        return this.f3542g;
    }

    public boolean isVisible() {
        return this.f3541f;
    }

    public PolylineOptions visible(boolean z) {
        this.f3541f = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.f3538c = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m4221a(this, parcel, i);
    }

    public PolylineOptions zIndex(float f) {
        this.f3540e = f;
        return this;
    }
}
