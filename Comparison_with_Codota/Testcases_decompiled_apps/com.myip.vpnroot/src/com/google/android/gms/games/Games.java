package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import java.util.ArrayList;

public final class Games {
    public static final Api<GamesOptions> API = new Api<>(f1616CV, f1615CU, SCOPE_GAMES);
    public static final Achievements Achievements = new AchievementsImpl();

    /* renamed from: CU */
    static final Api.C0268c<GamesClientImpl> f1615CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<GamesClientImpl, GamesOptions> f1616CV = new Api.C0267b<GamesClientImpl, GamesOptions>() {
        /* renamed from: a */
        public GamesClientImpl mo3762a(Context context, Looper looper, ClientSettings clientSettings, GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, clientSettings.getRealClientPackageName(), clientSettings.getAccountNameOrDefault(), connectionCallbacks, onConnectionFailedListener, clientSettings.getScopesArray(), clientSettings.getGravityForPopups(), clientSettings.getViewForPopups(), gamesOptions == null ? new GamesOptions() : gamesOptions);
        }

        public int getPriority() {
            return 1;
        }
    };
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();

    /* renamed from: Vo */
    public static final Scope f1617Vo = new Scope("https://www.googleapis.com/auth/games.firstparty");

    /* renamed from: Vp */
    public static final Api<GamesOptions> f1618Vp = new Api<>(f1616CV, f1615CU, f1617Vo);

    /* renamed from: Vq */
    public static final Multiplayer f1619Vq = new MultiplayerImpl();

    /* renamed from: Vr */
    public static final Acls f1620Vr = new AclsImpl();

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends BaseImplementation.C0269a<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl() {
            super(Games.f1615CU);
        }
    }

    public static final class GamesOptions implements Api.ApiOptions.Optional {

        /* renamed from: Vs */
        public final boolean f1621Vs;

        /* renamed from: Vt */
        public final boolean f1622Vt;

        /* renamed from: Vu */
        public final int f1623Vu;

        /* renamed from: Vv */
        public final boolean f1624Vv;

        /* renamed from: Vw */
        public final int f1625Vw;

        /* renamed from: Vx */
        public final String f1626Vx;

        /* renamed from: Vy */
        public final ArrayList<String> f1627Vy;

        public static final class Builder {

            /* renamed from: Vs */
            boolean f1628Vs;

            /* renamed from: Vt */
            boolean f1629Vt;

            /* renamed from: Vu */
            int f1630Vu;

            /* renamed from: Vv */
            boolean f1631Vv;

            /* renamed from: Vw */
            int f1632Vw;

            /* renamed from: Vx */
            String f1633Vx;

            /* renamed from: Vy */
            ArrayList<String> f1634Vy;

            private Builder() {
                this.f1628Vs = false;
                this.f1629Vt = true;
                this.f1630Vu = 17;
                this.f1631Vv = false;
                this.f1632Vw = 4368;
                this.f1633Vx = null;
                this.f1634Vy = new ArrayList<>();
            }

            public GamesOptions build() {
                return new GamesOptions(this);
            }

            public Builder setSdkVariant(int variant) {
                this.f1632Vw = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.f1629Vt = showConnectingPopup;
                this.f1630Vu = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.f1629Vt = showConnectingPopup;
                this.f1630Vu = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.f1621Vs = false;
            this.f1622Vt = true;
            this.f1623Vu = 17;
            this.f1624Vv = false;
            this.f1625Vw = 4368;
            this.f1626Vx = null;
            this.f1627Vy = new ArrayList<>();
        }

        private GamesOptions(Builder builder) {
            this.f1621Vs = builder.f1628Vs;
            this.f1622Vt = builder.f1629Vt;
            this.f1623Vu = builder.f1630Vu;
            this.f1624Vv = builder.f1631Vv;
            this.f1625Vw = builder.f1632Vw;
            this.f1626Vx = builder.f1633Vx;
            this.f1627Vy = builder.f1634Vy;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    private Games() {
    }

    /* renamed from: c */
    public static GamesClientImpl m2159c(GoogleApiClient googleApiClient) {
        C0348n.m859b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        C0348n.m852a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return m2160d(googleApiClient);
    }

    /* renamed from: d */
    public static GamesClientImpl m2160d(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImpl = (GamesClientImpl) googleApiClient.mo4218a(f1615CU);
        C0348n.m852a(gamesClientImpl != null, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gamesClientImpl;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return m2159c(apiClient).mo6722km();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return m2159c(apiClient).mo6705jX();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return m2159c(apiClient).mo6721kl();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return m2159c(apiClient).mo6720kk();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        m2159c(apiClient).mo6682dB(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        C0348n.m861i(gamesContentView);
        m2159c(apiClient).mo6708k(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.mo4221b(new SignOutImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6646b((BaseImplementation.C0270b<Status>) this);
            }
        });
    }
}
