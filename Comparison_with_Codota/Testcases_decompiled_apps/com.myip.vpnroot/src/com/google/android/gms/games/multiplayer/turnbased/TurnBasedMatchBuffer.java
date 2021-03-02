package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;

public final class TurnBasedMatchBuffer extends C0300g<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "external_match_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public TurnBasedMatch mo4356f(int i, int i2) {
        return new TurnBasedMatchRef(this.f667IC, i, i2);
    }
}
