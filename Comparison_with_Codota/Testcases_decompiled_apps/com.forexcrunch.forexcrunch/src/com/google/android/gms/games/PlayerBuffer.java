package com.google.android.gms.games;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.DataBuffer;

public final class PlayerBuffer extends DataBuffer<Player> {
    public PlayerBuffer(C0344d dataHolder) {
        super(dataHolder);
    }

    public Player get(int position) {
        return new C0382d(this.f792S, position);
    }
}
