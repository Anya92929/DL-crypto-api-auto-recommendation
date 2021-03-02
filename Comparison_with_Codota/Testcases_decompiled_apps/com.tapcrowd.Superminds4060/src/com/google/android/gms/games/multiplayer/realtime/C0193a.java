package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.common.data.C0144f;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.a */
public final class C0193a extends C0144f<Room> {
    public C0193a(C0140d dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Room mo3620a(int i, int i2) {
        return new C0195c(this.f366jf, i, i2);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
