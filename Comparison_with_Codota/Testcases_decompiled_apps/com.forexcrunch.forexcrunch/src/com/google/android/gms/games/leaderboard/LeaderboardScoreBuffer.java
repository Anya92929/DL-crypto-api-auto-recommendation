package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.DataBuffer;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {

    /* renamed from: ep */
    private final C0384b f904ep;

    public LeaderboardScoreBuffer(C0344d dataHolder) {
        super(dataHolder);
        this.f904ep = new C0384b(dataHolder.mo4065l());
    }

    /* renamed from: aF */
    public C0384b mo4293aF() {
        return this.f904ep;
    }

    public LeaderboardScore get(int position) {
        return new C0386d(this.f792S, position);
    }
}
