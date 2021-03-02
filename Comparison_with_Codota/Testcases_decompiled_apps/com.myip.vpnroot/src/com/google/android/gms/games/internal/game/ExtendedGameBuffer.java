package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;

public final class ExtendedGameBuffer extends C0300g<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "external_game_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public ExtendedGame mo4356f(int i, int i2) {
        return new ExtendedGameRef(this.f667IC, i, i2);
    }
}
