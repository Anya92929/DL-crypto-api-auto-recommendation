package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$10 */
    class C075410 extends LoadScoresImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2060XU;

        /* renamed from: XX */
        final /* synthetic */ String f2061XX;

        /* renamed from: YA */
        final /* synthetic */ int f2062YA;

        /* renamed from: YB */
        final /* synthetic */ int f2063YB;

        /* renamed from: YC */
        final /* synthetic */ int f2064YC;

        /* renamed from: Yz */
        final /* synthetic */ String f2065Yz;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6620a((BaseImplementation.C0270b<Leaderboards.LoadScoresResult>) this, this.f2061XX, this.f2065Yz, this.f2062YA, this.f2063YB, this.f2064YC, this.f2060XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$11 */
    class C075511 extends LoadScoresImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2066XU;

        /* renamed from: XX */
        final /* synthetic */ String f2067XX;

        /* renamed from: YA */
        final /* synthetic */ int f2068YA;

        /* renamed from: YB */
        final /* synthetic */ int f2069YB;

        /* renamed from: YC */
        final /* synthetic */ int f2070YC;

        /* renamed from: Yz */
        final /* synthetic */ String f2071Yz;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6653b(this, this.f2067XX, this.f2071Yz, this.f2068YA, this.f2069YB, this.f2070YC, this.f2066XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$8 */
    class C07628 extends LoadMetadataImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2099XU;

        /* renamed from: XX */
        final /* synthetic */ String f2100XX;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6671c((BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult>) this, this.f2100XX, this.f2099XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$9 */
    class C07639 extends LoadMetadataImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2101XU;

        /* renamed from: XX */
        final /* synthetic */ String f2102XX;

        /* renamed from: Yz */
        final /* synthetic */ String f2103Yz;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6623a((BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult>) this, this.f2102XX, this.f2103Yz, this.f2101XU);
        }
    }

    private static abstract class LoadMetadataImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LeaderboardMetadataResult> {
        private LoadMetadataImpl() {
        }

        /* renamed from: U */
        public Leaderboards.LeaderboardMetadataResult mo3773c(final Status status) {
            return new Leaderboards.LeaderboardMetadataResult() {
                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadPlayerScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl() {
        }

        /* renamed from: V */
        public Leaderboards.LoadPlayerScoreResult mo3773c(final Status status) {
            return new Leaderboards.LoadPlayerScoreResult() {
                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadScoresImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadScoresResult> {
        private LoadScoresImpl() {
        }

        /* renamed from: W */
        public Leaderboards.LoadScoresResult mo3773c(final Status status) {
            return new Leaderboards.LoadScoresResult() {
                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    protected static abstract class SubmitScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.SubmitScoreResult> {
        protected SubmitScoreImpl() {
        }

        /* renamed from: X */
        public Leaderboards.SubmitScoreResult mo3773c(final Status status) {
            return new Leaderboards.SubmitScoreResult() {
                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6711kb();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return Games.m2159c(apiClient).mo6661bu(leaderboardId);
    }

    public PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, final String leaderboardId, final int span, final int leaderboardCollection) {
        return apiClient.mo4219a(new LoadPlayerScoreImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6618a((BaseImplementation.C0270b<Leaderboards.LoadPlayerScoreResult>) this, (String) null, leaderboardId, span, leaderboardCollection);
            }
        });
    }

    public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.mo4219a(new LoadMetadataImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6627a((BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult>) this, leaderboardId, forceReload);
            }
        });
    }

    public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo4219a(new LoadMetadataImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6656b((BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult>) this, forceReload);
            }
        });
    }

    public PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, final LeaderboardScoreBuffer buffer, final int maxResults, final int pageDirection) {
        return apiClient.mo4219a(new LoadScoresImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6606a((BaseImplementation.C0270b<Leaderboards.LoadScoresResult>) this, buffer, maxResults, pageDirection);
            }
        });
    }

    public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo4219a(new LoadScoresImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6650b(this, str, i, i2, i3, z);
            }
        });
    }

    public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo4219a(new LoadScoresImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6611a((BaseImplementation.C0270b<Leaderboards.LoadScoresResult>) this, str, i, i2, i3, z);
            }
        });
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, (String) null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m2159c(apiClient).mo6616a((BaseImplementation.C0270b<Leaderboards.SubmitScoreResult>) null, leaderboardId, score, scoreTag);
    }

    public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, (String) null);
    }

    public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        final String str = leaderboardId;
        final long j = score;
        final String str2 = scoreTag;
        return apiClient.mo4221b(new SubmitScoreImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6616a((BaseImplementation.C0270b<Leaderboards.SubmitScoreResult>) this, str, j, str2);
            }
        });
    }
}
