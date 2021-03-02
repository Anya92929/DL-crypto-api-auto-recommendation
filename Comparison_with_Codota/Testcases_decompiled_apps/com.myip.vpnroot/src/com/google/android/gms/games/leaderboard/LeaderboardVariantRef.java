package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardVariantRef extends C0297d implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardVariantEntity.m3660a(this, obj);
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        if (mo4339aS("total_scores")) {
            return -1;
        }
        return getLong("total_scores");
    }

    public long getPlayerRank() {
        if (mo4339aS("player_rank")) {
            return -1;
        }
        return getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        if (mo4339aS("player_raw_score")) {
            return -1;
        }
        return getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !mo4339aS("player_raw_score");
    }

    public int hashCode() {
        return LeaderboardVariantEntity.m3659a(this);
    }

    /* renamed from: lB */
    public String mo7504lB() {
        return getString("top_page_token_next");
    }

    /* renamed from: lC */
    public String mo7505lC() {
        return getString("window_page_token_prev");
    }

    /* renamed from: lD */
    public String mo7506lD() {
        return getString("window_page_token_next");
    }

    /* renamed from: lE */
    public LeaderboardVariant freeze() {
        return new LeaderboardVariantEntity(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.m3661b(this);
    }
}
