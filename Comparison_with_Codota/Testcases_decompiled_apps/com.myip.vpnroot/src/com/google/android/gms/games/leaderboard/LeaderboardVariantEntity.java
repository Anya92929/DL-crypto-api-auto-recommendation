package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int abB;
    private final int abC;
    private final boolean abD;
    private final long abE;
    private final String abF;
    private final long abG;
    private final String abH;
    private final String abI;
    private final long abJ;
    private final String abK;
    private final String abL;
    private final String abM;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.abB = variant.getTimeSpan();
        this.abC = variant.getCollection();
        this.abD = variant.hasPlayerInfo();
        this.abE = variant.getRawPlayerScore();
        this.abF = variant.getDisplayPlayerScore();
        this.abG = variant.getPlayerRank();
        this.abH = variant.getDisplayPlayerRank();
        this.abI = variant.getPlayerScoreTag();
        this.abJ = variant.getNumScores();
        this.abK = variant.mo7504lB();
        this.abL = variant.mo7505lC();
        this.abM = variant.mo7506lD();
    }

    /* renamed from: a */
    static int m3659a(LeaderboardVariant leaderboardVariant) {
        return C0345m.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.mo7504lB(), leaderboardVariant.mo7506lD(), leaderboardVariant.mo7505lC());
    }

    /* renamed from: a */
    static boolean m3660a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return C0345m.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && C0345m.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && C0345m.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && C0345m.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && C0345m.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && C0345m.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && C0345m.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && C0345m.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && C0345m.equal(leaderboardVariant2.mo7504lB(), leaderboardVariant.mo7504lB()) && C0345m.equal(leaderboardVariant2.mo7506lD(), leaderboardVariant.mo7506lD()) && C0345m.equal(leaderboardVariant2.mo7505lC(), leaderboardVariant.mo7505lC());
    }

    /* renamed from: b */
    static String m3661b(LeaderboardVariant leaderboardVariant) {
        return C0345m.m848h(leaderboardVariant).mo4549a("TimeSpan", TimeSpan.m3520dH(leaderboardVariant.getTimeSpan())).mo4549a("Collection", LeaderboardCollection.m3517dH(leaderboardVariant.getCollection())).mo4549a("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").mo4549a("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").mo4549a("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").mo4549a("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").mo4549a("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).mo4549a("TopPageNextToken", leaderboardVariant.mo7504lB()).mo4549a("WindowPageNextToken", leaderboardVariant.mo7506lD()).mo4549a("WindowPagePrevToken", leaderboardVariant.mo7505lC()).toString();
    }

    public boolean equals(Object obj) {
        return m3660a(this, obj);
    }

    public int getCollection() {
        return this.abC;
    }

    public String getDisplayPlayerRank() {
        return this.abH;
    }

    public String getDisplayPlayerScore() {
        return this.abF;
    }

    public long getNumScores() {
        return this.abJ;
    }

    public long getPlayerRank() {
        return this.abG;
    }

    public String getPlayerScoreTag() {
        return this.abI;
    }

    public long getRawPlayerScore() {
        return this.abE;
    }

    public int getTimeSpan() {
        return this.abB;
    }

    public boolean hasPlayerInfo() {
        return this.abD;
    }

    public int hashCode() {
        return m3659a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: lB */
    public String mo7504lB() {
        return this.abK;
    }

    /* renamed from: lC */
    public String mo7505lC() {
        return this.abL;
    }

    /* renamed from: lD */
    public String mo7506lD() {
        return this.abM;
    }

    /* renamed from: lE */
    public LeaderboardVariant freeze() {
        return this;
    }

    public String toString() {
        return m3661b(this);
    }
}
