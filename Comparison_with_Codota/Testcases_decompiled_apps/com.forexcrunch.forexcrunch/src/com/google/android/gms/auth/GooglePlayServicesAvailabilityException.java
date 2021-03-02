package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {

    /* renamed from: y */
    private final int f771y;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.f771y = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.f771y;
    }
}
