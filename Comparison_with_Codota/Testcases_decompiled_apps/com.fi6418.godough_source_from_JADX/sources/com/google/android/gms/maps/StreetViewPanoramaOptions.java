package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a */
    private final int f5011a;

    /* renamed from: b */
    private StreetViewPanoramaCamera f5012b;

    /* renamed from: c */
    private String f5013c;

    /* renamed from: d */
    private LatLng f5014d;

    /* renamed from: e */
    private Integer f5015e;

    /* renamed from: f */
    private Boolean f5016f;

    /* renamed from: g */
    private Boolean f5017g;

    /* renamed from: h */
    private Boolean f5018h;

    /* renamed from: i */
    private Boolean f5019i;

    /* renamed from: j */
    private Boolean f5020j;

    public StreetViewPanoramaOptions() {
        this.f5016f = true;
        this.f5017g = true;
        this.f5018h = true;
        this.f5019i = true;
        this.f5011a = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f5016f = true;
        this.f5017g = true;
        this.f5018h = true;
        this.f5019i = true;
        this.f5011a = i;
        this.f5012b = streetViewPanoramaCamera;
        this.f5014d = latLng;
        this.f5015e = num;
        this.f5013c = str;
        this.f5016f = zza.zza(b);
        this.f5017g = zza.zza(b2);
        this.f5018h = zza.zza(b3);
        this.f5019i = zza.zza(b4);
        this.f5020j = zza.zza(b5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8107a() {
        return this.f5011a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte mo8108b() {
        return zza.zze(this.f5016f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte mo8109c() {
        return zza.zze(this.f5017g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public byte mo8110d() {
        return zza.zze(this.f5018h);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte mo8112e() {
        return zza.zze(this.f5019i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public byte mo8113f() {
        return zza.zze(this.f5020j);
    }

    public Boolean getPanningGesturesEnabled() {
        return this.f5018h;
    }

    public String getPanoramaId() {
        return this.f5013c;
    }

    public LatLng getPosition() {
        return this.f5014d;
    }

    public Integer getRadius() {
        return this.f5015e;
    }

    public Boolean getStreetNamesEnabled() {
        return this.f5019i;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.f5012b;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f5020j;
    }

    public Boolean getUserNavigationEnabled() {
        return this.f5016f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f5017g;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.f5018h = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f5012b = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.f5013c = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.f5014d = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.f5014d = latLng;
        this.f5015e = num;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.f5019i = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.f5020j = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.f5016f = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m5161a(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.f5017g = Boolean.valueOf(z);
        return this;
    }
}
