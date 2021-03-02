package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.C0348f;

public final class LeaderboardBuffer extends C0348f<Leaderboard> {
    public LeaderboardBuffer(C0344d dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public Leaderboard mo4071a(int rowIndex, int numChildren) {
        return new C0383a(this.f792S, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
