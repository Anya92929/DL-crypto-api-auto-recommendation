package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {

    /* renamed from: a */
    private final Status f4299a;

    /* renamed from: b */
    private final PendingResult[] f4300b;

    BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.f4299a = status;
        this.f4300b = pendingResultArr;
    }

    public Status getStatus() {
        return this.f4299a;
    }

    public Result take(BatchResultToken batchResultToken) {
        zzab.zzb(batchResultToken.f4301a < this.f4300b.length, (Object) "The result token does not belong to this batch");
        return this.f4300b[batchResultToken.f4301a].await(0, TimeUnit.MILLISECONDS);
    }
}
