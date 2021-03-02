package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;
import com.google.android.gms.maps.model.internal.C1907i;

public final class TileOverlayOptions implements SafeParcelable {
    public static final C1923w CREATOR = new C1923w();

    /* renamed from: BR */
    private final int f4480BR;
    private float ajA;
    private boolean ajB;
    /* access modifiers changed from: private */
    public C1907i akg;
    private TileProvider akh;
    private boolean aki;

    public TileOverlayOptions() {
        this.ajB = true;
        this.aki = true;
        this.f4480BR = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.ajB = true;
        this.aki = true;
        this.f4480BR = versionCode;
        this.akg = C1907i.C1908a.m6476by(delegate);
        this.akh = this.akg == null ? null : new TileProvider() {
            private final C1907i akj = TileOverlayOptions.this.akg;

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.akj.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.ajB = visible;
        this.ajA = zIndex;
        this.aki = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.aki = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.aki;
    }

    public TileProvider getTileProvider() {
        return this.akh;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4480BR;
    }

    public float getZIndex() {
        return this.ajA;
    }

    public boolean isVisible() {
        return this.ajB;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mP */
    public IBinder mo11024mP() {
        return this.akg.asBinder();
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.akh = tileProvider;
        this.akg = this.akh == null ? null : new C1907i.C1908a() {
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.ajB = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1924x.m6509a(this, out, flags);
        } else {
            C1923w.m6506a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.ajA = zIndex;
        return this;
    }
}
