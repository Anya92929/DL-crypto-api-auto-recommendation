package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.internal.C0408dl;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.leaderboard.a */
public final class C0179a extends C0138b implements Leaderboard {

    /* renamed from: nu */
    private final int f484nu;

    C0179a(C0140d dVar, int i, int i2) {
        super(dVar, i);
        this.f484nu = i2;
    }

    public String getDisplayName() {
        return getString(DBFavorites.KEY_NAME);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo3584a(DBFavorites.KEY_NAME, dataOut);
    }

    public Uri getIconImageUri() {
        return mo3591u("board_icon_image_uri");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.f484nu);
        for (int i = 0; i < this.f484nu; i++) {
            arrayList.add(new C0183e(this.f369jf, this.f370ji + i));
        }
        return arrayList;
    }

    public String toString() {
        return C0408dl.m938d(this).mo4388a("ID", getLeaderboardId()).mo4388a("DisplayName", getDisplayName()).mo4388a("IconImageURI", getIconImageUri()).mo4388a("ScoreOrder", Integer.valueOf(getScoreOrder())).toString();
    }
}
