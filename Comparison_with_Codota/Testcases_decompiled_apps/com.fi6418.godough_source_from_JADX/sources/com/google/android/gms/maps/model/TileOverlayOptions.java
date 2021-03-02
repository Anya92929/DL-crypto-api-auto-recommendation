package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();

    /* renamed from: a */
    private final int f5200a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzi f5201b;

    /* renamed from: c */
    private TileProvider f5202c;

    /* renamed from: d */
    private boolean f5203d;

    /* renamed from: e */
    private float f5204e;

    /* renamed from: f */
    private boolean f5205f;

    public TileOverlayOptions() {
        this.f5203d = true;
        this.f5205f = true;
        this.f5200a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.f5203d = true;
        this.f5205f = true;
        this.f5200a = i;
        this.f5201b = zzi.zza.zzcX(iBinder);
        this.f5202c = this.f5201b == null ? null : new C1217a(this);
        this.f5203d = z;
        this.f5204e = f;
        this.f5205f = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8750a() {
        return this.f5200a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IBinder mo8751b() {
        return this.f5201b.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.f5205f = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.f5205f;
    }

    public TileProvider getTileProvider() {
        return this.f5202c;
    }

    public float getZIndex() {
        return this.f5204e;
    }

    public boolean isVisible() {
        return this.f5203d;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.f5202c = tileProvider;
        this.f5201b = this.f5202c == null ? null : new C1218b(this, tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f5203d = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.m5130a(this, parcel, i);
    }

    public TileOverlayOptions zIndex(float f) {
        this.f5204e = f;
        return this;
    }
}
