package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzc();

    /* renamed from: a */
    final int f2898a;

    /* renamed from: b */
    final IBinder f2899b;

    /* renamed from: c */
    final Scope[] f2900c;

    /* renamed from: d */
    Integer f2901d;

    /* renamed from: e */
    Integer f2902e;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f2898a = i;
        this.f2899b = iBinder;
        this.f2900c = scopeArr;
        this.f2901d = num;
        this.f2902e = num2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m3910a(this, parcel, i);
    }
}
