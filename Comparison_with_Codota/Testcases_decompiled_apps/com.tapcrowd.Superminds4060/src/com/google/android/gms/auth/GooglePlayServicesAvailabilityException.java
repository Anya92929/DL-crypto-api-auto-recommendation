package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {

    /* renamed from: iL */
    private final int f344iL;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.f344iL = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.f344iL;
    }
}
