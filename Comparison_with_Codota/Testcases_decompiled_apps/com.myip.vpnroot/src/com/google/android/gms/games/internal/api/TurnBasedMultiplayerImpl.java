package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$11 */
    class C084911 extends InitiateMatchImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2292XX;

        /* renamed from: ZP */
        final /* synthetic */ String f2293ZP;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6669c((BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult>) this, this.f2292XX, this.f2293ZP);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$12 */
    class C085012 extends InitiateMatchImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2294XX;

        /* renamed from: ZP */
        final /* synthetic */ String f2295ZP;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6679d((BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult>) this, this.f2294XX, this.f2295ZP);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$13 */
    class C085113 extends LoadMatchesImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2296XX;

        /* renamed from: ZQ */
        final /* synthetic */ int f2297ZQ;

        /* renamed from: ZR */
        final /* synthetic */ int[] f2298ZR;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6615a((BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchesResult>) this, this.f2296XX, this.f2297ZQ, this.f2298ZR);
        }
    }

    private static abstract class CancelMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.CancelMatchResult> {
        /* access modifiers changed from: private */

        /* renamed from: BL */
        public final String f2322BL;

        public CancelMatchImpl(String id) {
            this.f2322BL = id;
        }

        /* renamed from: as */
        public TurnBasedMultiplayer.CancelMatchResult mo3773c(final Status status) {
            return new TurnBasedMultiplayer.CancelMatchResult() {
                public String getMatchId() {
                    return CancelMatchImpl.this.f2322BL;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class InitiateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.InitiateMatchResult> {
        private InitiateMatchImpl() {
        }

        /* renamed from: at */
        public TurnBasedMultiplayer.InitiateMatchResult mo3773c(final Status status) {
            return new TurnBasedMultiplayer.InitiateMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LeaveMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LeaveMatchResult> {
        private LeaveMatchImpl() {
        }

        /* renamed from: au */
        public TurnBasedMultiplayer.LeaveMatchResult mo3773c(final Status status) {
            return new TurnBasedMultiplayer.LeaveMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchResult> {
        private LoadMatchImpl() {
        }

        /* renamed from: av */
        public TurnBasedMultiplayer.LoadMatchResult mo3773c(final Status status) {
            return new TurnBasedMultiplayer.LoadMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadMatchesImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchesResult> {
        private LoadMatchesImpl() {
        }

        /* renamed from: aw */
        public TurnBasedMultiplayer.LoadMatchesResult mo3773c(final Status status) {
            return new TurnBasedMultiplayer.LoadMatchesResult() {
                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.UpdateMatchResult> {
        private UpdateMatchImpl() {
        }

        /* renamed from: ax */
        public TurnBasedMultiplayer.UpdateMatchResult mo3773c(final Status status) {
            return new TurnBasedMultiplayer.UpdateMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.mo4221b(new InitiateMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6685e((BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult>) this, invitationId);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo4221b(new CancelMatchImpl(matchId) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6695g((BaseImplementation.C0270b<TurnBasedMultiplayer.CancelMatchResult>) this, matchId);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.mo4221b(new InitiateMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6607a((BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult>) this, config);
            }
        });
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m2159c(apiClient).mo6737p(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m2159c(apiClient).mo6735o(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m2159c(apiClient).mo6662bv(matchId);
    }

    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, (byte[]) null, (ParticipantResult[]) null);
    }

    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient apiClient, final String matchId, final byte[] matchData, final ParticipantResult... results) {
        return apiClient.mo4221b(new UpdateMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6629a((BaseImplementation.C0270b<TurnBasedMultiplayer.UpdateMatchResult>) this, matchId, matchData, results);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6713kd();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6723kn();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m2159c(apiClient).mo6597a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m2159c(apiClient).mo6597a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo4221b(new LeaveMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6690f((BaseImplementation.C0270b<TurnBasedMultiplayer.LeaveMatchResult>) this, matchId);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.mo4221b(new LeaveMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6617a((BaseImplementation.C0270b<TurnBasedMultiplayer.LeaveMatchResult>) this, matchId, pendingParticipantId);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo4219a(new LoadMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6699h((BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchResult>) this, matchId);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.mo4219a(new LoadMatchesImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6605a((BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchesResult>) this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m2159c(apiClient).mo6639a(listener);
    }

    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo4221b(new InitiateMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6676d((BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult>) this, matchId);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final String str2 = pendingParticipantId;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.mo4221b(new UpdateMatchImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6628a((BaseImplementation.C0270b<TurnBasedMultiplayer.UpdateMatchResult>) this, str, bArr, str2, participantResultArr);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m2159c(apiClient).mo6716kg();
    }
}
