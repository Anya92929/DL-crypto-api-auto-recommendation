package com.google.android.gms.games;

import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.common.data.DataBuffer;

public final class GameBuffer extends DataBuffer<Game> {
    public GameBuffer(C0140d dataHolder) {
        super(dataHolder);
    }

    public Game get(int position) {
        return new C0176b(this.f366jf, position);
    }
}
