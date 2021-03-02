package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new C1010bg();

    /* renamed from: a */
    final int f4661a;

    /* renamed from: b */
    private final Account f4662b;

    /* renamed from: c */
    private final int f4663c;

    ResolveAccountRequest(int i, Account account, int i2) {
        this.f4661a = i;
        this.f4662b = account;
        this.f4663c = i2;
    }

    public ResolveAccountRequest(Account account, int i) {
        this(1, account, i);
    }

    /* renamed from: a */
    public Account mo7480a() {
        return this.f4662b;
    }

    /* renamed from: b */
    public int mo7481b() {
        return this.f4663c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1010bg.m4539a(this, parcel, i);
    }
}
