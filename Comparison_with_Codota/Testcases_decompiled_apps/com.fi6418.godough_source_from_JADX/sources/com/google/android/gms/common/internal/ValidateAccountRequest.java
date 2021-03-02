package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.C0772b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new C1013d();

    /* renamed from: a */
    final int f4669a;

    /* renamed from: b */
    final IBinder f4670b;

    /* renamed from: c */
    private final int f4671c;

    /* renamed from: d */
    private final Scope[] f4672d;

    /* renamed from: e */
    private final Bundle f4673e;

    /* renamed from: f */
    private final String f4674f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f4669a = i;
        this.f4671c = i2;
        this.f4670b = iBinder;
        this.f4672d = scopeArr;
        this.f4673e = bundle;
        this.f4674f = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ValidateAccountRequest(C0993aq aqVar, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, C0772b.f4563a, aqVar == null ? null : aqVar.asBinder(), scopeArr, bundle, str);
    }

    /* renamed from: a */
    public int mo7491a() {
        return this.f4671c;
    }

    /* renamed from: b */
    public Scope[] mo7492b() {
        return this.f4672d;
    }

    /* renamed from: c */
    public String mo7493c() {
        return this.f4674f;
    }

    /* renamed from: d */
    public Bundle mo7494d() {
        return this.f4673e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1013d.m4549a(this, parcel, i);
    }
}
