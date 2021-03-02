package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.games.C0178d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.leaderboard.d */
public final class C0182d extends C0138b implements LeaderboardScore {

    /* renamed from: nH */
    private final C0178d f496nH;

    C0182d(C0140d dVar, int i) {
        super(dVar, i);
        this.f496nH = new C0178d(dVar, i);
    }

    /* renamed from: cd */
    public LeaderboardScore freeze() {
        return new C0181c(this);
    }

    public boolean equals(Object obj) {
        return C0181c.m408a(this, obj);
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        mo3584a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        mo3584a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        if (mo3592v("external_player_id")) {
            return null;
        }
        return this.f496nH;
    }

    public String getScoreHolderDisplayName() {
        return mo3592v("external_player_id") ? getString("default_display_name") : this.f496nH.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (mo3592v("external_player_id")) {
            mo3584a("default_display_name", dataOut);
        } else {
            this.f496nH.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        if (mo3592v("external_player_id")) {
            return null;
        }
        return this.f496nH.getHiResImageUri();
    }

    public Uri getScoreHolderIconImageUri() {
        return mo3592v("external_player_id") ? mo3591u("default_display_image_uri") : this.f496nH.getIconImageUri();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return C0181c.m407a(this);
    }

    public String toString() {
        return C0181c.m409b(this);
    }
}
