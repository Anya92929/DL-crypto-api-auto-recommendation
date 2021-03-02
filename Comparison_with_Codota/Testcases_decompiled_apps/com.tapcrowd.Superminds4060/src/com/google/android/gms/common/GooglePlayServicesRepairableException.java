package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: iL */
    private final int f348iL;

    GooglePlayServicesRepairableException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.f348iL = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.f348iL;
    }
}
