package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

public final class QuestsImpl implements Quests {

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5 */
    class C08195 extends LoadsImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2206XU;

        /* renamed from: XX */
        final /* synthetic */ String f2207XX;

        /* renamed from: Yu */
        final /* synthetic */ int f2208Yu;

        /* renamed from: Zi */
        final /* synthetic */ int[] f2209Zi;

        /* renamed from: Zk */
        final /* synthetic */ String f2210Zk;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6625a((BaseImplementation.C0270b<Quests.LoadQuestsResult>) this, this.f2207XX, this.f2210Zk, this.f2209Zi, this.f2208Yu, this.f2206XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6 */
    class C08206 extends LoadsImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2211XU;

        /* renamed from: XX */
        final /* synthetic */ String f2212XX;

        /* renamed from: Zj */
        final /* synthetic */ String[] f2213Zj;

        /* renamed from: Zk */
        final /* synthetic */ String f2214Zk;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6624a((BaseImplementation.C0270b<Quests.LoadQuestsResult>) this, this.f2212XX, this.f2214Zk, this.f2211XU, this.f2213Zj);
        }
    }

    private static abstract class AcceptImpl extends Games.BaseGamesApiMethodImpl<Quests.AcceptQuestResult> {
        private AcceptImpl() {
        }

        /* renamed from: ah */
        public Quests.AcceptQuestResult mo3773c(final Status status) {
            return new Quests.AcceptQuestResult() {
                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ClaimImpl extends Games.BaseGamesApiMethodImpl<Quests.ClaimMilestoneResult> {
        private ClaimImpl() {
        }

        /* renamed from: ai */
        public Quests.ClaimMilestoneResult mo3773c(final Status status) {
            return new Quests.ClaimMilestoneResult() {
                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl<Quests.LoadQuestsResult> {
        private LoadsImpl() {
        }

        /* renamed from: aj */
        public Quests.LoadQuestsResult mo3773c(final Status status) {
            return new Quests.LoadQuestsResult() {
                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.m593as(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.mo4221b(new AcceptImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6702i(this, questId);
            }
        });
    }

    public PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.mo4221b(new ClaimImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6652b((BaseImplementation.C0270b<Quests.ClaimMilestoneResult>) this, questId, milestoneId);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.m2159c(apiClient).mo6663bz(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.m2159c(apiClient).mo6645b(questSelectors);
    }

    public PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient apiClient, final int[] questSelectors, final int sortOrder, final boolean forceReload) {
        return apiClient.mo4219a(new LoadsImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6634a((BaseImplementation.C0270b<Quests.LoadQuestsResult>) this, questSelectors, sortOrder, forceReload);
            }
        });
    }

    public PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.mo4219a(new LoadsImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6657b((BaseImplementation.C0270b<Quests.LoadQuestsResult>) this, forceReload, questIds);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        Games.m2159c(apiClient).mo6640a(listener);
    }

    public void showStateChangedPopup(GoogleApiClient apiClient, String questId) {
        Games.m2159c(apiClient).mo6660bA(questId);
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        Games.m2159c(apiClient).mo6717kh();
    }
}
