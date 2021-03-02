package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzpo;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzpo {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f4292d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f4293e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f4294f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final PendingResult[] f4295g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Object f4296h;

    public final class Builder {

        /* renamed from: a */
        private List f4297a = new ArrayList();

        /* renamed from: b */
        private GoogleApiClient f4298b;

        public Builder(GoogleApiClient googleApiClient) {
            this.f4298b = googleApiClient;
        }

        public BatchResultToken add(PendingResult pendingResult) {
            BatchResultToken batchResultToken = new BatchResultToken(this.f4297a.size());
            this.f4297a.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.f4297a, this.f4298b, (C1339a) null);
        }
    }

    private Batch(List list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f4296h = new Object();
        this.f4292d = list.size();
        this.f4295g = new PendingResult[this.f4292d];
        if (list.isEmpty()) {
            zzc((Result) new BatchResult(Status.f4328sq, this.f4295g));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                PendingResult pendingResult = (PendingResult) list.get(i2);
                this.f4295g[i2] = pendingResult;
                pendingResult.zza(new C1339a(this));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, C1339a aVar) {
        this(list, googleApiClient);
    }

    /* renamed from: b */
    static /* synthetic */ int m5957b(Batch batch) {
        int i = batch.f4292d;
        batch.f4292d = i - 1;
        return i;
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.f4295g) {
            cancel.cancel();
        }
    }

    /* renamed from: createFailedResult */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.f4295g);
    }
}
