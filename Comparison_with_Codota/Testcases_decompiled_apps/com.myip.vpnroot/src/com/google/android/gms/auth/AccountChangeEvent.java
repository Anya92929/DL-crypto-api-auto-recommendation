package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEvent implements SafeParcelable {
    public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();

    /* renamed from: Dd */
    final String f356Dd;

    /* renamed from: Di */
    final int f357Di;

    /* renamed from: Dj */
    final long f358Dj;

    /* renamed from: Dk */
    final int f359Dk;

    /* renamed from: Dl */
    final int f360Dl;

    /* renamed from: Dm */
    final String f361Dm;

    AccountChangeEvent(int version, long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.f357Di = version;
        this.f358Dj = id;
        this.f356Dd = (String) C0348n.m861i(accountName);
        this.f359Dk = changeType;
        this.f360Dl = eventIndex;
        this.f361Dm = changeData;
    }

    public AccountChangeEvent(long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.f357Di = 1;
        this.f358Dj = id;
        this.f356Dd = (String) C0348n.m861i(accountName);
        this.f359Dk = changeType;
        this.f360Dl = eventIndex;
        this.f361Dm = changeData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (!(that instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) that;
        return this.f357Di == accountChangeEvent.f357Di && this.f358Dj == accountChangeEvent.f358Dj && C0345m.equal(this.f356Dd, accountChangeEvent.f356Dd) && this.f359Dk == accountChangeEvent.f359Dk && this.f360Dl == accountChangeEvent.f360Dl && C0345m.equal(this.f361Dm, accountChangeEvent.f361Dm);
    }

    public String getAccountName() {
        return this.f356Dd;
    }

    public String getChangeData() {
        return this.f361Dm;
    }

    public int getChangeType() {
        return this.f359Dk;
    }

    public int getEventIndex() {
        return this.f360Dl;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f357Di), Long.valueOf(this.f358Dj), this.f356Dd, Integer.valueOf(this.f359Dk), Integer.valueOf(this.f360Dl), this.f361Dm);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.f359Dk) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.f356Dd + ", changeType = " + str + ", changeData = " + this.f361Dm + ", eventIndex = " + this.f360Dl + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventCreator.m343a(this, dest, flags);
    }
}
