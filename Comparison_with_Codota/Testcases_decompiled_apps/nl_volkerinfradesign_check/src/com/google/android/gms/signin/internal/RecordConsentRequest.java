package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzf();

    /* renamed from: a */
    final int f3596a;

    /* renamed from: b */
    private final Account f3597b;

    /* renamed from: c */
    private final Scope[] f3598c;

    /* renamed from: d */
    private final String f3599d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f3596a = i;
        this.f3597b = account;
        this.f3598c = scopeArr;
        this.f3599d = str;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.f3597b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m4245a(this, parcel, i);
    }

    public Scope[] zzFM() {
        return this.f3598c;
    }

    public String zzmR() {
        return this.f3599d;
    }
}
