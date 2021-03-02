package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] abh = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};

    /* renamed from: HF */
    private int f2350HF;

    /* renamed from: Vz */
    private String f2351Vz;
    private HashMap<Integer, Result> abN = new HashMap<>();
    private String abj;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore2, String formattedScore2, String scoreTag2, boolean newBest2) {
            this.rawScore = rawScore2;
            this.formattedScore = formattedScore2;
            this.scoreTag = scoreTag2;
            this.newBest = newBest2;
        }

        public String toString() {
            return C0345m.m848h(this).mo4549a("RawScore", Long.valueOf(this.rawScore)).mo4549a("FormattedScore", this.formattedScore).mo4549a("ScoreTag", this.scoreTag).mo4549a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.f2350HF = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        C0348n.m851K(count == 3);
        for (int i = 0; i < count; i++) {
            int ar = dataHolder.mo4304ar(i);
            if (i == 0) {
                this.abj = dataHolder.mo4306c("leaderboardId", i, ar);
                this.f2351Vz = dataHolder.mo4306c("playerId", i, ar);
            }
            if (dataHolder.mo4308d("hasResult", i, ar)) {
                m3670a(new Result(dataHolder.mo4301a("rawScore", i, ar), dataHolder.mo4306c("formattedScore", i, ar), dataHolder.mo4306c("scoreTag", i, ar), dataHolder.mo4308d("newBest", i, ar)), dataHolder.mo4305b("timeSpan", i, ar));
            }
        }
    }

    /* renamed from: a */
    private void m3670a(Result result, int i) {
        this.abN.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.abj;
    }

    public String getPlayerId() {
        return this.f2351Vz;
    }

    public Result getScoreResult(int timeSpan) {
        return this.abN.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        C0345m.C0347a a = C0345m.m848h(this).mo4549a("PlayerId", this.f2351Vz).mo4549a("StatusCode", Integer.valueOf(this.f2350HF));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return a.toString();
            }
            Result result = this.abN.get(Integer.valueOf(i2));
            a.mo4549a("TimesSpan", TimeSpan.m3520dH(i2));
            a.mo4549a("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}
