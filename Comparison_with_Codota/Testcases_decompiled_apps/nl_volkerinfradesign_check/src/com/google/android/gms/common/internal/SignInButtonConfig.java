package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInButtonConfig implements SafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zzaa();

    /* renamed from: a */
    final int f2925a;

    /* renamed from: b */
    private final int f2926b;

    /* renamed from: c */
    private final int f2927c;

    /* renamed from: d */
    private final Scope[] f2928d;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.f2925a = i;
        this.f2926b = i2;
        this.f2927c = i3;
        this.f2928d = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaa.m3901a(this, parcel, i);
    }

    public int zzrb() {
        return this.f2926b;
    }

    public int zzrc() {
        return this.f2927c;
    }

    public Scope[] zzrd() {
        return this.f2928d;
    }
}
