package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;

public final class ParticipantBuffer extends DataBuffer<Participant> {
    public Participant get(int position) {
        return new C0393d(this.f792S, position);
    }
}
