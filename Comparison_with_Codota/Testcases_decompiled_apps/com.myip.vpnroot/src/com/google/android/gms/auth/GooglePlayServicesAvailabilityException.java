package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {

    /* renamed from: Dr */
    private final int f372Dr;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.f372Dr = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.f372Dr;
    }
}
