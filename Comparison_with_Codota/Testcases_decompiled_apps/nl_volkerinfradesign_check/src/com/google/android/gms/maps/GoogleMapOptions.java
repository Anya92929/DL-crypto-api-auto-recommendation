package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0666R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    private final int f3331a;

    /* renamed from: b */
    private Boolean f3332b;

    /* renamed from: c */
    private Boolean f3333c;

    /* renamed from: d */
    private int f3334d;

    /* renamed from: e */
    private CameraPosition f3335e;

    /* renamed from: f */
    private Boolean f3336f;

    /* renamed from: g */
    private Boolean f3337g;

    /* renamed from: h */
    private Boolean f3338h;

    /* renamed from: i */
    private Boolean f3339i;

    /* renamed from: j */
    private Boolean f3340j;

    /* renamed from: k */
    private Boolean f3341k;

    /* renamed from: l */
    private Boolean f3342l;

    /* renamed from: m */
    private Boolean f3343m;

    /* renamed from: n */
    private Boolean f3344n;

    public GoogleMapOptions() {
        this.f3334d = -1;
        this.f3331a = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11) {
        this.f3334d = -1;
        this.f3331a = i;
        this.f3332b = zza.zza(b);
        this.f3333c = zza.zza(b2);
        this.f3334d = i2;
        this.f3335e = cameraPosition;
        this.f3336f = zza.zza(b3);
        this.f3337g = zza.zza(b4);
        this.f3338h = zza.zza(b5);
        this.f3339i = zza.zza(b6);
        this.f3340j = zza.zza(b7);
        this.f3341k = zza.zza(b8);
        this.f3342l = zza.zza(b9);
        this.f3343m = zza.zza(b10);
        this.f3344n = zza.zza(b11);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0666R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0666R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(C0666R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(C0666R.styleable.MapAttrs_ambientEnabled, false));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6195a() {
        return this.f3331a;
    }

    public GoogleMapOptions ambientEnabled(boolean z) {
        this.f3344n = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte mo6197b() {
        return zza.zze(this.f3332b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte mo6198c() {
        return zza.zze(this.f3333c);
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.f3335e = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.f3337g = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public byte mo6201d() {
        return zza.zze(this.f3336f);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte mo6203e() {
        return zza.zze(this.f3337g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public byte mo6204f() {
        return zza.zze(this.f3338h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public byte mo6205g() {
        return zza.zze(this.f3339i);
    }

    public Boolean getAmbientEnabled() {
        return this.f3344n;
    }

    public CameraPosition getCamera() {
        return this.f3335e;
    }

    public Boolean getCompassEnabled() {
        return this.f3337g;
    }

    public Boolean getLiteMode() {
        return this.f3342l;
    }

    public Boolean getMapToolbarEnabled() {
        return this.f3343m;
    }

    public int getMapType() {
        return this.f3334d;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f3341k;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f3338h;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f3340j;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f3333c;
    }

    public Boolean getZOrderOnTop() {
        return this.f3332b;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f3336f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f3339i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public byte mo6219h() {
        return zza.zze(this.f3340j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public byte mo6220i() {
        return zza.zze(this.f3341k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public byte mo6221j() {
        return zza.zze(this.f3342l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public byte mo6222k() {
        return zza.zze(this.f3343m);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public byte mo6223l() {
        return zza.zze(this.f3344n);
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.f3342l = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.f3343m = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.f3334d = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.f3341k = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.f3338h = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.f3340j = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.f3333c = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m4229a(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.f3332b = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.f3336f = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.f3339i = Boolean.valueOf(z);
        return this;
    }
}
