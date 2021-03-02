package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: Dr */
    private final int f544Dr;

    GooglePlayServicesRepairableException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.f544Dr = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.f544Dr;
    }
}
