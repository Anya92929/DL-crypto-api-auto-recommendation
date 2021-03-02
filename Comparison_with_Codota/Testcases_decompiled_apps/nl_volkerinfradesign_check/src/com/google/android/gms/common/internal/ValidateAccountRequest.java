package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzae();

    /* renamed from: a */
    final int f2929a;

    /* renamed from: b */
    final IBinder f2930b;

    /* renamed from: c */
    private final int f2931c;

    /* renamed from: d */
    private final Scope[] f2932d;

    /* renamed from: e */
    private final Bundle f2933e;

    /* renamed from: f */
    private final String f2934f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f2929a = i;
        this.f2931c = i2;
        this.f2930b = iBinder;
        this.f2932d = scopeArr;
        this.f2933e = bundle;
        this.f2934f = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getCallingPackage() {
        return this.f2934f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.m3909a(this, parcel, i);
    }

    public Scope[] zzrd() {
        return this.f2932d;
    }

    public int zzre() {
        return this.f2931c;
    }

    public Bundle zzrf() {
        return this.f2933e;
    }
}
