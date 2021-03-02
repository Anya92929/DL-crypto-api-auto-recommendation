package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();

    /* renamed from: a */
    private final int f3551a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzi f3552b;

    /* renamed from: c */
    private TileProvider f3553c;

    /* renamed from: d */
    private boolean f3554d;

    /* renamed from: e */
    private float f3555e;

    /* renamed from: f */
    private boolean f3556f;

    public TileOverlayOptions() {
        this.f3554d = true;
        this.f3556f = true;
        this.f3551a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.f3554d = true;
        this.f3556f = true;
        this.f3551a = i;
        this.f3552b = zzi.zza.zzdm(iBinder);
        this.f3553c = this.f3552b == null ? null : new TileProvider() {

            /* renamed from: b */
            private final zzi f3558b = TileOverlayOptions.this.f3552b;

            public Tile getTile(int i, int i2, int i3) {
                try {
                    return this.f3558b.getTile(i, i2, i3);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.f3554d = z;
        this.f3555e = f;
        this.f3556f = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6989a() {
        return this.f3551a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IBinder mo6990b() {
        return this.f3552b.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.f3556f = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.f3556f;
    }

    public TileProvider getTileProvider() {
        return this.f3553c;
    }

    public float getZIndex() {
        return this.f3555e;
    }

    public boolean isVisible() {
        return this.f3554d;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.f3553c = tileProvider;
        this.f3552b = this.f3553c == null ? null : new zzi.zza() {
            public Tile getTile(int i, int i2, int i3) {
                return tileProvider.getTile(i, i2, i3);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f3554d = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.m4227a(this, parcel, i);
    }

    public TileOverlayOptions zIndex(float f) {
        this.f3555e = f;
        return this;
    }
}
