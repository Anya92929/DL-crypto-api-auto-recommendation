package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0502ev;
import java.util.HashMap;

public final class SubmitScoreResult {

    /* renamed from: nI */
    private static final String[] f479nI = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};

    /* renamed from: iC */
    private int f480iC;

    /* renamed from: mD */
    private String f481mD;

    /* renamed from: nJ */
    private String f482nJ;

    /* renamed from: nK */
    private HashMap<Integer, Result> f483nK;

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
            return C0408dl.m938d(this).mo4388a("RawScore", Long.valueOf(this.rawScore)).mo4388a("FormattedScore", this.formattedScore).mo4388a("ScoreTag", this.scoreTag).mo4388a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public SubmitScoreResult(int statusCode, String leaderboardId, String playerId) {
        this(statusCode, leaderboardId, playerId, new HashMap());
    }

    public SubmitScoreResult(int statusCode, String leaderboardId, String playerId, HashMap<Integer, Result> results) {
        this.f480iC = statusCode;
        this.f482nJ = leaderboardId;
        this.f481mD = playerId;
        this.f483nK = results;
    }

    public SubmitScoreResult(C0140d dataHolder) {
        this.f480iC = dataHolder.getStatusCode();
        this.f483nK = new HashMap<>();
        int count = dataHolder.getCount();
        C0411dm.m946m(count == 3);
        for (int i = 0; i < count; i++) {
            int q = dataHolder.mo3614q(i);
            if (i == 0) {
                this.f482nJ = dataHolder.mo3602c("leaderboardId", i, q);
                this.f481mD = dataHolder.mo3602c("playerId", i, q);
            }
            if (dataHolder.mo3604d("hasResult", i, q)) {
                m405a(new Result(dataHolder.mo3594a("rawScore", i, q), dataHolder.mo3602c("formattedScore", i, q), dataHolder.mo3602c("scoreTag", i, q), dataHolder.mo3604d("newBest", i, q)), dataHolder.mo3600b("timeSpan", i, q));
            }
        }
    }

    /* renamed from: a */
    private void m405a(Result result, int i) {
        this.f483nK.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.f482nJ;
    }

    public String getPlayerId() {
        return this.f481mD;
    }

    public Result getScoreResult(int timeSpan) {
        return this.f483nK.get(Integer.valueOf(timeSpan));
    }

    public int getStatusCode() {
        return this.f480iC;
    }

    public String toString() {
        C0408dl.C0410a a = C0408dl.m938d(this).mo4388a("PlayerId", this.f481mD).mo4388a("StatusCode", Integer.valueOf(this.f480iC));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return a.toString();
            }
            Result result = this.f483nK.get(Integer.valueOf(i2));
            a.mo4388a("TimesSpan", C0502ev.m1488R(i2));
            a.mo4388a("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}
