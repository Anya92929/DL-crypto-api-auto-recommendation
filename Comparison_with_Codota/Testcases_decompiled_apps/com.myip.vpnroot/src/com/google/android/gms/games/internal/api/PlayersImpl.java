package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10 */
    class C078110 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2130XU;

        /* renamed from: XX */
        final /* synthetic */ String f2131XX;

        /* renamed from: Yl */
        final /* synthetic */ int f2132Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6621a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, "played_with", this.f2131XX, this.f2132Yl, false, this.f2130XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11 */
    class C078211 extends LoadPlayersImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2133XX;

        /* renamed from: Yl */
        final /* synthetic */ int f2134Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6621a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, "played_with", this.f2133XX, this.f2134Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12 */
    class C078312 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2135XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2136Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6647b((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, this.f2136Yl, false, this.f2135XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13 */
    class C078413 extends LoadPlayersImpl {

        /* renamed from: Yl */
        final /* synthetic */ int f2137Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6647b((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, this.f2137Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14 */
    class C078514 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2138XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2139Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6665c((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, this.f2139Yl, false, this.f2138XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15 */
    class C078615 extends LoadPlayersImpl {

        /* renamed from: Yl */
        final /* synthetic */ int f2140Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6665c((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, this.f2140Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16 */
    class C078716 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2141XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2142Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6675d(this, this.f2142Yl, false, this.f2141XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17 */
    class C078817 extends LoadPlayersImpl {

        /* renamed from: Yl */
        final /* synthetic */ int f2143Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6675d(this, this.f2143Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18 */
    class C078918 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2144XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2145Yl;

        /* renamed from: Yn */
        final /* synthetic */ String f2146Yn;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6692f(this, this.f2146Yn, this.f2145Yl, false, this.f2144XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19 */
    class C079019 extends LoadPlayersImpl {

        /* renamed from: Yl */
        final /* synthetic */ int f2147Yl;

        /* renamed from: Yn */
        final /* synthetic */ String f2148Yn;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6692f(this, this.f2148Yn, this.f2147Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$2 */
    class C07912 extends LoadPlayersImpl {

        /* renamed from: YU */
        final /* synthetic */ String[] f2149YU;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6635a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, this.f2149YU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20 */
    class C079220 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2150XU;

        /* renamed from: XX */
        final /* synthetic */ String f2151XX;

        /* renamed from: YV */
        final /* synthetic */ int f2152YV;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6612a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, this.f2151XX, this.f2152YV, this.f2150XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21 */
    class C079321 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2153XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2154Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6684e(this, this.f2154Yl, false, this.f2153XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$22 */
    class C079422 extends LoadPlayersImpl {

        /* renamed from: Yl */
        final /* synthetic */ int f2155Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6684e(this, this.f2155Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$23 */
    class C079523 extends LoadPlayersImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2156XU;

        /* renamed from: YW */
        final /* synthetic */ String f2157YW;

        /* renamed from: Yl */
        final /* synthetic */ int f2158Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6696g(this, this.f2157YW, this.f2158Yl, false, this.f2156XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$24 */
    class C079624 extends LoadPlayersImpl {

        /* renamed from: YW */
        final /* synthetic */ String f2159YW;

        /* renamed from: Yl */
        final /* synthetic */ int f2160Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6696g(this, this.f2159YW, this.f2160Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$25 */
    class C079725 extends LoadOwnerCoverPhotoUrisImpl {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6694g(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$26 */
    class C079826 extends LoadXpForGameCategoriesResultImpl {

        /* renamed from: YX */
        final /* synthetic */ String f2161YX;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6732n((BaseImplementation.C0270b<Players.LoadXpForGameCategoriesResult>) this, this.f2161YX);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$27 */
    class C079927 extends LoadXpStreamResultImpl {

        /* renamed from: YX */
        final /* synthetic */ String f2162YX;

        /* renamed from: YY */
        final /* synthetic */ int f2163YY;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6667c((BaseImplementation.C0270b<Players.LoadXpStreamResult>) this, this.f2162YX, this.f2163YY);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$28 */
    class C080028 extends LoadXpStreamResultImpl {

        /* renamed from: YX */
        final /* synthetic */ String f2164YX;

        /* renamed from: YY */
        final /* synthetic */ int f2165YY;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6677d((BaseImplementation.C0270b<Players.LoadXpStreamResult>) this, this.f2164YX, this.f2165YY);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$29 */
    class C080129 extends LoadProfileSettingsResultImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2166XU;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6693f((BaseImplementation.C0270b<Players.LoadProfileSettingsResult>) this, this.f2166XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$30 */
    class C080330 extends UpdateProfileSettingsResultImpl {

        /* renamed from: YZ */
        final /* synthetic */ boolean f2170YZ;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6697g((BaseImplementation.C0270b<Status>) this, this.f2170YZ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$8 */
    class C08088 extends LoadPlayersImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2180XX;

        /* renamed from: Yl */
        final /* synthetic */ int f2181Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6621a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, "nearby", this.f2180XX, this.f2181Yl, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$9 */
    class C08099 extends LoadPlayersImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2182XX;

        /* renamed from: Yl */
        final /* synthetic */ int f2183Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6621a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, "nearby", this.f2182XX, this.f2183Yl, true, false);
        }
    }

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends Games.BaseGamesApiMethodImpl<Players.LoadOwnerCoverPhotoUrisResult> {
        private LoadOwnerCoverPhotoUrisImpl() {
        }

        /* renamed from: ac */
        public Players.LoadOwnerCoverPhotoUrisResult mo3773c(final Status status) {
            return new Players.LoadOwnerCoverPhotoUrisResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadPlayersImpl extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult> {
        private LoadPlayersImpl() {
        }

        /* renamed from: ad */
        public Players.LoadPlayersResult mo3773c(final Status status) {
            return new Players.LoadPlayersResult() {
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadProfileSettingsResult> {
        private LoadProfileSettingsResultImpl() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: ae */
        public Players.LoadProfileSettingsResult mo3773c(final Status status) {
            return new Players.LoadProfileSettingsResult() {
                public Status getStatus() {
                    return status;
                }

                public boolean isProfileVisible() {
                    return true;
                }

                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult> {
        private LoadXpForGameCategoriesResultImpl() {
        }

        /* renamed from: af */
        public Players.LoadXpForGameCategoriesResult mo3773c(final Status status) {
            return new Players.LoadXpForGameCategoriesResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadXpStreamResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult> {
        private LoadXpStreamResultImpl() {
        }

        /* renamed from: ag */
        public Players.LoadXpStreamResult mo3773c(final Status status) {
            return new Players.LoadXpStreamResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Status> {
        private UpdateProfileSettingsResultImpl() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6707jZ();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6706jY();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6719kj();
    }

    public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo4219a(new LoadPlayersImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6631a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, forceReload);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo4219a(new LoadPlayersImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6604a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo4219a(new LoadPlayersImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6604a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo4219a(new LoadPlayersImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6613a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.mo4219a(new LoadPlayersImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6609a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, playerId);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo4219a(new LoadPlayersImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6613a((BaseImplementation.C0270b<Players.LoadPlayersResult>) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
