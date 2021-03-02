package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708r;
import com.google.android.gms.maps.model.internal.C0740g;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();

    /* renamed from: iM */
    private final int f1769iM;
    /* access modifiers changed from: private */

    /* renamed from: qP */
    public C0740g f1770qP;

    /* renamed from: qQ */
    private TileProvider f1771qQ;

    /* renamed from: qk */
    private float f1772qk;

    /* renamed from: ql */
    private boolean f1773ql;

    public TileOverlayOptions() {
        this.f1773ql = true;
        this.f1769iM = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex) {
        this.f1773ql = true;
        this.f1769iM = versionCode;
        this.f1770qP = C0740g.C0741a.m2150aj(delegate);
        this.f1771qQ = this.f1770qP == null ? null : new TileProvider() {

            /* renamed from: qR */
            private final C0740g f1774qR = TileOverlayOptions.this.f1770qP;

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.f1774qR.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.f1773ql = visible;
        this.f1772qk = zIndex;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cP */
    public IBinder mo5988cP() {
        return this.f1770qP.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public TileProvider getTileProvider() {
        return this.f1771qQ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1769iM;
    }

    public float getZIndex() {
        return this.f1772qk;
    }

    public boolean isVisible() {
        return this.f1773ql;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.f1771qQ = tileProvider;
        this.f1770qP = this.f1771qQ == null ? null : new C0740g.C0741a() {
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.f1773ql = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708r.m2074cK()) {
            C0743j.m2151a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m2100a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.f1772qk = zIndex;
        return this;
    }
}
