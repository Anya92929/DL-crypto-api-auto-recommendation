package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.C1415kj;
import com.google.android.gms.internal.C1421kl;

/* renamed from: com.google.android.gms.internal.ky */
public class C1461ky implements HistoryApi {

    /* renamed from: com.google.android.gms.internal.ky$a */
    private static class C1465a extends C1421kl.C1422a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DataReadResult> f4222De;

        /* renamed from: TB */
        private int f4223TB;

        /* renamed from: TC */
        private DataReadResult f4224TC;

        private C1465a(BaseImplementation.C0270b<DataReadResult> bVar) {
            this.f4223TB = 0;
            this.f4224TC = null;
            this.f4222De = bVar;
        }

        /* renamed from: a */
        public void mo9101a(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.f4224TC == null) {
                    this.f4224TC = dataReadResult;
                } else {
                    this.f4224TC.mo6217b(dataReadResult);
                }
                this.f4223TB++;
                if (this.f4223TB == this.f4224TC.mo6227jF()) {
                    this.f4222De.mo4196b(this.f4224TC);
                }
            }
        }
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9113a(request, (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    @Deprecated
    public PendingResult<Status> insert(GoogleApiClient client, final DataInsertRequest request) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9114a(request, (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return insert(client, new DataInsertRequest.Builder().setDataSet(dataSet).build());
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.mo4219a(new C1415kj.C1416a<DataReadResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9115a(request, (C1421kl) new C1465a(this), kjVar.getContext().getPackageName());
            }

            /* access modifiers changed from: protected */
            /* renamed from: y */
            public DataReadResult mo3773c(Status status) {
                return DataReadResult.m2083a(status, request);
            }
        });
    }
}
