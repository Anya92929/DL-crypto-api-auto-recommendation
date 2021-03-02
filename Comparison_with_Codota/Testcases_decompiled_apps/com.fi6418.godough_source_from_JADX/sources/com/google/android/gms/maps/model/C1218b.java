package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.internal.zzi;

/* renamed from: com.google.android.gms.maps.model.b */
class C1218b extends zzi.zza {

    /* renamed from: a */
    final /* synthetic */ TileProvider f5211a;

    /* renamed from: b */
    final /* synthetic */ TileOverlayOptions f5212b;

    C1218b(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.f5212b = tileOverlayOptions;
        this.f5211a = tileProvider;
    }

    public Tile getTile(int i, int i2, int i3) {
        return this.f5211a.getTile(i, i2, i3);
    }
}
