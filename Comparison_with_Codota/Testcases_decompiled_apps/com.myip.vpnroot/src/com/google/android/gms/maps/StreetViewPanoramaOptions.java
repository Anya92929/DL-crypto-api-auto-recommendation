package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1812a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final C1791c CREATOR = new C1791c();

    /* renamed from: BR */
    private final int f4431BR;
    private Boolean aiC;
    private StreetViewPanoramaCamera aiY;
    private String aiZ;
    private Boolean aiw;
    private LatLng aja;
    private Integer ajb;
    private Boolean ajc;
    private Boolean ajd;
    private Boolean aje;

    public StreetViewPanoramaOptions() {
        this.ajc = true;
        this.aiC = true;
        this.ajd = true;
        this.aje = true;
        this.f4431BR = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.ajc = true;
        this.aiC = true;
        this.ajd = true;
        this.aje = true;
        this.f4431BR = versionCode;
        this.aiY = camera;
        this.aja = position;
        this.ajb = radius;
        this.aiZ = panoId;
        this.ajc = C1812a.m6329a(userNavigationEnabled);
        this.aiC = C1812a.m6329a(zoomGesturesEnabled);
        this.ajd = C1812a.m6329a(panningGesturesEnabled);
        this.aje = C1812a.m6329a(streetNamesEnabled);
        this.aiw = C1812a.m6329a(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.ajd;
    }

    public String getPanoramaId() {
        return this.aiZ;
    }

    public LatLng getPosition() {
        return this.aja;
    }

    public Integer getRadius() {
        return this.ajb;
    }

    public Boolean getStreetNamesEnabled() {
        return this.aje;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.aiY;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.aiw;
    }

    public Boolean getUserNavigationEnabled() {
        return this.ajc;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4431BR;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.aiC;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mC */
    public byte mo10451mC() {
        return C1812a.m6330c(this.ajc);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mD */
    public byte mo10452mD() {
        return C1812a.m6330c(this.ajd);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mE */
    public byte mo10453mE() {
        return C1812a.m6330c(this.aje);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mq */
    public byte mo10454mq() {
        return C1812a.m6330c(this.aiw);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mu */
    public byte mo10455mu() {
        return C1812a.m6330c(this.aiC);
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.ajd = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.aiY = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.aiZ = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.aja = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.aja = position;
        this.ajb = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.aje = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.aiw = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.ajc = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1791c.m6316a(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.aiC = Boolean.valueOf(enabled);
        return this;
    }
}
