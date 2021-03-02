package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.internal.C0489bd;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.internal.C0621s;
import java.util.HashMap;

public final class SubmitScoreResult {

    /* renamed from: eB */
    private static final String[] f905eB = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest"};

    /* renamed from: dx */
    private String f906dx;

    /* renamed from: eC */
    private String f907eC;

    /* renamed from: eD */
    private HashMap<Integer, Result> f908eD;

    /* renamed from: p */
    private int f909p;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;

        public Result(long rawScore2, String formattedScore2, boolean newBest2) {
            this.rawScore = rawScore2;
            this.formattedScore = formattedScore2;
            this.newBest = newBest2;
        }

        public String toString() {
            return C0618r.m1882c(this).mo5486a("RawScore", Long.valueOf(this.rawScore)).mo5486a("FormattedScore", this.formattedScore).mo5486a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public SubmitScoreResult(int statusCode, String leaderboardId, String playerId) {
        this(statusCode, leaderboardId, playerId, new HashMap());
    }

    public SubmitScoreResult(int statusCode, String leaderboardId, String playerId, HashMap<Integer, Result> results) {
        this.f909p = statusCode;
        this.f907eC = leaderboardId;
        this.f906dx = playerId;
        this.f908eD = results;
    }

    public SubmitScoreResult(C0344d dataHolder) {
        this.f909p = dataHolder.getStatusCode();
        this.f908eD = new HashMap<>();
        int count = dataHolder.getCount();
        C0621s.m1889c(count == 3);
        for (int i = 0; i < count; i++) {
            int e = dataHolder.mo4054e(i);
            if (i == 0) {
                this.f907eC = dataHolder.mo4050c("leaderboardId", i, e);
                this.f906dx = dataHolder.mo4050c("playerId", i, e);
            }
            if (dataHolder.mo4052d("hasResult", i, e)) {
                m730a(new Result(dataHolder.mo4047a("rawScore", i, e), dataHolder.mo4050c("formattedScore", i, e), dataHolder.mo4052d("newBest", i, e)), dataHolder.mo4049b("timeSpan", i, e));
            }
        }
    }

    /* renamed from: a */
    private void m730a(Result result, int i) {
        this.f908eD.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.f907eC;
    }

    public String getPlayerId() {
        return this.f906dx;
    }

    public Result getScoreResult(int timeSpan) {
        return this.f908eD.get(Integer.valueOf(timeSpan));
    }

    public int getStatusCode() {
        return this.f909p;
    }

    public String toString() {
        C0618r.C0620a a = C0618r.m1882c(this).mo5486a("PlayerId", this.f906dx).mo5486a("StatusCode", Integer.valueOf(this.f909p));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return a.toString();
            }
            Result result = this.f908eD.get(Integer.valueOf(i2));
            a.mo5486a("TimesSpan", C0489bd.m1308G(i2));
            a.mo5486a("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}
