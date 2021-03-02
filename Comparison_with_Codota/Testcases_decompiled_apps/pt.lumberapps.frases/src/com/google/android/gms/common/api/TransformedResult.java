package com.google.android.gms.common.api;

public abstract class TransformedResult {
    public abstract void andFinally(ResultCallbacks resultCallbacks);

    public abstract TransformedResult then(ResultTransform resultTransform);
}
