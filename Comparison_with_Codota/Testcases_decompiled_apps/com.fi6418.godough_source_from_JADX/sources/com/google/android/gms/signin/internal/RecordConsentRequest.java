package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new C1261l();

    /* renamed from: a */
    final int f5280a;

    /* renamed from: b */
    private final Account f5281b;

    /* renamed from: c */
    private final Scope[] f5282c;

    /* renamed from: d */
    private final String f5283d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f5280a = i;
        this.f5281b = account;
        this.f5282c = scopeArr;
        this.f5283d = str;
    }

    /* renamed from: a */
    public Account mo9028a() {
        return this.f5281b;
    }

    /* renamed from: b */
    public Scope[] mo9029b() {
        return this.f5282c;
    }

    /* renamed from: c */
    public String mo9030c() {
        return this.f5283d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1261l.m5230a(this, parcel, i);
    }
}
