package com.google.android.gms.auth.api;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

public class GoogleAuthApiException extends Exception {

    /* renamed from: CM */
    private Status f375CM;
    private PendingIntent mPendingIntent;

    public GoogleAuthApiException(String message, Status status) {
        super(message);
        this.f375CM = status;
    }

    public GoogleAuthApiException(String message, Status status, PendingIntent pendingIntent) {
        super(message);
        this.f375CM = status;
        this.mPendingIntent = pendingIntent;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this.f375CM;
    }

    public boolean isUserRecoverable() {
        return this.mPendingIntent != null;
    }
}
