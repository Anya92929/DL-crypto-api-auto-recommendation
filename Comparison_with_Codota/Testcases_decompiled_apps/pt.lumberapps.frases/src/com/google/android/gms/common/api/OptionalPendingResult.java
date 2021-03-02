package com.google.android.gms.common.api;

public abstract class OptionalPendingResult extends PendingResult {
    public abstract Result get();

    public abstract boolean isDone();
}
