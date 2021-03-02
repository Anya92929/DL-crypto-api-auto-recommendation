package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {

    /* renamed from: a */
    private final Intent f4285a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f4285a = intent;
    }

    public Intent getIntent() {
        return new Intent(this.f4285a);
    }
}
