package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10 */
    class C070710 extends LoadImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f1956XU;

        /* renamed from: XW */
        final /* synthetic */ String f1957XW;

        /* renamed from: XX */
        final /* synthetic */ String f1958XX;

        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6654b((BaseImplementation.C0270b<Achievements.LoadAchievementsResult>) this, this.f1957XW, this.f1958XX, this.f1956XU);
        }
    }

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult> {
        private LoadImpl() {
        }

        /* renamed from: J */
        public Achievements.LoadAchievementsResult mo3773c(final Status status) {
            return new Achievements.LoadAchievementsResult() {
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult> {
        /* access modifiers changed from: private */

        /* renamed from: BL */
        public final String f1981BL;

        public UpdateImpl(String id) {
            this.f1981BL = id;
        }

        /* renamed from: K */
        public Achievements.UpdateAchievementResult mo3773c(final Status status) {
            return new Achievements.UpdateAchievementResult() {
                public String getAchievementId() {
                    return UpdateImpl.this.f1981BL;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6712kc();
    }

    public void increment(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6610a((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) null, id, numSteps);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6610a((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) this, id, numSteps);
            }
        });
    }

    public PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo4219a(new LoadImpl() {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6672c((BaseImplementation.C0270b<Achievements.LoadAchievementsResult>) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6648b((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) null, id);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6648b((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6649b((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) null, id, numSteps);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6649b((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) this, id, numSteps);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6666c((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) null, id);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo4221b(new UpdateImpl(id) {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6666c((BaseImplementation.C0270b<Achievements.UpdateAchievementResult>) this, id);
            }
        });
    }
}
