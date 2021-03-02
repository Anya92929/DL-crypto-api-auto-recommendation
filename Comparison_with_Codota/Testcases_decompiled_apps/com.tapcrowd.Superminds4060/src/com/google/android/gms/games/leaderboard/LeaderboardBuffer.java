package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.common.data.C0144f;

public final class LeaderboardBuffer extends C0144f<Leaderboard> {
    public LeaderboardBuffer(C0140d dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public Leaderboard mo3620a(int rowIndex, int numChildren) {
        return new C0179a(this.f366jf, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
