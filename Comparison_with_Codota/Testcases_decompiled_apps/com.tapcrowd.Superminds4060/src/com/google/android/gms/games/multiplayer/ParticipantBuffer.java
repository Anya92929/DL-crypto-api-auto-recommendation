package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;

public final class ParticipantBuffer extends DataBuffer<Participant> {
    public Participant get(int position) {
        return new C0189d(this.f366jf, position);
    }
}
