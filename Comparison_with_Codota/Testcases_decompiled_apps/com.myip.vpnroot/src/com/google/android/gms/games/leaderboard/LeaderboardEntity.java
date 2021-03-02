package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.C1386jv;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {

    /* renamed from: Nz */
    private final String f2346Nz;

    /* renamed from: UW */
    private final Uri f2347UW;

    /* renamed from: Vh */
    private final String f2348Vh;
    private final String abj;
    private final int abk;
    private final ArrayList<LeaderboardVariantEntity> abl;
    private final Game abm;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.abj = leaderboard.getLeaderboardId();
        this.f2346Nz = leaderboard.getDisplayName();
        this.f2347UW = leaderboard.getIconImageUri();
        this.f2348Vh = leaderboard.getIconImageUrl();
        this.abk = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.abm = game == null ? null : new GameEntity(game);
        ArrayList<LeaderboardVariant> variants = leaderboard.getVariants();
        int size = variants.size();
        this.abl = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.abl.add((LeaderboardVariantEntity) variants.get(i).freeze());
        }
    }

    /* renamed from: a */
    static int m3644a(Leaderboard leaderboard) {
        return C0345m.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    /* renamed from: a */
    static boolean m3645a(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return C0345m.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && C0345m.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && C0345m.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && C0345m.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && C0345m.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    /* renamed from: b */
    static String m3646b(Leaderboard leaderboard) {
        return C0345m.m848h(leaderboard).mo4549a("LeaderboardId", leaderboard.getLeaderboardId()).mo4549a("DisplayName", leaderboard.getDisplayName()).mo4549a("IconImageUri", leaderboard.getIconImageUri()).mo4549a("IconImageUrl", leaderboard.getIconImageUrl()).mo4549a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).mo4549a("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return m3645a(this, obj);
    }

    public String getDisplayName() {
        return this.f2346Nz;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f2346Nz, dataOut);
    }

    public Game getGame() {
        return this.abm;
    }

    public Uri getIconImageUri() {
        return this.f2347UW;
    }

    public String getIconImageUrl() {
        return this.f2348Vh;
    }

    public String getLeaderboardId() {
        return this.abj;
    }

    public int getScoreOrder() {
        return this.abk;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.abl);
    }

    public int hashCode() {
        return m3644a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: lx */
    public Leaderboard freeze() {
        return this;
    }

    public String toString() {
        return m3646b(this);
    }
}
