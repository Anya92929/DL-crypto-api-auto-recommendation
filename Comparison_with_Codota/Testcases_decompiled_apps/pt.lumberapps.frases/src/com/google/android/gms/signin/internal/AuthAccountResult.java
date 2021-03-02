package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator CREATOR = new zza();

    /* renamed from: a */
    final int f7407a;

    /* renamed from: b */
    private int f7408b;

    /* renamed from: c */
    private Intent f7409c;

    public AuthAccountResult() {
        this(0, (Intent) null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f7407a = i;
        this.f7408b = i2;
        this.f7409c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status getStatus() {
        return this.f7408b == 0 ? Status.f4328sq : Status.f4332su;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m8026a(this, parcel, i);
    }

    public int zzbzu() {
        return this.f7408b;
    }

    public Intent zzbzv() {
        return this.f7409c;
    }
}
