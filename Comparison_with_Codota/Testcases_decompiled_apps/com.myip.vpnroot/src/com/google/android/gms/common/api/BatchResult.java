package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.C0348n;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {

    /* renamed from: CM */
    private final Status f576CM;

    /* renamed from: Iy */
    private final PendingResult<?>[] f577Iy;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.f576CM = status;
        this.f577Iy = pendingResults;
    }

    public Status getStatus() {
        return this.f576CM;
    }

    public <R extends Result> R take(BatchResultToken<R> resultToken) {
        C0348n.m859b(resultToken.mId < this.f577Iy.length, (Object) "The result token does not belong to this batch");
        return this.f577Iy[resultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
