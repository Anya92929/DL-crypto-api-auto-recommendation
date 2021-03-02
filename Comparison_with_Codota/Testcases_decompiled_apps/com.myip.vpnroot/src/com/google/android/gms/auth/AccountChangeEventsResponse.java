package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final AccountChangeEventsResponseCreator CREATOR = new AccountChangeEventsResponseCreator();

    /* renamed from: Di */
    final int f365Di;

    /* renamed from: me */
    final List<AccountChangeEvent> f366me;

    AccountChangeEventsResponse(int version, List<AccountChangeEvent> events) {
        this.f365Di = version;
        this.f366me = (List) C0348n.m861i(events);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> events) {
        this.f365Di = 1;
        this.f366me = (List) C0348n.m861i(events);
    }

    public int describeContents() {
        return 0;
    }

    public List<AccountChangeEvent> getEvents() {
        return this.f366me;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventsResponseCreator.m345a(this, dest, flags);
    }
}
