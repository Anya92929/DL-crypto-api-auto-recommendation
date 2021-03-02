package com.google.android.gms.games;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.DataBuffer;

public final class GameBuffer extends DataBuffer<Game> {
    public GameBuffer(C0344d dataHolder) {
        super(dataHolder);
    }

    public Game get(int position) {
        return new C0380b(this.f792S, position);
    }
}
