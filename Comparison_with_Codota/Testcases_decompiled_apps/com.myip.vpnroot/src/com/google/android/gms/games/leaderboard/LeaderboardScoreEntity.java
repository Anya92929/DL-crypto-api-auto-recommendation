package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C1386jv;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long abo;
    private final String abp;
    private final String abq;
    private final long abr;
    private final long abs;
    private final String abt;
    private final Uri abu;
    private final Uri abv;
    private final PlayerEntity abw;
    private final String abx;
    private final String aby;
    private final String abz;

    public LeaderboardScoreEntity(LeaderboardScore score) {
        this.abo = score.getRank();
        this.abp = (String) C0348n.m861i(score.getDisplayRank());
        this.abq = (String) C0348n.m861i(score.getDisplayScore());
        this.abr = score.getRawScore();
        this.abs = score.getTimestampMillis();
        this.abt = score.getScoreHolderDisplayName();
        this.abu = score.getScoreHolderIconImageUri();
        this.abv = score.getScoreHolderHiResImageUri();
        Player scoreHolder = score.getScoreHolder();
        this.abw = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.abx = score.getScoreTag();
        this.aby = score.getScoreHolderIconImageUrl();
        this.abz = score.getScoreHolderHiResImageUrl();
    }

    /* renamed from: a */
    static int m3651a(LeaderboardScore leaderboardScore) {
        return C0345m.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    /* renamed from: a */
    static boolean m3652a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return C0345m.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && C0345m.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && C0345m.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && C0345m.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && C0345m.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && C0345m.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && C0345m.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && C0345m.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && C0345m.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && C0345m.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    /* renamed from: b */
    static String m3653b(LeaderboardScore leaderboardScore) {
        return C0345m.m848h(leaderboardScore).mo4549a("Rank", Long.valueOf(leaderboardScore.getRank())).mo4549a("DisplayRank", leaderboardScore.getDisplayRank()).mo4549a("Score", Long.valueOf(leaderboardScore.getRawScore())).mo4549a("DisplayScore", leaderboardScore.getDisplayScore()).mo4549a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).mo4549a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).mo4549a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).mo4549a("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).mo4549a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).mo4549a("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).mo4549a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).mo4549a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return m3652a(this, obj);
    }

    public String getDisplayRank() {
        return this.abp;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.abp, dataOut);
    }

    public String getDisplayScore() {
        return this.abq;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.abq, dataOut);
    }

    public long getRank() {
        return this.abo;
    }

    public long getRawScore() {
        return this.abr;
    }

    public Player getScoreHolder() {
        return this.abw;
    }

    public String getScoreHolderDisplayName() {
        return this.abw == null ? this.abt : this.abw.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.abw == null) {
            C1386jv.m5216b(this.abt, dataOut);
        } else {
            this.abw.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.abw == null ? this.abv : this.abw.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.abw == null ? this.abz : this.abw.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.abw == null ? this.abu : this.abw.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.abw == null ? this.aby : this.abw.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.abx;
    }

    public long getTimestampMillis() {
        return this.abs;
    }

    public int hashCode() {
        return m3651a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: lA */
    public LeaderboardScore freeze() {
        return this;
    }

    public String toString() {
        return m3653b(this);
    }
}
