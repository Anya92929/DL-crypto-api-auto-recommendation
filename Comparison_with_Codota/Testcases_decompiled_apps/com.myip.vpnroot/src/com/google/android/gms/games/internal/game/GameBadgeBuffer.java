package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;

public final class GameBadgeBuffer extends DataBuffer<GameBadge> {
    /* renamed from: dK */
    public GameBadge get(int i) {
        return new GameBadgeRef(this.f667IC, i);
    }
}
