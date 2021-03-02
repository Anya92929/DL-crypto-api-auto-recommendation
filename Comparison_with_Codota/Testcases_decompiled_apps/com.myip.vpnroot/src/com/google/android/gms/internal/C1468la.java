package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.C0649ae;
import com.google.android.gms.fitness.request.C0654ah;
import com.google.android.gms.fitness.request.C0670l;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.C1415kj;
import com.google.android.gms.internal.C1433kp;

/* renamed from: com.google.android.gms.internal.la */
public class C1468la implements RecordingApi {

    /* renamed from: com.google.android.gms.internal.la$a */
    private static class C1472a extends C1433kp.C1434a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<ListSubscriptionsResult> f4231De;

        private C1472a(BaseImplementation.C0270b<ListSubscriptionsResult> bVar) {
            this.f4231De = bVar;
        }

        /* renamed from: a */
        public void mo9139a(ListSubscriptionsResult listSubscriptionsResult) {
            this.f4231De.mo4196b(listSubscriptionsResult);
        }
    }

    /* renamed from: a */
    public PendingResult<Status> mo9171a(GoogleApiClient googleApiClient, final C0649ae aeVar) {
        return googleApiClient.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9123a(aeVar, (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    /* renamed from: a */
    public PendingResult<Status> mo9172a(GoogleApiClient googleApiClient, final C0654ah ahVar) {
        return googleApiClient.mo4221b(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9124a(ahVar, (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    /* renamed from: a */
    public PendingResult<ListSubscriptionsResult> mo9173a(GoogleApiClient googleApiClient, final C0670l lVar) {
        return googleApiClient.mo4219a(new C1415kj.C1416a<ListSubscriptionsResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9127a(lVar, (C1433kp) new C1472a(this), kjVar.getContext().getPackageName());
            }

            /* access modifiers changed from: protected */
            /* renamed from: z */
            public ListSubscriptionsResult mo3773c(Status status) {
                return ListSubscriptionsResult.m2097G(status);
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return mo9173a(client, new C0670l.C0672a().mo6120jk());
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, DataType dataType) {
        return mo9173a(client, new C0670l.C0672a().mo6119c(dataType).mo6120jk());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return mo9171a(client, new C0649ae.C0651a().mo6047b(new Subscription.C0607a().mo5758b(dataSource).mo5760iR()).mo6048jD());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return mo9171a(client, new C0649ae.C0651a().mo6047b(new Subscription.C0607a().mo5759b(dataType).mo5760iR()).mo6048jD());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataSource dataSource) {
        return mo9172a(client, new C0654ah.C0656a().mo6064d(dataSource).mo6066jE());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataType dataType) {
        return mo9172a(client, new C0654ah.C0656a().mo6065d(dataType).mo6066jE());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
