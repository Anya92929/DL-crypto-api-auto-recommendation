package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0610c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    private final int f4989a;

    /* renamed from: b */
    private Boolean f4990b;

    /* renamed from: c */
    private Boolean f4991c;

    /* renamed from: d */
    private int f4992d;

    /* renamed from: e */
    private CameraPosition f4993e;

    /* renamed from: f */
    private Boolean f4994f;

    /* renamed from: g */
    private Boolean f4995g;

    /* renamed from: h */
    private Boolean f4996h;

    /* renamed from: i */
    private Boolean f4997i;

    /* renamed from: j */
    private Boolean f4998j;

    /* renamed from: k */
    private Boolean f4999k;

    /* renamed from: l */
    private Boolean f5000l;

    /* renamed from: m */
    private Boolean f5001m;

    public GoogleMapOptions() {
        this.f4992d = -1;
        this.f4989a = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10) {
        this.f4992d = -1;
        this.f4989a = i;
        this.f4990b = zza.zza(b);
        this.f4991c = zza.zza(b2);
        this.f4992d = i2;
        this.f4993e = cameraPosition;
        this.f4994f = zza.zza(b3);
        this.f4995g = zza.zza(b4);
        this.f4996h = zza.zza(b5);
        this.f4997i = zza.zza(b6);
        this.f4998j = zza.zza(b7);
        this.f4999k = zza.zza(b8);
        this.f5000l = zza.zza(b9);
        this.f5001m = zza.zza(b10);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0610c.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0610c.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0610c.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0610c.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0610c.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0610c.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0610c.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0610c.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0610c.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0610c.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0610c.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0610c.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0610c.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0610c.MapAttrs_uiMapToolbar, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7999a() {
        return this.f4989a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte mo8000b() {
        return zza.zze(this.f4990b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte mo8001c() {
        return zza.zze(this.f4991c);
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.f4993e = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.f4995g = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public byte mo8004d() {
        return zza.zze(this.f4994f);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte mo8006e() {
        return zza.zze(this.f4995g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public byte mo8007f() {
        return zza.zze(this.f4996h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public byte mo8008g() {
        return zza.zze(this.f4997i);
    }

    public CameraPosition getCamera() {
        return this.f4993e;
    }

    public Boolean getCompassEnabled() {
        return this.f4995g;
    }

    public Boolean getLiteMode() {
        return this.f5000l;
    }

    public Boolean getMapToolbarEnabled() {
        return this.f5001m;
    }

    public int getMapType() {
        return this.f4992d;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f4999k;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f4996h;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f4998j;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f4991c;
    }

    public Boolean getZOrderOnTop() {
        return this.f4990b;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f4994f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f4997i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public byte mo8021h() {
        return zza.zze(this.f4998j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public byte mo8022i() {
        return zza.zze(this.f4999k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public byte mo8023j() {
        return zza.zze(this.f5000l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public byte mo8024k() {
        return zza.zze(this.f5001m);
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.f5000l = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.f5001m = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.f4992d = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.f4999k = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.f4996h = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.f4998j = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.f4991c = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m5160a(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.f4990b = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.f4994f = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.f4997i = Boolean.valueOf(z);
        return this;
    }
}
