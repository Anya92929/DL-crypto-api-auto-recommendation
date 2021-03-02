package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$2 */
    class C07192 extends LoadNotifyAclImpl {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6698h(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$3 */
    class C07203 extends UpdateNotifyAclImpl {

        /* renamed from: Yc */
        final /* synthetic */ String f1985Yc;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6736p((BaseImplementation.C0270b<Status>) this, this.f1985Yc);
        }
    }

    private static abstract class LoadNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult> {
        private LoadNotifyAclImpl() {
        }

        /* renamed from: N */
        public Acls.LoadAclResult mo3773c(Status status) {
            return AclsImpl.m3213L(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Status> {
        private UpdateNotifyAclImpl() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public static Acls.LoadAclResult m3213L(final Status status) {
        return new Acls.LoadAclResult() {
            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
