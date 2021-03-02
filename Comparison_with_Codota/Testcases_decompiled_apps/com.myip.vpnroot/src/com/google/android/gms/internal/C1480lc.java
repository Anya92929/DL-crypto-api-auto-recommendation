package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.C0680t;
import com.google.android.gms.fitness.request.C0682v;
import com.google.android.gms.fitness.request.C0686x;
import com.google.android.gms.fitness.request.C0690z;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.C1415kj;
import com.google.android.gms.internal.C1436kq;
import com.google.android.gms.internal.C1439kr;

/* renamed from: com.google.android.gms.internal.lc */
public class C1480lc implements SessionsApi {

    /* renamed from: com.google.android.gms.internal.lc$a */
    private static class C1487a extends C1436kq.C1437a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<SessionReadResult> f4254De;

        private C1487a(BaseImplementation.C0270b<SessionReadResult> bVar) {
            this.f4254De = bVar;
        }

        /* renamed from: a */
        public void mo9143a(SessionReadResult sessionReadResult) throws RemoteException {
            this.f4254De.mo4196b(sessionReadResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.lc$b */
    private static class C1488b extends C1439kr.C1440a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<SessionStopResult> f4255De;

        private C1488b(BaseImplementation.C0270b<SessionStopResult> bVar) {
            this.f4255De = bVar;
        }

        /* renamed from: a */
        public void mo9147a(SessionStopResult sessionStopResult) {
            this.f4255De.mo4196b(sessionStopResult);
        }
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9118a(request, (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.mo4219a(new C1415kj.C1416a<SessionReadResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: C */
            public SessionReadResult mo3773c(Status status) {
                return SessionReadResult.m2099H(status);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9119a(request, (C1436kq) new C1487a(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.mo4221b(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                C1415kj.C1417b bVar = new C1415kj.C1417b(this);
                kjVar.mo9097iT().mo9130a(new C0680t(intent), (C1442ks) bVar, kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        return client.mo4221b(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9131a(new C0682v.C0684a().mo6181b(session).mo6182jx(), (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, final String name, final String identifier) {
        return client.mo4221b(new C1415kj.C1416a<SessionStopResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: B */
            public SessionStopResult mo3773c(Status status) {
                return SessionStopResult.m2102I(status);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9132a(new C0686x.C0688a().mo6195br(name).mo6196bs(identifier).mo6197jy(), (C1439kr) new C1488b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.mo4221b(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                C1415kj.C1417b bVar = new C1415kj.C1417b(this);
                kjVar.mo9097iT().mo9133a(new C0690z(intent), (C1442ks) bVar, kjVar.getContext().getPackageName());
            }
        });
    }
}
