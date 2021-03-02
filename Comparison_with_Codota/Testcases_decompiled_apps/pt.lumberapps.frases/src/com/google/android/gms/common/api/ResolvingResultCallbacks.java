package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;

public abstract class ResolvingResultCallbacks extends ResultCallbacks {

    /* renamed from: a */
    private final Activity f4324a;

    /* renamed from: b */
    private final int f4325b;

    public final void onFailure(Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.f4324a, this.f4325b);
            } catch (IntentSender.SendIntentException e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                onUnresolvableFailure(new Status(8));
            }
        } else {
            onUnresolvableFailure(status);
        }
    }

    public abstract void onSuccess(Result result);

    public abstract void onUnresolvableFailure(Status status);
}
