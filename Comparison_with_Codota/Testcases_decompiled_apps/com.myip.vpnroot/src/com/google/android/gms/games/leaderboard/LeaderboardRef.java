package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends C0297d implements Leaderboard {
    private final int aaz;
    private final Game abm;

    LeaderboardRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.aaz = numChildren;
        this.abm = new GameRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardEntity.m3645a(this, obj);
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo4336a("name", dataOut);
    }

    public Game getGame() {
        return this.abm;
    }

    public Uri getIconImageUri() {
        return mo4338aR("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.aaz);
        for (int i = 0; i < this.aaz; i++) {
            arrayList.add(new LeaderboardVariantRef(this.f693IC, this.f694JQ + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return LeaderboardEntity.m3644a(this);
    }

    /* renamed from: lx */
    public Leaderboard freeze() {
        return new LeaderboardEntity(this);
    }

    public String toString() {
        return LeaderboardEntity.m3646b(this);
    }
}
