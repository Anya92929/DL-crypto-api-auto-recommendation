package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader abn;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.abn = new LeaderboardScoreBufferHeader(dataHolder.mo4321gz());
    }

    public LeaderboardScore get(int position) {
        return new LeaderboardScoreRef(this.f667IC, position);
    }

    /* renamed from: ly */
    public LeaderboardScoreBufferHeader mo7487ly() {
        return this.abn;
    }
}
