package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a */
    private final int f3388a;

    /* renamed from: b */
    private StreetViewPanoramaCamera f3389b;

    /* renamed from: c */
    private String f3390c;

    /* renamed from: d */
    private LatLng f3391d;

    /* renamed from: e */
    private Integer f3392e;

    /* renamed from: f */
    private Boolean f3393f;

    /* renamed from: g */
    private Boolean f3394g;

    /* renamed from: h */
    private Boolean f3395h;

    /* renamed from: i */
    private Boolean f3396i;

    /* renamed from: j */
    private Boolean f3397j;

    public StreetViewPanoramaOptions() {
        this.f3393f = true;
        this.f3394g = true;
        this.f3395h = true;
        this.f3396i = true;
        this.f3388a = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f3393f = true;
        this.f3394g = true;
        this.f3395h = true;
        this.f3396i = true;
        this.f3388a = i;
        this.f3389b = streetViewPanoramaCamera;
        this.f3391d = latLng;
        this.f3392e = num;
        this.f3390c = str;
        this.f3393f = zza.zza(b);
        this.f3394g = zza.zza(b2);
        this.f3395h = zza.zza(b3);
        this.f3396i = zza.zza(b4);
        this.f3397j = zza.zza(b5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6334a() {
        return this.f3388a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte mo6335b() {
        return zza.zze(this.f3393f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte mo6336c() {
        return zza.zze(this.f3394g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public byte mo6337d() {
        return zza.zze(this.f3395h);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte mo6339e() {
        return zza.zze(this.f3396i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public byte mo6340f() {
        return zza.zze(this.f3397j);
    }

    public Boolean getPanningGesturesEnabled() {
        return this.f3395h;
    }

    public String getPanoramaId() {
        return this.f3390c;
    }

    public LatLng getPosition() {
        return this.f3391d;
    }

    public Integer getRadius() {
        return this.f3392e;
    }

    public Boolean getStreetNamesEnabled() {
        return this.f3396i;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.f3389b;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f3397j;
    }

    public Boolean getUserNavigationEnabled() {
        return this.f3393f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f3394g;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.f3395h = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f3389b = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.f3390c = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.f3391d = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.f3391d = latLng;
        this.f3392e = num;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.f3396i = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.f3397j = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.f3393f = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m4230a(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.f3394g = Boolean.valueOf(z);
        return this;
    }
}
