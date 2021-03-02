package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* renamed from: a */
    final int f2462a;

    /* renamed from: b */
    int f2463b;
    @Deprecated

    /* renamed from: c */
    String f2464c;

    /* renamed from: d */
    Account f2465d;

    public AccountChangeEventsRequest() {
        this.f2462a = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.f2462a = i;
        this.f2463b = i2;
        this.f2464c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f2465d = account;
        } else {
            this.f2465d = new Account(str, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.f2465d;
    }

    public String getAccountName() {
        return this.f2464c;
    }

    public int getEventIndex() {
        return this.f2463b;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.f2465d = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String str) {
        this.f2464c = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.f2463b = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m3650a(this, parcel, i);
    }
}
