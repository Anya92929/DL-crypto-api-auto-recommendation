package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.C0665i;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.C1415kj;
import com.google.android.gms.internal.C1427kn;

/* renamed from: com.google.android.gms.internal.kx */
public class C1456kx implements ConfigApi {

    /* renamed from: com.google.android.gms.internal.kx$a */
    private static class C1460a extends C1427kn.C1428a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DataTypeResult> f4215De;

        private C1460a(BaseImplementation.C0270b<DataTypeResult> bVar) {
            this.f4215De = bVar;
        }

        /* renamed from: a */
        public void mo9109a(DataTypeResult dataTypeResult) {
            this.f4215De.mo4196b(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.mo4221b(new C1415kj.C1416a<DataTypeResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9117a(request, (C1427kn) new C1460a(this), kjVar.getContext().getPackageName());
            }

            /* access modifiers changed from: protected */
            /* renamed from: x */
            public DataTypeResult mo3773c(Status status) {
                return DataTypeResult.m2095F(status);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.mo4221b(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9134a((C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, String dataTypeName) {
        final C0665i iVar = new C0665i(dataTypeName);
        return client.mo4219a(new C1415kj.C1416a<DataTypeResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9126a(iVar, (C1427kn) new C1460a(this), kjVar.getContext().getPackageName());
            }

            /* access modifiers changed from: protected */
            /* renamed from: x */
            public DataTypeResult mo3773c(Status status) {
                return DataTypeResult.m2095F(status);
            }
        });
    }
}
