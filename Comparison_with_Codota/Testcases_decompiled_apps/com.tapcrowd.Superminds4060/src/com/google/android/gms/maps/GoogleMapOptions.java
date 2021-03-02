package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0129R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0663a;
import com.google.android.gms.maps.internal.C0708r;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();

    /* renamed from: iM */
    private final int f1641iM;

    /* renamed from: pA */
    private CameraPosition f1642pA;

    /* renamed from: pB */
    private Boolean f1643pB;

    /* renamed from: pC */
    private Boolean f1644pC;

    /* renamed from: pD */
    private Boolean f1645pD;

    /* renamed from: pE */
    private Boolean f1646pE;

    /* renamed from: pF */
    private Boolean f1647pF;

    /* renamed from: pG */
    private Boolean f1648pG;

    /* renamed from: px */
    private Boolean f1649px;

    /* renamed from: py */
    private Boolean f1650py;

    /* renamed from: pz */
    private int f1651pz;

    public GoogleMapOptions() {
        this.f1651pz = -1;
        this.f1641iM = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled) {
        this.f1651pz = -1;
        this.f1641iM = versionCode;
        this.f1649px = C0663a.m2018a(zOrderOnTop);
        this.f1650py = C0663a.m2018a(useViewLifecycleInFragment);
        this.f1651pz = mapType;
        this.f1642pA = camera;
        this.f1643pB = C0663a.m2018a(zoomControlsEnabled);
        this.f1644pC = C0663a.m2018a(compassEnabled);
        this.f1645pD = C0663a.m2018a(scrollGesturesEnabled);
        this.f1646pE = C0663a.m2018a(zoomGesturesEnabled);
        this.f1647pF = C0663a.m2018a(tiltGesturesEnabled);
        this.f1648pG = C0663a.m2018a(rotateGesturesEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0129R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(0)) {
            googleMapOptions.mapType(obtainAttributes.getInt(0, -1));
        }
        if (obtainAttributes.hasValue(13)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(13, false));
        }
        if (obtainAttributes.hasValue(12)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(12, false));
        }
        if (obtainAttributes.hasValue(6)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(6, true));
        }
        if (obtainAttributes.hasValue(7)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(7, true));
        }
        if (obtainAttributes.hasValue(8)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(8, true));
        }
        if (obtainAttributes.hasValue(9)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(9, true));
        }
        if (obtainAttributes.hasValue(11)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(11, true));
        }
        if (obtainAttributes.hasValue(10)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(10, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cA */
    public byte mo5486cA() {
        return C0663a.m2019b(this.f1646pE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cB */
    public byte mo5487cB() {
        return C0663a.m2019b(this.f1647pF);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cC */
    public byte mo5488cC() {
        return C0663a.m2019b(this.f1648pG);
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.f1642pA = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.f1644pC = Boolean.valueOf(enabled);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cv */
    public byte mo5491cv() {
        return C0663a.m2019b(this.f1649px);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cw */
    public byte mo5492cw() {
        return C0663a.m2019b(this.f1650py);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cx */
    public byte mo5493cx() {
        return C0663a.m2019b(this.f1643pB);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cy */
    public byte mo5494cy() {
        return C0663a.m2019b(this.f1644pC);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cz */
    public byte mo5495cz() {
        return C0663a.m2019b(this.f1645pD);
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.f1642pA;
    }

    public Boolean getCompassEnabled() {
        return this.f1644pC;
    }

    public int getMapType() {
        return this.f1651pz;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f1648pG;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f1645pD;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f1647pF;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f1650py;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1641iM;
    }

    public Boolean getZOrderOnTop() {
        return this.f1649px;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f1643pB;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f1646pE;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.f1651pz = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.f1648pG = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.f1645pD = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.f1647pF = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.f1650py = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0648a.m2010a(this, out, flags);
        } else {
            GoogleMapOptionsCreator.m1996a(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.f1649px = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.f1643pB = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.f1646pE = Boolean.valueOf(enabled);
        return this;
    }
}
