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
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0443em;
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
    public static final int STATUS_APP_MISCONFIGURED = 8;
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

    /* renamed from: mz */
    private final C0443em f464mz;

    public static final class Builder {

        /* renamed from: iq */
        private final GooglePlayServicesClient.ConnectionCallbacks f465iq;

        /* renamed from: ir */
        private final GooglePlayServicesClient.OnConnectionFailedListener f466ir;

        /* renamed from: is */
        private String[] f467is = {Scopes.GAMES};

        /* renamed from: it */
        private String f468it = "<<default account>>";

        /* renamed from: mA */
        private String f469mA;

        /* renamed from: mB */
        private int f470mB = 49;

        /* renamed from: mC */
        private View f471mC;
        private final Context mContext;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.f469mA = context.getPackageName();
            this.f465iq = connectedListener;
            this.f466ir = connectionFailedListener;
        }

        public GamesClient create() {
            return new GamesClient(this.mContext, this.f469mA, this.f468it, this.f465iq, this.f466ir, this.f467is, this.f470mB, this.f471mC);
        }

        public Builder setAccountName(String accountName) {
            this.f468it = (String) C0411dm.m944e(accountName);
            return this;
        }

        public Builder setGravityForPopups(int gravity) {
            this.f470mB = gravity;
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.f467is = scopes;
            return this;
        }

        public Builder setViewForPopups(View gamesContentView) {
            this.f471mC = (View) C0411dm.m944e(gamesContentView);
            return this;
        }
    }

    private GamesClient(Context context, String gamePackageName, String accountName, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView) {
        this.f464mz = new C0443em(context, gamePackageName, accountName, connectedListener, connectionFailedListener, scopes, gravity, gamesContentView, false);
    }

    public void clearAllNotifications() {
        this.f464mz.clearNotifications(-1);
    }

    public void clearNotifications(int notificationTypes) {
        this.f464mz.clearNotifications(notificationTypes);
    }

    public void connect() {
        this.f464mz.connect();
    }

    public void createRoom(RoomConfig config) {
        this.f464mz.createRoom(config);
    }

    public void declineRoomInvitation(String invitationId) {
        this.f464mz.mo4571j(invitationId, 0);
    }

    public void disconnect() {
        this.f464mz.disconnect();
    }

    public void dismissRoomInvitation(String invitationId) {
        this.f464mz.mo4570i(invitationId, 0);
    }

    public Intent getAchievementsIntent() {
        return this.f464mz.getAchievementsIntent();
    }

    public Intent getAllLeaderboardsIntent() {
        return this.f464mz.getAllLeaderboardsIntent();
    }

    public String getAppId() {
        return this.f464mz.getAppId();
    }

    public String getCurrentAccountName() {
        return this.f464mz.getCurrentAccountName();
    }

    public Game getCurrentGame() {
        return this.f464mz.getCurrentGame();
    }

    public Player getCurrentPlayer() {
        return this.f464mz.getCurrentPlayer();
    }

    public String getCurrentPlayerId() {
        return this.f464mz.getCurrentPlayerId();
    }

    public Intent getInvitationInboxIntent() {
        return this.f464mz.getInvitationInboxIntent();
    }

    public Intent getLeaderboardIntent(String leaderboardId) {
        return this.f464mz.getLeaderboardIntent(leaderboardId);
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String roomId, String participantId) {
        return this.f464mz.getRealTimeSocketForParticipant(roomId, participantId);
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int minParticipantsToStart) {
        return this.f464mz.getRealTimeWaitingRoomIntent(room, minParticipantsToStart);
    }

    public Intent getSelectPlayersIntent(int minPlayers, int maxPlayers) {
        return this.f464mz.getSelectPlayersIntent(minPlayers, maxPlayers);
    }

    public Intent getSettingsIntent() {
        return this.f464mz.getSettingsIntent();
    }

    public void incrementAchievement(String id, int numSteps) {
        this.f464mz.mo4550a((OnAchievementUpdatedListener) null, id, numSteps);
    }

    public void incrementAchievementImmediate(OnAchievementUpdatedListener listener, String id, int numSteps) {
        this.f464mz.mo4550a(listener, id, numSteps);
    }

    public boolean isConnected() {
        return this.f464mz.isConnected();
    }

    public boolean isConnecting() {
        return this.f464mz.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f464mz.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f464mz.isConnectionFailedListenerRegistered(listener);
    }

    public void joinRoom(RoomConfig config) {
        this.f464mz.joinRoom(config);
    }

    public void leaveRoom(RoomUpdateListener listener, String roomId) {
        this.f464mz.leaveRoom(listener, roomId);
    }

    public void loadAchievements(OnAchievementsLoadedListener listener, boolean forceReload) {
        this.f464mz.loadAchievements(listener, forceReload);
    }

    public void loadGame(OnGamesLoadedListener listener) {
        this.f464mz.loadGame(listener);
    }

    public void loadInvitablePlayers(OnPlayersLoadedListener listener, int pageSize, boolean forceReload) {
        this.f464mz.mo4548a(listener, pageSize, false, forceReload);
    }

    public void loadInvitations(OnInvitationsLoadedListener listener) {
        this.f464mz.loadInvitations(listener);
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
        this.f464mz.loadLeaderboardMetadata(listener, leaderboardId, forceReload);
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, boolean forceReload) {
        this.f464mz.loadLeaderboardMetadata(listener, forceReload);
    }

    public void loadMoreInvitablePlayers(OnPlayersLoadedListener listener, int pageSize) {
        this.f464mz.mo4548a(listener, pageSize, true, false);
    }

    public void loadMoreScores(OnLeaderboardScoresLoadedListener listener, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        this.f464mz.loadMoreScores(listener, buffer, maxResults, pageDirection);
    }

    public void loadPlayer(OnPlayersLoadedListener listener, String playerId) {
        this.f464mz.loadPlayer(listener, playerId);
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        this.f464mz.loadPlayerCenteredScores(listener, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        this.f464mz.loadPlayerCenteredScores(listener, leaderboardId, span, leaderboardCollection, maxResults, forceReload);
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        this.f464mz.loadTopScores(listener, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        this.f464mz.loadTopScores(listener, leaderboardId, span, leaderboardCollection, maxResults, forceReload);
    }

    public void reconnect() {
        this.f464mz.disconnect();
        this.f464mz.connect();
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f464mz.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f464mz.registerConnectionFailedListener(listener);
    }

    public void registerInvitationListener(OnInvitationReceivedListener listener) {
        this.f464mz.registerInvitationListener(listener);
    }

    public void revealAchievement(String id) {
        this.f464mz.mo4549a((OnAchievementUpdatedListener) null, id);
    }

    public void revealAchievementImmediate(OnAchievementUpdatedListener listener, String id) {
        this.f464mz.mo4549a(listener, id);
    }

    public int sendReliableRealTimeMessage(RealTimeReliableMessageSentListener listener, byte[] messageData, String roomId, String recipientParticipantId) {
        return this.f464mz.sendReliableRealTimeMessage(listener, messageData, roomId, recipientParticipantId);
    }

    public int sendUnreliableRealTimeMessage(byte[] messageData, String roomId, String recipientParticipantId) {
        return this.f464mz.mo4546a(messageData, roomId, new String[]{recipientParticipantId});
    }

    public int sendUnreliableRealTimeMessage(byte[] messageData, String roomId, List<String> recipientParticipantIds) {
        return this.f464mz.mo4546a(messageData, roomId, (String[]) recipientParticipantIds.toArray(new String[recipientParticipantIds.size()]));
    }

    public int sendUnreliableRealTimeMessageToAll(byte[] messageData, String roomId) {
        return this.f464mz.sendUnreliableRealTimeMessageToAll(messageData, roomId);
    }

    public void setAchievementSteps(String id, int numSteps) {
        this.f464mz.mo4553b((OnAchievementUpdatedListener) null, id, numSteps);
    }

    public void setAchievementStepsImmediate(OnAchievementUpdatedListener listener, String id, int numSteps) {
        this.f464mz.mo4553b(listener, id, numSteps);
    }

    public void setGravityForPopups(int gravity) {
        this.f464mz.setGravityForPopups(gravity);
    }

    public void setUseNewPlayerNotificationsFirstParty(boolean newPlayerStyle) {
        this.f464mz.setUseNewPlayerNotificationsFirstParty(newPlayerStyle);
    }

    public void setViewForPopups(View gamesContentView) {
        C0411dm.m944e(gamesContentView);
        this.f464mz.setViewForPopups(gamesContentView);
    }

    public void signOut() {
        this.f464mz.signOut((OnSignOutCompleteListener) null);
    }

    public void signOut(OnSignOutCompleteListener listener) {
        this.f464mz.signOut(listener);
    }

    public void submitScore(String leaderboardId, long score) {
        this.f464mz.mo4551a((OnScoreSubmittedListener) null, leaderboardId, score, (String) null);
    }

    public void submitScore(String leaderboardId, long score, String scoreTag) {
        this.f464mz.mo4551a((OnScoreSubmittedListener) null, leaderboardId, score, scoreTag);
    }

    public void submitScoreImmediate(OnScoreSubmittedListener listener, String leaderboardId, long score) {
        this.f464mz.mo4551a(listener, leaderboardId, score, (String) null);
    }

    public void submitScoreImmediate(OnScoreSubmittedListener listener, String leaderboardId, long score, String scoreTag) {
        this.f464mz.mo4551a(listener, leaderboardId, score, scoreTag);
    }

    public void unlockAchievement(String id) {
        this.f464mz.mo4552b((OnAchievementUpdatedListener) null, id);
    }

    public void unlockAchievementImmediate(OnAchievementUpdatedListener listener, String id) {
        this.f464mz.mo4552b(listener, id);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f464mz.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f464mz.unregisterConnectionFailedListener(listener);
    }

    public void unregisterInvitationListener() {
        this.f464mz.unregisterInvitationListener();
    }
}
