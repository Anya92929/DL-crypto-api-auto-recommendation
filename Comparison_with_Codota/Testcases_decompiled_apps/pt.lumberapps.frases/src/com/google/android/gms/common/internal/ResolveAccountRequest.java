package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzac();

    /* renamed from: a */
    final int f4463a;

    /* renamed from: b */
    private final Account f4464b;

    /* renamed from: c */
    private final int f4465c;

    /* renamed from: d */
    private final GoogleSignInAccount f4466d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f4463a = i;
        this.f4464b = account;
        this.f4465c = i2;
        this.f4466d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account getAccount() {
        return this.f4464b;
    }

    public int getSessionId() {
        return this.f4465c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzac.m6067a(this, parcel, i);
    }

    public GoogleSignInAccount zzatf() {
        return this.f4466d;
    }
}
