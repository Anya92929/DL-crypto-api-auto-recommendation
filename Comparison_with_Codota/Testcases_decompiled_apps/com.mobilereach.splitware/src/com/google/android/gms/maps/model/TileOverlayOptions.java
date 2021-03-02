package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    /* access modifiers changed from: private */
    public zzi zzaTP;
    private TileProvider zzaTQ;
    private boolean zzaTR;
    private float zzaTh;
    private boolean zzaTi;

    public TileOverlayOptions() {
        this.zzaTi = true;
        this.zzaTR = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.zzaTi = true;
        this.zzaTR = true;
        this.mVersionCode = versionCode;
        this.zzaTP = zzi.zza.zzdm(delegate);
        this.zzaTQ = this.zzaTP == null ? null : new TileProvider() {
            private final zzi zzaTS = TileOverlayOptions.this.zzaTP;

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.zzaTS.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.zzaTi = visible;
        this.zzaTh = zIndex;
        this.zzaTR = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.zzaTR = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaTR;
    }

    public TileProvider getTileProvider() {
        return this.zzaTQ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaTh;
    }

    public boolean isVisible() {
        return this.zzaTi;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaTQ = tileProvider;
        this.zzaTP = this.zzaTQ == null ? null : new zzi.zza() {
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.zzaTi = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.zzaTh = zIndex;
        return this;
    }

    /* access modifiers changed from: package-private */
    public IBinder zzAm() {
        return this.zzaTP.asBinder();
    }
}
