package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {

    /* renamed from: a */
    private Status f2507a;

    /* renamed from: b */
    private GoogleSignInAccount f2508b;

    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.f2508b = googleSignInAccount;
        this.f2507a = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.f2508b;
    }

    @NonNull
    public Status getStatus() {
        return this.f2507a;
    }

    public boolean isSuccess() {
        return this.f2507a.isSuccess();
    }
}
