package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0135R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1812a;
import com.google.android.gms.maps.internal.C1869v;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final C1789a CREATOR = new C1789a();

    /* renamed from: BR */
    private final int f4424BR;
    private Boolean aiA;
    private Boolean aiB;
    private Boolean aiC;
    private Boolean aiD;
    private Boolean aiE;
    private Boolean aiv;
    private Boolean aiw;
    private int aix;
    private CameraPosition aiy;
    private Boolean aiz;

    public GoogleMapOptions() {
        this.aix = -1;
        this.f4424BR = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled) {
        this.aix = -1;
        this.f4424BR = versionCode;
        this.aiv = C1812a.m6329a(zOrderOnTop);
        this.aiw = C1812a.m6329a(useViewLifecycleInFragment);
        this.aix = mapType;
        this.aiy = camera;
        this.aiz = C1812a.m6329a(zoomControlsEnabled);
        this.aiA = C1812a.m6329a(compassEnabled);
        this.aiB = C1812a.m6329a(scrollGesturesEnabled);
        this.aiC = C1812a.m6329a(zoomGesturesEnabled);
        this.aiD = C1812a.m6329a(tiltGesturesEnabled);
        this.aiE = C1812a.m6329a(rotateGesturesEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0135R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0135R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0135R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0135R.styleable.MapAttrs_uiZoomControls, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.aiy = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.aiA = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.aiy;
    }

    public Boolean getCompassEnabled() {
        return this.aiA;
    }

    public int getMapType() {
        return this.aix;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.aiE;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.aiB;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.aiD;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.aiw;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4424BR;
    }

    public Boolean getZOrderOnTop() {
        return this.aiv;
    }

    public Boolean getZoomControlsEnabled() {
        return this.aiz;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.aiC;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.aix = mapType;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mp */
    public byte mo10352mp() {
        return C1812a.m6330c(this.aiv);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mq */
    public byte mo10353mq() {
        return C1812a.m6330c(this.aiw);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mr */
    public byte mo10354mr() {
        return C1812a.m6330c(this.aiz);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ms */
    public byte mo10355ms() {
        return C1812a.m6330c(this.aiA);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mt */
    public byte mo10356mt() {
        return C1812a.m6330c(this.aiB);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mu */
    public byte mo10357mu() {
        return C1812a.m6330c(this.aiC);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mv */
    public byte mo10358mv() {
        return C1812a.m6330c(this.aiD);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mw */
    public byte mo10359mw() {
        return C1812a.m6330c(this.aiE);
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.aiE = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.aiB = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.aiD = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.aiw = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1790b.m6315a(this, out, flags);
        } else {
            C1789a.m6312a(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.aiv = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.aiz = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.aiC = Boolean.valueOf(enabled);
        return this;
    }
}
