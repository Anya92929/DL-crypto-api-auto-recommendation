package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzae();

    /* renamed from: a */
    final int f4472a;

    /* renamed from: b */
    private final int f4473b;

    /* renamed from: c */
    private final int f4474c;

    /* renamed from: d */
    private final Scope[] f4475d;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.f4472a = i;
        this.f4473b = i2;
        this.f4474c = i3;
        this.f4475d = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.m6069a(this, parcel, i);
    }

    public int zzatk() {
        return this.f4473b;
    }

    public int zzatl() {
        return this.f4474c;
    }

    public Scope[] zzatm() {
        return this.f4475d;
    }
}
