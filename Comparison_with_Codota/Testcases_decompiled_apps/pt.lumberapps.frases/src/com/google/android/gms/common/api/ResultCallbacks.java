package com.google.android.gms.common.api;

import android.util.Log;

public abstract class ResultCallbacks implements ResultCallback {
    public abstract void onFailure(Status status);

    public final void onResult(Result result) {
        Status status = result.getStatus();
        if (status.isSuccess()) {
            onSuccess(result);
            return;
        }
        onFailure(status);
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("ResultCallbacks", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public abstract void onSuccess(Result result);
}
