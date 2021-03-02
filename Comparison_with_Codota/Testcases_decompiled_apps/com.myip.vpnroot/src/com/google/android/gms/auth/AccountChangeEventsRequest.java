package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();

    /* renamed from: Dd */
    String f362Dd;

    /* renamed from: Di */
    final int f363Di;

    /* renamed from: Dl */
    int f364Dl;

    public AccountChangeEventsRequest() {
        this.f363Di = 1;
    }

    AccountChangeEventsRequest(int version, int eventIndex, String accountName) {
        this.f363Di = version;
        this.f364Dl = eventIndex;
        this.f362Dd = accountName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.f362Dd;
    }

    public int getEventIndex() {
        return this.f364Dl;
    }

    public AccountChangeEventsRequest setAccountName(String accountName) {
        this.f362Dd = accountName;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int eventIndex) {
        this.f364Dl = eventIndex;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventsRequestCreator.m344a(this, dest, flags);
    }
}
