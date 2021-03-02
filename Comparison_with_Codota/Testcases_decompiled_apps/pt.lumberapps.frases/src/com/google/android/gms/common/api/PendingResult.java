package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract class PendingResult {

    public interface zza {
        void zzv(Status status);
    }

    public abstract Result await();

    public abstract Result await(long j, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback resultCallback);

    public abstract void setResultCallback(ResultCallback resultCallback, long j, TimeUnit timeUnit);

    public TransformedResult then(ResultTransform resultTransform) {
        throw new UnsupportedOperationException();
    }

    public void zza(zza zza2) {
        throw new UnsupportedOperationException();
    }

    public Integer zzaoj() {
        throw new UnsupportedOperationException();
    }
}
