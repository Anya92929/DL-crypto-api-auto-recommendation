package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: a */
    private final int f2596a;

    GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.f2596a = i;
    }

    public int getConnectionStatusCode() {
        return this.f2596a;
    }
}
