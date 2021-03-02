package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {

    /* renamed from: a */
    private final Status f2619a;

    /* renamed from: b */
    private final PendingResult<?>[] f2620b;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f2619a = status;
        this.f2620b = pendingResultArr;
    }

    public Status getStatus() {
        return this.f2619a;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzx.zzb(batchResultToken.mId < this.f2620b.length, (Object) "The result token does not belong to this batch");
        return this.f2620b[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
