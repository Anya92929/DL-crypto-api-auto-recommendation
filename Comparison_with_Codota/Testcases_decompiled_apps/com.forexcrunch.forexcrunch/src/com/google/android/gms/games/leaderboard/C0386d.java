package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.games.C0382d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.leaderboard.d */
public final class C0386d extends C0342b implements LeaderboardScore {

    /* renamed from: eA */
    private final C0382d f921eA;

    C0386d(C0344d dVar, int i) {
        super(dVar, i);
        this.f921eA = new C0382d(dVar, i);
    }

    /* renamed from: aH */
    public LeaderboardScore freeze() {
        return new C0385c(this);
    }

    public boolean equals(Object obj) {
        return C0385c.m733a(this, obj);
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        mo4037a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        mo4037a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        if (mo4039e("external_player_id")) {
            return null;
        }
        return this.f921eA;
    }

    public String getScoreHolderDisplayName() {
        return mo4039e("external_player_id") ? getString("default_display_name") : this.f921eA.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (mo4039e("external_player_id")) {
            mo4037a("default_display_name", dataOut);
        } else {
            this.f921eA.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        if (mo4039e("external_player_id")) {
            return null;
        }
        return this.f921eA.getHiResImageUri();
    }

    public Uri getScoreHolderIconImageUri() {
        return mo4039e("external_player_id") ? mo4038d("default_display_image_uri") : this.f921eA.getIconImageUri();
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return C0385c.m732a(this);
    }

    public String toString() {
        return C0385c.m734b(this);
    }
}
