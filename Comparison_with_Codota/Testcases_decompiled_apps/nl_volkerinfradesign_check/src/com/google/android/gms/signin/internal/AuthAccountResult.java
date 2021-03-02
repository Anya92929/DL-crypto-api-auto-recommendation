package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<AuthAccountResult> CREATOR = new zza();

    /* renamed from: a */
    final int f3590a;

    /* renamed from: b */
    private int f3591b;

    /* renamed from: c */
    private Intent f3592c;

    public AuthAccountResult() {
        this(0, (Intent) null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f3590a = i;
        this.f3591b = i2;
        this.f3592c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.f3591b == 0 ? Status.zzagC : Status.zzagG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m4243a(this, parcel, i);
    }

    public int zzFK() {
        return this.f3591b;
    }

    public Intent zzFL() {
        return this.f3592c;
    }
}
