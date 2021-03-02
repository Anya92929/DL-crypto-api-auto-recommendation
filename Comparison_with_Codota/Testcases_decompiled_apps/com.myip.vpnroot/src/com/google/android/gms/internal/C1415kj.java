package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.C1442ks;

/* renamed from: com.google.android.gms.internal.kj */
public interface C1415kj extends Api.C0266a {

    /* renamed from: com.google.android.gms.internal.kj$a */
    public static abstract class C1416a<R extends Result> extends BaseImplementation.C0269a<R, C1415kj> {
        public C1416a() {
            super(Fitness.f1272CU);
        }
    }

    /* renamed from: com.google.android.gms.internal.kj$b */
    public static class C1417b extends C1442ks.C1443a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Status> f4185De;

        public C1417b(BaseImplementation.C0270b<Status> bVar) {
            this.f4185De = bVar;
        }

        /* renamed from: k */
        public void mo9098k(Status status) {
            this.f4185De.mo4196b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.kj$c */
    public static abstract class C1418c extends C1416a<Status> {
        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Status mo3773c(Status status) {
            C0348n.m851K(!status.isSuccess());
            return status;
        }
    }

    Context getContext();

    /* renamed from: iT */
    C1430ko mo9097iT();
}
