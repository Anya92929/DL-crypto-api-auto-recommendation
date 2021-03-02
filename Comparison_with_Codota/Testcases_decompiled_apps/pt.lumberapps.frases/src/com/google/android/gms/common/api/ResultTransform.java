package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzqs;

public abstract class ResultTransform {
    public final PendingResult createFailedResult(Status status) {
        return new zzqs(status);
    }

    public Status onFailure(Status status) {
        return status;
    }

    public abstract PendingResult onSuccess(Result result);
}
