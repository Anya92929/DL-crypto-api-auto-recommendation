package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zzy();

    /* renamed from: a */
    final int f2916a;

    /* renamed from: b */
    private final Account f2917b;

    /* renamed from: c */
    private final int f2918c;

    /* renamed from: d */
    private final GoogleSignInAccount f2919d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f2916a = i;
        this.f2917b = account;
        this.f2918c = i2;
        this.f2919d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.f2917b;
    }

    public int getSessionId() {
        return this.f2918c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzy.m3954a(this, parcel, i);
    }

    @Nullable
    public GoogleSignInAccount zzqW() {
        return this.f2919d;
    }
}
