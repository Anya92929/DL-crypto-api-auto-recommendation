package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;

public final class RoomBuffer extends C0300g<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "external_match_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Room mo4356f(int i, int i2) {
        return new RoomRef(this.f667IC, i, i2);
    }
}
