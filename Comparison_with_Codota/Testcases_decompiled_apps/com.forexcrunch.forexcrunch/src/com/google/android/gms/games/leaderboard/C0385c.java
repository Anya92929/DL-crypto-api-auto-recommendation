package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C0423ao;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.internal.C0621s;

/* renamed from: com.google.android.gms.games.leaderboard.c */
public final class C0385c implements LeaderboardScore {

    /* renamed from: er */
    private final long f912er;

    /* renamed from: es */
    private final String f913es;

    /* renamed from: et */
    private final String f914et;

    /* renamed from: eu */
    private final long f915eu;

    /* renamed from: ev */
    private final long f916ev;

    /* renamed from: ew */
    private final String f917ew;

    /* renamed from: ex */
    private final Uri f918ex;

    /* renamed from: ey */
    private final Uri f919ey;

    /* renamed from: ez */
    private final PlayerEntity f920ez;

    public C0385c(LeaderboardScore leaderboardScore) {
        this.f912er = leaderboardScore.getRank();
        this.f913es = (String) C0621s.m1890d(leaderboardScore.getDisplayRank());
        this.f914et = (String) C0621s.m1890d(leaderboardScore.getDisplayScore());
        this.f915eu = leaderboardScore.getRawScore();
        this.f916ev = leaderboardScore.getTimestampMillis();
        this.f917ew = leaderboardScore.getScoreHolderDisplayName();
        this.f918ex = leaderboardScore.getScoreHolderIconImageUri();
        this.f919ey = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.f920ez = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
    }

    /* renamed from: a */
    static int m732a(LeaderboardScore leaderboardScore) {
        return C0618r.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    /* renamed from: a */
    static boolean m733a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return C0618r.m1881a(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && C0618r.m1881a(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && C0618r.m1881a(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && C0618r.m1881a(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && C0618r.m1881a(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && C0618r.m1881a(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && C0618r.m1881a(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && C0618r.m1881a(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && C0618r.m1881a(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder());
    }

    /* renamed from: b */
    static String m734b(LeaderboardScore leaderboardScore) {
        return C0618r.m1882c(leaderboardScore).mo5486a("Rank", Long.valueOf(leaderboardScore.getRank())).mo5486a("DisplayRank", leaderboardScore.getDisplayRank()).mo5486a("Score", Long.valueOf(leaderboardScore.getRawScore())).mo5486a("DisplayScore", leaderboardScore.getDisplayScore()).mo5486a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).mo5486a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).mo5486a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).mo5486a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).mo5486a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).toString();
    }

    /* renamed from: aH */
    public LeaderboardScore freeze() {
        return this;
    }

    public boolean equals(Object obj) {
        return m733a(this, obj);
    }

    public String getDisplayRank() {
        return this.f913es;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        C0423ao.m905b(this.f913es, dataOut);
    }

    public String getDisplayScore() {
        return this.f914et;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        C0423ao.m905b(this.f914et, dataOut);
    }

    public long getRank() {
        return this.f912er;
    }

    public long getRawScore() {
        return this.f915eu;
    }

    public Player getScoreHolder() {
        return this.f920ez;
    }

    public String getScoreHolderDisplayName() {
        return this.f920ez == null ? this.f917ew : this.f920ez.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.f920ez == null) {
            C0423ao.m905b(this.f917ew, dataOut);
        } else {
            this.f920ez.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.f920ez == null ? this.f919ey : this.f920ez.getHiResImageUri();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.f920ez == null ? this.f918ex : this.f920ez.getIconImageUri();
    }

    public long getTimestampMillis() {
        return this.f916ev;
    }

    public int hashCode() {
        return m732a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m734b(this);
    }
}
