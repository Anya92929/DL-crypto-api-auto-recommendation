package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.C0618k;
import com.google.android.gms.fitness.data.C0621l;
import com.google.android.gms.fitness.request.C0674n;
import com.google.android.gms.fitness.request.C0676p;
import com.google.android.gms.fitness.request.DataSourceListener;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.C1415kj;
import com.google.android.gms.internal.C1424km;
import com.google.android.gms.internal.C1442ks;

/* renamed from: com.google.android.gms.internal.lb */
public class C1473lb implements SensorsApi {

    /* renamed from: com.google.android.gms.internal.lb$a */
    private static abstract class C1477a<R extends Result> extends BaseImplementation.C0269a<R, C1415kj> {
        public C1477a() {
            super(Fitness.f1272CU);
        }
    }

    /* renamed from: com.google.android.gms.internal.lb$b */
    private static class C1478b extends C1424km.C1425a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DataSourcesResult> f4239De;

        private C1478b(BaseImplementation.C0270b<DataSourcesResult> bVar) {
            this.f4239De = bVar;
        }

        /* renamed from: a */
        public void mo9105a(DataSourcesResult dataSourcesResult) {
            this.f4239De.mo4196b(dataSourcesResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.lb$c */
    private static class C1479c extends C1442ks.C1443a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Status> f4240De;

        /* renamed from: TM */
        private final DataSourceListener f4241TM;

        private C1479c(BaseImplementation.C0270b<Status> bVar, DataSourceListener dataSourceListener) {
            this.f4240De = bVar;
            this.f4241TM = dataSourceListener;
        }

        /* renamed from: k */
        public void mo9098k(Status status) {
            if (this.f4241TM != null && status.isSuccess()) {
                C0621l.C0623a.m1859iO().mo5826c(this.f4241TM);
            }
            this.f4240De.mo4196b(status);
        }
    }

    /* renamed from: a */
    private PendingResult<Status> m5385a(GoogleApiClient googleApiClient, final C0674n nVar) {
        return googleApiClient.mo4219a(new C1477a<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9128a(nVar, (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Status mo3773c(Status status) {
                return status;
            }
        });
    }

    /* renamed from: a */
    private PendingResult<Status> m5386a(GoogleApiClient googleApiClient, final C0676p pVar, final DataSourceListener dataSourceListener) {
        return googleApiClient.mo4221b(new C1477a<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9129a(pVar, (C1442ks) new C1479c(this, dataSourceListener), kjVar.getContext().getPackageName());
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Status mo3773c(Status status) {
                return status;
            }
        });
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.mo4219a(new C1477a<DataSourcesResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: A */
            public DataSourcesResult mo3773c(Status status) {
                return DataSourcesResult.m2093E(status);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9116a(request, (C1424km) new C1478b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> register(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return m5385a(client, new C0674n(request, (C0618k) null, intent));
    }

    public PendingResult<Status> register(GoogleApiClient client, SensorRequest request, DataSourceListener listener) {
        return m5385a(client, new C0674n(request, C0621l.C0623a.m1859iO().mo5824a(listener), (PendingIntent) null));
    }

    public PendingResult<Status> unregister(GoogleApiClient client, PendingIntent pendingIntent) {
        return m5386a(client, new C0676p((C0618k) null, pendingIntent), (DataSourceListener) null);
    }

    public PendingResult<Status> unregister(GoogleApiClient client, DataSourceListener listener) {
        C0621l b = C0621l.C0623a.m1859iO().mo5825b(listener);
        return b == null ? new C1445kt(Status.f591Jo) : m5386a(client, new C0676p(b, (PendingIntent) null), listener);
    }
}
