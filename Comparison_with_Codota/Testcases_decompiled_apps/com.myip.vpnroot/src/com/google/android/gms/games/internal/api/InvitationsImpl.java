package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$2 */
    class C07502 extends LoadInvitationsImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2053XX;

        /* renamed from: Yu */
        final /* synthetic */ int f2054Yu;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6686e(this, this.f2053XX, this.f2054Yu);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$3 */
    class C07513 extends LoadInvitationsImpl {

        /* renamed from: Yw */
        final /* synthetic */ String f2055Yw;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6734o((BaseImplementation.C0270b<Invitations.LoadInvitationsResult>) this, this.f2055Yw);
        }
    }

    private static abstract class LoadInvitationsImpl extends Games.BaseGamesApiMethodImpl<Invitations.LoadInvitationsResult> {
        private LoadInvitationsImpl() {
        }

        /* renamed from: T */
        public Invitations.LoadInvitationsResult mo3773c(final Status status) {
            return new Invitations.LoadInvitationsResult() {
                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6714ke();
    }

    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.mo4219a(new LoadInvitationsImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6664c((BaseImplementation.C0270b<Invitations.LoadInvitationsResult>) this, sortOrder);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m2159c(apiClient).mo6636a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m2159c(apiClient).mo6715kf();
    }
}
