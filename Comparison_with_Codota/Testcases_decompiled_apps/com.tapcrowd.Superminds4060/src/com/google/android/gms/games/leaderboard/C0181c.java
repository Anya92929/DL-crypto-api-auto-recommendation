package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0437eg;

/* renamed from: com.google.android.gms.games.leaderboard.c */
public final class C0181c implements LeaderboardScore {

    /* renamed from: nA */
    private final long f486nA;

    /* renamed from: nB */
    private final long f487nB;

    /* renamed from: nC */
    private final String f488nC;

    /* renamed from: nD */
    private final Uri f489nD;

    /* renamed from: nE */
    private final Uri f490nE;

    /* renamed from: nF */
    private final PlayerEntity f491nF;

    /* renamed from: nG */
    private final String f492nG;

    /* renamed from: nx */
    private final long f493nx;

    /* renamed from: ny */
    private final String f494ny;

    /* renamed from: nz */
    private final String f495nz;

    public C0181c(LeaderboardScore leaderboardScore) {
        this.f493nx = leaderboardScore.getRank();
        this.f494ny = (String) C0411dm.m944e(leaderboardScore.getDisplayRank());
        this.f495nz = (String) C0411dm.m944e(leaderboardScore.getDisplayScore());
        this.f486nA = leaderboardScore.getRawScore();
        this.f487nB = leaderboardScore.getTimestampMillis();
        this.f488nC = leaderboardScore.getScoreHolderDisplayName();
        this.f489nD = leaderboardScore.getScoreHolderIconImageUri();
        this.f490nE = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.f491nF = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.f492nG = leaderboardScore.getScoreTag();
    }

    /* renamed from: a */
    static int m407a(LeaderboardScore leaderboardScore) {
        return C0408dl.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    /* renamed from: a */
    static boolean m408a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return C0408dl.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && C0408dl.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && C0408dl.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && C0408dl.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && C0408dl.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && C0408dl.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && C0408dl.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && C0408dl.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && C0408dl.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && C0408dl.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    /* renamed from: b */
    static String m409b(LeaderboardScore leaderboardScore) {
        return C0408dl.m938d(leaderboardScore).mo4388a("Rank", Long.valueOf(leaderboardScore.getRank())).mo4388a("DisplayRank", leaderboardScore.getDisplayRank()).mo4388a("Score", Long.valueOf(leaderboardScore.getRawScore())).mo4388a("DisplayScore", leaderboardScore.getDisplayScore()).mo4388a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).mo4388a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).mo4388a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).mo4388a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).mo4388a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).mo4388a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    /* renamed from: cd */
    public LeaderboardScore freeze() {
        return this;
    }

    public boolean equals(Object obj) {
        return m408a(this, obj);
    }

    public String getDisplayRank() {
        return this.f494ny;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        C0437eg.m1081b(this.f494ny, dataOut);
    }

    public String getDisplayScore() {
        return this.f495nz;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        C0437eg.m1081b(this.f495nz, dataOut);
    }

    public long getRank() {
        return this.f493nx;
    }

    public long getRawScore() {
        return this.f486nA;
    }

    public Player getScoreHolder() {
        return this.f491nF;
    }

    public String getScoreHolderDisplayName() {
        return this.f491nF == null ? this.f488nC : this.f491nF.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.f491nF == null) {
            C0437eg.m1081b(this.f488nC, dataOut);
        } else {
            this.f491nF.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.f491nF == null ? this.f490nE : this.f491nF.getHiResImageUri();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.f491nF == null ? this.f489nD : this.f491nF.getIconImageUri();
    }

    public String getScoreTag() {
        return this.f492nG;
    }

    public long getTimestampMillis() {
        return this.f487nB;
    }

    public int hashCode() {
        return m407a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m409b(this);
    }
}
