package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C0300g<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "external_leaderboard_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Leaderboard mo4356f(int i, int i2) {
        return new LeaderboardRef(this.f667IC, i, i2);
    }
}
