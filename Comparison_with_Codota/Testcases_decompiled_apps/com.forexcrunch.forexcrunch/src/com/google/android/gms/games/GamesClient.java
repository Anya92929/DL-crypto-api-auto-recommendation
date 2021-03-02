package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.games.achievement.OnAchievementUpdatedListener;
import com.google.android.gms.games.achievement.OnAchievementsLoadedListener;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardMetadataLoadedListener;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.android.gms.games.leaderboard.OnScoreSubmittedListener;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.OnInvitationsLoadedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.C0429au;
import com.google.android.gms.internal.C0621s;
import java.util.List;

public final class GamesClient implements GooglePlayServicesClient {
    public static final String EXTRA_EXCLUSIVE_BIT_MASK = "exclusive_bit_mask";
    public static final String EXTRA_INVITATION = "invitation";
    public static final String EXTRA_MAX_AUTOMATCH_PLAYERS = "max_automatch_players";
    public static final String EXTRA_MIN_AUTOMATCH_PLAYERS = "min_automatch_players";
    public static final String EXTRA_PLAYERS = "players";
    public static final String EXTRA_ROOM = "room";
    public static final int MAX_RELIABLE_MESSAGE_LEN = 1400;
    public static final int MAX_UNRELIABLE_MESSAGE_LEN = 1168;
    public static final int NOTIFICATION_TYPES_ALL = -1;
    public static final int NOTIFICATION_TYPES_MULTIPLAYER = 1;
    public static final int NOTIFICATION_TYPE_INVITATION = 1;
    public static final int STATUS_ACHIEVEMENT_NOT_INCREMENTAL = 3002;
    public static final int STATUS_ACHIEVEMENT_UNKNOWN = 3001;
    public static final int STATUS_ACHIEVEMENT_UNLOCKED = 3003;
    public static final int STATUS_ACHIEVEMENT_UNLOCK_FAILURE = 3000;
    public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
    public static final int STATUS_INTERNAL_ERROR = 1;
    public static final int STATUS_INVALID_REAL_TIME_ROOM_ID = 7002;
    public static final int STATUS_LICENSE_CHECK_FAILED = 7;
    public static final int STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED = 6000;
    public static final int STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER = 6001;
    public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
    public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
    public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
    public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
    public static final int STATUS_OK = 0;
    public static final int STATUS_PARTICIPANT_NOT_CONNECTED = 7003;
    public static final int STATUS_REAL_TIME_CONNECTION_FAILED = 7000;
    public static final int STATUS_REAL_TIME_INACTIVE_ROOM = 7005;
    public static final int STATUS_REAL_TIME_MESSAGE_FAILED = -1;
    public static final int STATUS_REAL_TIME_MESSAGE_SEND_FAILED = 7001;
    public static final int STATUS_REAL_TIME_ROOM_NOT_JOINED = 7004;

    /* renamed from: dt */
    private final C0429au f890dt;

    public static final class Builder {

        /* renamed from: d */
        private final GooglePlayServicesClient.ConnectionCallbacks f891d;

        /* renamed from: du */
        private String f892du;

        /* renamed from: dv */
        private int f893dv = 49;

        /* renamed from: dw */
        private View f894dw;

        /* renamed from: e */
        private final GooglePlayServicesClient.OnConnectionFailedListener f895e;

        /* renamed from: f */
        private String[] f896f = {Scopes.GAMES};

        /* renamed from: g */
        private String f897g = "<<default account>>";
        private final Context mContext;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.f892du = context.getPackageName();
            this.f891d = connectedListener;
            this.f895e = connectionFailedListener;
        }

        public GamesClient create() {
            return new GamesClient(this.mContext, this.f892du, this.f897g, this.f891d, this.f895e, this.f896f, this.f893dv, this.f894dw);
        }

        public Builder setAccountName(String accountName) {
            this.f897g = (String) C0621s.m1890d(accountName);
            return this;
        }

        public Builder setGravityForPopups(int gravity) {
            this.f893dv = gravity;
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.f896f = scopes;
            return this;
        }

        public Builder setViewForPopups(View gamesContentView) {
            this.f894dw = (View) C0621s.m1890d(gamesContentView);
            return this;
        }
    }

    private GamesClient(Context context, String gamePackageName, String accountName, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView) {
        this.f890dt = new C0429au(context, gamePackageName, accountName, connectedListener, connectionFailedListener, scopes, gravity, gamesContentView, false);
    }

    public void clearAllNotifications() {
        this.f890dt.clearNotifications(-1);
    }

    public void clearNotifications(int notificationTypes) {
        this.f890dt.clearNotifications(notificationTypes);
    }

    public void connect() {
        this.f890dt.connect();
    }

    public void createRoom(RoomConfig config) {
        this.f890dt.createRoom(config);
    }

    public void declineRoomInvitation(String invitationId) {
        this.f890dt.mo4618i(invitationId, 0);
    }

    public void disconnect() {
        this.f890dt.disconnect();
    }

    public void dismissRoomInvitation(String invitationId) {
        this.f890dt.mo4617h(invitationId, 0);
    }

    public Intent getAchievementsIntent() {
        return this.f890dt.getAchievementsIntent();
    }

    public Intent getAllLeaderboardsIntent() {
        return this.f890dt.getAllLeaderboardsIntent();
    }

    public String getAppId() {
        return this.f890dt.getAppId();
    }

    public String getCurrentAccountName() {
        return this.f890dt.getCurrentAccountName();
    }

    public Game getCurrentGame() {
        return this.f890dt.getCurrentGame();
    }

    public Player getCurrentPlayer() {
        return this.f890dt.getCurrentPlayer();
    }

    public String getCurrentPlayerId() {
        return this.f890dt.getCurrentPlayerId();
    }

    public Intent getInvitationInboxIntent() {
        return this.f890dt.getInvitationInboxIntent();
    }

    public Intent getLeaderboardIntent(String leaderboardId) {
        return this.f890dt.getLeaderboardIntent(leaderboardId);
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String roomId, String participantId) {
        return this.f890dt.getRealTimeSocketForParticipant(roomId, participantId);
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int minParticipantsToStart) {
        return this.f890dt.getRealTimeWaitingRoomIntent(room, minParticipantsToStart);
    }

    public Intent getSelectPlayersIntent(int minPlayers, int maxPlayers) {
        return this.f890dt.getSelectPlayersIntent(minPlayers, maxPlayers);
    }

    public Intent getSettingsIntent() {
        return this.f890dt.getSettingsIntent();
    }

    public void incrementAchievement(String id, int numSteps) {
        this.f890dt.mo4593a((OnAchievementUpdatedListener) null, id, numSteps);
    }

    public void incrementAchievementImmediate(OnAchievementUpdatedListener listener, String id, int numSteps) {
        this.f890dt.mo4593a(listener, id, numSteps);
    }

    public boolean isConnected() {
        return this.f890dt.isConnected();
    }

    public boolean isConnecting() {
        return this.f890dt.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f890dt.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f890dt.isConnectionFailedListenerRegistered(listener);
    }

    public void joinRoom(RoomConfig config) {
        this.f890dt.joinRoom(config);
    }

    public void leaveRoom(RoomUpdateListener listener, String roomId) {
        this.f890dt.leaveRoom(listener, roomId);
    }

    public void loadAchievements(OnAchievementsLoadedListener listener, boolean forceReload) {
        this.f890dt.loadAchievements(listener, forceReload);
    }

    public void loadGame(OnGamesLoadedListener listener) {
        this.f890dt.loadGame(listener);
    }

    public void loadInvitablePlayers(OnPlayersLoadedListener listener, int pageSize, boolean forceReload) {
        this.f890dt.mo4591a(listener, pageSize, false, forceReload);
    }

    public void loadInvitations(OnInvitationsLoadedListener listener) {
        this.f890dt.loadInvitations(listener);
    }

    @Deprecated
    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener) {
        loadLeaderboardMetadata(listener, false);
    }

    @Deprecated
    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, String leaderboardId) {
        loadLeaderboardMetadata(listener, leaderboardId, false);
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, String leaderboardId, boolean forceReload) {
        this.f890dt.loadLeaderboardMetadata(listener, leaderboardId, forceReload);
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, boolean forceReload) {
        this.f890dt.loadLeaderboardMetadata(listener, forceReload);
    }

    public void loadMoreInvitablePlayers(OnPlayersLoadedListener listener, int pageSize) {
        this.f890dt.mo4591a(listener, pageSize, true, false);
    }

    public void loadMoreScores(OnLeaderboardScoresLoadedListener listener, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        this.f890dt.loadMoreScores(listener, buffer, maxResults, pageDirection);
    }

    public void loadPlayer(OnPlayersLoadedListener listener, String playerId) {
        this.f890dt.loadPlayer(listener, playerId);
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        this.f890dt.loadPlayerCenteredScores(listener, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        this.f890dt.loadPlayerCenteredScores(listener, leaderboardId, span, leaderboardCollection, maxResults, forceReload);
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        this.f890dt.loadTopScores(listener, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        this.f890dt.loadTopScores(listener, leaderboardId, span, leaderboardCollection, maxResults, forceReload);
    }

    public void reconnect() {
        this.f890dt.disconnect();
        this.f890dt.connect();
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f890dt.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f890dt.registerConnectionFailedListener(listener);
    }

    public void registerInvitationListener(OnInvitationReceivedListener listener) {
        this.f890dt.registerInvitationListener(listener);
    }

    public void revealAchievement(String id) {
        this.f890dt.mo4592a((OnAchievementUpdatedListener) null, id);
    }

    public void revealAchievementImmediate(OnAchievementUpdatedListener listener, String id) {
        this.f890dt.mo4592a(listener, id);
    }

    public int sendReliableRealTimeMessage(RealTimeReliableMessageSentListener listener, byte[] messageData, String roomId, String recipientParticipantId) {
        return this.f890dt.sendReliableRealTimeMessage(listener, messageData, roomId, recipientParticipantId);
    }

    public int sendUnreliableRealTimeMessage(byte[] messageData, String roomId, String recipientParticipantId) {
        return this.f890dt.mo4587a(messageData, roomId, new String[]{recipientParticipantId});
    }

    public int sendUnreliableRealTimeMessage(byte[] messageData, String roomId, List<String> recipientParticipantIds) {
        return this.f890dt.mo4587a(messageData, roomId, (String[]) recipientParticipantIds.toArray(new String[recipientParticipantIds.size()]));
    }

    public int sendUnreliableRealTimeMessageToAll(byte[] messageData, String roomId) {
        return this.f890dt.sendUnreliableRealTimeMessageToAll(messageData, roomId);
    }

    public void setGravityForPopups(int gravity) {
        this.f890dt.setGravityForPopups(gravity);
    }

    public void setUseNewPlayerNotificationsFirstParty(boolean newPlayerStyle) {
        this.f890dt.setUseNewPlayerNotificationsFirstParty(newPlayerStyle);
    }

    public void setViewForPopups(View gamesContentView) {
        C0621s.m1890d(gamesContentView);
        this.f890dt.setViewForPopups(gamesContentView);
    }

    public void signOut() {
        this.f890dt.signOut((OnSignOutCompleteListener) null);
    }

    public void signOut(OnSignOutCompleteListener listener) {
        this.f890dt.signOut(listener);
    }

    public void submitScore(String leaderboardId, long score) {
        this.f890dt.mo4594a((OnScoreSubmittedListener) null, leaderboardId, score);
    }

    public void submitScoreImmediate(OnScoreSubmittedListener listener, String leaderboardId, long score) {
        this.f890dt.mo4594a(listener, leaderboardId, score);
    }

    public void unlockAchievement(String id) {
        this.f890dt.mo4599b((OnAchievementUpdatedListener) null, id);
    }

    public void unlockAchievementImmediate(OnAchievementUpdatedListener listener, String id) {
        this.f890dt.mo4599b(listener, id);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f890dt.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f890dt.unregisterConnectionFailedListener(listener);
    }

    public void unregisterInvitationListener() {
        this.f890dt.unregisterInvitationListener();
    }
}
