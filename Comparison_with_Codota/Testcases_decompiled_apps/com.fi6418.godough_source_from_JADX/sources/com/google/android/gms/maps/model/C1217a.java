package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzi;

/* renamed from: com.google.android.gms.maps.model.a */
class C1217a implements TileProvider {

    /* renamed from: a */
    final /* synthetic */ TileOverlayOptions f5209a;

    /* renamed from: b */
    private final zzi f5210b = this.f5209a.f5201b;

    C1217a(TileOverlayOptions tileOverlayOptions) {
        this.f5209a = tileOverlayOptions;
    }

    public Tile getTile(int i, int i2, int i3) {
        try {
            return this.f5210b.getTile(i, i2, i3);
        } catch (RemoteException e) {
            return null;
        }
    }
}
