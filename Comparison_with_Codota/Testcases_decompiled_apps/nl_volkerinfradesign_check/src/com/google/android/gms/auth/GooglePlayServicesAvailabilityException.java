package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {

    /* renamed from: a */
    private final int f2468a;

    GooglePlayServicesAvailabilityException(int i, String str, Intent intent) {
        super(str, intent);
        this.f2468a = i;
    }

    public int getConnectionStatusCode() {
        return this.f2468a;
    }
}
