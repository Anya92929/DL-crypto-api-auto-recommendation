package com.google.android.gms.games.leaderboard;

public interface LeaderboardVariant {
    public static final int COLLECTION_PUBLIC = 0;
    public static final int COLLECTION_SOCIAL = 1;
    public static final int NUM_SCORES_UNKNOWN = -1;
    public static final int NUM_TIME_SPANS = 3;
    public static final int PLAYER_RANK_UNKNOWN = -1;
    public static final int PLAYER_SCORE_UNKNOWN = -1;
    public static final int TIME_SPAN_ALL_TIME = 2;
    public static final int TIME_SPAN_DAILY = 0;
    public static final int TIME_SPAN_WEEKLY = 1;

    int getCollection();

    String getDisplayPlayerRank();

    String getDisplayPlayerScore();

    long getNumScores();

    long getPlayerRank();

    long getRawPlayerScore();

    int getTimeSpan();

    boolean hasPlayerInfo();
}
