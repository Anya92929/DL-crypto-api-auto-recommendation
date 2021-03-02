package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.internal.C0488bc;
import com.google.android.gms.internal.C0489bd;
import com.google.android.gms.internal.C0618r;

/* renamed from: com.google.android.gms.games.leaderboard.e */
public final class C0387e extends C0342b implements LeaderboardVariant {
    C0387e(C0344d dVar, int i) {
        super(dVar, i);
    }

    /* renamed from: aI */
    public String mo4319aI() {
        return getString("top_page_token_next");
    }

    /* renamed from: aJ */
    public String mo4320aJ() {
        return getString("window_page_token_prev");
    }

    /* renamed from: aK */
    public String mo4321aK() {
        return getString("window_page_token_next");
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
        if (mo4039e("total_scores")) {
            return -1;
        }
        return getLong("total_scores");
    }

    public long getPlayerRank() {
        if (mo4039e("player_rank")) {
            return -1;
        }
        return getLong("player_rank");
    }

    public long getRawPlayerScore() {
        if (mo4039e("player_raw_score")) {
            return -1;
        }
        return getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !mo4039e("player_raw_score");
    }

    public String toString() {
        return C0618r.m1882c(this).mo5486a("TimeSpan", C0489bd.m1308G(getTimeSpan())).mo5486a("Collection", C0488bc.m1307G(getCollection())).mo5486a("RawPlayerScore", hasPlayerInfo() ? Long.valueOf(getRawPlayerScore()) : "none").mo5486a("DisplayPlayerScore", hasPlayerInfo() ? getDisplayPlayerScore() : "none").mo5486a("PlayerRank", hasPlayerInfo() ? Long.valueOf(getPlayerRank()) : "none").mo5486a("DisplayPlayerRank", hasPlayerInfo() ? getDisplayPlayerRank() : "none").mo5486a("NumScores", Long.valueOf(getNumScores())).mo5486a("TopPageNextToken", mo4319aI()).mo5486a("WindowPageNextToken", mo4321aK()).mo5486a("WindowPagePrevToken", mo4320aJ()).toString();
    }
}
