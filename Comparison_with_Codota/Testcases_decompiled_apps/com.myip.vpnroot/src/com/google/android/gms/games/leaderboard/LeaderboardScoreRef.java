package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends C0297d implements LeaderboardScore {
    private final PlayerRef abA;

    LeaderboardScoreRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.abA = new PlayerRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.m3652a(this, obj);
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        mo4336a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        mo4336a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        if (mo4339aS("external_player_id")) {
            return null;
        }
        return this.abA;
    }

    public String getScoreHolderDisplayName() {
        return mo4339aS("external_player_id") ? getString("default_display_name") : this.abA.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (mo4339aS("external_player_id")) {
            mo4336a("default_display_name", dataOut);
        } else {
            this.abA.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        if (mo4339aS("external_player_id")) {
            return null;
        }
        return this.abA.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        if (mo4339aS("external_player_id")) {
            return null;
        }
        return this.abA.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return mo4339aS("external_player_id") ? mo4338aR("default_display_image_uri") : this.abA.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return mo4339aS("external_player_id") ? getString("default_display_image_url") : this.abA.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.m3651a(this);
    }

    /* renamed from: lA */
    public LeaderboardScore freeze() {
        return new LeaderboardScoreEntity(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.m3653b(this);
    }
}
