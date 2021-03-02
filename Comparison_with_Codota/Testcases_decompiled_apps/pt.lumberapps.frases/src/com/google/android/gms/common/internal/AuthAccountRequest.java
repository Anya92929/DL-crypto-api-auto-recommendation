package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();

    /* renamed from: a */
    final int f4444a;

    /* renamed from: b */
    final IBinder f4445b;

    /* renamed from: c */
    final Scope[] f4446c;

    /* renamed from: d */
    Integer f4447d;

    /* renamed from: e */
    Integer f4448e;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f4444a = i;
        this.f4445b = iBinder;
        this.f4446c = scopeArr;
        this.f4447d = num;
        this.f4448e = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m6080a(this, parcel, i);
    }
}
