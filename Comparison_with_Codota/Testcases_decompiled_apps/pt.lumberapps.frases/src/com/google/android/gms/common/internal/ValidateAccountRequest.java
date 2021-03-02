package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzaj();

    /* renamed from: a */
    final int f4476a;

    /* renamed from: b */
    final IBinder f4477b;

    /* renamed from: c */
    private final int f4478c;

    /* renamed from: d */
    private final Scope[] f4479d;

    /* renamed from: e */
    private final Bundle f4480e;

    /* renamed from: f */
    private final String f4481f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f4476a = i;
        this.f4478c = i2;
        this.f4477b = iBinder;
        this.f4479d = scopeArr;
        this.f4480e = bundle;
        this.f4481f = str;
    }

    public String getCallingPackage() {
        return this.f4481f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaj.m6079a(this, parcel, i);
    }

    public Scope[] zzatm() {
        return this.f4479d;
    }

    public int zzato() {
        return this.f4478c;
    }

    public Bundle zzatp() {
        return this.f4480e;
    }
}
