package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.OnGamesLoadedListener;
import com.google.android.gms.games.OnPlayersLoadedListener;
import com.google.android.gms.games.OnSignOutCompleteListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.RealTimeSocket;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.OnAchievementUpdatedListener;
import com.google.android.gms.games.achievement.OnAchievementsLoadedListener;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardMetadataLoadedListener;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.android.gms.games.leaderboard.OnScoreSubmittedListener;
import com.google.android.gms.games.leaderboard.SubmitScoreResult;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.OnInvitationsLoadedListener;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.C0397a;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.C0479az;
import com.google.android.gms.internal.C0597k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.au */
public final class C0429au extends C0597k<C0479az> {

    /* renamed from: dA */
    private final Map<String, C0487bb> f1014dA;

    /* renamed from: dB */
    private PlayerEntity f1015dB;

    /* renamed from: dC */
    private GameEntity f1016dC;

    /* renamed from: dD */
    private final C0483ba f1017dD;

    /* renamed from: dE */
    private boolean f1018dE = false;

    /* renamed from: dF */
    private final Binder f1019dF;

    /* renamed from: dG */
    private final long f1020dG;

    /* renamed from: dH */
    private final boolean f1021dH;

    /* renamed from: dz */
    private final String f1022dz;

    /* renamed from: g */
    private final String f1023g;

    /* renamed from: com.google.android.gms.internal.au$a */
    abstract class C0430a extends C0449c {

        /* renamed from: dI */
        private final ArrayList<String> f1024dI = new ArrayList<>();

        C0430a(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar);
            for (String add : strArr) {
                this.f1024dI.add(add);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4641a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            mo4642a(roomStatusUpdateListener, room, this.f1024dI);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4642a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    /* renamed from: com.google.android.gms.internal.au$aa */
    final class C0431aa extends C0430a {
        C0431aa(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4642a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ab */
    final class C0432ab extends C0430a {
        C0432ab(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4642a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ac */
    final class C0433ac extends C0430a {
        C0433ac(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4642a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ad */
    final class C0434ad extends C0430a {
        C0434ad(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4642a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ae */
    final class C0435ae extends C0428at {

        /* renamed from: dY */
        private final OnPlayersLoadedListener f1031dY;

        C0435ae(OnPlayersLoadedListener onPlayersLoadedListener) {
            this.f1031dY = (OnPlayersLoadedListener) C0621s.m1887b(onPlayersLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: e */
        public void mo4560e(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0436af(this.f1031dY, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$af */
    final class C0436af extends C0597k<C0479az>.c<OnPlayersLoadedListener> {
        C0436af(OnPlayersLoadedListener onPlayersLoadedListener, C0344d dVar) {
            super(onPlayersLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(OnPlayersLoadedListener onPlayersLoadedListener, C0344d dVar) {
            onPlayersLoadedListener.onPlayersLoaded(dVar.getStatusCode(), new PlayerBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ag */
    final class C0437ag extends C0597k<C0479az>.b<RealTimeReliableMessageSentListener> {

        /* renamed from: dZ */
        private final String f1034dZ;

        /* renamed from: ea */
        private final int f1035ea;

        /* renamed from: p */
        private final int f1036p;

        C0437ag(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener, int i, int i2, String str) {
            super(realTimeReliableMessageSentListener);
            this.f1036p = i;
            this.f1035ea = i2;
            this.f1034dZ = str;
        }

        /* renamed from: a */
        public void mo4646a(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener) {
            if (realTimeReliableMessageSentListener != null) {
                realTimeReliableMessageSentListener.onRealTimeMessageSent(this.f1036p, this.f1035ea, this.f1034dZ);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ah */
    final class C0438ah extends C0428at {

        /* renamed from: eb */
        final RealTimeReliableMessageSentListener f1038eb;

        public C0438ah(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener) {
            this.f1038eb = realTimeReliableMessageSentListener;
        }

        /* renamed from: a */
        public void mo4549a(int i, int i2, String str) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0437ag(this.f1038eb, i, i2, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ai */
    final class C0439ai extends C0449c {
        C0439ai(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4641a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$aj */
    final class C0440aj extends C0428at {

        /* renamed from: ec */
        private final RoomUpdateListener f1041ec;

        /* renamed from: ed */
        private final RoomStatusUpdateListener f1042ed;

        /* renamed from: ee */
        private final RealTimeMessageReceivedListener f1043ee;

        public C0440aj(RoomUpdateListener roomUpdateListener) {
            this.f1041ec = (RoomUpdateListener) C0621s.m1887b(roomUpdateListener, (Object) "Callbacks must not be null");
            this.f1042ed = null;
            this.f1043ee = null;
        }

        public C0440aj(RoomUpdateListener roomUpdateListener, RoomStatusUpdateListener roomStatusUpdateListener, RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.f1041ec = (RoomUpdateListener) C0621s.m1887b(roomUpdateListener, (Object) "Callbacks must not be null");
            this.f1042ed = roomStatusUpdateListener;
            this.f1043ee = realTimeMessageReceivedListener;
        }

        /* renamed from: a */
        public void mo4553a(C0344d dVar, String[] strArr) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0432ab(this.f1042ed, dVar, strArr));
        }

        /* renamed from: b */
        public void mo4555b(C0344d dVar, String[] strArr) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0433ac(this.f1042ed, dVar, strArr));
        }

        /* renamed from: c */
        public void mo4557c(C0344d dVar, String[] strArr) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0434ad(this.f1042ed, dVar, strArr));
        }

        /* renamed from: d */
        public void mo4559d(C0344d dVar, String[] strArr) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0472z(this.f1042ed, dVar, strArr));
        }

        /* renamed from: e */
        public void mo4561e(C0344d dVar, String[] strArr) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0471y(this.f1042ed, dVar, strArr));
        }

        /* renamed from: f */
        public void mo4563f(C0344d dVar, String[] strArr) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0431aa(this.f1042ed, dVar, strArr));
        }

        /* renamed from: n */
        public void mo4571n(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0443am(this.f1041ec, dVar));
        }

        /* renamed from: o */
        public void mo4572o(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0462p(this.f1041ec, dVar));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0467u(this.f1041ec, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0469w(this.f1042ed, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0470x(this.f1042ed, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            C0475ax.m1062a("GamesClient", "RoomBinderCallbacks: onRealTimeMessageReceived");
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0468v(this.f1043ee, message));
        }

        /* renamed from: p */
        public void mo4579p(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0442al(this.f1042ed, dVar));
        }

        /* renamed from: q */
        public void mo4580q(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0439ai(this.f1042ed, dVar));
        }

        /* renamed from: r */
        public void mo4581r(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0441ak(this.f1041ec, dVar));
        }

        /* renamed from: s */
        public void mo4582s(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0454h(this.f1042ed, dVar));
        }

        /* renamed from: t */
        public void mo4583t(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0455i(this.f1042ed, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ak */
    final class C0441ak extends C0448b {
        C0441ak(RoomUpdateListener roomUpdateListener, C0344d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4648a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$al */
    final class C0442al extends C0449c {
        C0442al(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4641a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$am */
    final class C0443am extends C0448b {
        public C0443am(RoomUpdateListener roomUpdateListener, C0344d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4648a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$an */
    final class C0444an extends C0428at {

        /* renamed from: ef */
        private final OnSignOutCompleteListener f1048ef;

        public C0444an(OnSignOutCompleteListener onSignOutCompleteListener) {
            this.f1048ef = (OnSignOutCompleteListener) C0621s.m1887b(onSignOutCompleteListener, (Object) "Listener must not be null");
        }

        public void onSignOutComplete() {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0445ao(this.f1048ef));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ao */
    final class C0445ao extends C0597k<C0479az>.b<OnSignOutCompleteListener> {
        public C0445ao(OnSignOutCompleteListener onSignOutCompleteListener) {
            super(onSignOutCompleteListener);
        }

        /* renamed from: a */
        public void mo4646a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.onSignOutComplete();
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$ap */
    final class C0446ap extends C0428at {

        /* renamed from: eg */
        private final OnScoreSubmittedListener f1051eg;

        public C0446ap(OnScoreSubmittedListener onScoreSubmittedListener) {
            this.f1051eg = (OnScoreSubmittedListener) C0621s.m1887b(onScoreSubmittedListener, (Object) "Listener must not be null");
        }

        /* renamed from: d */
        public void mo4558d(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0447aq(this.f1051eg, new SubmitScoreResult(dVar)));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$aq */
    final class C0447aq extends C0597k<C0479az>.b<OnScoreSubmittedListener> {

        /* renamed from: eh */
        private final SubmitScoreResult f1053eh;

        public C0447aq(OnScoreSubmittedListener onScoreSubmittedListener, SubmitScoreResult submitScoreResult) {
            super(onScoreSubmittedListener);
            this.f1053eh = submitScoreResult;
        }

        /* renamed from: a */
        public void mo4646a(OnScoreSubmittedListener onScoreSubmittedListener) {
            onScoreSubmittedListener.onScoreSubmitted(this.f1053eh.getStatusCode(), this.f1053eh);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$b */
    abstract class C0448b extends C0597k<C0479az>.c<RoomUpdateListener> {
        C0448b(RoomUpdateListener roomUpdateListener, C0344d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(RoomUpdateListener roomUpdateListener, C0344d dVar) {
            mo4648a(roomUpdateListener, C0429au.this.m956x(dVar), dVar.getStatusCode());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4648a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    /* renamed from: com.google.android.gms.internal.au$c */
    abstract class C0449c extends C0597k<C0479az>.c<RoomStatusUpdateListener> {
        C0449c(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar) {
            mo4641a(roomStatusUpdateListener, C0429au.this.m956x(dVar));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4641a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    /* renamed from: com.google.android.gms.internal.au$d */
    final class C0450d extends C0428at {

        /* renamed from: dK */
        private final OnAchievementUpdatedListener f1057dK;

        C0450d(OnAchievementUpdatedListener onAchievementUpdatedListener) {
            this.f1057dK = (OnAchievementUpdatedListener) C0621s.m1887b(onAchievementUpdatedListener, (Object) "Listener must not be null");
        }

        public void onAchievementUpdated(int statusCode, String achievementId) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0451e(this.f1057dK, statusCode, achievementId));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$e */
    final class C0451e extends C0597k<C0479az>.b<OnAchievementUpdatedListener> {

        /* renamed from: dL */
        private final String f1059dL;

        /* renamed from: p */
        private final int f1060p;

        C0451e(OnAchievementUpdatedListener onAchievementUpdatedListener, int i, String str) {
            super(onAchievementUpdatedListener);
            this.f1060p = i;
            this.f1059dL = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(OnAchievementUpdatedListener onAchievementUpdatedListener) {
            onAchievementUpdatedListener.onAchievementUpdated(this.f1060p, this.f1059dL);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$f */
    final class C0452f extends C0428at {

        /* renamed from: dM */
        private final OnAchievementsLoadedListener f1062dM;

        C0452f(OnAchievementsLoadedListener onAchievementsLoadedListener) {
            this.f1062dM = (OnAchievementsLoadedListener) C0621s.m1887b(onAchievementsLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: b */
        public void mo4554b(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0453g(this.f1062dM, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$g */
    final class C0453g extends C0597k<C0479az>.c<OnAchievementsLoadedListener> {
        C0453g(OnAchievementsLoadedListener onAchievementsLoadedListener, C0344d dVar) {
            super(onAchievementsLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(OnAchievementsLoadedListener onAchievementsLoadedListener, C0344d dVar) {
            onAchievementsLoadedListener.onAchievementsLoaded(dVar.getStatusCode(), new AchievementBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$h */
    final class C0454h extends C0449c {
        C0454h(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4641a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$i */
    final class C0455i extends C0449c {
        C0455i(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4641a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$j */
    final class C0456j extends C0428at {

        /* renamed from: dN */
        private final OnGamesLoadedListener f1067dN;

        C0456j(OnGamesLoadedListener onGamesLoadedListener) {
            this.f1067dN = (OnGamesLoadedListener) C0621s.m1887b(onGamesLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: g */
        public void mo4564g(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0457k(this.f1067dN, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$k */
    final class C0457k extends C0597k<C0479az>.c<OnGamesLoadedListener> {
        C0457k(OnGamesLoadedListener onGamesLoadedListener, C0344d dVar) {
            super(onGamesLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(OnGamesLoadedListener onGamesLoadedListener, C0344d dVar) {
            onGamesLoadedListener.onGamesLoaded(dVar.getStatusCode(), new GameBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$l */
    final class C0458l extends C0428at {

        /* renamed from: dO */
        private final OnInvitationReceivedListener f1070dO;

        C0458l(OnInvitationReceivedListener onInvitationReceivedListener) {
            this.f1070dO = onInvitationReceivedListener;
        }

        /* renamed from: k */
        public void mo4568k(C0344d dVar) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dVar);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                if (invitation != null) {
                    C0429au.this.mo5431a((C0597k<T>.b<?>) new C0459m(this.f1070dO, invitation));
                }
            } finally {
                invitationBuffer.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.au$m */
    final class C0459m extends C0597k<C0479az>.b<OnInvitationReceivedListener> {

        /* renamed from: dP */
        private final Invitation f1072dP;

        C0459m(OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            super(onInvitationReceivedListener);
            this.f1072dP = invitation;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.f1072dP);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$n */
    final class C0460n extends C0428at {

        /* renamed from: dQ */
        private final OnInvitationsLoadedListener f1074dQ;

        C0460n(OnInvitationsLoadedListener onInvitationsLoadedListener) {
            this.f1074dQ = onInvitationsLoadedListener;
        }

        /* renamed from: j */
        public void mo4567j(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0461o(this.f1074dQ, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$o */
    final class C0461o extends C0597k<C0479az>.c<OnInvitationsLoadedListener> {
        C0461o(OnInvitationsLoadedListener onInvitationsLoadedListener, C0344d dVar) {
            super(onInvitationsLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(OnInvitationsLoadedListener onInvitationsLoadedListener, C0344d dVar) {
            onInvitationsLoadedListener.onInvitationsLoaded(dVar.getStatusCode(), new InvitationBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$p */
    final class C0462p extends C0448b {
        public C0462p(RoomUpdateListener roomUpdateListener, C0344d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4648a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$q */
    final class C0463q extends C0428at {

        /* renamed from: dR */
        private final OnLeaderboardScoresLoadedListener f1078dR;

        C0463q(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener) {
            this.f1078dR = (OnLeaderboardScoresLoadedListener) C0621s.m1887b(onLeaderboardScoresLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: a */
        public void mo4552a(C0344d dVar, C0344d dVar2) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0464r(this.f1078dR, dVar, dVar2));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$r */
    final class C0464r extends C0597k<C0479az>.b<OnLeaderboardScoresLoadedListener> {

        /* renamed from: dS */
        private final C0344d f1080dS;

        /* renamed from: dT */
        private final C0344d f1081dT;

        C0464r(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, C0344d dVar, C0344d dVar2) {
            super(onLeaderboardScoresLoadedListener);
            this.f1080dS = dVar;
            this.f1081dT = dVar2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener) {
            C0344d dVar;
            C0344d dVar2 = null;
            C0344d dVar3 = this.f1080dS;
            C0344d dVar4 = this.f1081dT;
            if (onLeaderboardScoresLoadedListener != null) {
                try {
                    onLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(dVar4.getStatusCode(), new LeaderboardBuffer(dVar3), new LeaderboardScoreBuffer(dVar4));
                    dVar = null;
                } catch (Throwable th) {
                    if (dVar3 != null) {
                        dVar3.close();
                    }
                    if (dVar4 != null) {
                        dVar4.close();
                    }
                    throw th;
                }
            } else {
                dVar2 = dVar4;
                dVar = dVar3;
            }
            if (dVar != null) {
                dVar.close();
            }
            if (dVar2 != null) {
                dVar2.close();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
            if (this.f1080dS != null) {
                this.f1080dS.close();
            }
            if (this.f1081dT != null) {
                this.f1081dT.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.au$s */
    final class C0465s extends C0428at {

        /* renamed from: dU */
        private final OnLeaderboardMetadataLoadedListener f1083dU;

        C0465s(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener) {
            this.f1083dU = (OnLeaderboardMetadataLoadedListener) C0621s.m1887b(onLeaderboardMetadataLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: c */
        public void mo4556c(C0344d dVar) {
            C0429au.this.mo5431a((C0597k<T>.b<?>) new C0466t(this.f1083dU, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$t */
    final class C0466t extends C0597k<C0479az>.c<OnLeaderboardMetadataLoadedListener> {
        C0466t(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, C0344d dVar) {
            super(onLeaderboardMetadataLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, C0344d dVar) {
            onLeaderboardMetadataLoadedListener.onLeaderboardMetadataLoaded(dVar.getStatusCode(), new LeaderboardBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.au$u */
    final class C0467u extends C0597k<C0479az>.b<RoomUpdateListener> {

        /* renamed from: dV */
        private final String f1086dV;

        /* renamed from: p */
        private final int f1087p;

        C0467u(RoomUpdateListener roomUpdateListener, int i, String str) {
            super(roomUpdateListener);
            this.f1087p = i;
            this.f1086dV = str;
        }

        /* renamed from: a */
        public void mo4646a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.f1087p, this.f1086dV);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$v */
    final class C0468v extends C0597k<C0479az>.b<RealTimeMessageReceivedListener> {

        /* renamed from: dW */
        private final RealTimeMessage f1089dW;

        C0468v(RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            super(realTimeMessageReceivedListener);
            this.f1089dW = realTimeMessage;
        }

        /* renamed from: a */
        public void mo4646a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            C0475ax.m1062a("GamesClient", "Deliver Message received callback");
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.f1089dW);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$w */
    final class C0469w extends C0597k<C0479az>.b<RoomStatusUpdateListener> {

        /* renamed from: dX */
        private final String f1091dX;

        C0469w(RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            super(roomStatusUpdateListener);
            this.f1091dX = str;
        }

        /* renamed from: a */
        public void mo4646a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.f1091dX);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$x */
    final class C0470x extends C0597k<C0479az>.b<RoomStatusUpdateListener> {

        /* renamed from: dX */
        private final String f1093dX;

        C0470x(RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            super(roomStatusUpdateListener);
            this.f1093dX = str;
        }

        /* renamed from: a */
        public void mo4646a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.f1093dX);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.au$y */
    final class C0471y extends C0430a {
        C0471y(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4642a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.au$z */
    final class C0472z extends C0430a {
        C0472z(RoomStatusUpdateListener roomStatusUpdateListener, C0344d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4642a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    public C0429au(Context context, String str, String str2, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String[] strArr, int i, View view, boolean z) {
        super(context, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f1022dz = str;
        this.f1023g = (String) C0621s.m1890d(str2);
        this.f1019dF = new Binder();
        this.f1014dA = new HashMap();
        this.f1017dD = C0483ba.m1296a(this, i);
        setViewForPopups(view);
        this.f1020dG = (long) hashCode();
        this.f1021dH = z;
    }

    /* renamed from: av */
    private void m953av() {
        this.f1015dB = null;
    }

    /* renamed from: aw */
    private void m954aw() {
        for (C0487bb close : this.f1014dA.values()) {
            try {
                close.close();
            } catch (IOException e) {
                C0475ax.m1063a("GamesClient", "IOException:", e);
            }
        }
        this.f1014dA.clear();
    }

    /* renamed from: t */
    private C0487bb m955t(String str) {
        try {
            String v = ((C0479az) mo5430C()).mo4743v(str);
            if (v == null) {
                return null;
            }
            C0475ax.m1066d("GamesClient", "Creating a socket to bind to:" + v);
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(v));
                C0487bb bbVar = new C0487bb(localSocket, str);
                this.f1014dA.put(str, bbVar);
                return bbVar;
            } catch (IOException e) {
                C0475ax.m1065c("GamesClient", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            C0475ax.m1065c("GamesClient", "Unable to create socket. Service died.");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public Room m956x(C0344d dVar) {
        C0397a aVar = new C0397a(dVar);
        Room room = null;
        try {
            if (aVar.getCount() > 0) {
                room = (Room) ((Room) aVar.get(0)).freeze();
            }
            return room;
        } finally {
            aVar.close();
        }
    }

    /* renamed from: a */
    public int mo4587a(byte[] bArr, String str, String[] strArr) {
        C0621s.m1887b(strArr, (Object) "Participant IDs must not be null");
        try {
            return ((C0479az) mo5430C()).mo4695b(bArr, str, strArr);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4588a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.f1018dE = bundle.getBoolean("show_welcome_popup");
        }
        super.mo4588a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void mo4589a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((C0479az) mo5430C()).mo4669a(iBinder, bundle);
            } catch (RemoteException e) {
                C0475ax.m1064b("GamesClient", "service died");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4590a(ConnectionResult connectionResult) {
        super.mo4590a(connectionResult);
        this.f1018dE = false;
    }

    /* renamed from: a */
    public void mo4591a(OnPlayersLoadedListener onPlayersLoadedListener, int i, boolean z, boolean z2) {
        try {
            ((C0479az) mo5430C()).mo4672a((C0476ay) new C0435ae(onPlayersLoadedListener), i, z, z2);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4592a(OnAchievementUpdatedListener onAchievementUpdatedListener, String str) {
        try {
            ((C0479az) mo5430C()).mo4683a((C0476ay) onAchievementUpdatedListener == null ? null : new C0450d(onAchievementUpdatedListener), str, this.f1017dD.mo4759aD(), this.f1017dD.mo4758aC());
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4593a(OnAchievementUpdatedListener onAchievementUpdatedListener, String str, int i) {
        try {
            ((C0479az) mo5430C()).mo4679a((C0476ay) onAchievementUpdatedListener == null ? null : new C0450d(onAchievementUpdatedListener), str, i, this.f1017dD.mo4759aD(), this.f1017dD.mo4758aC());
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4594a(OnScoreSubmittedListener onScoreSubmittedListener, String str, long j) {
        try {
            ((C0479az) mo5430C()).mo4682a((C0476ay) onScoreSubmittedListener == null ? null : new C0446ap(onScoreSubmittedListener), str, j);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4595a(C0612p pVar, C0597k.C0601d dVar) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.f1021dH);
        pVar.mo5473a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f1023g, mo5434x(), this.f1022dz, this.f1017dD.mo4759aD(), locale, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4596a(String... strArr) {
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
            C0621s.m1885a(!z2, String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        C0621s.m1885a(z2, String.format("GamesClient requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    /* renamed from: ax */
    public void mo4597ax() {
        if (isConnected()) {
            try {
                ((C0479az) mo5430C()).mo4692ax();
            } catch (RemoteException e) {
                C0475ax.m1064b("GamesClient", "service died");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4598b() {
        return "com.google.android.gms.games.service.START";
    }

    /* renamed from: b */
    public void mo4599b(OnAchievementUpdatedListener onAchievementUpdatedListener, String str) {
        try {
            ((C0479az) mo5430C()).mo4703b((C0476ay) onAchievementUpdatedListener == null ? null : new C0450d(onAchievementUpdatedListener), str, this.f1017dD.mo4759aD(), this.f1017dD.mo4758aC());
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4601c() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void clearNotifications(int notificationTypes) {
        try {
            ((C0479az) mo5430C()).clearNotifications(notificationTypes);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void connect() {
        m953av();
        super.connect();
    }

    public void createRoom(RoomConfig config) {
        try {
            ((C0479az) mo5430C()).mo4675a((C0476ay) new C0440aj(config.getRoomUpdateListener(), config.getRoomStatusUpdateListener(), config.getMessageReceivedListener()), (IBinder) this.f1019dF, config.getVariant(), config.getInvitedPlayerIds(), config.getAutoMatchCriteria(), config.isSocketEnabled(), this.f1020dG);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void disconnect() {
        this.f1018dE = false;
        if (isConnected()) {
            try {
                C0479az azVar = (C0479az) mo5430C();
                azVar.mo4692ax();
                azVar.mo4697b(this.f1020dG);
                azVar.mo4668a(this.f1020dG);
            } catch (RemoteException e) {
                C0475ax.m1064b("GamesClient", "Failed to notify client disconnect.");
            }
        }
        m954aw();
        super.disconnect();
    }

    public Intent getAchievementsIntent() {
        mo5429B();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_ACHIEVEMENTS");
        intent.addFlags(67108864);
        return C0474aw.m1061b(intent);
    }

    public Intent getAllLeaderboardsIntent() {
        mo5429B();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARDS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.f1022dz);
        intent.addFlags(67108864);
        return C0474aw.m1061b(intent);
    }

    public String getAppId() {
        try {
            return ((C0479az) mo5430C()).getAppId();
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
            return null;
        }
    }

    public String getCurrentAccountName() {
        try {
            return ((C0479az) mo5430C()).getCurrentAccountName();
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
            return null;
        }
    }

    public Game getCurrentGame() {
        GameBuffer gameBuffer;
        mo5429B();
        synchronized (this) {
            if (this.f1016dC == null) {
                try {
                    gameBuffer = new GameBuffer(((C0479az) mo5430C()).mo4691aA());
                    if (gameBuffer.getCount() > 0) {
                        this.f1016dC = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    C0475ax.m1064b("GamesClient", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                    throw th;
                }
            }
        }
        return this.f1016dC;
    }

    public Player getCurrentPlayer() {
        PlayerBuffer playerBuffer;
        mo5429B();
        synchronized (this) {
            if (this.f1015dB == null) {
                try {
                    playerBuffer = new PlayerBuffer(((C0479az) mo5430C()).mo4693ay());
                    if (playerBuffer.getCount() > 0) {
                        this.f1015dB = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    C0475ax.m1064b("GamesClient", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                    throw th;
                }
            }
        }
        return this.f1015dB;
    }

    public String getCurrentPlayerId() {
        try {
            return ((C0479az) mo5430C()).getCurrentPlayerId();
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
            return null;
        }
    }

    public Intent getInvitationInboxIntent() {
        mo5429B();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_INVITATIONS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.f1022dz);
        return C0474aw.m1061b(intent);
    }

    public Intent getLeaderboardIntent(String leaderboardId) {
        mo5429B();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARD_SCORES");
        intent.putExtra("com.google.android.gms.games.LEADERBOARD_ID", leaderboardId);
        intent.addFlags(67108864);
        return C0474aw.m1061b(intent);
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String roomId, String participantId) {
        if (participantId == null || !ParticipantUtils.m763z(participantId)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        C0487bb bbVar = this.f1014dA.get(participantId);
        return (bbVar == null || bbVar.isClosed()) ? m955t(participantId) : bbVar;
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int minParticipantsToStart) {
        mo5429B();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_REAL_TIME_WAITING_ROOM");
        C0621s.m1887b(room, (Object) "Room parameter must not be null");
        intent.putExtra(GamesClient.EXTRA_ROOM, (Parcelable) room.freeze());
        C0621s.m1885a(minParticipantsToStart >= 0, "minParticipantsToStart must be >= 0");
        intent.putExtra("com.google.android.gms.games.MIN_PARTICIPANTS_TO_START", minParticipantsToStart);
        return C0474aw.m1061b(intent);
    }

    public Intent getSelectPlayersIntent(int minPlayers, int maxPlayers) {
        mo5429B();
        Intent intent = new Intent("com.google.android.gms.games.SELECT_PLAYERS");
        intent.putExtra("com.google.android.gms.games.MIN_SELECTIONS", minPlayers);
        intent.putExtra("com.google.android.gms.games.MAX_SELECTIONS", maxPlayers);
        return C0474aw.m1061b(intent);
    }

    public Intent getSettingsIntent() {
        mo5429B();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_SETTINGS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.f1022dz);
        intent.addFlags(67108864);
        return C0474aw.m1061b(intent);
    }

    /* renamed from: h */
    public void mo4617h(String str, int i) {
        try {
            ((C0479az) mo5430C()).mo4733h(str, i);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* renamed from: i */
    public void mo4618i(String str, int i) {
        try {
            ((C0479az) mo5430C()).mo4736i(str, i);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void joinRoom(RoomConfig config) {
        try {
            ((C0479az) mo5430C()).mo4676a((C0476ay) new C0440aj(config.getRoomUpdateListener(), config.getRoomStatusUpdateListener(), config.getMessageReceivedListener()), (IBinder) this.f1019dF, config.getInvitationId(), config.isSocketEnabled(), this.f1020dG);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void leaveRoom(RoomUpdateListener listener, String roomId) {
        try {
            ((C0479az) mo5430C()).mo4722e((C0476ay) new C0440aj(listener), roomId);
            m954aw();
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadAchievements(OnAchievementsLoadedListener listener, boolean forceReload) {
        try {
            ((C0479az) mo5430C()).mo4708b((C0476ay) new C0452f(listener), forceReload);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadGame(OnGamesLoadedListener listener) {
        try {
            ((C0479az) mo5430C()).mo4716d(new C0456j(listener));
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadInvitations(OnInvitationsLoadedListener listener) {
        try {
            ((C0479az) mo5430C()).mo4720e(new C0460n(listener));
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, String leaderboardId, boolean forceReload) {
        try {
            ((C0479az) mo5430C()).mo4713c((C0476ay) new C0465s(listener), leaderboardId, forceReload);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, boolean forceReload) {
        try {
            ((C0479az) mo5430C()).mo4714c((C0476ay) new C0465s(listener), forceReload);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadMoreScores(OnLeaderboardScoresLoadedListener listener, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        try {
            ((C0479az) mo5430C()).mo4674a((C0476ay) new C0463q(listener), buffer.mo4293aF().mo4312aG(), maxResults, pageDirection);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadPlayer(OnPlayersLoadedListener listener, String playerId) {
        try {
            ((C0479az) mo5430C()).mo4711c((C0476ay) new C0435ae(listener), playerId);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        try {
            ((C0479az) mo5430C()).mo4701b(new C0463q(listener), leaderboardId, span, leaderboardCollection, maxResults, forceReload);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        try {
            ((C0479az) mo5430C()).mo4678a(new C0463q(listener), leaderboardId, span, leaderboardCollection, maxResults, forceReload);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C0479az mo4600c(IBinder iBinder) {
        return C0479az.C0480a.m1216o(iBinder);
    }

    public void registerInvitationListener(OnInvitationReceivedListener listener) {
        try {
            ((C0479az) mo5430C()).mo4673a((C0476ay) new C0458l(listener), this.f1020dG);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public int sendReliableRealTimeMessage(RealTimeReliableMessageSentListener listener, byte[] messageData, String roomId, String recipientParticipantId) {
        try {
            return ((C0479az) mo5430C()).mo4667a((C0476ay) new C0438ah(listener), messageData, roomId, recipientParticipantId);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
            return -1;
        }
    }

    public int sendUnreliableRealTimeMessageToAll(byte[] messageData, String roomId) {
        try {
            return ((C0479az) mo5430C()).mo4695b(messageData, roomId, (String[]) null);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
            return -1;
        }
    }

    public void setGravityForPopups(int gravity) {
        this.f1017dD.setGravity(gravity);
    }

    public void setUseNewPlayerNotificationsFirstParty(boolean newPlayerStyle) {
        try {
            ((C0479az) mo5430C()).setUseNewPlayerNotificationsFirstParty(newPlayerStyle);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void setViewForPopups(View gamesContentView) {
        this.f1017dD.mo4756a(gamesContentView);
    }

    public void signOut(OnSignOutCompleteListener listener) {
        try {
            ((C0479az) mo5430C()).mo4670a((C0476ay) listener == null ? null : new C0444an(listener));
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    public void unregisterInvitationListener() {
        try {
            ((C0479az) mo5430C()).mo4697b(this.f1020dG);
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public void mo4639y() {
        super.mo4639y();
        if (this.f1018dE) {
            this.f1017dD.mo4757aB();
            this.f1018dE = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public Bundle mo4640z() {
        try {
            Bundle z = ((C0479az) mo5430C()).mo4747z();
            if (z == null) {
                return z;
            }
            z.setClassLoader(C0429au.class.getClassLoader());
            return z;
        } catch (RemoteException e) {
            C0475ax.m1064b("GamesClient", "service died");
            return null;
        }
    }
}
