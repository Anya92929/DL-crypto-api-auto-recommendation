package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();

    /* renamed from: a */
    final int f7413a;

    /* renamed from: b */
    private final Account f7414b;

    /* renamed from: c */
    private final Scope[] f7415c;

    /* renamed from: d */
    private final String f7416d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f7413a = i;
        this.f7414b = account;
        this.f7415c = scopeArr;
        this.f7416d = str;
    }

    public Account getAccount() {
        return this.f7414b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m8028a(this, parcel, i);
    }

    public String zzafu() {
        return this.f7416d;
    }

    public Scope[] zzbzw() {
        return this.f7415c;
    }
}
