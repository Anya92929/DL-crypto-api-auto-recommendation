package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0501eu;
import com.google.android.gms.internal.C0502ev;
import org.apache.cordova.NetworkManager;

/* renamed from: com.google.android.gms.games.leaderboard.e */
public final class C0183e extends C0138b implements LeaderboardVariant {
    C0183e(C0140d dVar, int i) {
        super(dVar, i);
    }

    /* renamed from: ce */
    public String mo3870ce() {
        return getString("top_page_token_next");
    }

    /* renamed from: cf */
    public String mo3871cf() {
        return getString("window_page_token_prev");
    }

    /* renamed from: cg */
    public String mo3872cg() {
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
        if (mo3592v("total_scores")) {
            return -1;
        }
        return getLong("total_scores");
    }

    public long getPlayerRank() {
        if (mo3592v("player_rank")) {
            return -1;
        }
        return getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        if (mo3592v("player_raw_score")) {
            return -1;
        }
        return getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !mo3592v("player_raw_score");
    }

    public String toString() {
        return C0408dl.m938d(this).mo4388a("TimeSpan", C0502ev.m1488R(getTimeSpan())).mo4388a("Collection", C0501eu.m1487R(getCollection())).mo4388a("RawPlayerScore", hasPlayerInfo() ? Long.valueOf(getRawPlayerScore()) : NetworkManager.TYPE_NONE).mo4388a("DisplayPlayerScore", hasPlayerInfo() ? getDisplayPlayerScore() : NetworkManager.TYPE_NONE).mo4388a("PlayerRank", hasPlayerInfo() ? Long.valueOf(getPlayerRank()) : NetworkManager.TYPE_NONE).mo4388a("DisplayPlayerRank", hasPlayerInfo() ? getDisplayPlayerRank() : NetworkManager.TYPE_NONE).mo4388a("NumScores", Long.valueOf(getNumScores())).mo4388a("TopPageNextToken", mo3870ce()).mo4388a("WindowPageNextToken", mo3872cg()).mo4388a("WindowPagePrevToken", mo3871cf()).toString();
    }
}
