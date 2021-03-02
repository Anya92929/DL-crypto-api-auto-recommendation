package com.google.android.gms.games.leaderboard;

public interface OnLeaderboardScoresLoadedListener {
    void onLeaderboardScoresLoaded(int i, LeaderboardBuffer leaderboardBuffer, LeaderboardScoreBuffer leaderboardScoreBuffer);
}
