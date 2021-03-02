package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0334R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0666a;
import com.google.android.gms.maps.internal.C0708q;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();

    /* renamed from: ab */
    private final int f1502ab;

    /* renamed from: go */
    private Boolean f1503go;

    /* renamed from: gp */
    private Boolean f1504gp;

    /* renamed from: gq */
    private int f1505gq;

    /* renamed from: gr */
    private CameraPosition f1506gr;

    /* renamed from: gs */
    private Boolean f1507gs;

    /* renamed from: gt */
    private Boolean f1508gt;

    /* renamed from: gu */
    private Boolean f1509gu;

    /* renamed from: gv */
    private Boolean f1510gv;

    /* renamed from: gw */
    private Boolean f1511gw;

    /* renamed from: gx */
    private Boolean f1512gx;

    public GoogleMapOptions() {
        this.f1505gq = -1;
        this.f1502ab = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled) {
        this.f1505gq = -1;
        this.f1502ab = versionCode;
        this.f1503go = C0666a.m1972a(zOrderOnTop);
        this.f1504gp = C0666a.m1972a(useViewLifecycleInFragment);
        this.f1505gq = mapType;
        this.f1506gr = camera;
        this.f1507gs = C0666a.m1972a(zoomControlsEnabled);
        this.f1508gt = C0666a.m1972a(compassEnabled);
        this.f1509gu = C0666a.m1972a(scrollGesturesEnabled);
        this.f1510gv = C0666a.m1972a(zoomGesturesEnabled);
        this.f1511gw = C0666a.m1972a(tiltGesturesEnabled);
        this.f1512gx = C0666a.m1972a(rotateGesturesEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0334R.styleable.MapAttrs);
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
    /* renamed from: aZ */
    public byte mo5659aZ() {
        return C0666a.m1973b(this.f1503go);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ba */
    public byte mo5660ba() {
        return C0666a.m1973b(this.f1504gp);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bb */
    public byte mo5661bb() {
        return C0666a.m1973b(this.f1507gs);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bc */
    public byte mo5662bc() {
        return C0666a.m1973b(this.f1508gt);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bd */
    public byte mo5663bd() {
        return C0666a.m1973b(this.f1509gu);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: be */
    public byte mo5664be() {
        return C0666a.m1973b(this.f1510gv);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bf */
    public byte mo5665bf() {
        return C0666a.m1973b(this.f1511gw);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bg */
    public byte mo5666bg() {
        return C0666a.m1973b(this.f1512gx);
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.f1506gr = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.f1508gt = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.f1506gr;
    }

    public Boolean getCompassEnabled() {
        return this.f1508gt;
    }

    public int getMapType() {
        return this.f1505gq;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f1512gx;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f1509gu;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f1511gw;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f1504gp;
    }

    public Boolean getZOrderOnTop() {
        return this.f1503go;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f1507gs;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f1510gv;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5680i() {
        return this.f1502ab;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.f1505gq = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.f1512gx = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.f1509gu = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.f1511gw = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.f1504gp = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0651a.m1964a(this, out, flags);
        } else {
            GoogleMapOptionsCreator.m1950a(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.f1503go = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.f1507gs = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.f1510gv = Boolean.valueOf(enabled);
        return this;
    }
}
