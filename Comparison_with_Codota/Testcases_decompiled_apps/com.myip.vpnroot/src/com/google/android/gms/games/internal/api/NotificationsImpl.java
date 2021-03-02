package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1 */
    class C07681 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {

        /* renamed from: YL */
        final /* synthetic */ String f2112YL;

        /* renamed from: Y */
        public Notifications.GameMuteStatusChangeResult mo3773c(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6680d((BaseImplementation.C0270b<Notifications.GameMuteStatusChangeResult>) this, this.f2112YL, true);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2 */
    class C07702 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {

        /* renamed from: YL */
        final /* synthetic */ String f2115YL;

        /* renamed from: Y */
        public Notifications.GameMuteStatusChangeResult mo3773c(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6680d((BaseImplementation.C0270b<Notifications.GameMuteStatusChangeResult>) this, this.f2115YL, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3 */
    class C07723 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusLoadResult> {

        /* renamed from: YL */
        final /* synthetic */ String f2118YL;

        /* renamed from: Z */
        public Notifications.GameMuteStatusLoadResult mo3773c(final Status status) {
            return new Notifications.GameMuteStatusLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6738q(this, this.f2118YL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4 */
    class C07744 extends ContactSettingLoadImpl {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6701i(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5 */
    class C07755 extends ContactSettingLoadImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2121XU;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6700h((BaseImplementation.C0270b<Notifications.ContactSettingLoadResult>) this, this.f2121XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6 */
    class C07766 extends ContactSettingUpdateImpl {

        /* renamed from: YP */
        final /* synthetic */ boolean f2122YP;

        /* renamed from: YQ */
        final /* synthetic */ Bundle f2123YQ;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6632a((BaseImplementation.C0270b<Status>) this, this.f2122YP, this.f2123YQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$7 */
    class C07777 extends InboxCountImpl {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6703j((BaseImplementation.C0270b<Notifications.InboxCountResult>) this);
        }
    }

    private static abstract class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl<Notifications.ContactSettingLoadResult> {
        private ContactSettingLoadImpl() {
        }

        /* renamed from: aa */
        public Notifications.ContactSettingLoadResult mo3773c(final Status status) {
            return new Notifications.ContactSettingLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl<Status> {
        private ContactSettingUpdateImpl() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends Games.BaseGamesApiMethodImpl<Notifications.InboxCountResult> {
        private InboxCountImpl() {
        }

        /* renamed from: ab */
        public Notifications.InboxCountResult mo3773c(final Status status) {
            return new Notifications.InboxCountResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.m2159c(apiClient).mo6683dC(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
