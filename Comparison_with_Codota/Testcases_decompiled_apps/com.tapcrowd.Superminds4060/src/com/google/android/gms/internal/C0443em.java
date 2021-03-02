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
import com.google.android.gms.common.data.C0140d;
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
import com.google.android.gms.games.multiplayer.realtime.C0193a;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.C0387de;
import com.google.android.gms.internal.C0493er;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.em */
public final class C0443em extends C0387de<C0493er> {

    /* renamed from: it */
    private final String f1183it;

    /* renamed from: mF */
    private final String f1184mF;

    /* renamed from: mG */
    private final Map<String, C0500et> f1185mG;

    /* renamed from: mH */
    private PlayerEntity f1186mH;

    /* renamed from: mI */
    private GameEntity f1187mI;

    /* renamed from: mJ */
    private final C0496es f1188mJ;

    /* renamed from: mK */
    private boolean f1189mK = false;

    /* renamed from: mL */
    private final Binder f1190mL;

    /* renamed from: mM */
    private final long f1191mM;

    /* renamed from: mN */
    private final boolean f1192mN;

    /* renamed from: com.google.android.gms.internal.em$a */
    abstract class C0444a extends C0463c {

        /* renamed from: mO */
        private final ArrayList<String> f1193mO = new ArrayList<>();

        C0444a(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar);
            for (String add : strArr) {
                this.f1193mO.add(add);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4591a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            mo4592a(roomStatusUpdateListener, room, this.f1193mO);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4592a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    /* renamed from: com.google.android.gms.internal.em$aa */
    final class C0445aa extends C0444a {
        C0445aa(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4592a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ab */
    final class C0446ab extends C0444a {
        C0446ab(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4592a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ac */
    final class C0447ac extends C0444a {
        C0447ac(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4592a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ad */
    final class C0448ad extends C0444a {
        C0448ad(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4592a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ae */
    final class C0449ae extends C0442el {

        /* renamed from: ne */
        private final OnPlayersLoadedListener f1200ne;

        C0449ae(OnPlayersLoadedListener onPlayersLoadedListener) {
            this.f1200ne = (OnPlayersLoadedListener) C0411dm.m940a(onPlayersLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: e */
        public void mo4518e(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0450af(this.f1200ne, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$af */
    final class C0450af extends C0387de<C0493er>.c<OnPlayersLoadedListener> {
        C0450af(OnPlayersLoadedListener onPlayersLoadedListener, C0140d dVar) {
            super(onPlayersLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(OnPlayersLoadedListener onPlayersLoadedListener, C0140d dVar) {
            onPlayersLoadedListener.onPlayersLoaded(dVar.getStatusCode(), new PlayerBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ag */
    final class C0451ag extends C0387de<C0493er>.b<RealTimeReliableMessageSentListener> {

        /* renamed from: iC */
        private final int f1202iC;

        /* renamed from: nf */
        private final String f1204nf;

        /* renamed from: ng */
        private final int f1205ng;

        C0451ag(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener, int i, int i2, String str) {
            super(realTimeReliableMessageSentListener);
            this.f1202iC = i;
            this.f1205ng = i2;
            this.f1204nf = str;
        }

        /* renamed from: a */
        public void mo4270a(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener) {
            if (realTimeReliableMessageSentListener != null) {
                realTimeReliableMessageSentListener.onRealTimeMessageSent(this.f1202iC, this.f1205ng, this.f1204nf);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ah */
    final class C0452ah extends C0442el {

        /* renamed from: nh */
        final RealTimeReliableMessageSentListener f1207nh;

        public C0452ah(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener) {
            this.f1207nh = realTimeReliableMessageSentListener;
        }

        /* renamed from: a */
        public void mo4507a(int i, int i2, String str) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0451ag(this.f1207nh, i, i2, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ai */
    final class C0453ai extends C0463c {
        C0453ai(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4591a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$aj */
    final class C0454aj extends C0442el {

        /* renamed from: ni */
        private final RoomUpdateListener f1210ni;

        /* renamed from: nj */
        private final RoomStatusUpdateListener f1211nj;

        /* renamed from: nk */
        private final RealTimeMessageReceivedListener f1212nk;

        public C0454aj(RoomUpdateListener roomUpdateListener) {
            this.f1210ni = (RoomUpdateListener) C0411dm.m940a(roomUpdateListener, (Object) "Callbacks must not be null");
            this.f1211nj = null;
            this.f1212nk = null;
        }

        public C0454aj(RoomUpdateListener roomUpdateListener, RoomStatusUpdateListener roomStatusUpdateListener, RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.f1210ni = (RoomUpdateListener) C0411dm.m940a(roomUpdateListener, (Object) "Callbacks must not be null");
            this.f1211nj = roomStatusUpdateListener;
            this.f1212nk = realTimeMessageReceivedListener;
        }

        /* renamed from: a */
        public void mo4510a(C0140d dVar, String[] strArr) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0446ab(this.f1211nj, dVar, strArr));
        }

        /* renamed from: b */
        public void mo4512b(C0140d dVar, String[] strArr) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0447ac(this.f1211nj, dVar, strArr));
        }

        /* renamed from: c */
        public void mo4515c(C0140d dVar, String[] strArr) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0448ad(this.f1211nj, dVar, strArr));
        }

        /* renamed from: d */
        public void mo4517d(C0140d dVar, String[] strArr) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0486z(this.f1211nj, dVar, strArr));
        }

        /* renamed from: e */
        public void mo4519e(C0140d dVar, String[] strArr) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0485y(this.f1211nj, dVar, strArr));
        }

        /* renamed from: f */
        public void mo4521f(C0140d dVar, String[] strArr) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0445aa(this.f1211nj, dVar, strArr));
        }

        /* renamed from: n */
        public void mo4529n(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0457am(this.f1210ni, dVar));
        }

        /* renamed from: o */
        public void mo4530o(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0476p(this.f1210ni, dVar));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0481u(this.f1210ni, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0483w(this.f1211nj, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0484x(this.f1211nj, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            C0489ep.m1240b("GamesClient", "RoomBinderCallbacks: onRealTimeMessageReceived");
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0482v(this.f1212nk, message));
        }

        /* renamed from: p */
        public void mo4537p(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0456al(this.f1211nj, dVar));
        }

        /* renamed from: q */
        public void mo4538q(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0453ai(this.f1211nj, dVar));
        }

        /* renamed from: r */
        public void mo4539r(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0455ak(this.f1210ni, dVar));
        }

        /* renamed from: s */
        public void mo4540s(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0468h(this.f1211nj, dVar));
        }

        /* renamed from: t */
        public void mo4541t(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0469i(this.f1211nj, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ak */
    final class C0455ak extends C0462b {
        C0455ak(RoomUpdateListener roomUpdateListener, C0140d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4595a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$al */
    final class C0456al extends C0463c {
        C0456al(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4591a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$am */
    final class C0457am extends C0462b {
        public C0457am(RoomUpdateListener roomUpdateListener, C0140d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4595a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$an */
    final class C0458an extends C0442el {

        /* renamed from: nl */
        private final OnSignOutCompleteListener f1217nl;

        public C0458an(OnSignOutCompleteListener onSignOutCompleteListener) {
            this.f1217nl = (OnSignOutCompleteListener) C0411dm.m940a(onSignOutCompleteListener, (Object) "Listener must not be null");
        }

        public void onSignOutComplete() {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0459ao(this.f1217nl));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ao */
    final class C0459ao extends C0387de<C0493er>.b<OnSignOutCompleteListener> {
        public C0459ao(OnSignOutCompleteListener onSignOutCompleteListener) {
            super(onSignOutCompleteListener);
        }

        /* renamed from: a */
        public void mo4270a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.onSignOutComplete();
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$ap */
    final class C0460ap extends C0442el {

        /* renamed from: nm */
        private final OnScoreSubmittedListener f1220nm;

        public C0460ap(OnScoreSubmittedListener onScoreSubmittedListener) {
            this.f1220nm = (OnScoreSubmittedListener) C0411dm.m940a(onScoreSubmittedListener, (Object) "Listener must not be null");
        }

        /* renamed from: d */
        public void mo4516d(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0461aq(this.f1220nm, new SubmitScoreResult(dVar)));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$aq */
    final class C0461aq extends C0387de<C0493er>.b<OnScoreSubmittedListener> {

        /* renamed from: nn */
        private final SubmitScoreResult f1222nn;

        public C0461aq(OnScoreSubmittedListener onScoreSubmittedListener, SubmitScoreResult submitScoreResult) {
            super(onScoreSubmittedListener);
            this.f1222nn = submitScoreResult;
        }

        /* renamed from: a */
        public void mo4270a(OnScoreSubmittedListener onScoreSubmittedListener) {
            onScoreSubmittedListener.onScoreSubmitted(this.f1222nn.getStatusCode(), this.f1222nn);
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$b */
    abstract class C0462b extends C0387de<C0493er>.c<RoomUpdateListener> {
        C0462b(RoomUpdateListener roomUpdateListener, C0140d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(RoomUpdateListener roomUpdateListener, C0140d dVar) {
            mo4595a(roomUpdateListener, C0443em.this.m1132x(dVar), dVar.getStatusCode());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4595a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    /* renamed from: com.google.android.gms.internal.em$c */
    abstract class C0463c extends C0387de<C0493er>.c<RoomStatusUpdateListener> {
        C0463c(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar) {
            mo4591a(roomStatusUpdateListener, C0443em.this.m1132x(dVar));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4591a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    /* renamed from: com.google.android.gms.internal.em$d */
    final class C0464d extends C0442el {

        /* renamed from: mQ */
        private final OnAchievementUpdatedListener f1226mQ;

        C0464d(OnAchievementUpdatedListener onAchievementUpdatedListener) {
            this.f1226mQ = (OnAchievementUpdatedListener) C0411dm.m940a(onAchievementUpdatedListener, (Object) "Listener must not be null");
        }

        public void onAchievementUpdated(int statusCode, String achievementId) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0465e(this.f1226mQ, statusCode, achievementId));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$e */
    final class C0465e extends C0387de<C0493er>.b<OnAchievementUpdatedListener> {

        /* renamed from: iC */
        private final int f1227iC;

        /* renamed from: mR */
        private final String f1229mR;

        C0465e(OnAchievementUpdatedListener onAchievementUpdatedListener, int i, String str) {
            super(onAchievementUpdatedListener);
            this.f1227iC = i;
            this.f1229mR = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(OnAchievementUpdatedListener onAchievementUpdatedListener) {
            onAchievementUpdatedListener.onAchievementUpdated(this.f1227iC, this.f1229mR);
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$f */
    final class C0466f extends C0442el {

        /* renamed from: mS */
        private final OnAchievementsLoadedListener f1231mS;

        C0466f(OnAchievementsLoadedListener onAchievementsLoadedListener) {
            this.f1231mS = (OnAchievementsLoadedListener) C0411dm.m940a(onAchievementsLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: b */
        public void mo4511b(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0467g(this.f1231mS, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$g */
    final class C0467g extends C0387de<C0493er>.c<OnAchievementsLoadedListener> {
        C0467g(OnAchievementsLoadedListener onAchievementsLoadedListener, C0140d dVar) {
            super(onAchievementsLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(OnAchievementsLoadedListener onAchievementsLoadedListener, C0140d dVar) {
            onAchievementsLoadedListener.onAchievementsLoaded(dVar.getStatusCode(), new AchievementBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$h */
    final class C0468h extends C0463c {
        C0468h(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4591a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$i */
    final class C0469i extends C0463c {
        C0469i(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar) {
            super(roomStatusUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4591a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$j */
    final class C0470j extends C0442el {

        /* renamed from: mT */
        private final OnGamesLoadedListener f1236mT;

        C0470j(OnGamesLoadedListener onGamesLoadedListener) {
            this.f1236mT = (OnGamesLoadedListener) C0411dm.m940a(onGamesLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: g */
        public void mo4522g(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0471k(this.f1236mT, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$k */
    final class C0471k extends C0387de<C0493er>.c<OnGamesLoadedListener> {
        C0471k(OnGamesLoadedListener onGamesLoadedListener, C0140d dVar) {
            super(onGamesLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(OnGamesLoadedListener onGamesLoadedListener, C0140d dVar) {
            onGamesLoadedListener.onGamesLoaded(dVar.getStatusCode(), new GameBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$l */
    final class C0472l extends C0442el {

        /* renamed from: mU */
        private final OnInvitationReceivedListener f1239mU;

        C0472l(OnInvitationReceivedListener onInvitationReceivedListener) {
            this.f1239mU = onInvitationReceivedListener;
        }

        /* renamed from: k */
        public void mo4526k(C0140d dVar) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dVar);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                if (invitation != null) {
                    C0443em.this.mo4326a((C0387de<T>.b<?>) new C0473m(this.f1239mU, invitation));
                }
            } finally {
                invitationBuffer.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.em$m */
    final class C0473m extends C0387de<C0493er>.b<OnInvitationReceivedListener> {

        /* renamed from: mV */
        private final Invitation f1241mV;

        C0473m(OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            super(onInvitationReceivedListener);
            this.f1241mV = invitation;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.f1241mV);
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$n */
    final class C0474n extends C0442el {

        /* renamed from: mW */
        private final OnInvitationsLoadedListener f1243mW;

        C0474n(OnInvitationsLoadedListener onInvitationsLoadedListener) {
            this.f1243mW = onInvitationsLoadedListener;
        }

        /* renamed from: j */
        public void mo4525j(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0475o(this.f1243mW, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$o */
    final class C0475o extends C0387de<C0493er>.c<OnInvitationsLoadedListener> {
        C0475o(OnInvitationsLoadedListener onInvitationsLoadedListener, C0140d dVar) {
            super(onInvitationsLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(OnInvitationsLoadedListener onInvitationsLoadedListener, C0140d dVar) {
            onInvitationsLoadedListener.onInvitationsLoaded(dVar.getStatusCode(), new InvitationBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$p */
    final class C0476p extends C0462b {
        public C0476p(RoomUpdateListener roomUpdateListener, C0140d dVar) {
            super(roomUpdateListener, dVar);
        }

        /* renamed from: a */
        public void mo4595a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$q */
    final class C0477q extends C0442el {

        /* renamed from: mX */
        private final OnLeaderboardScoresLoadedListener f1247mX;

        C0477q(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener) {
            this.f1247mX = (OnLeaderboardScoresLoadedListener) C0411dm.m940a(onLeaderboardScoresLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: a */
        public void mo4509a(C0140d dVar, C0140d dVar2) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0478r(this.f1247mX, dVar, dVar2));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$r */
    final class C0478r extends C0387de<C0493er>.b<OnLeaderboardScoresLoadedListener> {

        /* renamed from: mY */
        private final C0140d f1249mY;

        /* renamed from: mZ */
        private final C0140d f1250mZ;

        C0478r(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, C0140d dVar, C0140d dVar2) {
            super(onLeaderboardScoresLoadedListener);
            this.f1249mY = dVar;
            this.f1250mZ = dVar2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener) {
            C0140d dVar;
            C0140d dVar2 = null;
            C0140d dVar3 = this.f1249mY;
            C0140d dVar4 = this.f1250mZ;
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
        /* renamed from: aF */
        public void mo4271aF() {
            if (this.f1249mY != null) {
                this.f1249mY.close();
            }
            if (this.f1250mZ != null) {
                this.f1250mZ.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.em$s */
    final class C0479s extends C0442el {

        /* renamed from: na */
        private final OnLeaderboardMetadataLoadedListener f1252na;

        C0479s(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener) {
            this.f1252na = (OnLeaderboardMetadataLoadedListener) C0411dm.m940a(onLeaderboardMetadataLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: c */
        public void mo4514c(C0140d dVar) {
            C0443em.this.mo4326a((C0387de<T>.b<?>) new C0480t(this.f1252na, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$t */
    final class C0480t extends C0387de<C0493er>.c<OnLeaderboardMetadataLoadedListener> {
        C0480t(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, C0140d dVar) {
            super(onLeaderboardMetadataLoadedListener, dVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, C0140d dVar) {
            onLeaderboardMetadataLoadedListener.onLeaderboardMetadataLoaded(dVar.getStatusCode(), new LeaderboardBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.em$u */
    final class C0481u extends C0387de<C0493er>.b<RoomUpdateListener> {

        /* renamed from: iC */
        private final int f1254iC;

        /* renamed from: nb */
        private final String f1256nb;

        C0481u(RoomUpdateListener roomUpdateListener, int i, String str) {
            super(roomUpdateListener);
            this.f1254iC = i;
            this.f1256nb = str;
        }

        /* renamed from: a */
        public void mo4270a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.f1254iC, this.f1256nb);
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$v */
    final class C0482v extends C0387de<C0493er>.b<RealTimeMessageReceivedListener> {

        /* renamed from: nc */
        private final RealTimeMessage f1258nc;

        C0482v(RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            super(realTimeMessageReceivedListener);
            this.f1258nc = realTimeMessage;
        }

        /* renamed from: a */
        public void mo4270a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            C0489ep.m1240b("GamesClient", "Deliver Message received callback");
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.f1258nc);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$w */
    final class C0483w extends C0387de<C0493er>.b<RoomStatusUpdateListener> {

        /* renamed from: nd */
        private final String f1260nd;

        C0483w(RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            super(roomStatusUpdateListener);
            this.f1260nd = str;
        }

        /* renamed from: a */
        public void mo4270a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.f1260nd);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$x */
    final class C0484x extends C0387de<C0493er>.b<RoomStatusUpdateListener> {

        /* renamed from: nd */
        private final String f1262nd;

        C0484x(RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            super(roomStatusUpdateListener);
            this.f1262nd = str;
        }

        /* renamed from: a */
        public void mo4270a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.f1262nd);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em$y */
    final class C0485y extends C0444a {
        C0485y(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4592a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.em$z */
    final class C0486z extends C0444a {
        C0486z(RoomStatusUpdateListener roomStatusUpdateListener, C0140d dVar, String[] strArr) {
            super(roomStatusUpdateListener, dVar, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4592a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    public C0443em(Context context, String str, String str2, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String[] strArr, int i, View view, boolean z) {
        super(context, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f1184mF = str;
        this.f1183it = (String) C0411dm.m944e(str2);
        this.f1190mL = new Binder();
        this.f1185mG = new HashMap();
        this.f1188mJ = C0496es.m1476a(this, i);
        setViewForPopups(view);
        this.f1191mM = (long) hashCode();
        this.f1192mN = z;
    }

    /* renamed from: K */
    private C0500et m1128K(String str) {
        try {
            String M = ((C0493er) mo4332bd()).mo4615M(str);
            if (M == null) {
                return null;
            }
            C0489ep.m1243e("GamesClient", "Creating a socket to bind to:" + M);
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(M));
                C0500et etVar = new C0500et(localSocket, str);
                this.f1185mG.put(str, etVar);
                return etVar;
            } catch (IOException e) {
                C0489ep.m1242d("GamesClient", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            C0489ep.m1242d("GamesClient", "Unable to create socket. Service died.");
            return null;
        }
    }

    /* renamed from: bR */
    private void m1130bR() {
        this.f1186mH = null;
    }

    /* renamed from: bS */
    private void m1131bS() {
        for (C0500et close : this.f1185mG.values()) {
            try {
                close.close();
            } catch (IOException e) {
                C0489ep.m1239a("GamesClient", "IOException:", e);
            }
        }
        this.f1185mG.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public Room m1132x(C0140d dVar) {
        C0193a aVar = new C0193a(dVar);
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

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public C0493er mo4168p(IBinder iBinder) {
        return C0493er.C0494a.m1396C(iBinder);
    }

    /* renamed from: a */
    public int mo4546a(byte[] bArr, String str, String[] strArr) {
        C0411dm.m940a(strArr, (Object) "Participant IDs must not be null");
        try {
            return ((C0493er) mo4332bd()).mo4643b(bArr, str, strArr);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4324a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.f1189mK = bundle.getBoolean("show_welcome_popup");
        }
        super.mo4324a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void mo4547a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((C0493er) mo4332bd()).mo4620a(iBinder, bundle);
            } catch (RemoteException e) {
                C0489ep.m1241c("GamesClient", "service died");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4325a(ConnectionResult connectionResult) {
        super.mo4325a(connectionResult);
        this.f1189mK = false;
    }

    /* renamed from: a */
    public void mo4548a(OnPlayersLoadedListener onPlayersLoadedListener, int i, boolean z, boolean z2) {
        try {
            ((C0493er) mo4332bd()).mo4623a((C0490eq) new C0449ae(onPlayersLoadedListener), i, z, z2);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4549a(OnAchievementUpdatedListener onAchievementUpdatedListener, String str) {
        try {
            ((C0493er) mo4332bd()).mo4635a((C0490eq) onAchievementUpdatedListener == null ? null : new C0464d(onAchievementUpdatedListener), str, this.f1188mJ.mo4703bZ(), this.f1188mJ.mo4702bY());
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4550a(OnAchievementUpdatedListener onAchievementUpdatedListener, String str, int i) {
        try {
            ((C0493er) mo4332bd()).mo4630a((C0490eq) onAchievementUpdatedListener == null ? null : new C0464d(onAchievementUpdatedListener), str, i, this.f1188mJ.mo4703bZ(), this.f1188mJ.mo4702bY());
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4551a(OnScoreSubmittedListener onScoreSubmittedListener, String str, long j, String str2) {
        try {
            ((C0493er) mo4332bd()).mo4634a((C0490eq) onScoreSubmittedListener == null ? null : new C0460ap(onScoreSubmittedListener), str, j, str2);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4163a(C0402dj djVar, C0387de.C0391d dVar) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.f1192mN);
        djVar.mo4373a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f1183it, mo4327aY(), this.f1184mF, this.f1188mJ.mo4703bZ(), locale, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4260a(String... strArr) {
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
            C0411dm.m941a(!z2, (Object) String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        C0411dm.m941a(z2, (Object) String.format("GamesClient requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: aZ */
    public void mo4328aZ() {
        super.mo4328aZ();
        if (this.f1189mK) {
            this.f1188mJ.mo4701bX();
            this.f1189mK = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public String mo4164ag() {
        return "com.google.android.gms.games.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public String mo4165ah() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* renamed from: b */
    public void mo4552b(OnAchievementUpdatedListener onAchievementUpdatedListener, String str) {
        try {
            ((C0493er) mo4332bd()).mo4650b((C0490eq) onAchievementUpdatedListener == null ? null : new C0464d(onAchievementUpdatedListener), str, this.f1188mJ.mo4703bZ(), this.f1188mJ.mo4702bY());
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    /* renamed from: b */
    public void mo4553b(OnAchievementUpdatedListener onAchievementUpdatedListener, String str, int i) {
        try {
            ((C0493er) mo4332bd()).mo4648b((C0490eq) onAchievementUpdatedListener == null ? null : new C0464d(onAchievementUpdatedListener), str, i, this.f1188mJ.mo4703bZ(), this.f1188mJ.mo4702bY());
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    /* renamed from: bT */
    public void mo4554bT() {
        if (isConnected()) {
            try {
                ((C0493er) mo4332bd()).mo4656bT();
            } catch (RemoteException e) {
                C0489ep.m1241c("GamesClient", "service died");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ba */
    public Bundle mo4329ba() {
        try {
            Bundle ba = ((C0493er) mo4332bd()).mo4660ba();
            if (ba == null) {
                return ba;
            }
            ba.setClassLoader(C0443em.class.getClassLoader());
            return ba;
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
            return null;
        }
    }

    public void clearNotifications(int notificationTypes) {
        try {
            ((C0493er) mo4332bd()).clearNotifications(notificationTypes);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void connect() {
        m1130bR();
        super.connect();
    }

    public void createRoom(RoomConfig config) {
        try {
            ((C0493er) mo4332bd()).mo4626a((C0490eq) new C0454aj(config.getRoomUpdateListener(), config.getRoomStatusUpdateListener(), config.getMessageReceivedListener()), (IBinder) this.f1190mL, config.getVariant(), config.getInvitedPlayerIds(), config.getAutoMatchCriteria(), config.isSocketEnabled(), this.f1191mM);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void disconnect() {
        this.f1189mK = false;
        if (isConnected()) {
            try {
                C0493er erVar = (C0493er) mo4332bd();
                erVar.mo4656bT();
                erVar.mo4680g(this.f1191mM);
                erVar.mo4676f(this.f1191mM);
            } catch (RemoteException e) {
                C0489ep.m1241c("GamesClient", "Failed to notify client disconnect.");
            }
        }
        m1131bS();
        super.disconnect();
    }

    public Intent getAchievementsIntent() {
        mo4331bc();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_ACHIEVEMENTS");
        intent.addFlags(67108864);
        return C0488eo.m1238c(intent);
    }

    public Intent getAllLeaderboardsIntent() {
        mo4331bc();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARDS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.f1184mF);
        intent.addFlags(67108864);
        return C0488eo.m1238c(intent);
    }

    public String getAppId() {
        try {
            return ((C0493er) mo4332bd()).getAppId();
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
            return null;
        }
    }

    public String getCurrentAccountName() {
        try {
            return ((C0493er) mo4332bd()).getCurrentAccountName();
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
            return null;
        }
    }

    public Game getCurrentGame() {
        GameBuffer gameBuffer;
        mo4331bc();
        synchronized (this) {
            if (this.f1187mI == null) {
                try {
                    gameBuffer = new GameBuffer(((C0493er) mo4332bd()).mo4659bW());
                    if (gameBuffer.getCount() > 0) {
                        this.f1187mI = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    C0489ep.m1241c("GamesClient", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                    throw th;
                }
            }
        }
        return this.f1187mI;
    }

    public Player getCurrentPlayer() {
        PlayerBuffer playerBuffer;
        mo4331bc();
        synchronized (this) {
            if (this.f1186mH == null) {
                try {
                    playerBuffer = new PlayerBuffer(((C0493er) mo4332bd()).mo4657bU());
                    if (playerBuffer.getCount() > 0) {
                        this.f1186mH = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    C0489ep.m1241c("GamesClient", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                    throw th;
                }
            }
        }
        return this.f1186mH;
    }

    public String getCurrentPlayerId() {
        try {
            return ((C0493er) mo4332bd()).getCurrentPlayerId();
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
            return null;
        }
    }

    public Intent getInvitationInboxIntent() {
        mo4331bc();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_INVITATIONS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.f1184mF);
        return C0488eo.m1238c(intent);
    }

    public Intent getLeaderboardIntent(String leaderboardId) {
        mo4331bc();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARD_SCORES");
        intent.putExtra("com.google.android.gms.games.LEADERBOARD_ID", leaderboardId);
        intent.addFlags(67108864);
        return C0488eo.m1238c(intent);
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String roomId, String participantId) {
        if (participantId == null || !ParticipantUtils.m434Q(participantId)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        C0500et etVar = this.f1185mG.get(participantId);
        return (etVar == null || etVar.isClosed()) ? m1128K(participantId) : etVar;
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int minParticipantsToStart) {
        mo4331bc();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_REAL_TIME_WAITING_ROOM");
        C0411dm.m940a(room, (Object) "Room parameter must not be null");
        intent.putExtra(GamesClient.EXTRA_ROOM, (Parcelable) room.freeze());
        C0411dm.m941a(minParticipantsToStart >= 0, (Object) "minParticipantsToStart must be >= 0");
        intent.putExtra("com.google.android.gms.games.MIN_PARTICIPANTS_TO_START", minParticipantsToStart);
        return C0488eo.m1238c(intent);
    }

    public Intent getSelectPlayersIntent(int minPlayers, int maxPlayers) {
        mo4331bc();
        Intent intent = new Intent("com.google.android.gms.games.SELECT_PLAYERS");
        intent.putExtra("com.google.android.gms.games.MIN_SELECTIONS", minPlayers);
        intent.putExtra("com.google.android.gms.games.MAX_SELECTIONS", maxPlayers);
        return C0488eo.m1238c(intent);
    }

    public Intent getSettingsIntent() {
        mo4331bc();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_SETTINGS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.f1184mF);
        intent.addFlags(67108864);
        return C0488eo.m1238c(intent);
    }

    /* renamed from: i */
    public void mo4570i(String str, int i) {
        try {
            ((C0493er) mo4332bd()).mo4690i(str, i);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    /* renamed from: j */
    public void mo4571j(String str, int i) {
        try {
            ((C0493er) mo4332bd()).mo4692j(str, i);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void joinRoom(RoomConfig config) {
        try {
            ((C0493er) mo4332bd()).mo4627a((C0490eq) new C0454aj(config.getRoomUpdateListener(), config.getRoomStatusUpdateListener(), config.getMessageReceivedListener()), (IBinder) this.f1190mL, config.getInvitationId(), config.isSocketEnabled(), this.f1191mM);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void leaveRoom(RoomUpdateListener listener, String roomId) {
        try {
            ((C0493er) mo4332bd()).mo4675e(new C0454aj(listener), roomId);
            m1131bS();
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadAchievements(OnAchievementsLoadedListener listener, boolean forceReload) {
        try {
            ((C0493er) mo4332bd()).mo4655b((C0490eq) new C0466f(listener), forceReload);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadGame(OnGamesLoadedListener listener) {
        try {
            ((C0493er) mo4332bd()).mo4668d(new C0470j(listener));
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadInvitations(OnInvitationsLoadedListener listener) {
        try {
            ((C0493er) mo4332bd()).mo4673e((C0490eq) new C0474n(listener));
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, String leaderboardId, boolean forceReload) {
        try {
            ((C0493er) mo4332bd()).mo4665c((C0490eq) new C0479s(listener), leaderboardId, forceReload);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, boolean forceReload) {
        try {
            ((C0493er) mo4332bd()).mo4666c((C0490eq) new C0479s(listener), forceReload);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadMoreScores(OnLeaderboardScoresLoadedListener listener, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        try {
            ((C0493er) mo4332bd()).mo4625a((C0490eq) new C0477q(listener), buffer.mo3843cb().mo3863cc(), maxResults, pageDirection);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadPlayer(OnPlayersLoadedListener listener, String playerId) {
        try {
            ((C0493er) mo4332bd()).mo4663c((C0490eq) new C0449ae(listener), playerId);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        try {
            ((C0493er) mo4332bd()).mo4647b(new C0477q(listener), leaderboardId, span, leaderboardCollection, maxResults, forceReload);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        try {
            ((C0493er) mo4332bd()).mo4629a(new C0477q(listener), leaderboardId, span, leaderboardCollection, maxResults, forceReload);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void registerInvitationListener(OnInvitationReceivedListener listener) {
        try {
            ((C0493er) mo4332bd()).mo4624a((C0490eq) new C0472l(listener), this.f1191mM);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public int sendReliableRealTimeMessage(RealTimeReliableMessageSentListener listener, byte[] messageData, String roomId, String recipientParticipantId) {
        try {
            return ((C0493er) mo4332bd()).mo4619a((C0490eq) new C0452ah(listener), messageData, roomId, recipientParticipantId);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
            return -1;
        }
    }

    public int sendUnreliableRealTimeMessageToAll(byte[] messageData, String roomId) {
        try {
            return ((C0493er) mo4332bd()).mo4643b(messageData, roomId, (String[]) null);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
            return -1;
        }
    }

    public void setGravityForPopups(int gravity) {
        this.f1188mJ.setGravity(gravity);
    }

    public void setUseNewPlayerNotificationsFirstParty(boolean newPlayerStyle) {
        try {
            ((C0493er) mo4332bd()).setUseNewPlayerNotificationsFirstParty(newPlayerStyle);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void setViewForPopups(View gamesContentView) {
        this.f1188mJ.mo4704e(gamesContentView);
    }

    public void signOut(OnSignOutCompleteListener listener) {
        try {
            ((C0493er) mo4332bd()).mo4621a(listener == null ? null : new C0458an(listener));
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }

    public void unregisterInvitationListener() {
        try {
            ((C0493er) mo4332bd()).mo4680g(this.f1191mM);
        } catch (RemoteException e) {
            C0489ep.m1241c("GamesClient", "service died");
        }
    }
}
