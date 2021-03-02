package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.common.data.DataBuffer;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {

    /* renamed from: nv */
    private final C0180b f478nv;

    public LeaderboardScoreBuffer(C0140d dataHolder) {
        super(dataHolder);
        this.f478nv = new C0180b(dataHolder.mo3599aM());
    }

    /* renamed from: cb */
    public C0180b mo3843cb() {
        return this.f478nv;
    }

    public LeaderboardScore get(int position) {
        return new C0182d(this.f366jf, position);
    }
}
