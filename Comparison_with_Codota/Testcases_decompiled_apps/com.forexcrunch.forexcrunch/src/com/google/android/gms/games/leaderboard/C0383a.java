package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.forexcrunch.forexcrunch.gui.utils.Constants;
import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.internal.C0618r;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.leaderboard.a */
public final class C0383a extends C0342b implements Leaderboard {

    /* renamed from: eo */
    private final int f910eo;

    C0383a(C0344d dVar, int i, int i2) {
        super(dVar, i);
        this.f910eo = i2;
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo4037a("name", dataOut);
    }

    public Uri getIconImageUri() {
        return mo4038d("board_icon_image_uri");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.f910eo);
        for (int i = 0; i < this.f910eo; i++) {
            arrayList.add(new C0387e(this.f795S, this.f796V + i));
        }
        return arrayList;
    }

    public String toString() {
        return C0618r.m1882c(this).mo5486a(Constants.INDONESIA, getLeaderboardId()).mo5486a("DisplayName", getDisplayName()).mo5486a("IconImageURI", getIconImageUri()).mo5486a("ScoreOrder", Integer.valueOf(getScoreOrder())).toString();
    }
}
