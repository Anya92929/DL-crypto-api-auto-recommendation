package com.google.android.gms.auth;

import android.content.Intent;

public class UserRecoverableAuthException extends GoogleAuthException {

    /* renamed from: a */
    private final Intent f2475a;

    public UserRecoverableAuthException(String str, Intent intent) {
        super(str);
        this.f2475a = intent;
    }

    public Intent getIntent() {
        if (this.f2475a == null) {
            return null;
        }
        return new Intent(this.f2475a);
    }
}
