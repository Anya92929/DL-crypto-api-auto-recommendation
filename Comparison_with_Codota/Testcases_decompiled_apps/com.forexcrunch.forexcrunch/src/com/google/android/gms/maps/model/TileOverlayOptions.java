package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708q;
import com.google.android.gms.maps.model.internal.C0740g;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();

    /* renamed from: ab */
    private final int f1629ab;
    /* access modifiers changed from: private */

    /* renamed from: hG */
    public C0740g f1630hG;

    /* renamed from: hH */
    private TileProvider f1631hH;

    /* renamed from: hb */
    private float f1632hb;

    /* renamed from: hc */
    private boolean f1633hc;

    public TileOverlayOptions() {
        this.f1633hc = true;
        this.f1629ab = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex) {
        this.f1633hc = true;
        this.f1629ab = versionCode;
        this.f1630hG = C0740g.C0741a.m2110U(delegate);
        this.f1631hH = this.f1630hG == null ? null : new TileProvider() {

            /* renamed from: hI */
            private final C0740g f1634hI = TileOverlayOptions.this.f1630hG;

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.f1634hI.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.f1633hc = visible;
        this.f1632hb = zIndex;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bs */
    public IBinder mo6150bs() {
        return this.f1630hG.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public TileProvider getTileProvider() {
        return this.f1631hH;
    }

    public float getZIndex() {
        return this.f1632hb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo6154i() {
        return this.f1629ab;
    }

    public boolean isVisible() {
        return this.f1633hc;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.f1631hH = tileProvider;
        this.f1630hG = this.f1631hH == null ? null : new C0740g.C0741a() {
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.f1633hc = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0743j.m2111a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m2061a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.f1632hb = zIndex;
        return this;
    }
}
