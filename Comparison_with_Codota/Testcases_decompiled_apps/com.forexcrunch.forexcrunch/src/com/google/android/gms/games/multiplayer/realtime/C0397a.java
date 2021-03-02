package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.C0348f;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.a */
public final class C0397a extends C0348f<Room> {
    public C0397a(C0344d dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Room mo4071a(int i, int i2) {
        return new C0399c(this.f792S, i, i2);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
