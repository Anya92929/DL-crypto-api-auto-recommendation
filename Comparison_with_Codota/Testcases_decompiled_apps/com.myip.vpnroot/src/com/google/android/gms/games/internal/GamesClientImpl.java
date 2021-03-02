package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.C0273a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0294a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.IGamesService;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.C1394kc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends C0316d<IGamesService> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: Dd */
    private final String f1688Dd;

    /* renamed from: Wh */
    EventIncrementManager f1689Wh = new EventIncrementManager() {
        /* renamed from: kv */
        public EventIncrementCache mo6740kv() {
            return new GameClientEventIncrementCache();
        }
    };

    /* renamed from: Wi */
    private final String f1690Wi;

    /* renamed from: Wj */
    private final Map<String, RealTimeSocket> f1691Wj;

    /* renamed from: Wk */
    private PlayerEntity f1692Wk;

    /* renamed from: Wl */
    private GameEntity f1693Wl;

    /* renamed from: Wm */
    private final PopupManager f1694Wm;

    /* renamed from: Wn */
    private boolean f1695Wn = false;

    /* renamed from: Wo */
    private final Binder f1696Wo;

    /* renamed from: Wp */
    private final long f1697Wp;

    /* renamed from: Wq */
    private final Games.GamesOptions f1698Wq;

    private abstract class AbstractPeerStatusCallback extends AbstractRoomStatusCallback {

        /* renamed from: Ws */
        private final ArrayList<String> f1701Ws = new ArrayList<>();

        AbstractPeerStatusCallback(RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            super(listener, dataHolder);
            for (String add : participantIds) {
                this.f1701Ws.add(add);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6741a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            mo6742a(roomStatusUpdateListener, room, this.f1701Ws);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo6742a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private abstract class AbstractRoomCallback extends C0316d<IGamesService>.d<RoomUpdateListener> {
        AbstractRoomCallback(RoomUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4455a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            mo6744a(roomUpdateListener, GamesClientImpl.this.m2265R(dataHolder), dataHolder.getStatusCode());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo6744a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private abstract class AbstractRoomStatusCallback extends C0316d<IGamesService>.d<RoomStatusUpdateListener> {
        AbstractRoomStatusCallback(RoomStatusUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4455a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            mo6741a(roomStatusUpdateListener, GamesClientImpl.this.m2265R(dataHolder));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo6741a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class AcceptQuestResultImpl extends C0273a implements Quests.AcceptQuestResult {

        /* renamed from: Wt */
        private final Quest f1704Wt;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.f1704Wt = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.f1704Wt = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.f1704Wt;
        }
    }

    private final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Achievements.UpdateAchievementResult> f1705De;

        AchievementUpdatedBinderCallback(BaseImplementation.C0270b<Achievements.UpdateAchievementResult> resultHolder) {
            this.f1705De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: g */
        public void mo6556g(int i, String str) {
            this.f1705De.mo4196b(new UpdateAchievementResultImpl(i, str));
        }
    }

    private final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Achievements.LoadAchievementsResult> f1707De;

        AchievementsLoadedBinderCallback(BaseImplementation.C0270b<Achievements.LoadAchievementsResult> resultHolder) {
            this.f1707De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: c */
        public void mo6540c(DataHolder dataHolder) {
            this.f1707De.mo4196b(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {

        /* renamed from: CM */
        private final Status f1709CM;

        /* renamed from: Wu */
        private final String f1710Wu;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.f1709CM = status;
            this.f1710Wu = externalMatchId;
        }

        public String getMatchId() {
            return this.f1710Wu;
        }

        public Status getStatus() {
            return this.f1709CM;
        }
    }

    private static final class ClaimMilestoneResultImpl extends C0273a implements Quests.ClaimMilestoneResult {

        /* renamed from: Wt */
        private final Quest f1711Wt;

        /* renamed from: Wv */
        private final Milestone f1712Wv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.f1711Wt = new QuestEntity((Quest) questBuffer.get(0));
                    List<Milestone> lH = this.f1711Wt.mo7730lH();
                    int size = lH.size();
                    for (int i = 0; i < size; i++) {
                        if (lH.get(i).getMilestoneId().equals(milestoneId)) {
                            this.f1712Wv = lH.get(i);
                            return;
                        }
                    }
                    this.f1712Wv = null;
                } else {
                    this.f1712Wv = null;
                    this.f1711Wt = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.f1712Wv;
        }

        public Quest getQuest() {
            return this.f1711Wt;
        }
    }

    private static final class CommitSnapshotResultImpl extends C0273a implements Snapshots.CommitSnapshotResult {

        /* renamed from: Ww */
        private final SnapshotMetadata f1713Ww;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.f1713Ww = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.f1713Ww = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.f1713Ww;
        }
    }

    private final class ConnectedToRoomCallback extends AbstractRoomStatusCallback {
        ConnectedToRoomCallback(RoomStatusUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* renamed from: a */
        public void mo6741a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends C0273a implements Notifications.ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Notifications.ContactSettingLoadResult> f1715De;

        ContactSettingsLoadedBinderCallback(BaseImplementation.C0270b<Notifications.ContactSettingLoadResult> holder) {
            this.f1715De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: D */
        public void mo6517D(DataHolder dataHolder) {
            this.f1715De.mo4196b(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Status> f1717De;

        ContactSettingsUpdatedBinderCallback(BaseImplementation.C0270b<Status> holder) {
            this.f1717De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: dy */
        public void mo6546dy(int i) {
            this.f1717De.mo4196b(new Status(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {

        /* renamed from: CM */
        private final Status f1719CM;

        /* renamed from: Wx */
        private final String f1720Wx;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.f1719CM = new Status(statusCode);
            this.f1720Wx = snapshotId;
        }

        public String getSnapshotId() {
            return this.f1720Wx;
        }

        public Status getStatus() {
            return this.f1719CM;
        }
    }

    private final class DisconnectedFromRoomCallback extends AbstractRoomStatusCallback {
        DisconnectedFromRoomCallback(RoomStatusUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* renamed from: a */
        public void mo6741a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Events.LoadEventsResult> f1722De;

        EventsLoadedBinderCallback(BaseImplementation.C0270b<Events.LoadEventsResult> resultHolder) {
            this.f1722De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: d */
        public void mo6543d(DataHolder dataHolder) {
            this.f1722De.mo4196b(new LoadEventResultImpl(dataHolder));
        }
    }

    private final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> f1724De;

        ExtendedGamesLoadedBinderCallback(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> holder) {
            this.f1724De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: j */
        public void mo6562j(DataHolder dataHolder) {
            this.f1724De.mo4196b(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        public GameClientEventIncrementCache() {
            super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
        }

        /* access modifiers changed from: protected */
        /* renamed from: q */
        public void mo6752q(String str, int i) {
            try {
                if (GamesClientImpl.this.isConnected()) {
                    ((IGamesService) GamesClientImpl.this.mo4435gS()).mo6958n(str, i);
                } else {
                    GamesLog.m2554q("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesLog.m2553p("GamesClientImpl", "service died");
            }
        }
    }

    private final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<GamesMetadata.LoadGameInstancesResult> f1727De;

        GameInstancesLoadedBinderCallback(BaseImplementation.C0270b<GamesMetadata.LoadGameInstancesResult> holder) {
            this.f1727De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: k */
        public void mo6563k(DataHolder dataHolder) {
            this.f1727De.mo4196b(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {

        /* renamed from: CM */
        private final Status f1729CM;

        /* renamed from: Wy */
        private final String f1730Wy;

        /* renamed from: Wz */
        private final boolean f1731Wz;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.f1729CM = new Status(statusCode);
            this.f1730Wy = externalGameId;
            this.f1731Wz = isMuted;
        }

        public Status getStatus() {
            return this.f1729CM;
        }
    }

    private final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Notifications.GameMuteStatusChangeResult> f1732De;

        GameMuteStatusChangedBinderCallback(BaseImplementation.C0270b<Notifications.GameMuteStatusChangeResult> holder) {
            this.f1732De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo6531a(int i, String str, boolean z) {
            this.f1732De.mo4196b(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {

        /* renamed from: CM */
        private final Status f1734CM;

        /* renamed from: Wy */
        private final String f1735Wy;

        /* renamed from: Wz */
        private final boolean f1736Wz;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.f1734CM = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.f1735Wy = dataHolder.mo4306c("external_game_id", 0, 0);
                    this.f1736Wz = dataHolder.mo4308d("muted", 0, 0);
                } else {
                    this.f1735Wy = null;
                    this.f1736Wz = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.f1734CM;
        }
    }

    private final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Notifications.GameMuteStatusLoadResult> f1737De;

        GameMuteStatusLoadedBinderCallback(BaseImplementation.C0270b<Notifications.GameMuteStatusLoadResult> holder) {
            this.f1737De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: B */
        public void mo6515B(DataHolder dataHolder) {
            this.f1737De.mo4196b(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<GamesMetadata.LoadGameSearchSuggestionsResult> f1739De;

        GameSearchSuggestionsLoadedBinderCallback(BaseImplementation.C0270b<GamesMetadata.LoadGameSearchSuggestionsResult> holder) {
            this.f1739De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: l */
        public void mo6564l(DataHolder dataHolder) {
            this.f1739De.mo4196b(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<GamesMetadata.LoadGamesResult> f1741De;

        GamesLoadedBinderCallback(BaseImplementation.C0270b<GamesMetadata.LoadGamesResult> holder) {
            this.f1741De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: i */
        public void mo6561i(DataHolder dataHolder) {
            this.f1741De.mo4196b(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountResultImpl implements Notifications.InboxCountResult {

        /* renamed from: CM */
        private final Status f1743CM;

        /* renamed from: WA */
        private final Bundle f1744WA;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.f1743CM = status;
            this.f1744WA = inboxCounts;
        }

        public Status getStatus() {
            return this.f1743CM;
        }
    }

    private final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Notifications.InboxCountResult> f1745De;

        InboxCountsLoadedBinderCallback(BaseImplementation.C0270b<Notifications.InboxCountResult> holder) {
            this.f1745De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: f */
        public void mo6551f(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f1745De.mo4196b(new InboxCountResultImpl(new Status(i), bundle));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: WB */
        private final OnInvitationReceivedListener f1747WB;

        InvitationReceivedBinderCallback(OnInvitationReceivedListener listener) {
            this.f1747WB = listener;
        }

        /* renamed from: n */
        public void mo6566n(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                if (invitation != null) {
                    GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new InvitationReceivedCallback(this.f1747WB, invitation));
                }
            } finally {
                invitationBuffer.release();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new InvitationRemovedCallback(this.f1747WB, invitationId));
        }
    }

    private final class InvitationReceivedCallback extends C0316d<IGamesService>.b<OnInvitationReceivedListener> {

        /* renamed from: WC */
        private final Invitation f1749WC;

        InvitationReceivedCallback(OnInvitationReceivedListener listener, Invitation invitation) {
            super(listener);
            this.f1749WC = invitation;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.f1749WC);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class InvitationRemovedCallback extends C0316d<IGamesService>.b<OnInvitationReceivedListener> {

        /* renamed from: WD */
        private final String f1751WD;

        InvitationRemovedCallback(OnInvitationReceivedListener listener, String invitationId) {
            super(listener);
            this.f1751WD = invitationId;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.f1751WD);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Invitations.LoadInvitationsResult> f1753De;

        InvitationsLoadedBinderCallback(BaseImplementation.C0270b<Invitations.LoadInvitationsResult> resultHolder) {
            this.f1753De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: m */
        public void mo6565m(DataHolder dataHolder) {
            this.f1753De.mo4196b(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private final class JoinedRoomCallback extends AbstractRoomCallback {
        public JoinedRoomCallback(RoomUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* renamed from: a */
        public void mo6744a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends C0273a implements Leaderboards.LeaderboardMetadataResult {

        /* renamed from: WE */
        private final LeaderboardBuffer f1756WE;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1756WE = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.f1756WE;
        }
    }

    private final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Leaderboards.LoadScoresResult> f1757De;

        LeaderboardScoresLoadedBinderCallback(BaseImplementation.C0270b<Leaderboards.LoadScoresResult> resultHolder) {
            this.f1757De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo6532a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.f1757De.mo4196b(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult> f1759De;

        LeaderboardsLoadedBinderCallback(BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult> resultHolder) {
            this.f1759De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo6549e(DataHolder dataHolder) {
            this.f1759De.mo4196b(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class LeftRoomCallback extends C0316d<IGamesService>.b<RoomUpdateListener> {

        /* renamed from: HF */
        private final int f1761HF;

        /* renamed from: WF */
        private final String f1762WF;

        LeftRoomCallback(RoomUpdateListener listener, int statusCode, String roomId) {
            super(listener);
            this.f1761HF = statusCode;
            this.f1762WF = roomId;
        }

        /* renamed from: a */
        public void mo4449g(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.f1761HF, this.f1762WF);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private static final class LoadAchievementsResultImpl extends C0273a implements Achievements.LoadAchievementsResult {

        /* renamed from: WG */
        private final AchievementBuffer f1764WG;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1764WG = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.f1764WG;
        }
    }

    private static final class LoadAclResultImpl extends C0273a implements Acls.LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadEventResultImpl extends C0273a implements Events.LoadEventsResult {

        /* renamed from: WH */
        private final EventBuffer f1765WH;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1765WH = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.f1765WH;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends C0273a implements GamesMetadata.LoadExtendedGamesResult {

        /* renamed from: WI */
        private final ExtendedGameBuffer f1766WI;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1766WI = new ExtendedGameBuffer(dataHolder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends C0273a implements GamesMetadata.LoadGameInstancesResult {

        /* renamed from: WJ */
        private final GameInstanceBuffer f1767WJ;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1767WJ = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends C0273a implements GamesMetadata.LoadGameSearchSuggestionsResult {
        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
        }
    }

    private static final class LoadGamesResultImpl extends C0273a implements GamesMetadata.LoadGamesResult {

        /* renamed from: WK */
        private final GameBuffer f1768WK;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1768WK = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.f1768WK;
        }
    }

    private static final class LoadInvitationsResultImpl extends C0273a implements Invitations.LoadInvitationsResult {

        /* renamed from: WL */
        private final InvitationBuffer f1769WL;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1769WL = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.f1769WL;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {

        /* renamed from: CM */
        private final Status f1770CM;

        /* renamed from: WM */
        private final LoadMatchesResponse f1771WM;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.f1770CM = status;
            this.f1771WM = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.f1771WM;
        }

        public Status getStatus() {
            return this.f1770CM;
        }

        public void release() {
            this.f1771WM.close();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements Players.LoadOwnerCoverPhotoUrisResult {

        /* renamed from: CM */
        private final Status f1772CM;

        /* renamed from: MZ */
        private final Bundle f1773MZ;

        LoadOwnerCoverPhotoUrisResultImpl(int statusCode, Bundle bundle) {
            this.f1772CM = new Status(statusCode);
            this.f1773MZ = bundle;
        }

        public Status getStatus() {
            return this.f1772CM;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends C0273a implements Leaderboards.LoadPlayerScoreResult {

        /* renamed from: WN */
        private final LeaderboardScoreEntity f1774WN;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.f1774WN = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.f1774WN = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.f1774WN;
        }
    }

    private static final class LoadPlayersResultImpl extends C0273a implements Players.LoadPlayersResult {

        /* renamed from: WO */
        private final PlayerBuffer f1775WO;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1775WO = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.f1775WO;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends C0273a implements Players.LoadProfileSettingsResult {

        /* renamed from: WP */
        private final boolean f1776WP;

        /* renamed from: We */
        private final boolean f1777We;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int ar = dataHolder.mo4304ar(0);
                    this.f1777We = dataHolder.mo4308d("profile_visible", 0, ar);
                    this.f1776WP = dataHolder.mo4308d("profile_visibility_explicitly_set", 0, ar);
                } else {
                    this.f1777We = true;
                    this.f1776WP = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.f599CM;
        }

        public boolean isProfileVisible() {
            return this.f1777We;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.f1776WP;
        }
    }

    private static final class LoadQuestsResultImpl extends C0273a implements Quests.LoadQuestsResult {

        /* renamed from: IC */
        private final DataHolder f1778IC;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1778IC = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.f1778IC);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends C0273a implements Requests.LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {

        /* renamed from: CM */
        private final Status f1779CM;

        /* renamed from: WQ */
        private final Bundle f1780WQ;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.f1779CM = status;
            this.f1780WQ = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String dH = RequestType.m3519dH(requestType);
            if (!this.f1780WQ.containsKey(dH)) {
                return null;
            }
            return new GameRequestBuffer((DataHolder) this.f1780WQ.get(dH));
        }

        public Status getStatus() {
            return this.f1779CM;
        }

        public void release() {
            for (String parcelable : this.f1780WQ.keySet()) {
                DataHolder dataHolder = (DataHolder) this.f1780WQ.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends C0273a implements Leaderboards.LoadScoresResult {

        /* renamed from: WR */
        private final LeaderboardEntity f1781WR;

        /* renamed from: WS */
        private final LeaderboardScoreBuffer f1782WS;

        /* JADX INFO: finally extract failed */
        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.f1781WR = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.f1781WR = null;
                }
                leaderboardBuffer.release();
                this.f1782WS = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        public Leaderboard getLeaderboard() {
            return this.f1781WR;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.f1782WS;
        }
    }

    private static final class LoadSnapshotsResultImpl extends C0273a implements Snapshots.LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.f600IC);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {

        /* renamed from: CM */
        private final Status f1783CM;

        /* renamed from: WT */
        private final List<String> f1784WT;

        /* renamed from: WU */
        private final Bundle f1785WU;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.f1783CM = status;
            this.f1784WT = xpData.getStringArrayList("game_category_list");
            this.f1785WU = xpData;
        }

        public Status getStatus() {
            return this.f1783CM;
        }
    }

    private static final class LoadXpStreamResultImpl extends C0273a implements Players.LoadXpStreamResult {

        /* renamed from: WV */
        private final ExperienceEventBuffer f1786WV;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1786WV = new ExperienceEventBuffer(dataHolder);
        }
    }

    private final class MatchRemovedCallback extends C0316d<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {

        /* renamed from: WW */
        private final String f1787WW;

        MatchRemovedCallback(OnTurnBasedMatchUpdateReceivedListener listener, String matchId) {
            super(listener);
            this.f1787WW = matchId;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.f1787WW);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: WX */
        private final OnTurnBasedMatchUpdateReceivedListener f1789WX;

        MatchUpdateReceivedBinderCallback(OnTurnBasedMatchUpdateReceivedListener listener) {
            this.f1789WX = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new MatchRemovedCallback(this.f1789WX, matchId));
        }

        /* renamed from: t */
        public void mo6579t(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                if (turnBasedMatch != null) {
                    GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new MatchUpdateReceivedCallback(this.f1789WX, turnBasedMatch));
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private final class MatchUpdateReceivedCallback extends C0316d<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {

        /* renamed from: WY */
        private final TurnBasedMatch f1791WY;

        MatchUpdateReceivedCallback(OnTurnBasedMatchUpdateReceivedListener listener, TurnBasedMatch match) {
            super(listener);
            this.f1791WY = match;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.f1791WY);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class MessageReceivedCallback extends C0316d<IGamesService>.b<RealTimeMessageReceivedListener> {

        /* renamed from: WZ */
        private final RealTimeMessage f1793WZ;

        MessageReceivedCallback(RealTimeMessageReceivedListener listener, RealTimeMessage message) {
            super(listener);
            this.f1793WZ = message;
        }

        /* renamed from: a */
        public void mo4449g(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.f1793WZ);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class NearbyPlayerDetectedCallback extends C0316d<IGamesService>.b<OnNearbyPlayerDetectedListener> {

        /* renamed from: Xa */
        private final Player f1795Xa;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4449g(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.mo6378a(this.f1795Xa);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Acls.LoadAclResult> f1796De;

        NotifyAclLoadedBinderCallback(BaseImplementation.C0270b<Acls.LoadAclResult> resultHolder) {
            this.f1796De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: C */
        public void mo6516C(DataHolder dataHolder) {
            this.f1796De.mo4196b(new LoadAclResultImpl(dataHolder));
        }
    }

    private final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Status> f1798De;

        NotifyAclUpdatedBinderCallback(BaseImplementation.C0270b<Status> resultHolder) {
            this.f1798De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: dx */
        public void mo6545dx(int i) {
            this.f1798De.mo4196b(new Status(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends C0273a implements Snapshots.OpenSnapshotResult {

        /* renamed from: Xb */
        private final Snapshot f1800Xb;

        /* renamed from: Xc */
        private final String f1801Xc;

        /* renamed from: Xd */
        private final Snapshot f1802Xd;

        /* renamed from: Xe */
        private final Contents f1803Xe;

        /* renamed from: Xf */
        private final SnapshotContents f1804Xf;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, (String) null, currentContents, (Contents) null, (Contents) null);
        }

        /* JADX INFO: finally extract failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            super(metadataHolder);
            boolean z = true;
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.f1800Xb = null;
                    this.f1802Xd = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    C0313a.m678I(metadataHolder.getStatusCode() == 4004 ? false : z);
                    this.f1800Xb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContents(currentContents));
                    this.f1802Xd = null;
                } else {
                    this.f1800Xb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContents(currentContents));
                    this.f1802Xd = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContents(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.f1801Xc = conflictId;
                this.f1803Xe = resolutionContents;
                this.f1804Xf = new SnapshotContents(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        public String getConflictId() {
            return this.f1801Xc;
        }

        public Snapshot getConflictingSnapshot() {
            return this.f1802Xd;
        }

        @Deprecated
        public Contents getResolutionContents() {
            return this.f1803Xe;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.f1804Xf;
        }

        public Snapshot getSnapshot() {
            return this.f1800Xb;
        }
    }

    private final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Players.LoadOwnerCoverPhotoUrisResult> f1805De;

        OwnerCoverPhotoUrisLoadedBinderCallback(BaseImplementation.C0270b<Players.LoadOwnerCoverPhotoUrisResult> holder) {
            this.f1805De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: d */
        public void mo6542d(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f1805De.mo4196b(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    private final class P2PConnectedCallback extends C0316d<IGamesService>.b<RoomStatusUpdateListener> {

        /* renamed from: Xg */
        private final String f1808Xg;

        P2PConnectedCallback(RoomStatusUpdateListener listener, String participantId) {
            super(listener);
            this.f1808Xg = participantId;
        }

        /* renamed from: a */
        public void mo4449g(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.f1808Xg);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class P2PDisconnectedCallback extends C0316d<IGamesService>.b<RoomStatusUpdateListener> {

        /* renamed from: Xg */
        private final String f1810Xg;

        P2PDisconnectedCallback(RoomStatusUpdateListener listener, String participantId) {
            super(listener);
            this.f1810Xg = participantId;
        }

        /* renamed from: a */
        public void mo4449g(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.f1810Xg);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class PeerConnectedCallback extends AbstractPeerStatusCallback {
        PeerConnectedCallback(RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            super(listener, dataHolder, participantIds);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6742a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private final class PeerDeclinedCallback extends AbstractPeerStatusCallback {
        PeerDeclinedCallback(RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            super(listener, dataHolder, participantIds);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6742a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private final class PeerDisconnectedCallback extends AbstractPeerStatusCallback {
        PeerDisconnectedCallback(RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            super(listener, dataHolder, participantIds);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6742a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private final class PeerInvitedToRoomCallback extends AbstractPeerStatusCallback {
        PeerInvitedToRoomCallback(RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            super(listener, dataHolder, participantIds);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6742a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private final class PeerJoinedRoomCallback extends AbstractPeerStatusCallback {
        PeerJoinedRoomCallback(RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            super(listener, dataHolder, participantIds);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6742a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private final class PeerLeftRoomCallback extends AbstractPeerStatusCallback {
        PeerLeftRoomCallback(RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            super(listener, dataHolder, participantIds);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6742a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Leaderboards.LoadPlayerScoreResult> f1817De;

        PlayerLeaderboardScoreLoadedBinderCallback(BaseImplementation.C0270b<Leaderboards.LoadPlayerScoreResult> resultHolder) {
            this.f1817De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: E */
        public void mo6518E(DataHolder dataHolder) {
            this.f1817De.mo4196b(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Players.LoadXpForGameCategoriesResult> f1819De;

        PlayerXpForGameCategoriesLoadedBinderCallback(BaseImplementation.C0270b<Players.LoadXpForGameCategoriesResult> holder) {
            this.f1819De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo6548e(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f1819De.mo4196b(new LoadXpForGameCategoriesResultImpl(new Status(i), bundle));
        }
    }

    final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Players.LoadXpStreamResult> f1821De;

        PlayerXpStreamLoadedBinderCallback(BaseImplementation.C0270b<Players.LoadXpStreamResult> holder) {
            this.f1821De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: P */
        public void mo6529P(DataHolder dataHolder) {
            this.f1821De.mo4196b(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Players.LoadPlayersResult> f1823De;

        PlayersLoadedBinderCallback(BaseImplementation.C0270b<Players.LoadPlayersResult> holder) {
            this.f1823De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: g */
        public void mo6557g(DataHolder dataHolder) {
            this.f1823De.mo4196b(new LoadPlayersResultImpl(dataHolder));
        }

        /* renamed from: h */
        public void mo6559h(DataHolder dataHolder) {
            this.f1823De.mo4196b(new LoadPlayersResultImpl(dataHolder));
        }
    }

    final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Players.LoadProfileSettingsResult> f1825De;

        ProfileSettingsLoadedBinderCallback(BaseImplementation.C0270b<Players.LoadProfileSettingsResult> holder) {
            this.f1825De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: Q */
        public void mo6530Q(DataHolder dataHolder) {
            this.f1825De.mo4196b(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Status> f1827De;

        ProfileSettingsUpdatedBinderCallback(BaseImplementation.C0270b<Status> holder) {
            this.f1827De = (BaseImplementation.C0270b) C0348n.m857b(holder, (Object) "Holder must not be null");
        }

        /* renamed from: dz */
        public void mo6547dz(int i) {
            this.f1827De.mo4196b(new Status(i));
        }
    }

    private final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xh */
        private final BaseImplementation.C0270b<Quests.AcceptQuestResult> f1830Xh;

        public QuestAcceptedBinderCallbacks(BaseImplementation.C0270b<Quests.AcceptQuestResult> resultHolder) {
            this.f1830Xh = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: L */
        public void mo6525L(DataHolder dataHolder) {
            this.f1830Xh.mo4196b(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private final class QuestCompletedCallback extends C0316d<IGamesService>.b<QuestUpdateListener> {

        /* renamed from: Wt */
        private final Quest f1832Wt;

        QuestCompletedCallback(QuestUpdateListener listener, Quest quest) {
            super(listener);
            this.f1832Wt = quest;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.f1832Wt);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xi */
        private final BaseImplementation.C0270b<Quests.ClaimMilestoneResult> f1834Xi;

        /* renamed from: Xj */
        private final String f1835Xj;

        public QuestMilestoneClaimBinderCallbacks(BaseImplementation.C0270b<Quests.ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.f1834Xi = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
            this.f1835Xj = (String) C0348n.m857b(milestoneId, (Object) "MilestoneId must not be null");
        }

        /* renamed from: K */
        public void mo6524K(DataHolder dataHolder) {
            this.f1834Xi.mo4196b(new ClaimMilestoneResultImpl(dataHolder, this.f1835Xj));
        }
    }

    private final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: Xk */
        private final QuestUpdateListener f1837Xk;

        QuestUpdateBinderCallback(QuestUpdateListener listener) {
            this.f1837Xk = listener;
        }

        /* renamed from: S */
        private Quest m2500S(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                return quest;
            } finally {
                questBuffer.release();
            }
        }

        /* renamed from: M */
        public void mo6526M(DataHolder dataHolder) {
            Quest S = m2500S(dataHolder);
            if (S != null) {
                GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new QuestCompletedCallback(this.f1837Xk, S));
            }
        }
    }

    private final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xl */
        private final BaseImplementation.C0270b<Quests.LoadQuestsResult> f1839Xl;

        public QuestsLoadedBinderCallbacks(BaseImplementation.C0270b<Quests.LoadQuestsResult> resultHolder) {
            this.f1839Xl = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: O */
        public void mo6528O(DataHolder dataHolder) {
            this.f1839Xl.mo4196b(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private final class RealTimeMessageSentCallback extends C0316d<IGamesService>.b<RealTimeMultiplayer.ReliableMessageSentCallback> {

        /* renamed from: HF */
        private final int f1840HF;

        /* renamed from: Xm */
        private final String f1842Xm;

        /* renamed from: Xn */
        private final int f1843Xn;

        RealTimeMessageSentCallback(RealTimeMultiplayer.ReliableMessageSentCallback listener, int statusCode, int token, String recipientParticipantId) {
            super(listener);
            this.f1840HF = statusCode;
            this.f1843Xn = token;
            this.f1842Xm = recipientParticipantId;
        }

        /* renamed from: a */
        public void mo4449g(RealTimeMultiplayer.ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.f1840HF, this.f1843Xn, this.f1842Xm);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xo */
        final RealTimeMultiplayer.ReliableMessageSentCallback f1845Xo;

        public RealTimeReliableMessageBinderCallbacks(RealTimeMultiplayer.ReliableMessageSentCallback messageSentCallbacks) {
            this.f1845Xo = messageSentCallbacks;
        }

        /* renamed from: b */
        public void mo6536b(int i, int i2, String str) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new RealTimeMessageSentCallback(this.f1845Xo, i, i2, str));
        }
    }

    private final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {

        /* renamed from: Xp */
        private final OnRequestReceivedListener f1847Xp;

        RequestReceivedBinderCallback(OnRequestReceivedListener listener) {
            this.f1847Xp = listener;
        }

        /* renamed from: o */
        public void mo6567o(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                if (gameRequest != null) {
                    GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new RequestReceivedCallback(this.f1847Xp, gameRequest));
                }
            } finally {
                gameRequestBuffer.release();
            }
        }

        public void onRequestRemoved(String requestId) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new RequestRemovedCallback(this.f1847Xp, requestId));
        }
    }

    private final class RequestReceivedCallback extends C0316d<IGamesService>.b<OnRequestReceivedListener> {

        /* renamed from: Xq */
        private final GameRequest f1849Xq;

        RequestReceivedCallback(OnRequestReceivedListener listener, GameRequest request) {
            super(listener);
            this.f1849Xq = request;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.f1849Xq);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class RequestRemovedCallback extends C0316d<IGamesService>.b<OnRequestReceivedListener> {

        /* renamed from: Xr */
        private final String f1851Xr;

        RequestRemovedCallback(OnRequestReceivedListener listener, String requestId) {
            super(listener);
            this.f1851Xr = requestId;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.f1851Xr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    private final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xs */
        private final BaseImplementation.C0270b<Requests.SendRequestResult> f1853Xs;

        public RequestSentBinderCallbacks(BaseImplementation.C0270b<Requests.SendRequestResult> resultHolder) {
            this.f1853Xs = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: G */
        public void mo6520G(DataHolder dataHolder) {
            this.f1853Xs.mo4196b(new SendRequestResultImpl(dataHolder));
        }
    }

    private final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xt */
        private final BaseImplementation.C0270b<Requests.LoadRequestSummariesResult> f1855Xt;

        public RequestSummariesLoadedBinderCallbacks(BaseImplementation.C0270b<Requests.LoadRequestSummariesResult> resultHolder) {
            this.f1855Xt = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: H */
        public void mo6521H(DataHolder dataHolder) {
            this.f1855Xt.mo4196b(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xu */
        private final BaseImplementation.C0270b<Requests.LoadRequestsResult> f1857Xu;

        public RequestsLoadedBinderCallbacks(BaseImplementation.C0270b<Requests.LoadRequestsResult> resultHolder) {
            this.f1857Xu = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: c */
        public void mo6539c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f1857Xu.mo4196b(new LoadRequestsResultImpl(new Status(i), bundle));
        }
    }

    private final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xv */
        private final BaseImplementation.C0270b<Requests.UpdateRequestsResult> f1859Xv;

        public RequestsUpdatedBinderCallbacks(BaseImplementation.C0270b<Requests.UpdateRequestsResult> resultHolder) {
            this.f1859Xv = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: F */
        public void mo6519F(DataHolder dataHolder) {
            this.f1859Xv.mo4196b(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private final class RoomAutoMatchingCallback extends AbstractRoomStatusCallback {
        RoomAutoMatchingCallback(RoomStatusUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* renamed from: a */
        public void mo6741a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private final class RoomBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xw */
        private final RoomUpdateListener f1862Xw;

        /* renamed from: Xx */
        private final RoomStatusUpdateListener f1863Xx;

        /* renamed from: Xy */
        private final RealTimeMessageReceivedListener f1864Xy;

        public RoomBinderCallbacks(RoomUpdateListener roomCallbacks) {
            this.f1862Xw = (RoomUpdateListener) C0348n.m857b(roomCallbacks, (Object) "Callbacks must not be null");
            this.f1863Xx = null;
            this.f1864Xy = null;
        }

        public RoomBinderCallbacks(RoomUpdateListener roomCallbacks, RoomStatusUpdateListener roomStatusCallbacks, RealTimeMessageReceivedListener realTimeMessageReceivedCallbacks) {
            this.f1862Xw = (RoomUpdateListener) C0348n.m857b(roomCallbacks, (Object) "Callbacks must not be null");
            this.f1863Xx = roomStatusCallbacks;
            this.f1864Xy = realTimeMessageReceivedCallbacks;
        }

        /* renamed from: A */
        public void mo6514A(DataHolder dataHolder) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new DisconnectedFromRoomCallback(this.f1863Xx, dataHolder));
        }

        /* renamed from: a */
        public void mo6535a(DataHolder dataHolder, String[] strArr) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new PeerInvitedToRoomCallback(this.f1863Xx, dataHolder, strArr));
        }

        /* renamed from: b */
        public void mo6538b(DataHolder dataHolder, String[] strArr) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new PeerJoinedRoomCallback(this.f1863Xx, dataHolder, strArr));
        }

        /* renamed from: c */
        public void mo6541c(DataHolder dataHolder, String[] strArr) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new PeerLeftRoomCallback(this.f1863Xx, dataHolder, strArr));
        }

        /* renamed from: d */
        public void mo6544d(DataHolder dataHolder, String[] strArr) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new PeerDeclinedCallback(this.f1863Xx, dataHolder, strArr));
        }

        /* renamed from: e */
        public void mo6550e(DataHolder dataHolder, String[] strArr) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new PeerConnectedCallback(this.f1863Xx, dataHolder, strArr));
        }

        /* renamed from: f */
        public void mo6554f(DataHolder dataHolder, String[] strArr) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new PeerDisconnectedCallback(this.f1863Xx, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new LeftRoomCallback(this.f1862Xw, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new P2PConnectedCallback(this.f1863Xx, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new P2PDisconnectedCallback(this.f1863Xx, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new MessageReceivedCallback(this.f1864Xy, message));
        }

        /* renamed from: u */
        public void mo6580u(DataHolder dataHolder) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new RoomCreatedCallback(this.f1862Xw, dataHolder));
        }

        /* renamed from: v */
        public void mo6581v(DataHolder dataHolder) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new JoinedRoomCallback(this.f1862Xw, dataHolder));
        }

        /* renamed from: w */
        public void mo6582w(DataHolder dataHolder) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new RoomConnectingCallback(this.f1863Xx, dataHolder));
        }

        /* renamed from: x */
        public void mo6583x(DataHolder dataHolder) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new RoomAutoMatchingCallback(this.f1863Xx, dataHolder));
        }

        /* renamed from: y */
        public void mo6584y(DataHolder dataHolder) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new RoomConnectedCallback(this.f1862Xw, dataHolder));
        }

        /* renamed from: z */
        public void mo6585z(DataHolder dataHolder) {
            GamesClientImpl.this.mo4430a((C0316d<T>.b<?>) new ConnectedToRoomCallback(this.f1863Xx, dataHolder));
        }
    }

    private final class RoomConnectedCallback extends AbstractRoomCallback {
        RoomConnectedCallback(RoomUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* renamed from: a */
        public void mo6744a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private final class RoomConnectingCallback extends AbstractRoomStatusCallback {
        RoomConnectingCallback(RoomStatusUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* renamed from: a */
        public void mo6741a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private final class RoomCreatedCallback extends AbstractRoomCallback {
        public RoomCreatedCallback(RoomUpdateListener listener, DataHolder dataHolder) {
            super(listener, dataHolder);
        }

        /* renamed from: a */
        public void mo6744a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends C0273a implements Requests.SendRequestResult {

        /* renamed from: Xq */
        private final GameRequest f1868Xq;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.f1868Xq = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.f1868Xq = null;
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    private final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Status> f1869De;

        public SignOutCompleteBinderCallbacks(BaseImplementation.C0270b<Status> resultHolder) {
            this.f1869De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: fq */
        public void mo6555fq() {
            this.f1869De.mo4196b(new Status(0));
        }
    }

    private final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: Xz */
        private final BaseImplementation.C0270b<Snapshots.CommitSnapshotResult> f1872Xz;

        public SnapshotCommittedBinderCallbacks(BaseImplementation.C0270b<Snapshots.CommitSnapshotResult> resultHolder) {
            this.f1872Xz = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: J */
        public void mo6523J(DataHolder dataHolder) {
            this.f1872Xz.mo4196b(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Snapshots.DeleteSnapshotResult> f1873De;

        public SnapshotDeletedBinderCallbacks(BaseImplementation.C0270b<Snapshots.DeleteSnapshotResult> resultHolder) {
            this.f1873De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: i */
        public void mo6560i(int i, String str) {
            this.f1873De.mo4196b(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XA */
        private final BaseImplementation.C0270b<Snapshots.OpenSnapshotResult> f1876XA;

        public SnapshotOpenedBinderCallbacks(BaseImplementation.C0270b<Snapshots.OpenSnapshotResult> resultHolder) {
            this.f1876XA = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo6533a(DataHolder dataHolder, Contents contents) {
            this.f1876XA.mo4196b(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        /* renamed from: a */
        public void mo6534a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.f1876XA.mo4196b(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XB */
        private final BaseImplementation.C0270b<Snapshots.LoadSnapshotsResult> f1878XB;

        public SnapshotsLoadedBinderCallbacks(BaseImplementation.C0270b<Snapshots.LoadSnapshotsResult> resultHolder) {
            this.f1878XB = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: I */
        public void mo6522I(DataHolder dataHolder) {
            this.f1878XB.mo4196b(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Leaderboards.SubmitScoreResult> f1879De;

        public SubmitScoreBinderCallbacks(BaseImplementation.C0270b<Leaderboards.SubmitScoreResult> resultHolder) {
            this.f1879De = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: f */
        public void mo6553f(DataHolder dataHolder) {
            this.f1879De.mo4196b(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends C0273a implements Leaderboards.SubmitScoreResult {

        /* renamed from: XC */
        private final ScoreSubmissionData f1881XC;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.f1881XC = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.f1881XC;
        }
    }

    private final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XD */
        private final BaseImplementation.C0270b<TurnBasedMultiplayer.CancelMatchResult> f1883XD;

        public TurnBasedMatchCanceledBinderCallbacks(BaseImplementation.C0270b<TurnBasedMultiplayer.CancelMatchResult> resultHolder) {
            this.f1883XD = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: h */
        public void mo6558h(int i, String str) {
            this.f1883XD.mo4196b(new CancelMatchResultImpl(new Status(i), str));
        }
    }

    private final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XE */
        private final BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult> f1885XE;

        public TurnBasedMatchInitiatedBinderCallbacks(BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult> resultHolder) {
            this.f1885XE = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: q */
        public void mo6576q(DataHolder dataHolder) {
            this.f1885XE.mo4196b(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XF */
        private final BaseImplementation.C0270b<TurnBasedMultiplayer.LeaveMatchResult> f1887XF;

        public TurnBasedMatchLeftBinderCallbacks(BaseImplementation.C0270b<TurnBasedMultiplayer.LeaveMatchResult> resultHolder) {
            this.f1887XF = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: s */
        public void mo6578s(DataHolder dataHolder) {
            this.f1887XF.mo4196b(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XG */
        private final BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchResult> f1889XG;

        public TurnBasedMatchLoadedBinderCallbacks(BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchResult> resultHolder) {
            this.f1889XG = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: p */
        public void mo6575p(DataHolder dataHolder) {
            this.f1889XG.mo4196b(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends C0273a {

        /* renamed from: WY */
        final TurnBasedMatch f1890WY;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.f1890WY = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.f1890WY = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.f1890WY;
        }
    }

    private final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XH */
        private final BaseImplementation.C0270b<TurnBasedMultiplayer.UpdateMatchResult> f1892XH;

        public TurnBasedMatchUpdatedBinderCallbacks(BaseImplementation.C0270b<TurnBasedMultiplayer.UpdateMatchResult> resultHolder) {
            this.f1892XH = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: r */
        public void mo6577r(DataHolder dataHolder) {
            this.f1892XH.mo4196b(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {

        /* renamed from: XI */
        private final BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchesResult> f1894XI;

        public TurnBasedMatchesLoadedBinderCallbacks(BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchesResult> resultHolder) {
            this.f1894XI = (BaseImplementation.C0270b) C0348n.m857b(resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: b */
        public void mo6537b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f1894XI.mo4196b(new LoadMatchesResultImpl(new Status(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {

        /* renamed from: CM */
        private final Status f1895CM;

        /* renamed from: VP */
        private final String f1896VP;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.f1895CM = new Status(statusCode);
            this.f1896VP = achievementId;
        }

        public String getAchievementId() {
            return this.f1896VP;
        }

        public Status getStatus() {
            return this.f1895CM;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends C0273a implements Requests.UpdateRequestsResult {

        /* renamed from: XJ */
        private final RequestUpdateOutcomes f1897XJ;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.f1897XJ = RequestUpdateOutcomes.m3637V(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.f1897XJ.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.f1897XJ.getRequestOutcome(requestId);
        }
    }

    public GamesClientImpl(Context context, Looper looper, String gamePackageName, String accountName, GoogleApiClient.ConnectionCallbacks connectedListener, GoogleApiClient.OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView, Games.GamesOptions options) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.f1690Wi = gamePackageName;
        this.f1688Dd = (String) C0348n.m861i(accountName);
        this.f1696Wo = new Binder();
        this.f1691Wj = new HashMap();
        this.f1694Wm = PopupManager.m3177a(this, gravity);
        mo6708k(gamesContentView);
        this.f1697Wp = (long) hashCode();
        this.f1698Wq = options;
        registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this);
        registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public Room m2265R(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            return room;
        } finally {
            roomBuffer.release();
        }
    }

    /* renamed from: bw */
    private RealTimeSocket m2267bw(String str) {
        RealTimeSocket by = C1394kc.m5240hD() ? m2269by(str) : m2268bx(str);
        if (by != null) {
            this.f1691Wj.put(str, by);
        }
        return by;
    }

    /* renamed from: bx */
    private RealTimeSocket m2268bx(String str) {
        try {
            String bC = ((IGamesService) mo4435gS()).mo6873bC(str);
            if (bC == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress(bC));
            return new RealTimeSocketImpl(localSocket, str);
        } catch (RemoteException e) {
            GamesLog.m2554q("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        } catch (IOException e2) {
            GamesLog.m2554q("GamesClientImpl", "connect() call failed on socket: " + e2.getMessage());
            return null;
        }
    }

    /* renamed from: by */
    private RealTimeSocket m2269by(String str) {
        try {
            ParcelFileDescriptor bH = ((IGamesService) mo4435gS()).mo6878bH(str);
            if (bH != null) {
                GamesLog.m2552o("GamesClientImpl", "Created native libjingle socket.");
                return new LibjingleNativeSocket(bH);
            }
            GamesLog.m2554q("GamesClientImpl", "Unable to create socket for " + str);
            return null;
        } catch (RemoteException e) {
            GamesLog.m2554q("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    /* renamed from: jW */
    private void m2270jW() {
        this.f1692Wk = null;
    }

    /* renamed from: kt */
    private void m2271kt() {
        for (RealTimeSocket close : this.f1691Wj.values()) {
            try {
                close.close();
            } catch (IOException e) {
                GamesLog.m2551c("GamesClientImpl", "IOException:", e);
            }
        }
        this.f1691Wj.clear();
    }

    /* renamed from: a */
    public int mo6595a(RealTimeMultiplayer.ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) mo4435gS()).mo6790a((IGamesCallbacks) new RealTimeReliableMessageBinderCallbacks(reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public int mo6596a(byte[] bArr, String str, String[] strArr) {
        C0348n.m857b(strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) mo4435gS()).mo6849b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public Intent mo6597a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) mo4435gS()).mo6791a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent mo6598a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) mo4435gS()).mo6792a(i, bArr, i2, str);
            C0348n.m857b(bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent mo6599a(Room room, int i) {
        try {
            return ((IGamesService) mo4435gS()).mo6796a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent mo6600a(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) mo4435gS()).mo6797a(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4429a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.f1695Wn = bundle.getBoolean("show_welcome_popup");
        }
        super.mo4429a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void mo6601a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) mo4435gS()).mo6800a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.m2553p("GamesClientImpl", "service died");
            }
        }
    }

    /* renamed from: a */
    public void mo6602a(BaseImplementation.C0270b<Requests.LoadRequestsResult> bVar, int i, int i2, int i3) {
        try {
            ((IGamesService) mo4435gS()).mo6804a((IGamesCallbacks) new RequestsLoadedBinderCallbacks(bVar), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6603a(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> bVar, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6805a((IGamesCallbacks) new ExtendedGamesLoadedBinderCallback(bVar), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6604a(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6807a((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6605a(BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchesResult> bVar, int i, int[] iArr) {
        try {
            ((IGamesService) mo4435gS()).mo6808a((IGamesCallbacks) new TurnBasedMatchesLoadedBinderCallbacks(bVar), i, iArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6606a(BaseImplementation.C0270b<Leaderboards.LoadScoresResult> bVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) mo4435gS()).mo6811a((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(bVar), leaderboardScoreBuffer.mo7487ly().mo7488lz(), i, i2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6607a(BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult> bVar, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) mo4435gS()).mo6806a((IGamesCallbacks) new TurnBasedMatchInitiatedBinderCallbacks(bVar), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.mo7678lF(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6608a(BaseImplementation.C0270b<Snapshots.CommitSnapshotResult> bVar, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        C0348n.m852a(!snapshotContents.isClosed(), "Snapshot already closed");
        C0294a lK = snapshotMetadataChange.mo7805lK();
        if (lK != null) {
            lK.mo4325a(getContext().getCacheDir());
        }
        Contents contents = snapshotContents.getContents();
        snapshotContents.close();
        try {
            ((IGamesService) mo4435gS()).mo6825a((IGamesCallbacks) new SnapshotCommittedBinderCallbacks(bVar), snapshot.getMetadata().getSnapshotId(), snapshotMetadataChange, contents);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6609a(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6814a((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6610a(BaseImplementation.C0270b<Achievements.UpdateAchievementResult> bVar, String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6817a((IGamesCallbacks) bVar == null ? null : new AchievementUpdatedBinderCallback(bVar), str, i, this.f1694Wm.mo7051kL(), this.f1694Wm.mo7050kK());
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6611a(BaseImplementation.C0270b<Leaderboards.LoadScoresResult> bVar, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6816a((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(bVar), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6612a(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, String str, int i, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6818a((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), str, i, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6613a(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, String str, int i, boolean z, boolean z2) {
        char c = 65535;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                try {
                    ((IGamesService) mo4435gS()).mo6901d(new PlayersLoadedBinderCallback(bVar), str, i, z, z2);
                    return;
                } catch (RemoteException e) {
                    GamesLog.m2553p("GamesClientImpl", "service died");
                    return;
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    /* renamed from: a */
    public void mo6614a(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) mo4435gS()).mo6820a((IGamesCallbacks) new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6615a(BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchesResult> bVar, String str, int i, int[] iArr) {
        try {
            ((IGamesService) mo4435gS()).mo6821a((IGamesCallbacks) new TurnBasedMatchesLoadedBinderCallbacks(bVar), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6616a(BaseImplementation.C0270b<Leaderboards.SubmitScoreResult> bVar, String str, long j, String str2) {
        try {
            ((IGamesService) mo4435gS()).mo6823a((IGamesCallbacks) bVar == null ? null : new SubmitScoreBinderCallbacks(bVar), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6617a(BaseImplementation.C0270b<TurnBasedMultiplayer.LeaveMatchResult> bVar, String str, String str2) {
        try {
            ((IGamesService) mo4435gS()).mo6889c((IGamesCallbacks) new TurnBasedMatchLeftBinderCallbacks(bVar), str, str2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6618a(BaseImplementation.C0270b<Leaderboards.LoadPlayerScoreResult> bVar, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) mo4435gS()).mo6827a((IGamesCallbacks) new PlayerLeaderboardScoreLoadedBinderCallback(bVar), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6619a(BaseImplementation.C0270b<Requests.LoadRequestsResult> bVar, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) mo4435gS()).mo6828a((IGamesCallbacks) new RequestsLoadedBinderCallbacks(bVar), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6620a(BaseImplementation.C0270b<Leaderboards.LoadScoresResult> bVar, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6829a((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(bVar), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6621a(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, String str, String str2, int i, boolean z, boolean z2) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    c = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    c = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                try {
                    ((IGamesService) mo4435gS()).mo6830a((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), str, str2, i, z, z2);
                    return;
                } catch (RemoteException e) {
                    GamesLog.m2553p("GamesClientImpl", "service died");
                    return;
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    /* renamed from: a */
    public void mo6622a(BaseImplementation.C0270b<Snapshots.OpenSnapshotResult> bVar, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        C0348n.m852a(!snapshotContents.isClosed(), "SnapshotContents already closed");
        C0294a lK = snapshotMetadataChange.mo7805lK();
        if (lK != null) {
            lK.mo4325a(getContext().getCacheDir());
        }
        Contents contents = snapshotContents.getContents();
        snapshotContents.close();
        try {
            ((IGamesService) mo4435gS()).mo6831a((IGamesCallbacks) new SnapshotOpenedBinderCallbacks(bVar), str, str2, snapshotMetadataChange, contents);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6623a(BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult> bVar, String str, String str2, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6867b((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(bVar), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6624a(BaseImplementation.C0270b<Quests.LoadQuestsResult> bVar, String str, String str2, boolean z, String[] strArr) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6835a((IGamesCallbacks) new QuestsLoadedBinderCallbacks(bVar), str, str2, strArr, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6625a(BaseImplementation.C0270b<Quests.LoadQuestsResult> bVar, String str, String str2, int[] iArr, int i, boolean z) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6833a((IGamesCallbacks) new QuestsLoadedBinderCallbacks(bVar), str, str2, iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6626a(BaseImplementation.C0270b<Requests.UpdateRequestsResult> bVar, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) mo4435gS()).mo6834a((IGamesCallbacks) new RequestsUpdatedBinderCallbacks(bVar), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6627a(BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6891c((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6628a(BaseImplementation.C0270b<TurnBasedMultiplayer.UpdateMatchResult> bVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) mo4435gS()).mo6837a((IGamesCallbacks) new TurnBasedMatchUpdatedBinderCallbacks(bVar), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6629a(BaseImplementation.C0270b<TurnBasedMultiplayer.UpdateMatchResult> bVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) mo4435gS()).mo6838a((IGamesCallbacks) new TurnBasedMatchUpdatedBinderCallbacks(bVar), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6630a(BaseImplementation.C0270b<Requests.SendRequestResult> bVar, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) mo4435gS()).mo6840a((IGamesCallbacks) new RequestSentBinderCallbacks(bVar), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6631a(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6892c((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6632a(BaseImplementation.C0270b<Status> bVar, boolean z, Bundle bundle) {
        try {
            ((IGamesService) mo4435gS()).mo6842a((IGamesCallbacks) new ContactSettingsUpdatedBinderCallback(bVar), z, bundle);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6633a(BaseImplementation.C0270b<Events.LoadEventsResult> bVar, boolean z, String... strArr) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6843a((IGamesCallbacks) new EventsLoadedBinderCallback(bVar), z, strArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6634a(BaseImplementation.C0270b<Quests.LoadQuestsResult> bVar, int[] iArr, int i, boolean z) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6845a((IGamesCallbacks) new QuestsLoadedBinderCallbacks(bVar), iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6635a(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, String[] strArr) {
        try {
            ((IGamesService) mo4435gS()).mo6893c((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), strArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.f1698Wq.f1621Vs);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.f1698Wq.f1622Vt);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.f1698Wq.f1623Vu);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.f1698Wq.f1624Vv);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.f1698Wq.f1625Vw);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.f1698Wq.f1626Vx);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.f1698Wq.f1627Vy);
        kVar.mo4512a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f1688Dd, mo4434gR(), this.f1690Wi, this.f1694Wm.mo7051kL(), locale, bundle);
    }

    /* renamed from: a */
    public void mo6636a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((IGamesService) mo4435gS()).mo6809a((IGamesCallbacks) new InvitationReceivedBinderCallback(onInvitationReceivedListener), this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6637a(RoomConfig roomConfig) {
        m2271kt();
        try {
            ((IGamesService) mo4435gS()).mo6812a((IGamesCallbacks) new RoomBinderCallbacks(roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), (IBinder) this.f1696Wo, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6638a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6886c((IGamesCallbacks) new RoomBinderCallbacks(roomUpdateListener), str);
            m2271kt();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6639a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) mo4435gS()).mo6855b((IGamesCallbacks) new MatchUpdateReceivedBinderCallback(onTurnBasedMatchUpdateReceivedListener), this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6640a(QuestUpdateListener questUpdateListener) {
        try {
            ((IGamesService) mo4435gS()).mo6898d((IGamesCallbacks) new QuestUpdateBinderCallback(questUpdateListener), this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6641a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((IGamesService) mo4435gS()).mo6884c((IGamesCallbacks) new RequestReceivedBinderCallback(onRequestReceivedListener), this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo6642a(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        C0348n.m852a(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents contents = snapshotContents.getContents();
        snapshotContents.close();
        try {
            ((IGamesService) mo4435gS()).mo6801a(contents);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: az */
    public IGamesService mo3832j(IBinder iBinder) {
        return IGamesService.Stub.m2876aB(iBinder);
    }

    /* renamed from: b */
    public Intent mo6644b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) mo4435gS()).mo6850b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: b */
    public Intent mo6645b(int[] iArr) {
        try {
            return ((IGamesService) mo4435gS()).mo6851b(iArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: b */
    public void mo6646b(BaseImplementation.C0270b<Status> bVar) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6802a((IGamesCallbacks) new SignOutCompleteBinderCallbacks(bVar));
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6647b(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6854b((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6648b(BaseImplementation.C0270b<Achievements.UpdateAchievementResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6824a((IGamesCallbacks) bVar == null ? null : new AchievementUpdatedBinderCallback(bVar), str, this.f1694Wm.mo7051kL(), this.f1694Wm.mo7050kK());
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6649b(BaseImplementation.C0270b<Achievements.UpdateAchievementResult> bVar, String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6860b((IGamesCallbacks) bVar == null ? null : new AchievementUpdatedBinderCallback(bVar), str, i, this.f1694Wm.mo7051kL(), this.f1694Wm.mo7050kK());
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6650b(BaseImplementation.C0270b<Leaderboards.LoadScoresResult> bVar, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6859b((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(bVar), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6651b(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6819a((IGamesCallbacks) new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6652b(BaseImplementation.C0270b<Quests.ClaimMilestoneResult> bVar, String str, String str2) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6916f(new QuestMilestoneClaimBinderCallbacks(bVar, str2), str, str2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6653b(BaseImplementation.C0270b<Leaderboards.LoadScoresResult> bVar, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6865b(new LeaderboardScoresLoadedBinderCallback(bVar), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6654b(BaseImplementation.C0270b<Achievements.LoadAchievementsResult> bVar, String str, String str2, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6832a((IGamesCallbacks) new AchievementsLoadedBinderCallback(bVar), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6655b(BaseImplementation.C0270b<Snapshots.OpenSnapshotResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6911e((IGamesCallbacks) new SnapshotOpenedBinderCallbacks(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6656b(BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult> bVar, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6869b((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6657b(BaseImplementation.C0270b<Quests.LoadQuestsResult> bVar, boolean z, String[] strArr) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6847a((IGamesCallbacks) new QuestsLoadedBinderCallbacks(bVar), strArr, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6658b(BaseImplementation.C0270b<Requests.UpdateRequestsResult> bVar, String[] strArr) {
        try {
            ((IGamesService) mo4435gS()).mo6846a((IGamesCallbacks) new RequestsUpdatedBinderCallbacks(bVar), strArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo6659b(RoomConfig roomConfig) {
        m2271kt();
        try {
            ((IGamesService) mo4435gS()).mo6813a((IGamesCallbacks) new RoomBinderCallbacks(roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), (IBinder) this.f1696Wo, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: bA */
    public void mo6660bA(String str) {
        try {
            ((IGamesService) mo4435gS()).mo6848a(str, this.f1694Wm.mo7051kL(), this.f1694Wm.mo7050kK());
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: bu */
    public Intent mo6661bu(String str) {
        try {
            return ((IGamesService) mo4435gS()).mo6879bu(str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: bv */
    public void mo6662bv(String str) {
        try {
            ((IGamesService) mo4435gS()).mo6877bG(str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: bz */
    public Intent mo6663bz(String str) {
        try {
            return ((IGamesService) mo4435gS()).mo6880bz(str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: c */
    public void mo6664c(BaseImplementation.C0270b<Invitations.LoadInvitationsResult> bVar, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6803a((IGamesCallbacks) new InvitationsLoadedBinderCallback(bVar), i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6665c(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6883c((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6666c(BaseImplementation.C0270b<Achievements.UpdateAchievementResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6863b((IGamesCallbacks) bVar == null ? null : new AchievementUpdatedBinderCallback(bVar), str, this.f1694Wm.mo7051kL(), this.f1694Wm.mo7050kK());
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6667c(BaseImplementation.C0270b<Players.LoadXpStreamResult> bVar, String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6858b((IGamesCallbacks) new PlayerXpStreamLoadedBinderCallback(bVar), str, i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6668c(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6909e(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6669c(BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult> bVar, String str, String str2) {
        try {
            ((IGamesService) mo4435gS()).mo6902d((IGamesCallbacks) new TurnBasedMatchInitiatedBinderCallbacks(bVar), str, str2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6670c(BaseImplementation.C0270b<Snapshots.LoadSnapshotsResult> bVar, String str, String str2, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6890c((IGamesCallbacks) new SnapshotsLoadedBinderCallbacks(bVar), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6671c(BaseImplementation.C0270b<Leaderboards.LeaderboardMetadataResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6903d((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6672c(BaseImplementation.C0270b<Achievements.LoadAchievementsResult> bVar, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6841a((IGamesCallbacks) new AchievementsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo6673c(BaseImplementation.C0270b<Requests.UpdateRequestsResult> bVar, String[] strArr) {
        try {
            ((IGamesService) mo4435gS()).mo6870b((IGamesCallbacks) new RequestsUpdatedBinderCallbacks(bVar), strArr);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4432c(String... strArr) {
        boolean z = false;
        boolean z2 = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z2 = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                z = true;
            }
        }
        if (z) {
            C0348n.m853a(!z2, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
            return;
        }
        C0348n.m853a(z2, "Games APIs requires %s to function.", Scopes.GAMES);
    }

    public void connect() {
        m2270jW();
        super.connect();
    }

    /* renamed from: d */
    public int mo6674d(byte[] bArr, String str) {
        try {
            return ((IGamesService) mo4435gS()).mo6849b(bArr, str, (String[]) null);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: d */
    public void mo6675d(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6907e(new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void mo6676d(BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6955l(new TurnBasedMatchInitiatedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void mo6677d(BaseImplementation.C0270b<Players.LoadXpStreamResult> bVar, String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6887c((IGamesCallbacks) new PlayerXpStreamLoadedBinderCallback(bVar), str, i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void mo6678d(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6915f(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void mo6679d(BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult> bVar, String str, String str2) {
        try {
            ((IGamesService) mo4435gS()).mo6910e((IGamesCallbacks) new TurnBasedMatchInitiatedBinderCallbacks(bVar), str, str2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void mo6680d(BaseImplementation.C0270b<Notifications.GameMuteStatusChangeResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6836a((IGamesCallbacks) new GameMuteStatusChangedBinderCallback(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void mo6681d(BaseImplementation.C0270b<Events.LoadEventsResult> bVar, boolean z) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6917f((IGamesCallbacks) new EventsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: dB */
    public void mo6682dB(int i) {
        this.f1694Wm.setGravity(i);
    }

    /* renamed from: dC */
    public void mo6683dC(int i) {
        try {
            ((IGamesService) mo4435gS()).mo6905dC(i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.f1695Wn = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) mo4435gS();
                iGamesService.mo6950ku();
                this.f1689Wh.flush();
                iGamesService.mo6963q(this.f1697Wp);
            } catch (RemoteException e) {
                GamesLog.m2553p("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        m2271kt();
        super.disconnect();
    }

    /* renamed from: e */
    public void mo6684e(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6897d(new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void mo6685e(BaseImplementation.C0270b<TurnBasedMultiplayer.InitiateMatchResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6956m(new TurnBasedMatchInitiatedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void mo6686e(BaseImplementation.C0270b<Invitations.LoadInvitationsResult> bVar, String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6861b((IGamesCallbacks) new InvitationsLoadedBinderCallback(bVar), str, i, false);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void mo6687e(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6888c(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void mo6688e(BaseImplementation.C0270b<Snapshots.LoadSnapshotsResult> bVar, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6904d((IGamesCallbacks) new SnapshotsLoadedBinderCallbacks(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void mo6689f(BaseImplementation.C0270b<GamesMetadata.LoadGamesResult> bVar) {
        try {
            ((IGamesService) mo4435gS()).mo6896d(new GamesLoadedBinderCallback(bVar));
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void mo6690f(BaseImplementation.C0270b<TurnBasedMultiplayer.LeaveMatchResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6959o((IGamesCallbacks) new TurnBasedMatchLeftBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void mo6691f(BaseImplementation.C0270b<Requests.LoadRequestSummariesResult> bVar, String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6815a((IGamesCallbacks) new RequestSummariesLoadedBinderCallbacks(bVar), str, i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void mo6692f(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6862b((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void mo6693f(BaseImplementation.C0270b<Players.LoadProfileSettingsResult> bVar, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6921g((IGamesCallbacks) new ProfileSettingsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: fD */
    public Bundle mo4273fD() {
        try {
            Bundle fD = ((IGamesService) mo4435gS()).mo6918fD();
            if (fD == null) {
                return fD;
            }
            fD.setClassLoader(GamesClientImpl.class.getClassLoader());
            return fD;
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: g */
    public void mo6694g(BaseImplementation.C0270b<Players.LoadOwnerCoverPhotoUrisResult> bVar) {
        try {
            ((IGamesService) mo4435gS()).mo6928j(new OwnerCoverPhotoUrisLoadedBinderCallback(bVar));
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void mo6695g(BaseImplementation.C0270b<TurnBasedMultiplayer.CancelMatchResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6957n((IGamesCallbacks) new TurnBasedMatchCanceledBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void mo6696g(BaseImplementation.C0270b<Players.LoadPlayersResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) mo4435gS()).mo6866b((IGamesCallbacks) new PlayersLoadedBinderCallback(bVar), str, (String) null, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void mo6697g(BaseImplementation.C0270b<Status> bVar, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6925h((IGamesCallbacks) new ProfileSettingsUpdatedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    /* renamed from: h */
    public void mo6698h(BaseImplementation.C0270b<Acls.LoadAclResult> bVar) {
        try {
            ((IGamesService) mo4435gS()).mo6924h((IGamesCallbacks) new NotifyAclLoadedBinderCallback(bVar));
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: h */
    public void mo6699h(BaseImplementation.C0270b<TurnBasedMultiplayer.LoadMatchResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6961p((IGamesCallbacks) new TurnBasedMatchLoadedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: h */
    public void mo6700h(BaseImplementation.C0270b<Notifications.ContactSettingLoadResult> bVar, boolean z) {
        try {
            ((IGamesService) mo4435gS()).mo6912e((IGamesCallbacks) new ContactSettingsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    @Deprecated
    /* renamed from: i */
    public void mo6701i(BaseImplementation.C0270b<Notifications.ContactSettingLoadResult> bVar) {
        try {
            ((IGamesService) mo4435gS()).mo6912e((IGamesCallbacks) new ContactSettingsLoadedBinderCallback(bVar), false);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: i */
    public void mo6702i(BaseImplementation.C0270b<Quests.AcceptQuestResult> bVar, String str) {
        try {
            this.f1689Wh.flush();
            ((IGamesService) mo4435gS()).mo6974u((IGamesCallbacks) new QuestAcceptedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: j */
    public void mo6703j(BaseImplementation.C0270b<Notifications.InboxCountResult> bVar) {
        try {
            ((IGamesService) mo4435gS()).mo6972t(new InboxCountsLoadedBinderCallback(bVar), (String) null);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: j */
    public void mo6704j(BaseImplementation.C0270b<Snapshots.DeleteSnapshotResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6966r((IGamesCallbacks) new SnapshotDeletedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: jX */
    public String mo6705jX() {
        try {
            return ((IGamesService) mo4435gS()).mo6930jX();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: jY */
    public String mo6706jY() {
        try {
            return ((IGamesService) mo4435gS()).mo6931jY();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: jZ */
    public Player mo6707jZ() {
        PlayerBuffer playerBuffer;
        mo4433dK();
        synchronized (this) {
            if (this.f1692Wk == null) {
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) mo4435gS()).mo6951kw());
                    if (playerBuffer.getCount() > 0) {
                        this.f1692Wk = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.m2553p("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.f1692Wk;
    }

    /* renamed from: k */
    public void mo6708k(View view) {
        this.f1694Wm.mo7052l(view);
    }

    /* renamed from: k */
    public void mo6709k(BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6908e((IGamesCallbacks) new ExtendedGamesLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: ka */
    public Game mo6710ka() {
        GameBuffer gameBuffer;
        mo4433dK();
        synchronized (this) {
            if (this.f1693Wl == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) mo4435gS()).mo6953ky());
                    if (gameBuffer.getCount() > 0) {
                        this.f1693Wl = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.m2553p("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.release();
                    throw th;
                }
            }
        }
        return this.f1693Wl;
    }

    /* renamed from: kb */
    public Intent mo6711kb() {
        try {
            return ((IGamesService) mo4435gS()).mo6936kb();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: kc */
    public Intent mo6712kc() {
        try {
            return ((IGamesService) mo4435gS()).mo6937kc();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: kd */
    public Intent mo6713kd() {
        try {
            return ((IGamesService) mo4435gS()).mo6938kd();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: ke */
    public Intent mo6714ke() {
        try {
            return ((IGamesService) mo4435gS()).mo6939ke();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: kf */
    public void mo6715kf() {
        try {
            ((IGamesService) mo4435gS()).mo6965r(this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: kg */
    public void mo6716kg() {
        try {
            ((IGamesService) mo4435gS()).mo6968s(this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: kh */
    public void mo6717kh() {
        try {
            ((IGamesService) mo4435gS()).mo6973u(this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: ki */
    public void mo6718ki() {
        try {
            ((IGamesService) mo4435gS()).mo6971t(this.f1697Wp);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: kj */
    public Intent mo6719kj() {
        try {
            return ((IGamesService) mo4435gS()).mo6940kj();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: kk */
    public Intent mo6720kk() {
        try {
            return ((IGamesService) mo4435gS()).mo6941kk();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: kl */
    public int mo6721kl() {
        try {
            return ((IGamesService) mo4435gS()).mo6942kl();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return 4368;
        }
    }

    /* renamed from: km */
    public String mo6722km() {
        try {
            return ((IGamesService) mo4435gS()).mo6943km();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: kn */
    public int mo6723kn() {
        try {
            return ((IGamesService) mo4435gS()).mo6944kn();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: ko */
    public Intent mo6724ko() {
        try {
            return ((IGamesService) mo4435gS()).mo6945ko();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: kp */
    public int mo6725kp() {
        try {
            return ((IGamesService) mo4435gS()).mo6946kp();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: kq */
    public int mo6726kq() {
        try {
            return ((IGamesService) mo4435gS()).mo6947kq();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: kr */
    public int mo6727kr() {
        try {
            return ((IGamesService) mo4435gS()).mo6948kr();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: ks */
    public int mo6728ks() {
        try {
            return ((IGamesService) mo4435gS()).mo6949ks();
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: ku */
    public void mo6729ku() {
        if (isConnected()) {
            try {
                ((IGamesService) mo4435gS()).mo6950ku();
            } catch (RemoteException e) {
                GamesLog.m2553p("GamesClientImpl", "service died");
            }
        }
    }

    /* renamed from: l */
    public void mo6730l(BaseImplementation.C0270b<GamesMetadata.LoadGameInstancesResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6914f((IGamesCallbacks) new GameInstancesLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: m */
    public void mo6731m(BaseImplementation.C0270b<GamesMetadata.LoadGameSearchSuggestionsResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6964q(new GameSearchSuggestionsLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: n */
    public void mo6732n(BaseImplementation.C0270b<Players.LoadXpForGameCategoriesResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6969s((IGamesCallbacks) new PlayerXpForGameCategoriesLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: n */
    public void mo6733n(String str, int i) {
        this.f1689Wh.mo7319n(str, i);
    }

    /* renamed from: o */
    public void mo6734o(BaseImplementation.C0270b<Invitations.LoadInvitationsResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6932k(new InvitationsLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: o */
    public void mo6735o(String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6960o(str, i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.f1695Wn) {
            this.f1694Wm.mo7049kJ();
            this.f1695Wn = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.f1695Wn = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    /* renamed from: p */
    public void mo6736p(BaseImplementation.C0270b<Status> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6929j(new NotifyAclUpdatedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: p */
    public void mo6737p(String str, int i) {
        try {
            ((IGamesService) mo4435gS()).mo6962p(str, i);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: q */
    public void mo6738q(BaseImplementation.C0270b<Notifications.GameMuteStatusLoadResult> bVar, String str) {
        try {
            ((IGamesService) mo4435gS()).mo6927i(new GameMuteStatusLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.m2553p("GamesClientImpl", "service died");
        }
    }

    /* renamed from: t */
    public RealTimeSocket mo6739t(String str, String str2) {
        if (str2 == null || !ParticipantUtils.m3698bS(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = this.f1691Wj.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? m2267bw(str2) : realTimeSocket;
    }
}
